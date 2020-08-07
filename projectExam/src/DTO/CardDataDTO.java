package DTO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Security.Decrypt;
import client.ClientHandler;
import client.ServerMsgListener;
import �⸻��������Ʈ.MyAdd_Card;
import �⸻��������Ʈ.MyAdd_memo;
import �⸻��������Ʈ.MyCard;

public class CardDataDTO extends JPanel implements ActionListener{
	ImageIcon image1 = new ImageIcon("look.png");
	ImageIcon image2 = new ImageIcon("delete.png");
	// ������ ��
	private int pm_num;
	private String c_name;
	private String c_type;
	private String c_num1;
	private String c_num2;
	private String c_num3;
	private String c_num4;
	private String c_end_month;
	private String c_end_year;
	private String c_start_month;
	private String c_start_year;
	private String c_password;

	// �ʵ� ��
	private JLabel cardNamePane;
	private JButton showButton, deleteButton;

	
	// ����Ʈ
	public static ArrayList<CardDataDTO> cardDataList = new ArrayList<CardDataDTO>();

	//�г�
	private static MyCard mc = null;
	public static MyCard getMc() {
		return mc;
	}

	public static void setMc(MyCard mc) {
		CardDataDTO.mc = mc;
	}

	public int getPm_num() {
		return pm_num;
	}

	public void setPm_num(int pm_num) {
		this.pm_num = pm_num;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_type() {
		return c_type;
	}

	public void setC_type(String c_type) {
		this.c_type = c_type;
	}

	public String getC_num1() {
		return c_num1;
	}

	public void setC_num1(String c_num1) {
		this.c_num1 = c_num1;
	}

	public String getC_num2() {
		return c_num2;
	}

	public void setC_num2(String c_num2) {
		this.c_num2 = c_num2;
	}

	public String getC_num3() {
		return c_num3;
	}

	public void setC_num3(String c_num3) {
		this.c_num3 = c_num3;
	}

	public String getC_num4() {
		return c_num4;
	}

	public void setC_num4(String c_num4) {
		this.c_num4 = c_num4;
	}

	public String getC_end_month() {
		return c_end_month;
	}

	public void setC_end_month(String c_end_month) {
		this.c_end_month = c_end_month;
	}

	public String getC_end_year() {
		return c_end_year;
	}

	public void setC_end_year(String c_end_year) {
		this.c_end_year = c_end_year;
	}

	public String getC_start_month() {
		return c_start_month;
	}

	public void setC_start_month(String c_start_month) {
		this.c_start_month = c_start_month;
	}

	public String getC_start_year() {
		return c_start_year;
	}

	public void setC_start_year(String c_start_year) {
		this.c_start_year = c_start_year;
	}

	public String getC_password() {
		return c_password;
	}

	public void setC_password(String c_password) {
		this.c_password = c_password;
	}

	public CardDataDTO(int pm_num, String c_name, String c_type, String c_num1, String c_num2, String c_num3,
			String c_num4, String c_end_month, String c_end_year, String c_start_month, String c_start_year,
			String c_password) {
		super();
		
		
		System.out.println("��ȣȭ �� : " + c_name);
		String deC_name = makedeString(c_name);
		System.out.println("��ȣȭ �� : " + c_type);
		String deC_type = makedeString(c_type);
		String deC_num1 = makedeString(c_num1);
		String deC_num2 = makedeString(c_num2);
		String deC_num3 = makedeString(c_num3);
		String deC_num4 = makedeString(c_num4);
		String deC_end_month = makedeString(c_end_month);
		String deC_end_year = makedeString(c_end_year);
		String deC_start_month = makedeString(c_start_month);
		String deC_start_year = makedeString(c_start_year);
		String deC_c_password = makedeString(c_password);

		this.pm_num = pm_num;
		this.c_name = deC_name;
		this.c_type = deC_type;
		this.c_num1 = deC_num1;
		this.c_num2 = deC_num2;
		this.c_num3 = deC_num3;
		this.c_num4 = deC_num4;
		this.c_end_month = deC_end_month;
		this.c_end_year = deC_end_year;
		this.c_start_month = deC_start_month;
		this.c_start_year = deC_start_year;
		this.c_password = deC_c_password;

		init();
		start();
	}

	private void start() {
		// TODO Auto-generated method stub
		// showButton, deleteButton;
		
		showButton.addActionListener(this);
		deleteButton.addActionListener(this);

	}

	private void init() {
		// TODO Auto-generated method stub
		
		setLayout(null);
		cardNamePane = new JLabel(c_name);
		cardNamePane.setBounds(0, 0, 130, 80);
		cardNamePane.setFont(new Font("���� ���", Font.BOLD, 23));
		cardNamePane.setBackground(Color.white);

		showButton = new JButton(image1);
		showButton.setBorderPainted(false);
		showButton.setBounds(250, 0, 180, 80);

		deleteButton = new JButton(image2);
		deleteButton.setBorderPainted(false);
		deleteButton.setBounds(430, 0, 70, 80);

		add(cardNamePane);
		add(showButton);
		add(deleteButton);

		setBackground(Color.white);

	}

	private String makedeString(String st) {
		Decrypt de = null;
		try { // ����Ʈ ��ȣȭ
			de = new Decrypt(st);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("��ȣȭ(pw����Ʈ)�� �� : " + de.getDeString());
		String desiteName = de.getDeString();
		return desiteName;
	}

	public CardDataDTO() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();// ���õ� ��ư�� �˾Ƴ���

		if (src == showButton) {

			System.out.println("�����ư Ŭ����");
			System.out.println(mc);
			mc.dispose();
			
			new MyAdd_Card(pm_num, c_name,c_type,c_num1,c_num2,c_num3,c_num4,c_end_month,
					c_end_year,c_start_month,c_start_year,c_password);

		} else if (src == deleteButton) {
			// �����ϱ�
			ClientHandler ch;
			ch = ClientHandler.getInstance();
			System.out.println("���� ��ư Ŭ��");
			String msg = pm_num + "";

			System.out.println("������ ���� �޼��� Ȯ�� : " + msg);
			// ������ ���� ����
			ch.requestdeleteCardData(msg);

			System.out.println("������� ����Ǿ����ϴ�.");
		}
	}

}
