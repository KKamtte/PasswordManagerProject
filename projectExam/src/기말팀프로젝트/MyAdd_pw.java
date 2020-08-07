package 기말팀프로젝트;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Security.Encrypt;
import client.ClientHandler;

public class MyAdd_pw extends JFrame implements ActionListener, MouseListener {
	ImageIcon image1 = new ImageIcon("return투명.png");
	ImageIcon image2 = new ImageIcon("생성기3.png");
	ImageIcon image3 = new ImageIcon("복사2.png");
	ImageIcon image4 = new ImageIcon("eyes.png");
	JTextField 직함1, URL2, ID2, password2;
	JPanel title, panel1, panel2, panel3, panel4;
	JButton return1, save, 생성기, 복사, 눈;
	JLabel titleLabel, 직함, URL, ID, password;

	int pm_numDate;
	String siteNameDate;
	String urlDate;
	String idDate;
	String pwDate;

	boolean updateVer = false;

	private ClientHandler ch;

	public MyAdd_pw() {
		init();
		start();
		ch = ClientHandler.getInstance();
	}

	public MyAdd_pw(int pm_numDate, String siteNameDate, String urlDate, String idDate, String pwDate) {
		// TODO Auto-generated constructor stub
		this.pm_numDate=pm_numDate;
		this.siteNameDate=siteNameDate;
		this.urlDate=urlDate;
		this.idDate=idDate;
		this.pwDate=pwDate;
		
		updateVer=true;
		init();
		start();
		ch = ClientHandler.getInstance();
		
	}

	
	private void init() {
		//setLocation(ClientHandler.p);;
		setSize(500, 650);
		
		if(updateVer==false){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}else if(updateVer==true){
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
		getContentPane().setLayout(null);

		// 1
		title = new JPanel();
		title.setLayout(null);
		title.setBounds(0, 0, 500, 120);
		title.setBackground(new Color(204, 204, 204));

		return1 = new JButton(image1);
		return1.setBounds(10, 25, 70, 50);
		return1.setBorderPainted(false);
		return1.setBackground(new Color(204, 204, 204));
		return1.setBorder(BorderFactory.createEmptyBorder());
		title.add(return1);

		titleLabel = new JLabel("암호추가");
		titleLabel.setFont(new Font("", Font.BOLD, 30));
		titleLabel.setBounds(180, 30, 200, 50);
		title.add(titleLabel);

		if(updateVer==false){
			save = new JButton("저장");
		}else if (updateVer==true) {
			save = new JButton("수정");
		}
		

		save.setBounds(420, 25, 70, 50);
		save.setFont(new Font("", Font.BOLD, 20));
		save.setBackground(new Color(204, 204, 204));
		save.setBorder(BorderFactory.createEmptyBorder());
		title.add(save);

		getContentPane().add(title);
		//

		// 2

		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0, 210, 494, 100);
		panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panel1.setBackground(Color.gray);
		
		
			직함 = new JLabel("사이트 명");
		
		
		
		직함.setBounds(10, 10, 200, 30);
		직함.setFont(new Font("", Font.PLAIN, 25));
		panel1.add(직함);

		
		if(updateVer==false){
			직함1 = new JTextField("사이트 명을 입력하시오. ex) 네이버,다음");
		}else if(updateVer == true){
			직함1 = new JTextField(siteNameDate);
		}
		

		직함1.setBounds(10, 50, 440, 30);
		직함1.setFont(new Font("", Font.BOLD, 20));
		panel1.add(직함1);

		getContentPane().add(panel1);

		//

		// 3
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 305, 494, 100);
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panel2.setBackground(Color.gray);

		URL = new JLabel("URL");
		URL.setBounds(10, 10, 200, 30);
		URL.setFont(new Font("", Font.PLAIN, 25));
		panel2.add(URL);

		
		if(updateVer==false){
			URL2 = new JTextField("URL을 입력하시오. ex) http://www.naver.com");
		}else if(updateVer == true){
			URL2 = new JTextField(urlDate);
		}
		

		URL2.setBounds(10, 50, 440, 30);
		URL2.setFont(new Font("", Font.BOLD, 20));
		panel2.add(URL2);

		getContentPane().add(panel2);
		//

		// 4
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(0, 400, 494, 100);
		panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panel3.setBackground(Color.gray);

		ID = new JLabel("ID");
		ID.setBounds(10, 10, 200, 30);
		ID.setFont(new Font("", Font.PLAIN, 25));
		panel3.add(ID);

		if(updateVer==false){
			ID2 = new JTextField("ID를 입력하시오. ex) SKHU <3");
		}else if(updateVer == true){
			ID2 = new JTextField(idDate);
		}
		

		ID2.setBounds(10, 50, 440, 30);
		ID2.setFont(new Font("", Font.BOLD, 20));
		panel3.add(ID2);

		getContentPane().add(panel3);
		//

		// 5
		panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setBounds(0, 495, 494, 100);
		panel4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panel4.setBackground(Color.gray);

		password = new JLabel("패스워드");
		password.setBounds(10, 10, 200, 30);
		password.setFont(new Font("", Font.PLAIN, 25));
		panel4.add(password);

		if(updateVer==false){
			password2 = new JTextField("password를 입력하시오.");
		}else if(updateVer == true){
			
			password2 = new JTextField(pwDate);
		}
		

		password2.setBounds(10, 50, 440, 30);
		password2.setFont(new Font("", Font.BOLD, 20));
		panel4.add(password2);

		생성기 = new JButton(image2);

		생성기.setBounds(280, 10, 50, 30);
		panel4.add(생성기);

		복사 = new JButton(image3);

		복사.setBounds(340, 10, 50, 30);
		panel4.add(복사);

		눈 = new JButton(image4);

		눈.setBounds(400, 10, 50, 30);
		panel4.add(눈);

		getContentPane().add(panel4);
		//

		setVisible(true);
		setResizable(false);

	}

	private void start() {
		// 마우스 리스너들 직함1, URL2, ID2, password2;
		password2.addMouseListener(this);
		ID2.addMouseListener(this);
		URL2.addMouseListener(this);
		직함1.addMouseListener(this);
		// 버튼 리스너들
		save.addActionListener(this);
		return1.addActionListener(this);
		생성기.addActionListener(this);
		복사.addActionListener(this);
		눈.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();// 선택된 버튼을 알아낸다
		if (src == save) {
			// 값들을 서버로 전송하기 insert 문이므로 회원가입과 형식이 비슷하다.
			if (!(직함1.getText().equals("")) && !(URL2.getText().equals("")) && !(ID2.getText().equals(""))
					&& !(password2.getText().equals(""))) {

				// 서버로 보낼 msg 작성

				String en직함1 = makeEnString(직함1.getText());
				String enURL2 = makeEnString(URL2.getText());

				String enID2 = makeEnString(ID2.getText());
				String enpassword2 = makeEnString(password2.getText());

				

				
				if(updateVer==false){
					String msg = en직함1 + "," + enURL2 + "," + enID2 + "," + enpassword2 + ","
							+ ClientHandler.getMember().getUserNum();
					
					System.out.println("서버로 보낼 메세지 확인 : " + msg);
					//값을 새롭게 추가
					ch.requestaddPwData(msg);

					System.out.println("내용들이 저장되었습니다.");
					new MyPassword(ClientHandler.getMember());
					dispose();
				}else if(updateVer==true){
					String msg = en직함1 + "," + enURL2 + "," + enID2 + "," + enpassword2 + ","
							+pm_numDate ;
					
					System.out.println("서버로 보낼 메세지 확인 : " + msg);
					//기존의 값을 저장
					ch.requestupdatePwData(msg);

					System.out.println("내용들이 저장되었습니다.");
					new MyPassword(ClientHandler.getMember());
					dispose();
				}
				
			} else {
				System.out.println("asdasdasd");

				JOptionPane.showMessageDialog(null, "필수항목 중에 빠진 부분이 있습니다. 확인해주세요!!", "확인",
						JOptionPane.INFORMATION_MESSAGE, null);

			}
		} else if (src == return1) {
			new MyPassword(ClientHandler.getMember());
			dispose();
		} else if (src == 생성기) {
			new PassWord_init();

		} else if (src == 복사) {
			JLabel msg = new JLabel();
			msg.setText("비밀번호를 복사하시겠습니까?");
			if (JOptionPane.showConfirmDialog(null, msg, "확인", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
				password2.getText();// 비밀번호 출력 읽기
			} else {
			}

		} else if (src == 눈) {
			password2.setText("비밀번호를 암호화 시켰다");

		}

		else {
			System.out.println("asdasdasd");

			JOptionPane.showMessageDialog(null, "필수항목 중에 빠진 부분이 있습니다. 확인해주세요!!", "확인", JOptionPane.INFORMATION_MESSAGE,
					null);

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		// 뭘 누르든 똑같음
		if(updateVer==false){
			Object src = e.getSource();// 선택된 버튼을 알아낸다
			JTextField empty = (JTextField) src;
			empty.setText(null);
		}else if(updateVer==true){
			Object src = e.getSource();// 선택된 버튼을 알아낸다
			JTextField empty = (JTextField) src;
			
		}
		

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private String makeEnString(String text) {
		Encrypt en = null;

		try { // 카드명1 암호화
			en = new Encrypt(text);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("암호화(카드명1)된 값 : " + en.getEnco());
		// String en카드명1 = en.getEnco();
		return en.getEnco();
	}
}
