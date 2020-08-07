package 기말팀프로젝트;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import Security.Encrypt;
import client.ClientHandler;

import java.awt.*;
import java.awt.image.*;
import java.util.Enumeration;

import javax.swing.*;

public class MyAdd_Card extends JFrame implements ActionListener, MouseListener {
	//ClassLoader c1 = this.getClass().getClassLoader();
	ImageIcon image1 = new ImageIcon("return투명.png");

	JTextField 카드명1, 신용카드1, 신용카드2, 신용카드3, 신용카드4, password2;
	JPanel title, panel1, panel2, panel3, panel4;
	JLabel titleLabel, 카드명, 신용카드, password, 만료일, month2, year2, 발급일, month4, year4;
	JButton return1, save;
	JRadioButton r1, r2, r3, r4;
	ButtonGroup 유형2;
	String[] monthArray = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
	JComboBox month, year, month3, year3;
	String[] yearArray = { "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
			"31" };
	String[] S_monthArray = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
	String[] S_yearArray = { "08", "09", "10", "11", "12", "13", "14", "15", "16" };

	private ClientHandler ch;

	boolean updateVer = false;
	int pm_num;
	String c_name;
	String c_type;
	String c_num1;
	String c_num2;
	String c_num3;
	String c_num4;
	String c_end_month;
	String c_end_year;
	String c_start_month;
	String c_start_year;
	String c_password;

	public MyAdd_Card() {
		init();
		start();
		ch = ClientHandler.getInstance();
	}

	public MyAdd_Card(int pm_num, String c_name, String c_type, String c_num1, String c_num2, String c_num3,
			String c_num4, String c_end_month, String c_end_year, String c_start_month, String c_start_year,
			String c_password) {
		updateVer=true;
		this.pm_num = pm_num;
		this.c_name = c_name;
		this.c_type = c_type;
		this.c_num1 = c_num1;
		this.c_num2 = c_num2;
		this.c_num3 = c_num3;
		this.c_num4 = c_num4;
		this.c_end_month = c_end_month;
		this.c_end_year = c_end_year;
		this.c_start_month = c_start_month;
		this.c_start_year = c_start_year;
		this.c_password = c_password;

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

		return1.setBounds(10, 25, 70, 50);
		return1.setBorderPainted(false);
		return1.setBackground(new Color(204, 204, 204));
		return1.setBorder(BorderFactory.createEmptyBorder());
		title.add(return1);

		if (updateVer == false) {
			titleLabel = new JLabel("카드 추가");
		} else if (updateVer == true) {
			titleLabel = new JLabel("카드 정보");
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

		카드명 = new JLabel("카드상의 이름");
		카드명.setBounds(10, 10, 200, 30);
		카드명.setFont(new Font("", Font.BOLD, 25));
		panel1.add(카드명);

		if (updateVer == false) {
			카드명1 = new JTextField("카드상의 이름을 입력하시오. ex)신한.나라사랑카드");
		} else if (updateVer == true) {
			카드명1 = new JTextField(c_name);
			카드명1.setEditable(false);
			카드명1.setEnabled(false);
		}

		카드명1.setBounds(10, 50, 460, 30);
		카드명1.setFont(new Font("", Font.BOLD, 15));
		panel1.add(카드명1);

		getContentPane().add(panel1);

		//

		// 3
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 230, 494, 380);
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panel2.setBackground(Color.gray);

		JLabel 유형 = new JLabel("유형:");
		유형.setBounds(10, 10, 60, 30);
		유형.setFont(new Font("돋움", Font.BOLD, 25));
		panel2.add(유형);

		r1 = new JRadioButton("VISA");
		r2 = new JRadioButton("Master Card");
		r3 = new JRadioButton("American Express");
		r4 = new JRadioButton("etc...");
		유형2 = new ButtonGroup();
		유형2.add(r1);
		유형2.add(r2);
		유형2.add(r3);
		유형2.add(r4);
		r1.setBounds(90, 10, 60, 35);
		r2.setBounds(160, 10, 100, 35);
		r3.setBounds(270, 10, 130, 35);
		r4.setBounds(410, 10, 60, 35);

		r1.setBackground(Color.gray);
		r2.setBackground(Color.gray);
		r3.setBackground(Color.gray);
		r4.setBackground(Color.gray);

		if (updateVer == false) {
			r1.setSelected(true);// VISA 카드 미리 선택
		} else if (updateVer == true) {
			r1.setEnabled(false);
			r2.setEnabled(false);
			r3.setEnabled(false);
			r4.setEnabled(false);
			if (c_type.equals("VISA")) {
				r1.setSelected(true);// VISA 카드 미리 선택
			} else if (c_type.equals("Master Card")) {
				r2.setSelected(true);// VISA 카드 미리 선택
			} else if (c_type.equals("American Express")) {
				r3.setSelected(true);// VISA 카드 미리 선택
			} else if (c_type.equals("etc...")) {
				r4.setSelected(true);// VISA 카드 미리 선택
			}
			
		}

		panel2.add(r1);
		panel2.add(r2);
		panel2.add(r3);
		panel2.add(r4);

		신용카드 = new JLabel("신용카드 번호:");
		신용카드.setBounds(10, 70, 180, 30);
		신용카드.setFont(new Font("돋움", Font.BOLD, 25));
		panel2.add(신용카드);

		if (updateVer == false) {
			신용카드1 = new JTextField("1111");
		} else if (updateVer == true) {
			신용카드1 = new JTextField(c_num1);
			신용카드1.setEditable(false);
			신용카드1.setEnabled(false);
		}

		신용카드1.setBounds(180, 70, 60, 35);
		신용카드1.setFont(new Font("돋움", Font.ITALIC, 20));
		panel2.add(신용카드1);

		if (updateVer == false) {
			신용카드2 = new JTextField("2222");
		} else if (updateVer == true) {
			신용카드2 = new JTextField(c_num2);
			신용카드2.setEditable(false);
			신용카드2.setEnabled(false);
		}

		신용카드2.setBounds(250, 70, 60, 35);
		신용카드2.setFont(new Font("돋움", Font.ITALIC, 20));

		panel2.add(신용카드2);

		if (updateVer == false) {
			신용카드3 = new JTextField("3333");
		} else if (updateVer == true) {
			신용카드3 = new JTextField(c_num3);
			신용카드3.setEditable(false);
			신용카드3.setEnabled(false);
		}

		신용카드3.setBounds(320, 70, 60, 35);
		신용카드3.setFont(new Font("돋움", Font.ITALIC, 20));
		panel2.add(신용카드3);

		if (updateVer == false) {
			신용카드4 = new JTextField("4444");
		} else if (updateVer == true) {
			신용카드4 = new JTextField(c_num4);
			신용카드4.setEditable(false);
			신용카드4.setEnabled(false);
			
		}

		신용카드4.setBounds(390, 70, 60, 35);
		신용카드4.setFont(new Font("돋움", Font.ITALIC, 20));
		panel2.add(신용카드4);

		password = new JLabel("비밀번호:");
		password.setBounds(10, 310, 150, 30);
		password.setFont(new Font("돋움", Font.BOLD, 25));
		panel2.add(password);
		password2 = new JTextField("123456");
		if (updateVer == false) {
			
		} else if (updateVer == true) {
			System.out.println(c_password);
			password2.setText(c_password);
			
		}
		
		
		password2.setBounds(130, 310, 150, 35);
		password2.setFont(new Font("돋움", Font.ITALIC, 20));

		panel2.add(password2);

		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(5, 350, 200, 170);
		panel3.setBorder(BorderFactory.createTitledBorder("날짜"));
		panel3.setBackground(Color.gray);

		만료일 = new JLabel("만료일");
		만료일.setBounds(10, 20, 130, 30);
		만료일.setFont(new Font("돋움", Font.BOLD, 25));
		panel3.add(만료일);

		month2 = new JLabel("month");
		month2.setForeground(Color.WHITE);
		month2.setBounds(30, 60, 50, 30);
		panel3.add(month2);

		month = new JComboBox(monthArray);
		if (updateVer == false) {

		} else if (updateVer == true) {
			month.setSelectedIndex(Integer.parseInt(c_end_month));
			month.setEnabled(false);
		}

		month.setBounds(10, 90, 80, 60);

		year2 = new JLabel("year");
		year2.setForeground(Color.WHITE);
		year2.setBounds(130, 60, 50, 30);
		panel3.add(year2);

		year = new JComboBox(yearArray);

	
		if (updateVer == false) {

		} else if (updateVer == true) {
			System.out.println(c_end_year);
			System.out.println(year.getSelectedIndex());
			year.setSelectedIndex(Integer.parseInt(c_end_year)-17);
			year.setEnabled(false);
		}
		year.setBounds(110, 90, 80, 60);

		panel3.add(month);
		panel3.add(year);
		//

		panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setBounds(230, 350, 200, 170);
		panel4.setBorder(BorderFactory.createTitledBorder("날짜"));
		panel4.setBackground(Color.gray);

		발급일 = new JLabel("발급일");
		발급일.setBounds(10, 20, 130, 30);
		발급일.setFont(new Font("돋움", Font.BOLD, 25));
		panel4.add(발급일);
		// 콤보박스

		month4 = new JLabel("month");
		month4.setForeground(Color.WHITE);
		month4.setBounds(30, 60, 50, 30);
		panel4.add(month4);

		month3 = new JComboBox(S_monthArray);
		if (updateVer == false) {

		} else if (updateVer == true) {
			month3.setSelectedIndex(Integer.parseInt(c_start_month));
			month3.setEnabled(false);
		}
		month3.setBounds(10, 90, 80, 60);

		year4 = new JLabel("year");
		year4.setForeground(Color.WHITE);
		year4.setBounds(130, 60, 50, 30);
		panel4.add(year4);

		year3 = new JComboBox(S_yearArray);
		if (updateVer == false) {

		} else if (updateVer == true) {
			System.out.println(c_start_year);
			String st[];
			try {
				Integer.parseInt(c_start_year);
				System.out.println(year3.getSelectedIndex());
				year3.setSelectedIndex(Integer.parseInt(c_start_year)-8);
			} catch (Exception e) {
				// TODO: handle exception
				st=c_start_year.split("0");
				System.out.println("st.length  : "+st.length);
				System.out.println(year3.getSelectedIndex());
				year3.setSelectedIndex(Integer.parseInt(st[1])-8);
			}
			
	
			
			year3.setEnabled(false);
		}

		year3.setBounds(110, 90, 80, 60);

		panel4.add(month3);
		panel4.add(year3);
		//

		getContentPane().add(panel3);
		getContentPane().add(panel4);
		getContentPane().add(panel2);

		setVisible(true);
		setResizable(false);
	}

	private void start() {
		// 마우스 리스너들 카드명1,신용카드1,신용카드2,신용카드3,신용카드4,password2
		카드명1.addMouseListener(this);
		신용카드1.addMouseListener(this);
		신용카드2.addMouseListener(this);
		신용카드3.addMouseListener(this);
		신용카드4.addMouseListener(this);
		password2.addMouseListener(this);

		// 버튼 리스너들
		save.addActionListener(this);
		return1.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String selectedString = null;
		Object src = e.getSource();// 선택된 버튼을 알아낸다
		if (src == save) {
			// 값들을 서버로 전송하기 insert 문이므로 회원가입과 형식이 비슷하다.
			if (!(카드명1.getText().equals("")) && !(신용카드1.getText().equals("")) && !(신용카드2.getText().equals(""))
					&& !(신용카드3.getText().equals("")) && !(신용카드4.getText().equals(""))
					&& !(password2.getText().equals(""))) {

				Enumeration<AbstractButton> enums = 유형2.getElements();
				int gibonCode = 0;
				while (enums.hasMoreElements()) {
					AbstractButton ab = enums.nextElement();
					JRadioButton jb = (JRadioButton) ab;

					if (jb.isSelected())
						selectedString = jb.getText();
				}

				
				
				if(updateVer==false){
					//정보의 암호화.
					String en카드명1 = makeEnString(카드명1.getText());
					String entype = makeEnString(selectedString);
					String en신용카드1 = makeEnString(신용카드1.getText());
					String en신용카드2 = makeEnString(신용카드2.getText());
					String en신용카드3 = makeEnString(신용카드3.getText());
					String en신용카드4 = makeEnString(신용카드4.getText());
					String enpassword2 = makeEnString(password2.getText());

					// 콤보박스에서 내용 가져오기
					// 콤보박스는 총 4개 month, year, month3, year3;

					String enmonth = makeEnString((String) month.getSelectedItem());
					String enyear = makeEnString((String) year.getSelectedItem());
					String enmonth3 = makeEnString((String) month3.getSelectedItem());
					String enyear3 = makeEnString((String) year3.getSelectedItem());
					// 서버로 보낼 msg 작성
					String msg = en카드명1 + "," + entype + "," + en신용카드1 + "," + en신용카드2 + "," + en신용카드3 + "," + en신용카드4 + ","
							+ enmonth + "," + enyear + "," + enmonth3 + "," + enyear3 + "," + enpassword2 + ","
							+ ClientHandler.getMember().getUserNum();
					
					System.out.println("서버로 보낼 메세지 확인 : " + msg);

					ch.requestaddCardData(msg);

					System.out.println("내용들이 저장되었습니다.");
					new MyCradit_wallet(ClientHandler.getMember());
					dispose();
				}else if ( updateVer==true){
					String enpassword2 = makeEnString(password2.getText());
					String msg =enpassword2 + ","+pm_num;
					
					System.out.println("서버로 보낼 메세지 확인 : " + msg);

					ch.requestUpdateCardData(msg);

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
			new MyCradit_wallet(ClientHandler.getMember());
			dispose();

		}

		else {
			System.out.println("asdasdasd");

			JOptionPane.showMessageDialog(null, "필수항목 중에 빠진 부분이 있습니다. 확인해주세요!!", "확인", JOptionPane.INFORMATION_MESSAGE,
					null);

		}
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
		Object src = e.getSource();// 선택된 버튼을 알아낸다
		if(updateVer==false){
			
			JTextField empty = (JTextField) src;
			empty.setText(null);
		}else if( updateVer==true){
			//걍 가만히 있어 
		}
		// 신용카드2.setDocument(new JTextFieldLimit(4));
		if (src == 신용카드1) {
			신용카드1.setDocument(new JTextFieldLimit(4));
		} else if (src == 신용카드2) {
			신용카드2.setDocument(new JTextFieldLimit(4));
		} else if (src == 신용카드3) {
			신용카드3.setDocument(new JTextFieldLimit(4));
		} else if (src == 신용카드4) {
			신용카드4.setDocument(new JTextFieldLimit(4));
		} else if ( src == password2){
			password2.setDocument(new JTextFieldLimit(6));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
