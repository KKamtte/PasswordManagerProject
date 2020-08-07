package DTO;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import Security.Decrypt;
import client.ClientHandler;
import �⸻��������Ʈ.MyAdd_pw;
import �⸻��������Ʈ.MyPassword;

public class PwDataDTO extends JPanel implements ActionListener {
	ImageIcon image1 = new ImageIcon("����Ʈ���̵�.png");
	ImageIcon image2 = new ImageIcon("id.png");
	ImageIcon image3 = new ImageIcon("password_icon.png");

	private int pm_num;
	private String siteName;
	private String url;
	private String id;
	private String pw;

	private JLabel siteNamePane;
	private JButton urlButton, idButton, pwButton, update, delete;

	public static ArrayList<PwDataDTO> pwDataList = new ArrayList<PwDataDTO>();
	private static MyPassword mp = null;

	public static MyPassword getMp() {
		return mp;
	}

	public static void setMp(MyPassword mp) {
		PwDataDTO.mp = mp;
	}

	public int getPm_num() {
		return pm_num;
	}

	public void setPm_num(int pm_num) {
		this.pm_num = pm_num;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public PwDataDTO() {
		// TODO Auto-generated constructor stub
	}

	public PwDataDTO(int pm_num, String siteName, String url, String id, String pw) {
		super();
		Decrypt de = null;
		try { // ����Ʈ ��ȣȭ
			de = new Decrypt(siteName);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("��ȣȭ(pw����Ʈ)�� �� : " + de.getDeString());
		String desiteName = de.getDeString();

		try { // URL ��ȣȭ
			de = new Decrypt(url);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("��ȣȭ(pwURL)�� �� : " + de.getDeString());
		String deurl = de.getDeString();

		try { // ID ��ȣȭ
			de = new Decrypt(id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("��ȣȭ(pwID)�� �� : " + de.getDeString());
		String deid = de.getDeString();

		try { // pw ��ȣȭ
			de = new Decrypt(pw);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("��ȣȭ(pw��й�ȣ)�� �� : " + de.getDeString());
		String depw = de.getDeString();

		this.pm_num = pm_num;
		this.siteName = desiteName;
		this.url = deurl;
		this.id = deid;
		this.pw = depw;

		init();
		start();

	}

	private void start() {
		// TODO Auto-generated method stub
		urlButton.addActionListener(this);
		idButton.addActionListener(this);
		pwButton.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
	}

	private void init() {
		// TODO Auto-generated method stub
		// private JTextPane siteNamePane;
		// private JButton urlButton;
		// private JButton idButton;
		// private JButton pwButton;
		siteNamePane = new JLabel(siteName);
		siteNamePane.setFont(new Font("���� ���", Font.BOLD, 23));
		siteNamePane.setBounds(0, 0, 130, 80);

		urlButton = new JButton(image1);
		urlButton.setBorderPainted(false);
		urlButton.setBounds(130, 0, 120, 80);

		idButton = new JButton(image2);
		idButton.setBorderPainted(false);
		idButton.setBounds(250, 0, 80, 80);

		pwButton = new JButton(image3);
		pwButton.setBorderPainted(false);
		pwButton.setBounds(330, 0, 100, 80);

		update = new JButton("����");
		update.setBorderPainted(false);
		update.setBounds(430, 0, 70, 40);

		delete = new JButton("����");
		delete.setBorderPainted(false);
		delete.setBounds(430, 40, 70, 40);

		setLayout(null);

		add(siteNamePane);
		add(urlButton);
		add(idButton);
		add(pwButton);
		add(update);
		add(delete);

		setBackground(Color.white);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();// ���õ� ��ư�� �˾Ƴ���

		if (src == urlButton) {
			Runtime runtime = Runtime.getRuntime();
			String ie = "C:\\Program Files\\Internet Explorer\\iexplore.exe";
			String html = "D:\\JAVA\\test\\JDBC\\a.html";
			String url = "http://micropilot.tistory.com";
			String site = "http://" + getUrl(); // �̵��ϰ���� ����Ʈ
			String[] ar = { ie, site };
			try {
				runtime.exec(ar);
			} catch (Exception e1) {
				System.out.println("������ ����� ����DB����������,�����");
			}
			System.out.println("��ư�� ������");
		} else if (src == idButton) {
			System.out.println(getId());
			JLabel msg = new JLabel();
			msg.setText("���̵� �����Ͻðڽ��ϱ�?");
			if (JOptionPane.showConfirmDialog(null, msg, "Ȯ��", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

				// System.out.println(��й�ȣ���);

				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				String copyString = getId();
				if (copyString != null) {
					StringSelection contents = new StringSelection(copyString);
					clipboard.setContents(contents, null);
				}
			}
		} else if (src == pwButton) {
			System.out.println(getPw());
			JLabel msg = new JLabel();
			msg.setText("��й�ȣ�� �����Ͻðڽ��ϱ�?");
			if (JOptionPane.showConfirmDialog(null, msg, "Ȯ��", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

				// System.out.println(��й�ȣ���);

				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				String copyString = getPw();
				if (copyString != null) {
					StringSelection contents = new StringSelection(copyString);
					clipboard.setContents(contents, null);
				}
			}
		} else if (src == update) {
			// �����ϱ�
			// private int pm_num;
			// private String siteName;
			// private String url;
			// private String id;
			// private String pw;
			mp.dispose();
			new MyAdd_pw(pm_num, siteName, url, id, pw);

		} else if (src == delete) {
			// �����ϱ�
			ClientHandler ch;
			ch = ClientHandler.getInstance();
			System.out.println("���� ��ư Ŭ��");
			String msg = pm_num + "";

			System.out.println("������ ���� �޼��� Ȯ�� : " + msg);
			// ������ ���� ����
			ch.requestdeletePwData(msg);

			System.out.println("������� ����Ǿ����ϴ�.");

		} else {

		}
	}

}