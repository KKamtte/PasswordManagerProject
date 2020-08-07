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
import 기말팀프로젝트.MyAdd_memo;
import 기말팀프로젝트.MyAdd_pw;
import 기말팀프로젝트.MyPassword;
import 기말팀프로젝트.securityMemo;

public class SmDataDTO extends JPanel implements ActionListener {
	ImageIcon image1 = new ImageIcon("look.png");
	ImageIcon image2 = new ImageIcon("delete.png");
	// 데이터 부
	private int pm_num;
	private String smTitle;
	private String smData;

	// 필드 부
	private JLabel smNamePane;
	private JButton showButton, deleteButton;

	// 리스트
	public static ArrayList<SmDataDTO> smDataList = new ArrayList<SmDataDTO>();
	private static securityMemo sm = null;

	public static securityMemo getSm() {
		return sm;
	}

	public static void setSm(securityMemo sm) {
		SmDataDTO.sm = sm;
	}

	public int getPm_num() {
		return pm_num;
	}

	public void setPm_num(int pm_num) {
		this.pm_num = pm_num;
	}

	public String getSmTitle() {
		return smTitle;
	}

	public void setSmTitle(String smTitle) {
		this.smTitle = smTitle;
	}

	public String getSmData() {
		return smData;
	}

	public void setSmData(String smData) {
		this.smData = smData;
	}

	public SmDataDTO() {
		super();
	}

	public SmDataDTO(int pm_num, String smTitle, String smData) {
		super();

		String deSmTitle = makedeString(smTitle);
		String deSmData = makedeString(smData);
		this.pm_num = pm_num;

		this.smTitle = deSmTitle;
		this.smData = deSmData;

		init();
		start();
	}

	private void start() {
		// TODO Auto-generated method stub
		showButton.addActionListener(this);
		deleteButton.addActionListener(this);
	}

	private void init() {
		// TODO Auto-generated method stub

		setLayout(null);
		smNamePane = new JLabel(smTitle);
		smNamePane.setBounds(0, 0, 240, 80);
		smNamePane.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		smNamePane.setBackground(Color.white);

		showButton = new JButton(image1);
		showButton.setBorderPainted(false);
		showButton.setBounds(250, 0, 180, 80);

		deleteButton = new JButton(image2);
		deleteButton.setBorderPainted(false);
		deleteButton.setBounds(430, 0, 70, 80);

		add(smNamePane);
		add(showButton);
		add(deleteButton);

		setBackground(Color.white);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();// 선택된 버튼을 알아낸다

		if (src == showButton) {
			// private int pm_num;
			// private String smTitle;
			// private String smData;
			System.out.println("보기버튼 클릭됨");
			sm.dispose();
			new MyAdd_memo(pm_num, smTitle, smData);

		} else if (src == deleteButton) {
			// 삭제하기
			ClientHandler ch;
			ch = ClientHandler.getInstance();
			System.out.println("삭제 버튼 클릭");
			String msg = pm_num + "";

			System.out.println("서버로 보낼 메세지 확인 : " + msg);
			// 기존의 값을 저장
			ch.requestdeleteSMData(msg);

			System.out.println("내용들이 저장되었습니다.");
		}
	}
}