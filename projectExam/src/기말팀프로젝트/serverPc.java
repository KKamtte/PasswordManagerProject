package 기말팀프로젝트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JOptionPane;

public class serverPc  implements Runnable{
	static final int login = 1;
	private static InetAddress inet;
	private static Socket socket;
	private static BufferedReader br;
	public static void printInfo() {
		System.out.println("소캣 정보 출력");
		System.out.println(socket);
	}

	public static void sendAndget(String id, String pw2, int i) throws IOException {
		// 메세지 전송 : socket이 알고있는 대상에게(문자열 출력)

		OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());// 대상
		BufferedWriter bw = new BufferedWriter(osw);// 통로
		PrintWriter pw = new PrintWriter(bw);// 버퍼

		// pw에게 명령 내리고 flush() 수행

		String msg = i+"/"+id+"/"+pw2+"/";
		
			
		pw.println(msg);
		pw.flush();

		//메세지 받기
		try{
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String clientMsg = null;
			while(true){
				clientMsg = br.readLine();
				
				
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "연결이 종료되었습니다.");
		}
		osw.close();
		bw.close();
		pw.close();
	}

	public static int inputLoginData(String id, String pw, int i) {
		// TODO Auto-generated method stub
		System.out.println("로그인 데이터 전하는 메소드");
		try {
			// InetAddress, Socket 사용
			System.out.println("localhost로 연결");
			inet = InetAddress.getByName("localhost");

			// 소켓을 생성하여 연결 시도
			socket = new Socket(inet, 20030);

			printInfo();// socket 정보 출력

			 sendAndget(id, pw, i);

			 
			// 연결 종료
			socket.close();
		} catch (Exception ex) {
			System.out.println("오류가 발생하여 종료합니다.");
			System.exit(-1);
		}

		return 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
