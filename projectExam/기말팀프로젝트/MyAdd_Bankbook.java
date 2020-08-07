package 기말팀프로젝트;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import DTO.BankDataDTO;
import Security.Encrypt;
import client.ClientHandler;
import 기말팀프로젝트.MyAdd_Card.JTextFieldLimit;

import java.awt.*;
import java.awt.image.*;
import java.util.Enumeration;

import javax.swing.*;

public class MyAdd_Bankbook extends JFrame implements ActionListener, MouseListener {
	ImageIcon image1 = new ImageIcon("return투명.png");

	JTextField 통장명1, 신용카드1, 신용카드2, 신용카드3, 신용카드4, 발행일1, 계좌관리점1, password2;
	JPanel title, panel1, panel2;
	JButton return1, save;
	JLabel titleLabel, 통장명, 유형, 신용카드, 발행일, 계좌관리점, password;
	JRadioButton r1, r2, r3, r4;
	ButtonGroup 유형2;
	private ClientHandler ch;

	// 임시로 데이터를 담아두는 곳
	int pm_num;
	String b_name;
	String b_type;
	String b_num1;
	String b_num2;
	String b_num3;
	String b_num4;
	String b_date;
	String b_department;
	String b_password;

	// 수정인지 삽입인지 구별해주는 플레그
	boolean updateVer = false;

	public MyAdd_Bankbook() {
		init();
		start();
		ch = ClientHandler.getInstance();
	}

	public MyAdd_Bankbook(int pm_num, String b_name, String b_type, String b_num1, String b_num2, String b_num3,
			String b_num4, String b_date, String b_department, String b_password) throws HeadlessException {
		super();
		this.pm_num = pm_num;
		this.b_name = b_name;
		this.b_type = b_type;
		this.b_num1 = b_num1;
		this.b_num2 = b_num2;
		this.b_num3 = b_num3;
		this.b_num4 = b_num4;
		this.b_date = b_date;
		this.b_department = b_department;
		this.b_password = b_password;
		updateVer=true;
		init();
		start();
		ch = ClientHandler.getInstance();
	}

	private void init() {
		// setLocation(ClientHandler.p);;
		setSize(500, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		
		
		
		// 1
		title = new JPanel();
		title.setLayout(null);
		title.setBounds(0, 0, 500, 120);
		title.setBackground(new Color(204, 204, 204));

		return1 = new JButton(image1);
		return1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MyBankbook(ClientHandler.getMember());
				dispose();
			}
		});
		return1.setBounds(10, 25, 70, 50);
		return1.setBorderPainted(false);
		return1.setBackground(new Color(204, 204, 204));
		return1.setBorder(BorderFactory.createEmptyBorder());
		title.add(return1);

		if (updateVer == false) {
			titleLabel = new JLabel("통장 추가");
		} else if (updateVer == true) {
			titleLabel = new JLabel("통장 정보");
		}
		
		titleLabel.setFont(new Font("", Font.BOLD, 30));
		titleLabel.setBounds(180, 30, 200, 50);
		title.add(titleLabel);

		if (updateVer == false) {
			save = new JButton("저장");
		} else if (updateVer == true) {
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
		panel1.setBounds(0, 120, 494, 100);
		panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panel1.setBackground(Color.gray);

		통장명 = new JLabel("통장 이름");
		통장명.setBounds(10, 10, 200, 30);
		통장명.setFont(new Font("", Font.BOLD, 25));
		panel1.add(통장명);

		if (updateVer == false) {
			통장명1 = new JTextField("통장 이름을 입력하시오. ex)신한은행,농협,우리");

		} else if (updateVer == true) {
			통장명1 = new JTextField(b_name);
			통장명1.setEditable(false);
			통장명1.setEnabled(false);
		}
		
		

		통장명1.setBounds(10, 50, 460, 30);
		통장명1.setFont(new Font("", Font.BOLD, 15));
		panel1.add(통장명1);

		getContentPane().add(panel1);

		//

		// 3
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 230, 494, 380);
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panel2.setBackground(Color.gray);

		유형 = new JLabel("종류:");
		유형.setBounds(10, 10, 60, 30);
		유형.setFont(new Font("돋움", Font.BOLD, 25));
		panel2.add(유형);

		r1 = new JRadioButton("입출금식(일반)");
		r2 = new JRadioButton("청약 통장");
		r3 = new JRadioButton("적금,부금,예금");
		r4 = new JRadioButton("외화예금");
		유형2 = new ButtonGroup();
		유형2.add(r1);
		유형2.add(r2);
		유형2.add(r3);
		유형2.add(r4);
		r1.setBounds(70, 10, 120, 35);
		r2.setBounds(190, 10, 90, 35);
		r3.setBounds(280, 10, 120, 35);
		r4.setBounds(400, 10, 80, 35);

		r1.setBackground(Color.gray);
		r2.setBackground(Color.gray);
		r3.setBackground(Color.gray);
		r4.setBackground(Color.gray);

	
		
		if (updateVer == false) {
			r1.setSelected(true);// 입출금식 카드 미리 선택
		} else if (updateVer == true) {
			r1.setEnabled(false);
			r2.setEnabled(false);
			r3.setEnabled(false);
			r4.setEnabled(false);
			if (b_type.equals("입출금식(일반)")) {
				r1.setSelected(true);// VISA 카드 미리 선택
			} else if (b_type.equals("청약 통장")) {
				r2.setSelected(true);// VISA 카드 미리 선택
			} else if (b_type.equals("적금,부금,예금")) {
				r3.setSelected(true);// VISA 카드 미리 선택
			} else if (b_type.equals("외화예금")) {
				r4.setSelected(true);// VISA 카드 미리 선택
			}
			
		}
		
		panel2.add(r1);
		panel2.add(r2);
		panel2.add(r3);
		panel2.add(r4);

		신용카드 = new JLabel("계좌번호:");
		신용카드.setBounds(10, 70, 140, 30);
		신용카드.setFont(new Font("돋움", Font.BOLD, 25));
		panel2.add(신용카드);

		if (updateVer == false) {
			신용카드1 = new JTextField("1111");
		} else if (updateVer == true) {
			신용카드1 = new JTextField(b_num1);
			신용카드1.setEditable(false);
			신용카드1.setEnabled(false);
		}

		신용카드1.setBounds(130, 70, 40, 35);
		신용카드1.setFont(new Font("돋움", Font.ITALIC, 20));
		panel2.add(신용카드1);

		
		if (updateVer == false) {
			신용카드2 = new JTextField("222222");
		} else if (updateVer == true) {
			신용카드2 = new JTextField(b_num2);
			신용카드2.setEditable(false);
			신용카드2.setEnabled(false);
		}
		신용카드2.setBounds(180, 70, 80, 35);
		신용카드2.setFont(new Font("돋움", Font.ITALIC, 20));
		panel2.add(신용카드2);

		

		if (updateVer == false) {
			신용카드3 = new JTextField("333");
		} else if (updateVer == true) {
			신용카드3 = new JTextField(b_num3);
			신용카드3.setEditable(false);
			신용카드3.setEnabled(false);
		}
		
		신용카드3.setBounds(270, 70, 40, 35);
		신용카드3.setFont(new Font("돋움", Font.ITALIC, 20));
		panel2.add(신용카드3);

		

		if (updateVer == false) {
			신용카드4 = new JTextField("444");
		} else if (updateVer == true) {
			신용카드4 = new JTextField(b_num4);
			신용카드4.setEditable(false);
			신용카드4.setEnabled(false);
			
		}
		신용카드4.setBounds(320, 70, 40, 35);
		신용카드4.setFont(new Font("돋움", Font.ITALIC, 20));
		panel2.add(신용카드4);

		발행일 = new JLabel("발행일:");
		발행일.setBounds(10, 130, 140, 35);
		발행일.setFont(new Font("돋움", Font.BOLD, 25));
		panel2.add(발행일);

		
		if (updateVer == false) {
			발행일1 = new JTextField("2016-06-01");
		} else if (updateVer == true) {
			발행일1 = new JTextField(b_date);
			발행일1.setEditable(false);
			발행일1.setEnabled(false);
			
		}
		
		발행일1.setBounds(130, 130, 150, 35);
		발행일1.setFont(new Font("돋움", Font.ITALIC, 20));
		panel2.add(발행일1);

		계좌관리점 = new JLabel("계좌관리점:");
		
		계좌관리점.setBounds(10, 190, 140, 35);
		계좌관리점.setFont(new Font("돋움", Font.BOLD, 25));
		panel2.add(계좌관리점);

	

		if (updateVer == false) {
			계좌관리점1 = new JTextField("성공회점,부천점..");
		} else if (updateVer == true) {
			계좌관리점1 = new JTextField(b_department);
			계좌관리점1.setEditable(false);
			계좌관리점1.setEnabled(false);
			
		}
		
		계좌관리점1.setBounds(150, 190, 210, 35);
		계좌관리점1.setFont(new Font("돋움", Font.ITALIC, 20));
		panel2.add(계좌관리점1);

		password = new JLabel("비밀번호:");
		password.setBounds(10, 250, 150, 30);
		password.setFont(new Font("돋움", Font.BOLD, 25));
		panel2.add(password);

		password2 = new JTextField("******");
		if (updateVer == false) {
			
		} else if (updateVer == true) {
			
			password2.setText(b_password);
			
		}
		password2.setBounds(130, 250, 150, 35);
		password2.setFont(new Font("돋움", Font.ITALIC, 20));
		panel2.add(password2);

		getContentPane().add(panel2);

		setVisible(true);
		setResizable(false);
	}

	private void start() {

		// 마우스 리스너들 JTextField 통장명1, 신용카드1, 신용카드2, 신용카드3,
		// 신용카드4, 발행일1, 계좌관리점1, password2;
		통장명1.addMouseListener(this);
		신용카드1.addMouseListener(this);
		신용카드2.addMouseListener(this);
		신용카드3.addMouseListener(this);
		신용카드4.addMouseListener(this);
		발행일1.addMouseListener(this);
		계좌관리점1.addMouseListener(this);
		password2.addMouseListener(this);

		// 버튼 리스너들
		save.addActionListener(this);
		return1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();// 선택된 버튼을 알아낸다
		String selectedString = null;
		if (src == save) {
			// JTextField 통장명1, 신용카드1, 신용카드2, 신용카드3, 신용카드4, 발행일1, 계좌관리점1,
			// password2;
			if (!(통장명1.getText().equals("")) && !(신용카드1.getText().equals("")) && !(신용카드2.getText().equals(""))
					&& !(신용카드3.getText().equals("")) && !(신용카드4.getText().equals("")) && !(발행일1.getText().equals(""))
					&& !(계좌관리점1.getText().equals("")) && !(password2.getText().equals(""))) {

				Enumeration<AbstractButton> enums = 유형2.getElements();
				int gibonCode = 0;
				while (enums.hasMoreElements()) { // hasMoreElements() Enum에 더
													// 꺼낼 개체가 있는지 체크한다. 없으며
													// false 반환
					AbstractButton ab = enums.nextElement(); // 제네릭스가
																// AbstractButton
																// 이니까 당연히
																// AbstractButton으로
																// 받아야함
					JRadioButton jb = (JRadioButton) ab; // 형변환. 물론 윗줄과 이줄을 합쳐서
															// 바로 형변환 해서 받아도 된다.

					if (jb.isSelected())
						selectedString = jb.getText();// 받아낸 라디오버튼의 체크 상태를 확인한다.
														// 체크되었을경우 true 반환.
				}
				
				
				
				if(updateVer==false){
					//정보의 암호화.
					String en통장명1 = makeEnString(통장명1.getText());				
					String en신용카드1 = makeEnString(신용카드1.getText());
					String en신용카드2 = makeEnString(신용카드2.getText());			
					String en신용카드3 =makeEnString(신용카드3.getText());
					String en신용카드4 = makeEnString(신용카드4.getText());
					String en발행일1 = makeEnString(발행일1.getText());
					String en계좌관리점1 = makeEnString(계좌관리점1.getText());
					String enpassword2 = makeEnString(password2.getText());

					// 서버로 보낼 msg 작성
					String msg = en통장명1 + "," + selectedString + "," + en신용카드1 + "," + en신용카드2 + "," + en신용카드3 + ","
							+ en신용카드4 + "," + en발행일1 + "," + en계좌관리점1 + "," + enpassword2 + ","
							+ ClientHandler.getMember().getUserNum();
					System.out.println("통장만들기 전 서버로 보낼 메세지 확인 : " + msg);

					ch.requestaddBankData(msg);

					System.out.println("내용들이 저장되었습니다.");
					new MyBankbook(ClientHandler.getMember());
					dispose();
				}else if (updateVer==true){
					String enpassword2 = makeEnString(password2.getText());
					String msg =enpassword2 + ","+pm_num;
					
					System.out.println("서버로 보낼 메세지 확인 : " + msg);

					ch.requestUpdateBankData(msg);

					System.out.println("내용들이 저장되었습니다.");
					new MyCradit_wallet(ClientHandler.getMember());
					dispose();
				}
				
				
			} else {
				System.out.println("asdasdasd");

				JOptionPane.showMessageDialog(null, "필수항목 중에 빠진 부분이 있습니다. 확인해주세요!!", "확인",
						JOptionPane.INFORMATION_MESSAGE, null);

			}
		} else if (src == return1) {
			new MyBankbook(ClientHandler.getMember());
			dispose();
		}

		else {
			System.out.println("asdasdasd");

			JOptionPane.showMessageDialog(null, "필수항목 중에 빠진 부분이 있습니다. 확인해주세요!!", "확인", JOptionPane.INFORMATION_MESSAGE,
					null);

		}

	}

	public class JTextFieldLimit extends PlainDocument {
		private int limit;

		public JTextFieldLimit(int limit) {
			super();
			this.limit = limit;
		}

		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			if (str == null)
				return;
			if (getLength() + str.length() <= limit)
				super.insertString(offset, str, attr);
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
		// TODO Auto-generated method stub
		Object src = e.getSource();// 선택된 버튼을 알아낸다
		if (updateVer == false) {

			JTextField empty = (JTextField) src;
			empty.setText(null);
		} else if (updateVer == true) {
			// 걍 가만히 있어
		}
		// 마우스 리스너들 JTextField 통장명1, 신용카드1, 신용카드2, 신용카드3,
		// 신용카드4, 발행일1, 계좌관리점1, password2;
		if (src == 신용카드1) {
			신용카드1.setDocument(new JTextFieldLimit(3));
		} else if (src == 신용카드2) {
			신용카드2.setDocument(new JTextFieldLimit(6));
		} else if (src == 신용카드3) {
			신용카드3.setDocument(new JTextFieldLimit(4));
		} else if (src == 신용카드4) {
			신용카드4.setDocument(new JTextFieldLimit(4));
		} else if (src == 발행일1) {
			발행일1.setDocument(new JTextFieldLimit(10));
		} else if (src == 계좌관리점1) {
			계좌관리점1.setDocument(new JTextFieldLimit(10));
		} else if (src == password2) {
			password2.setDocument(new JTextFieldLimit(6));
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