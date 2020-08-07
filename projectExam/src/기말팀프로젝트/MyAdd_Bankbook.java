package �⸻��������Ʈ;

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
import �⸻��������Ʈ.MyAdd_Card.JTextFieldLimit;

import java.awt.*;
import java.awt.image.*;
import java.util.Enumeration;

import javax.swing.*;

public class MyAdd_Bankbook extends JFrame implements ActionListener, MouseListener {
	ImageIcon image1 = new ImageIcon("return����.png");

	JTextField �����1, �ſ�ī��1, �ſ�ī��2, �ſ�ī��3, �ſ�ī��4, ������1, ���°�����1, password2;
	JPanel title, panel1, panel2;
	JButton return1, save;
	JLabel titleLabel, �����, ����, �ſ�ī��, ������, ���°�����, password;
	JRadioButton r1, r2, r3, r4;
	ButtonGroup ����2;
	private ClientHandler ch;

	// �ӽ÷� �����͸� ��Ƶδ� ��
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

	// �������� �������� �������ִ� �÷���
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
			titleLabel = new JLabel("���� �߰�");
		} else if (updateVer == true) {
			titleLabel = new JLabel("���� ����");
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

		����� = new JLabel("���� �̸�");
		�����.setBounds(10, 10, 200, 30);
		�����.setFont(new Font("", Font.BOLD, 25));
		panel1.add(�����);

		if (updateVer == false) {
			�����1 = new JTextField("���� �̸��� �Է��Ͻÿ�. ex)��������,����,�츮");

		} else if (updateVer == true) {
			�����1 = new JTextField(b_name);
			�����1.setEditable(false);
			�����1.setEnabled(false);
		}
		
		

		�����1.setBounds(10, 50, 460, 30);
		�����1.setFont(new Font("", Font.BOLD, 15));
		panel1.add(�����1);

		getContentPane().add(panel1);

		//

		// 3
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 230, 494, 380);
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panel2.setBackground(Color.gray);

		���� = new JLabel("����:");
		����.setBounds(10, 10, 60, 30);
		����.setFont(new Font("����", Font.BOLD, 25));
		panel2.add(����);

		r1 = new JRadioButton("����ݽ�(�Ϲ�)");
		r2 = new JRadioButton("û�� ����");
		r3 = new JRadioButton("����,�α�,����");
		r4 = new JRadioButton("��ȭ����");
		����2 = new ButtonGroup();
		����2.add(r1);
		����2.add(r2);
		����2.add(r3);
		����2.add(r4);
		r1.setBounds(70, 10, 120, 35);
		r2.setBounds(190, 10, 90, 35);
		r3.setBounds(280, 10, 120, 35);
		r4.setBounds(400, 10, 80, 35);

		r1.setBackground(Color.gray);
		r2.setBackground(Color.gray);
		r3.setBackground(Color.gray);
		r4.setBackground(Color.gray);

	
		
		if (updateVer == false) {
			r1.setSelected(true);// ����ݽ� ī�� �̸� ����
		} else if (updateVer == true) {
			r1.setEnabled(false);
			r2.setEnabled(false);
			r3.setEnabled(false);
			r4.setEnabled(false);
			if (b_type.equals("����ݽ�(�Ϲ�)")) {
				r1.setSelected(true);// VISA ī�� �̸� ����
			} else if (b_type.equals("û�� ����")) {
				r2.setSelected(true);// VISA ī�� �̸� ����
			} else if (b_type.equals("����,�α�,����")) {
				r3.setSelected(true);// VISA ī�� �̸� ����
			} else if (b_type.equals("��ȭ����")) {
				r4.setSelected(true);// VISA ī�� �̸� ����
			}
			
		}
		
		panel2.add(r1);
		panel2.add(r2);
		panel2.add(r3);
		panel2.add(r4);

		�ſ�ī�� = new JLabel("���¹�ȣ:");
		�ſ�ī��.setBounds(10, 70, 140, 30);
		�ſ�ī��.setFont(new Font("����", Font.BOLD, 25));
		panel2.add(�ſ�ī��);

		if (updateVer == false) {
			�ſ�ī��1 = new JTextField("1111");
		} else if (updateVer == true) {
			�ſ�ī��1 = new JTextField(b_num1);
			�ſ�ī��1.setEditable(false);
			�ſ�ī��1.setEnabled(false);
		}

		�ſ�ī��1.setBounds(130, 70, 40, 35);
		�ſ�ī��1.setFont(new Font("����", Font.ITALIC, 20));
		panel2.add(�ſ�ī��1);

		
		if (updateVer == false) {
			�ſ�ī��2 = new JTextField("222222");
		} else if (updateVer == true) {
			�ſ�ī��2 = new JTextField(b_num2);
			�ſ�ī��2.setEditable(false);
			�ſ�ī��2.setEnabled(false);
		}
		�ſ�ī��2.setBounds(180, 70, 80, 35);
		�ſ�ī��2.setFont(new Font("����", Font.ITALIC, 20));
		panel2.add(�ſ�ī��2);

		

		if (updateVer == false) {
			�ſ�ī��3 = new JTextField("333");
		} else if (updateVer == true) {
			�ſ�ī��3 = new JTextField(b_num3);
			�ſ�ī��3.setEditable(false);
			�ſ�ī��3.setEnabled(false);
		}
		
		�ſ�ī��3.setBounds(270, 70, 40, 35);
		�ſ�ī��3.setFont(new Font("����", Font.ITALIC, 20));
		panel2.add(�ſ�ī��3);

		

		if (updateVer == false) {
			�ſ�ī��4 = new JTextField("444");
		} else if (updateVer == true) {
			�ſ�ī��4 = new JTextField(b_num4);
			�ſ�ī��4.setEditable(false);
			�ſ�ī��4.setEnabled(false);
			
		}
		�ſ�ī��4.setBounds(320, 70, 40, 35);
		�ſ�ī��4.setFont(new Font("����", Font.ITALIC, 20));
		panel2.add(�ſ�ī��4);

		������ = new JLabel("������:");
		������.setBounds(10, 130, 140, 35);
		������.setFont(new Font("����", Font.BOLD, 25));
		panel2.add(������);

		
		if (updateVer == false) {
			������1 = new JTextField("2016-06-01");
		} else if (updateVer == true) {
			������1 = new JTextField(b_date);
			������1.setEditable(false);
			������1.setEnabled(false);
			
		}
		
		������1.setBounds(130, 130, 150, 35);
		������1.setFont(new Font("����", Font.ITALIC, 20));
		panel2.add(������1);

		���°����� = new JLabel("���°�����:");
		
		���°�����.setBounds(10, 190, 140, 35);
		���°�����.setFont(new Font("����", Font.BOLD, 25));
		panel2.add(���°�����);

	

		if (updateVer == false) {
			���°�����1 = new JTextField("����ȸ��,��õ��..");
		} else if (updateVer == true) {
			���°�����1 = new JTextField(b_department);
			���°�����1.setEditable(false);
			���°�����1.setEnabled(false);
			
		}
		
		���°�����1.setBounds(150, 190, 210, 35);
		���°�����1.setFont(new Font("����", Font.ITALIC, 20));
		panel2.add(���°�����1);

		password = new JLabel("��й�ȣ:");
		password.setBounds(10, 250, 150, 30);
		password.setFont(new Font("����", Font.BOLD, 25));
		panel2.add(password);

		password2 = new JTextField("******");
		if (updateVer == false) {
			
		} else if (updateVer == true) {
			
			password2.setText(b_password);
			
		}
		password2.setBounds(130, 250, 150, 35);
		password2.setFont(new Font("����", Font.ITALIC, 20));
		panel2.add(password2);

		getContentPane().add(panel2);

		setVisible(true);
		setResizable(false);
	}

	private void start() {

		// ���콺 �����ʵ� JTextField �����1, �ſ�ī��1, �ſ�ī��2, �ſ�ī��3,
		// �ſ�ī��4, ������1, ���°�����1, password2;
		�����1.addMouseListener(this);
		�ſ�ī��1.addMouseListener(this);
		�ſ�ī��2.addMouseListener(this);
		�ſ�ī��3.addMouseListener(this);
		�ſ�ī��4.addMouseListener(this);
		������1.addMouseListener(this);
		���°�����1.addMouseListener(this);
		password2.addMouseListener(this);

		// ��ư �����ʵ�
		save.addActionListener(this);
		return1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();// ���õ� ��ư�� �˾Ƴ���
		String selectedString = null;
		if (src == save) {
			// JTextField �����1, �ſ�ī��1, �ſ�ī��2, �ſ�ī��3, �ſ�ī��4, ������1, ���°�����1,
			// password2;
			if (!(�����1.getText().equals("")) && !(�ſ�ī��1.getText().equals("")) && !(�ſ�ī��2.getText().equals(""))
					&& !(�ſ�ī��3.getText().equals("")) && !(�ſ�ī��4.getText().equals("")) && !(������1.getText().equals(""))
					&& !(���°�����1.getText().equals("")) && !(password2.getText().equals(""))) {

				Enumeration<AbstractButton> enums = ����2.getElements();
				int gibonCode = 0;
				while (enums.hasMoreElements()) { // hasMoreElements() Enum�� ��
													// ���� ��ü�� �ִ��� üũ�Ѵ�. ������
													// false ��ȯ
					AbstractButton ab = enums.nextElement(); // ���׸�����
																// AbstractButton
																// �̴ϱ� �翬��
																// AbstractButton����
																// �޾ƾ���
					JRadioButton jb = (JRadioButton) ab; // ����ȯ. ���� ���ٰ� ������ ���ļ�
															// �ٷ� ����ȯ �ؼ� �޾Ƶ� �ȴ�.

					if (jb.isSelected())
						selectedString = jb.getText();// �޾Ƴ� ������ư�� üũ ���¸� Ȯ���Ѵ�.
														// üũ�Ǿ������ true ��ȯ.
				}
				
				
				
				if(updateVer==false){
					//������ ��ȣȭ.
					String en�����1 = makeEnString(�����1.getText());				
					String en�ſ�ī��1 = makeEnString(�ſ�ī��1.getText());
					String en�ſ�ī��2 = makeEnString(�ſ�ī��2.getText());			
					String en�ſ�ī��3 =makeEnString(�ſ�ī��3.getText());
					String en�ſ�ī��4 = makeEnString(�ſ�ī��4.getText());
					String en������1 = makeEnString(������1.getText());
					String en���°�����1 = makeEnString(���°�����1.getText());
					String enpassword2 = makeEnString(password2.getText());

					// ������ ���� msg �ۼ�
					String msg = en�����1 + "," + selectedString + "," + en�ſ�ī��1 + "," + en�ſ�ī��2 + "," + en�ſ�ī��3 + ","
							+ en�ſ�ī��4 + "," + en������1 + "," + en���°�����1 + "," + enpassword2 + ","
							+ ClientHandler.getMember().getUserNum();
					System.out.println("���常��� �� ������ ���� �޼��� Ȯ�� : " + msg);

					ch.requestaddBankData(msg);

					System.out.println("������� ����Ǿ����ϴ�.");
					new MyBankbook(ClientHandler.getMember());
					dispose();
				}else if (updateVer==true){
					String enpassword2 = makeEnString(password2.getText());
					String msg =enpassword2 + ","+pm_num;
					
					System.out.println("������ ���� �޼��� Ȯ�� : " + msg);

					ch.requestUpdateBankData(msg);

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
			new MyBankbook(ClientHandler.getMember());
			dispose();
		}

		else {
			System.out.println("asdasdasd");

			JOptionPane.showMessageDialog(null, "�ʼ��׸� �߿� ���� �κ��� �ֽ��ϴ�. Ȯ�����ּ���!!", "Ȯ��", JOptionPane.INFORMATION_MESSAGE,
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
		Object src = e.getSource();// ���õ� ��ư�� �˾Ƴ���
		if (updateVer == false) {

			JTextField empty = (JTextField) src;
			empty.setText(null);
		} else if (updateVer == true) {
			// �� ������ �־�
		}
		// ���콺 �����ʵ� JTextField �����1, �ſ�ī��1, �ſ�ī��2, �ſ�ī��3,
		// �ſ�ī��4, ������1, ���°�����1, password2;
		if (src == �ſ�ī��1) {
			�ſ�ī��1.setDocument(new JTextFieldLimit(3));
		} else if (src == �ſ�ī��2) {
			�ſ�ī��2.setDocument(new JTextFieldLimit(6));
		} else if (src == �ſ�ī��3) {
			�ſ�ī��3.setDocument(new JTextFieldLimit(4));
		} else if (src == �ſ�ī��4) {
			�ſ�ī��4.setDocument(new JTextFieldLimit(4));
		} else if (src == ������1) {
			������1.setDocument(new JTextFieldLimit(10));
		} else if (src == ���°�����1) {
			���°�����1.setDocument(new JTextFieldLimit(10));
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

}