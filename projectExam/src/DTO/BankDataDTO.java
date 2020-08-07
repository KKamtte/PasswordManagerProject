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
import 기말팀프로젝트.MyAdd_Bankbook;
import 기말팀프로젝트.MyAdd_Card;
import 기말팀프로젝트.MyBankbook;

public class BankDataDTO extends JPanel implements ActionListener {

	ImageIcon image1 = new ImageIcon("look.png");
	ImageIcon image2 = new ImageIcon("delete.png");
	// 데이터부
	private int pm_num;
	private String b_name;
	private String b_type;
	private String b_num1;
	private String b_num2;
	private String b_num3;
	private String b_num4;
	private String b_date;
	private String b_department;
	private String b_password;

	// 필드 부
	private JLabel bankNamePane;
	private JButton showButton, deleteButton;

	public static ArrayList<BankDataDTO> bankDataList = new ArrayList<BankDataDTO>();
	private static MyBankbook mb = null;

	public static MyBankbook getMb() {
		return mb;
	}

	public static void setMb(MyBankbook mb) {
		BankDataDTO.mb = mb;
	}

	public int getPm_num() {
		return pm_num;
	}

	public void setPm_num(int pm_num) {
		this.pm_num = pm_num;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_type() {
		return b_type;
	}

	public void setB_type(String b_type) {
		this.b_type = b_type;
	}

	public String getB_num1() {
		return b_num1;
	}

	public void setB_num1(String b_num1) {
		this.b_num1 = b_num1;
	}

	public String getB_num2() {
		return b_num2;
	}

	public void setB_num2(String b_num2) {
		this.b_num2 = b_num2;
	}

	public String getB_num3() {
		return b_num3;
	}

	public void setB_num3(String b_num3) {
		this.b_num3 = b_num3;
	}

	public String getB_num4() {
		return b_num4;
	}

	public void setB_num4(String b_num4) {
		this.b_num4 = b_num4;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	public String getB_department() {
		return b_department;
	}

	public void setB_department(String b_department) {
		this.b_department = b_department;
	}

	public String getB_password() {
		return b_password;
	}

	public void setB_password(String b_password) {
		this.b_password = b_password;
	}

	public BankDataDTO(int pm_num, String b_name, String b_type, String b_num1, String b_num2, String b_num3,
			String b_num4, String b_date, String b_department, String b_password) {
		super();

		// 복호화 작업 수행
		String deb_name = makedeString(b_name);
		String deb_num1 = makedeString(b_num1);
		String deb_num2 = makedeString(b_num2);
		String deb_num3 = makedeString(b_num3);
		String deb_num4 = makedeString(b_num4);
		String deb_date = makedeString(b_date);
		String deb_department = makedeString(b_date);
		String deb_password = makedeString(b_password);

		this.pm_num = pm_num;
		this.b_name = deb_name;
		this.b_type = b_type;
		this.b_num1 = deb_num1;
		this.b_num2 = deb_num2;
		this.b_num3 = deb_num3;
		this.b_num4 = deb_num4;
		this.b_date = deb_date;
		this.b_department = deb_department;
		this.b_password = deb_password;

		init();
		start();
	}

	public BankDataDTO() {
		super();
	}

	private void start() {
		// TODO Auto-generated method stub
//showButton, deleteButton;
		
		showButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
	}

	private void init() {
		// TODO Auto-generated method stub
		
		setLayout(null);
		bankNamePane = new JLabel(b_name);
		bankNamePane.setBounds(0, 0, 130, 80);
		bankNamePane.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		bankNamePane.setBackground(Color.white);

		showButton = new JButton(image1);
		showButton.setBorderPainted(false);
		showButton.setBounds(250, 0, 180, 80);

		deleteButton = new JButton(image2);
		deleteButton.setBorderPainted(false);
		deleteButton.setBounds(430, 0, 70, 80);

		add(bankNamePane);
		add(showButton);
		add(deleteButton);

		setBackground(Color.white);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();// 선택된 버튼을 알아낸다
		if (src == showButton) {

			System.out.println("보기버튼 클릭됨");
			System.out.println(mb);
			mb.dispose();
			
			new MyAdd_Bankbook(pm_num, b_name,b_type,b_num1,b_num2,b_num3,b_num4,b_date,
					b_department,b_password);

		} else if (src == deleteButton) {
			// 삭제하기
			ClientHandler ch;
			ch = ClientHandler.getInstance();
			System.out.println("삭제 버튼 클릭");
			String msg = pm_num + "";

			System.out.println("서버로 보낼 메세지 확인 : " + msg);
			// 기존의 값을 저장
			ch.requestdeleteBankData(msg);

			System.out.println("내용들이 저장되었습니다.");
		}
	}

	private String makedeString(String st) {
		Decrypt de = null;
		try { // 사이트 복호화
			de = new Decrypt(st);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("복호화(pw사이트)된 값 : " + de.getDeString());
		String desiteName = de.getDeString();
		return desiteName;
	}
}
