package 기말팀프로젝트;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import client.ClientHandler;

public class PassWord_init extends JFrame {
	ImageIcon image;
	private JTextField textField;
	JLabel 비밀번호출력;

	public PassWord_init() {
		setSize(500, 650);
		setLocation(500, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setToolTipText("암호 옆자리");
		panel.setLayout(null);
		panel.setBounds(0, 0, 500, 53);
		panel.setBackground(Color.white);

		JLabel 열쇠 = new JLabel(new ImageIcon("생성기2.png"));
		열쇠.setBounds(0, 0, 65, 53);
		panel.add(열쇠);
		열쇠.setBorder(BorderFactory.createLineBorder(Color.orange));

		JLabel label = new JLabel("생성기");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("굴림", Font.PLAIN, 25));
		label.setBounds(160, 0, 185, 57);
		panel.add(label);

		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(442, 0, 55, 51);
		panel2.setBorder(BorderFactory.createLineBorder(Color.orange));
		panel.add(panel2);

		JButton addBtn = new JButton(new ImageIcon("select.png"));
		addBtn.setBounds(2, 1, 52, 50);
		addBtn.setBorderPainted(false);
		panel2.add(addBtn);

		panel.setBorder(BorderFactory.createLineBorder(Color.orange));
		getContentPane().add(panel);

		JPanel 비밀의방패널 = new JPanel();
		비밀의방패널.setBounds(0, 53, 494, 73);
		비밀의방패널.setBackground(Color.white);
		비밀의방패널.setBorder(BorderFactory.createLineBorder(Color.orange));
		getContentPane().add(비밀의방패널);

		JButton mainBtn = new JButton(new ImageIcon("비밀.png"));// 메인으로 이동 이미지
		비밀의방패널.setLayout(null);
		mainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyFrame(ClientHandler.getMember());
				dispose();
			}
		});
		mainBtn.setBounds(2, 25, 161, 39);
		mainBtn.setBorderPainted(false);
		비밀의방패널.add(mainBtn);

		JPanel 메인패널 = new JPanel();
		메인패널.setLayout(null);
		메인패널.setBounds(0, 126, 494, 524);
		메인패널.setBackground(Color.white);
		메인패널.setBorder(BorderFactory.createLineBorder(Color.orange));
		
		JLabel label2 =new JLabel("보안력이 강한");
		JLabel label2_2=new JLabel("비밀번호를 생성하세요 !!!");
		label2.setFont(new Font("굴림", Font.PLAIN, 20));
		label2_2.setFont(new Font("굴림", Font.PLAIN, 20));
		label2.setBounds(20,20,250,30);
		label2_2.setBounds(20,60,400,30);
		메인패널.add(label2);
		메인패널.add(label2_2);
		
		JPanel 생성기패널=new JPanel();
		생성기패널.setLayout(null);
		생성기패널.setBounds(40,160,410,250);
		생성기패널.setBackground(Color.WHITE);
		생성기패널.setBorder(BorderFactory.createLineBorder(Color.black,20));
		메인패널.add(생성기패널);
		
		JPanel 생성기패널2=new JPanel();
		생성기패널2.setLayout(null);
		생성기패널2.setBounds(30, 30, 350, 190);
		생성기패널.add(생성기패널2);
		
		비밀번호출력=new JLabel("비밀번호 출력란");
		비밀번호출력.setFont(new Font("", Font.BOLD, 19));
		비밀번호출력.setForeground(Color.RED);
		비밀번호출력.setHorizontalAlignment(SwingConstants.LEFT);
		비밀번호출력.setBounds(0,0,350,100);
		비밀번호출력.setBorder(BorderFactory.createLineBorder(Color.black,10));
		생성기패널2.add(비밀번호출력);
		
		JButton 복사하기=new JButton(new ImageIcon("복사.png"));
		복사하기.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JLabel msg = new JLabel(); 
				msg.setText("비밀번호를 복사하시겠습니까?");
				if (JOptionPane.showConfirmDialog(null, msg, "확인", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
						
						
						//System.out.println(비밀번호출력);
								
						Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						String copyString = 비밀번호출력.getText();
						if(copyString != null)
						{
						     StringSelection contents = new StringSelection(copyString);
						     clipboard.setContents(contents, null);
						}		
				}
				else {
					System.out.println("여기여기222");
				}
			}
		});
		복사하기.setBounds(250,10,90,80);
		복사하기.setBorder(BorderFactory.createEmptyBorder());
		생성기패널2.add(복사하기);
		
		JButton 복사하기2=new JButton(new ImageIcon("복사하기2.png"));
		복사하기2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pwd_algorithm pa= new Pwd_algorithm();
				
				System.out.println("비밀번호 생성 버튼 클릭시 이벤트");
				
			}
		});
		복사하기2.setBounds(0,100,350,90);
		복사하기2.setBorder(BorderFactory.createEmptyBorder());
		생성기패널2.add(복사하기2);
		
		getContentPane().add(메인패널);
		
		setVisible(true);
		setResizable(false);
	}

	public class Pwd_algorithm {
		public Pwd_algorithm() {

			String[] num = new String[20]; // 배열 0~16까지 생성
			String result = "";
			int counter = 0;
			int[] spe = { 33, 64, 35, 36, 37, 94, 38, 42 };// 특수문자 배열
			int i = (int) (Math.random() * 4) + 12; // 8~14사이의 숫자
													// 생성(특수문자/소문자/대문자 중
													// 두가지가 빠질 상황 고려)
			// System.out.println("i="+i);
			char aString = 0; // 암호를 받기위한 스트링
			int upper = 0, lower = 0, special = 0; // 소문자/대문자/특수문자 개수 확인
			String str;

			for (int k = 0; k < i; k++) {
				aString = (char) ((Math.random() * 60) + 65); // A~Z/특수문자/a~z
																// 무작위로
																// 입력
				/* 대,소,특수문자 개수확인 */
				if (aString < 91)
					upper++;
				else if (aString > 96 && aString < 123)
					lower++;
				else
					special++;

				/* 특수문자를 숫자부분의 특수문자로 교환해주는 작업 */
				if (aString == 91)
					aString = 33; // !로 교환
				if (aString == 92)
					aString = 64; // @로 교환
				if (aString == 93)
					aString = 35; // #로 교환
				if (aString == 95)
					aString = 36; // $로 교환
				if (aString == 96)
					aString = 37; // %로 교환
				if (aString == 123)
					aString = 38; // &로 교환
				if (aString == 124)
					aString = 42; // *로 교환
				str = String.valueOf(aString);
				num[k] = str;
				// System.out.println("num["+k+"]="+num[k]);
				System.out.print(num[k]);
				result += num[k];
			}

			/* 비밀번호 조건을 만족하지 못할 경우 */
			if (upper == 0) { // 대문자가 없는경우
				i++;
				aString = (char) ((Math.random() * 26) + 65);
				num[i] = String.valueOf(aString);
				System.out.print(num[i]);
				result += num[i];
			}
			if (lower == 0) { // 소문자가 없는경우
				i++;
				aString = (char) ((Math.random() * 26) + 97);
				num[i] = String.valueOf(aString);
				System.out.print(num[i]);
				result += num[i];
			}
			if (special == 0) { // 특수문자가 없는경우
				i++;
				int j = (int) (Math.random() * 7);
				aString = (char) spe[j];
				num[i] = String.valueOf(aString);
				System.out.print(num[i]);
				result += num[i];
			}

			System.out.println("");
			System.out.println("result : " + result);
			비밀번호출력.setText(result);
			// System.out.println("대문자="+upper + "소문자="+lower+"특수문자="+special);
		}

	}
}