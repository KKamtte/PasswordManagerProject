package �⸻��������Ʈ;

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
		System.out.println("��Ĺ ���� ���");
		System.out.println(socket);
	}

	public static void sendAndget(String id, String pw2, int i) throws IOException {
		// �޼��� ���� : socket�� �˰��ִ� ��󿡰�(���ڿ� ���)

		OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());// ���
		BufferedWriter bw = new BufferedWriter(osw);// ���
		PrintWriter pw = new PrintWriter(bw);// ����

		// pw���� ��� ������ flush() ����

		String msg = i+"/"+id+"/"+pw2+"/";
		
			
		pw.println(msg);
		pw.flush();

		//�޼��� �ޱ�
		try{
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String clientMsg = null;
			while(true){
				clientMsg = br.readLine();
				
				
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "������ ����Ǿ����ϴ�.");
		}
		osw.close();
		bw.close();
		pw.close();
	}

	public static int inputLoginData(String id, String pw, int i) {
		// TODO Auto-generated method stub
		System.out.println("�α��� ������ ���ϴ� �޼ҵ�");
		try {
			// InetAddress, Socket ���
			System.out.println("localhost�� ����");
			inet = InetAddress.getByName("localhost");

			// ������ �����Ͽ� ���� �õ�
			socket = new Socket(inet, 20030);

			printInfo();// socket ���� ���

			 sendAndget(id, pw, i);

			 
			// ���� ����
			socket.close();
		} catch (Exception ex) {
			System.out.println("������ �߻��Ͽ� �����մϴ�.");
			System.exit(-1);
		}

		return 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
