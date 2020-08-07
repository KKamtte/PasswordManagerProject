package �⸻��������Ʈ;

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
	ImageIcon image1 = new ImageIcon("return����.png");

	JTextField ī���1, �ſ�ī��1, �ſ�ī��2, �ſ�ī��3, �ſ�ī��4, password2;
	JPanel title, panel1, panel2, panel3, panel4;
	JLabel titleLabel, ī���, �ſ�ī��, password, ������, month2, year2, �߱���, month4, year4;
	JButton return1, save;
	JRadioButton r1, r2, r3, r4;
	ButtonGroup ����2;
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
			titleLabel = new JLabel("ī�� �߰�");
		} else if (updateVer == true) {
			titleLabel = new JLabel("ī�� ����");
		}

		titleLabel.setFont(new Font("", Font.BOLD, 30));
		titleLabel.setBounds(180, 30, 200, 50);
		title.add(titleLabel);

		if (updateVer == false) {
			save = new JButton("����");
		} else if (updateVer == true) {
			save = new JButton("����");
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

		ī��� = new JLabel("ī����� �̸�");
		ī���.setBounds(10, 10, 200, 30);
		ī���.setFont(new Font("", Font.BOLD, 25));
		panel1.add(ī���);

		if (updateVer == false) {
			ī���1 = new JTextField("ī����� �̸��� �Է��Ͻÿ�. ex)����.������ī��");
		} else if (updateVer == true) {
			ī���1 = new JTextField(c_name);
			ī���1.setEditable(false);
			ī���1.setEnabled(false);
		}

		ī���1.setBounds(10, 50, 460, 30);
		ī���1.setFont(new Font("", Font.BOLD, 15));
		panel1.add(ī���1);

		getContentPane().add(panel1);

		//

		// 3
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 230, 494, 380);
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panel2.setBackground(Color.gray);

		JLabel ���� = new JLabel("����:");
		����.setBounds(10, 10, 60, 30);
		����.setFont(new Font("����", Font.BOLD, 25));
		panel2.add(����);

		r1 = new JRadioButton("VISA");
		r2 = new JRadioButton("Master Card");
		r3 = new JRadioButton("American Express");
		r4 = new JRadioButton("etc...");
		����2 = new ButtonGroup();
		����2.add(r1);
		����2.add(r2);
		����2.add(r3);
		����2.add(r4);
		r1.setBounds(90, 10, 60, 35);
		r2.setBounds(160, 10, 100, 35);
		r3.setBounds(270, 10, 130, 35);
		r4.setBounds(410, 10, 60, 35);

		r1.setBackground(Color.gray);
		r2.setBackground(Color.gray);
		r3.setBackground(Color.gray);
		r4.setBackground(Color.gray);

		if (updateVer == false) {
			r1.setSelected(true);// VISA ī�� �̸� ����
		} else if (updateVer == true) {
			r1.setEnabled(false);
			r2.setEnabled(false);
			r3.setEnabled(false);
			r4.setEnabled(false);
			if (c_type.equals("VISA")) {
				r1.setSelected(true);// VISA ī�� �̸� ����
			} else if (c_type.equals("Master Card")) {
				r2.setSelected(true);// VISA ī�� �̸� ����
			} else if (c_type.equals("American Express")) {
				r3.setSelected(true);// VISA ī�� �̸� ����
			} else if (c_type.equals("etc...")) {
				r4.setSelected(true);// VISA ī�� �̸� ����
			}
			
		}

		panel2.add(r1);
		panel2.add(r2);
		panel2.add(r3);
		panel2.add(r4);

		�ſ�ī�� = new JLabel("�ſ�ī�� ��ȣ:");
		�ſ�ī��.setBounds(10, 70, 180, 30);
		�ſ�ī��.setFont(new Font("����", Font.BOLD, 25));
		panel2.add(�ſ�ī��);

		if (updateVer == false) {
			�ſ�ī��1 = new JTextField("1111");
		} else if (updateVer == true) {
			�ſ�ī��1 = new JTextField(c_num1);
			�ſ�ī��1.setEditable(false);
			�ſ�ī��1.setEnabled(false);
		}

		�ſ�ī��1.setBounds(180, 70, 60, 35);
		�ſ�ī��1.setFont(new Font("����", Font.ITALIC, 20));
		panel2.add(�ſ�ī��1);

		if (updateVer == false) {
			�ſ�ī��2 = new JTextField("2222");
		} else if (updateVer == true) {
			�ſ�ī��2 = new JTextField(c_num2);
			�ſ�ī��2.setEditable(false);
			�ſ�ī��2.setEnabled(false);
		}

		�ſ�ī��2.setBounds(250, 70, 60, 35);
		�ſ�ī��2.setFont(new Font("����", Font.ITALIC, 20));

		panel2.add(�ſ�ī��2);

		if (updateVer == false) {
			�ſ�ī��3 = new JTextField("3333");
		} else if (updateVer == true) {
			�ſ�ī��3 = new JTextField(c_num3);
			�ſ�ī��3.setEditable(false);
			�ſ�ī��3.setEnabled(false);
		}

		�ſ�ī��3.setBounds(320, 70, 60, 35);
		�ſ�ī��3.setFont(new Font("����", Font.ITALIC, 20));
		panel2.add(�ſ�ī��3);

		if (updateVer == false) {
			�ſ�ī��4 = new JTextField("4444");
		} else if (updateVer == true) {
			�ſ�ī��4 = new JTextField(c_num4);
			�ſ�ī��4.setEditable(false);
			�ſ�ī��4.setEnabled(false);
			
		}

		�ſ�ī��4.setBounds(390, 70, 60, 35);
		�ſ�ī��4.setFont(new Font("����", Font.ITALIC, 20));
		panel2.add(�ſ�ī��4);

		password = new JLabel("��й�ȣ:");
		password.setBounds(10, 310, 150, 30);
		password.setFont(new Font("����", Font.BOLD, 25));
		panel2.add(password);
		password2 = new JTextField("123456");
		if (updateVer == false) {
			
		} else if (updateVer == true) {
			System.out.println(c_password);
			password2.setText(c_password);
			
		}
		
		
		password2.setBounds(130, 310, 150, 35);
		password2.setFont(new Font("����", Font.ITALIC, 20));

		panel2.add(password2);

		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(5, 350, 200, 170);
		panel3.setBorder(BorderFactory.createTitledBorder("��¥"));
		panel3.setBackground(Color.gray);

		������ = new JLabel("������");
		������.setBounds(10, 20, 130, 30);
		������.setFont(new Font("����", Font.BOLD, 25));
		panel3.add(������);

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
		panel4.setBorder(BorderFactory.createTitledBorder("��¥"));
		panel4.setBackground(Color.gray);

		�߱��� = new JLabel("�߱���");
		�߱���.setBounds(10, 20, 130, 30);
		�߱���.setFont(new Font("����", Font.BOLD, 25));
		panel4.add(�߱���);
		// �޺��ڽ�

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
		// ���콺 �����ʵ� ī���1,�ſ�ī��1,�ſ�ī��2,�ſ�ī��3,�ſ�ī��4,password2
		ī���1.addMouseListener(this);
		�ſ�ī��1.addMouseListener(this);
		�ſ�ī��2.addMouseListener(this);
		�ſ�ī��3.addMouseListener(this);
		�ſ�ī��4.addMouseListener(this);
		password2.addMouseListener(this);

		// ��ư �����ʵ�
		save.addActionListener(this);
		return1.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String selectedString = null;
		Object src = e.getSource();// ���õ� ��ư�� �˾Ƴ���
		if (src == save) {
			// ������ ������ �����ϱ� insert ���̹Ƿ� ȸ�����԰� ������ ����ϴ�.
			if (!(ī���1.getText().equals("")) && !(�ſ�ī��1.getText().equals("")) && !(�ſ�ī��2.getText().equals(""))
					&& !(�ſ�ī��3.getText().equals("")) && !(�ſ�ī��4.getText().equals(""))
					&& !(password2.getText().equals(""))) {

				Enumeration<AbstractButton> enums = ����2.getElements();
				int gibonCode = 0;
				while (enums.hasMoreElements()) {
					AbstractButton ab = enums.nextElement();
					JRadioButton jb = (JRadioButton) ab;

					if (jb.isSelected())
						selectedString = jb.getText();
				}

				
				
				if(updateVer==false){
					//������ ��ȣȭ.
					String enī���1 = makeEnString(ī���1.getText());
					String entype = makeEnString(selectedString);
					String en�ſ�ī��1 = makeEnString(�ſ�ī��1.getText());
					String en�ſ�ī��2 = makeEnString(�ſ�ī��2.getText());
					String en�ſ�ī��3 = makeEnString(�ſ�ī��3.getText());
					String en�ſ�ī��4 = makeEnString(�ſ�ī��4.getText());
					String enpassword2 = makeEnString(password2.getText());

					// �޺��ڽ����� ���� ��������
					// �޺��ڽ��� �� 4�� month, year, month3, year3;

					String enmonth = makeEnString((String) month.getSelectedItem());
					String enyear = makeEnString((String) year.getSelectedItem());
					String enmonth3 = makeEnString((String) month3.getSelectedItem());
					String enyear3 = makeEnString((String) year3.getSelectedItem());
					// ������ ���� msg �ۼ�
					String msg = enī���1 + "," + entype + "," + en�ſ�ī��1 + "," + en�ſ�ī��2 + "," + en�ſ�ī��3 + "," + en�ſ�ī��4 + ","
							+ enmonth + "," + enyear + "," + enmonth3 + "," + enyear3 + "," + enpassword2 + ","
							+ ClientHandler.getMember().getUserNum();
					
					System.out.println("������ ���� �޼��� Ȯ�� : " + msg);

					ch.requestaddCardData(msg);

					System.out.println("������� ����Ǿ����ϴ�.");
					new MyCradit_wallet(ClientHandler.getMember());
					dispose();
				}else if ( updateVer==true){
					String enpassword2 = makeEnString(password2.getText());
					String msg =enpassword2 + ","+pm_num;
					
					System.out.println("������ ���� �޼��� Ȯ�� : " + msg);

					ch.requestUpdateCardData(msg);

					System.out.println("������� ����Ǿ����ϴ�.");
					new MyCradit_wallet(ClientHandler.getMember());
					dispose();
				}
				
			} else {
				System.out.println("asdasdasd");

				JOptionPane.showMessageDialog(null, "�ʼ��׸� �߿� ���� �κ��� �ֽ��ϴ�. Ȯ�����ּ���!!", "Ȯ��",
						JOptionPane.INFORMATION_MESSAGE, null);

			}
		} else if (src == return1) {
			new MyCradit_wallet(ClientHandler.getMember());
			dispose();

		}

		else {
			System.out.println("asdasdasd");

			JOptionPane.showMessageDialog(null, "�ʼ��׸� �߿� ���� �κ��� �ֽ��ϴ�. Ȯ�����ּ���!!", "Ȯ��", JOptionPane.INFORMATION_MESSAGE,
					null);

		}
	}

	private String makeEnString(String text) {
		Encrypt en = null;

		try { // ī���1 ��ȣȭ
			en = new Encrypt(text);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("��ȣȭ(ī���1)�� �� : " + en.getEnco());
		// String enī���1 = en.getEnco();
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
		Object src = e.getSource();// ���õ� ��ư�� �˾Ƴ���
		if(updateVer==false){
			
			JTextField empty = (JTextField) src;
			empty.setText(null);
		}else if( updateVer==true){
			//�� ������ �־� 
		}
		// �ſ�ī��2.setDocument(new JTextFieldLimit(4));
		if (src == �ſ�ī��1) {
			�ſ�ī��1.setDocument(new JTextFieldLimit(4));
		} else if (src == �ſ�ī��2) {
			�ſ�ī��2.setDocument(new JTextFieldLimit(4));
		} else if (src == �ſ�ī��3) {
			�ſ�ī��3.setDocument(new JTextFieldLimit(4));
		} else if (src == �ſ�ī��4) {
			�ſ�ī��4.setDocument(new JTextFieldLimit(4));
		} else if ( src == password2){
			password2.setDocument(new JTextFieldLimit(6));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
