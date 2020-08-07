package �⸻��������Ʈ;

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
	ImageIcon image1 = new ImageIcon("return����.png");
	ImageIcon image2 = new ImageIcon("������3.png");
	ImageIcon image3 = new ImageIcon("����2.png");
	ImageIcon image4 = new ImageIcon("eyes.png");
	JTextField ����1, URL2, ID2, password2;
	JPanel title, panel1, panel2, panel3, panel4;
	JButton return1, save, ������, ����, ��;
	JLabel titleLabel, ����, URL, ID, password;

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

		titleLabel = new JLabel("��ȣ�߰�");
		titleLabel.setFont(new Font("", Font.BOLD, 30));
		titleLabel.setBounds(180, 30, 200, 50);
		title.add(titleLabel);

		if(updateVer==false){
			save = new JButton("����");
		}else if (updateVer==true) {
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
		panel1.setBounds(0, 210, 494, 100);
		panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panel1.setBackground(Color.gray);
		
		
			���� = new JLabel("����Ʈ ��");
		
		
		
		����.setBounds(10, 10, 200, 30);
		����.setFont(new Font("", Font.PLAIN, 25));
		panel1.add(����);

		
		if(updateVer==false){
			����1 = new JTextField("����Ʈ ���� �Է��Ͻÿ�. ex) ���̹�,����");
		}else if(updateVer == true){
			����1 = new JTextField(siteNameDate);
		}
		

		����1.setBounds(10, 50, 440, 30);
		����1.setFont(new Font("", Font.BOLD, 20));
		panel1.add(����1);

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
			URL2 = new JTextField("URL�� �Է��Ͻÿ�. ex) http://www.naver.com");
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
			ID2 = new JTextField("ID�� �Է��Ͻÿ�. ex) SKHU <3");
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

		password = new JLabel("�н�����");
		password.setBounds(10, 10, 200, 30);
		password.setFont(new Font("", Font.PLAIN, 25));
		panel4.add(password);

		if(updateVer==false){
			password2 = new JTextField("password�� �Է��Ͻÿ�.");
		}else if(updateVer == true){
			
			password2 = new JTextField(pwDate);
		}
		

		password2.setBounds(10, 50, 440, 30);
		password2.setFont(new Font("", Font.BOLD, 20));
		panel4.add(password2);

		������ = new JButton(image2);

		������.setBounds(280, 10, 50, 30);
		panel4.add(������);

		���� = new JButton(image3);

		����.setBounds(340, 10, 50, 30);
		panel4.add(����);

		�� = new JButton(image4);

		��.setBounds(400, 10, 50, 30);
		panel4.add(��);

		getContentPane().add(panel4);
		//

		setVisible(true);
		setResizable(false);

	}

	private void start() {
		// ���콺 �����ʵ� ����1, URL2, ID2, password2;
		password2.addMouseListener(this);
		ID2.addMouseListener(this);
		URL2.addMouseListener(this);
		����1.addMouseListener(this);
		// ��ư �����ʵ�
		save.addActionListener(this);
		return1.addActionListener(this);
		������.addActionListener(this);
		����.addActionListener(this);
		��.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();// ���õ� ��ư�� �˾Ƴ���
		if (src == save) {
			// ������ ������ �����ϱ� insert ���̹Ƿ� ȸ�����԰� ������ ����ϴ�.
			if (!(����1.getText().equals("")) && !(URL2.getText().equals("")) && !(ID2.getText().equals(""))
					&& !(password2.getText().equals(""))) {

				// ������ ���� msg �ۼ�

				String en����1 = makeEnString(����1.getText());
				String enURL2 = makeEnString(URL2.getText());

				String enID2 = makeEnString(ID2.getText());
				String enpassword2 = makeEnString(password2.getText());

				

				
				if(updateVer==false){
					String msg = en����1 + "," + enURL2 + "," + enID2 + "," + enpassword2 + ","
							+ ClientHandler.getMember().getUserNum();
					
					System.out.println("������ ���� �޼��� Ȯ�� : " + msg);
					//���� ���Ӱ� �߰�
					ch.requestaddPwData(msg);

					System.out.println("������� ����Ǿ����ϴ�.");
					new MyPassword(ClientHandler.getMember());
					dispose();
				}else if(updateVer==true){
					String msg = en����1 + "," + enURL2 + "," + enID2 + "," + enpassword2 + ","
							+pm_numDate ;
					
					System.out.println("������ ���� �޼��� Ȯ�� : " + msg);
					//������ ���� ����
					ch.requestupdatePwData(msg);

					System.out.println("������� ����Ǿ����ϴ�.");
					new MyPassword(ClientHandler.getMember());
					dispose();
				}
				
			} else {
				System.out.println("asdasdasd");

				JOptionPane.showMessageDialog(null, "�ʼ��׸� �߿� ���� �κ��� �ֽ��ϴ�. Ȯ�����ּ���!!", "Ȯ��",
						JOptionPane.INFORMATION_MESSAGE, null);

			}
		} else if (src == return1) {
			new MyPassword(ClientHandler.getMember());
			dispose();
		} else if (src == ������) {
			new PassWord_init();

		} else if (src == ����) {
			JLabel msg = new JLabel();
			msg.setText("��й�ȣ�� �����Ͻðڽ��ϱ�?");
			if (JOptionPane.showConfirmDialog(null, msg, "Ȯ��", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
				password2.getText();// ��й�ȣ ��� �б�
			} else {
			}

		} else if (src == ��) {
			password2.setText("��й�ȣ�� ��ȣȭ ���״�");

		}

		else {
			System.out.println("asdasdasd");

			JOptionPane.showMessageDialog(null, "�ʼ��׸� �߿� ���� �κ��� �ֽ��ϴ�. Ȯ�����ּ���!!", "Ȯ��", JOptionPane.INFORMATION_MESSAGE,
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
		// �� ������ �Ȱ���
		if(updateVer==false){
			Object src = e.getSource();// ���õ� ��ư�� �˾Ƴ���
			JTextField empty = (JTextField) src;
			empty.setText(null);
		}else if(updateVer==true){
			Object src = e.getSource();// ���õ� ��ư�� �˾Ƴ���
			JTextField empty = (JTextField) src;
			
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
