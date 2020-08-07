package 기말팀프로젝트;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import client.ClientHandler;
import client.Member;


public class MyFrame extends JFrame {
	Container ContentPane = getContentPane();
	ImageIcon image1=new ImageIcon("나의비밀번호.png");
	ImageIcon image2=new ImageIcon("안전메모.png");
	ImageIcon image3=new ImageIcon("지갑.png");
	ImageIcon image4=new ImageIcon("신용지갑.png");
	ImageIcon main=new ImageIcon("메인.png");
	
	Member mb;
	private ClientHandler ch;
	public MyFrame(Member member) {

		
	//	setLocation(ClientHandler.p);;
		
		ch= ClientHandler.getInstance();
		
		mb =  member;
		
		setTitle("비밀의 방");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(ContentPane);
		ContentPane.setBackground(Color.orange);
		setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 500, 48);
		getContentPane().add(menuBar);
		
		JMenu login = new JMenu("종료");
		menuBar.add(login);
		
		JMenuItem menuItem_1 = new JMenuItem("종료");
		menuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		login.add(menuItem_1);
		
		
		JMenu setting = new JMenu("설정");
		menuBar.add(setting);
		
		JMenuItem menuItem_4 = new JMenuItem("도움말");
		menuItem_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "<도움말>\n 비밀상자 개발 환경\n -JAVA Eclipse\n -Oracle -Server");
			}
		});
		setting.add(menuItem_4);
		
		JMenuItem menuItem_3=new JMenuItem("자주 묻는 질문");
		menuItem_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "<자주 묻는 질문>\n -01023605510 정지원 전화");
			}
		});
		setting.addSeparator();
		setting.add(menuItem_3);
		
		JMenuItem menuItem_2=new JMenuItem("비밀상자 설명");
		menuItem_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "<비밀상자 설명>\n -언제 어디서나 당신의 비밀번호를 안전하게 보관, 관리 할수 있습니다.");
			}
		});
		setting.addSeparator();
		setting.add(menuItem_2);

		
		JMenu infor = new JMenu("제작");
		menuBar.add(infor);
		
		JMenuItem menuItem_5 = new JMenuItem("제작자");
		menuItem_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "<SKHU>\n -201134027 정지원\n -201234015 이우도\n -201334006 김승현");
			}
		});
		infor.add(menuItem_5);
		

		
		JPanel panel = new JPanel();
		panel.setToolTipText("메뉴 바");
		menuBar.add(panel);
		
		JLabel label=new JLabel(main);
		label.setBounds(0, 48, 500, 97);
		getContentPane().add(label);

		
		JPanel panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 148, 500, 502);
		panel2.setBackground(Color.orange);
		
		JButton MyPassWord = new JButton(image1);
		MyPassWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyPassword(ClientHandler.getMember());
				dispose();
			}
		});
		MyPassWord.setBounds(0, -1, 249, 225);

		
		JButton securityMemo = new JButton(image2);
		securityMemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new securityMemo(ClientHandler.getMember());
				dispose();
			}
		});
		securityMemo.setBounds(251, -1, 243, 225);

		
		JButton MyWallet = new JButton(image3);
		MyWallet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyWallet();
				dispose();
			}
		});
		MyWallet.setBounds(0, 226, 249, 232);

		
		JButton PassWord_init = new JButton(image4);
		PassWord_init.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyCradit_wallet(ClientHandler.getMember());
				dispose();
			}
		});
		PassWord_init.setBounds(251, 226, 243, 232);

		
		panel2.add(MyPassWord);
		panel2.add(securityMemo);
		panel2.add(MyWallet);
		panel2.add(PassWord_init);
		
		getContentPane().add(panel2);
		setSize(500, 650);
		setVisible(true);
	    setResizable(false);
		ContentPane.requestFocus();
		
	
	}

	private void getData() {
		// TODO Auto-generated method stub
		
	}

	private void start() {
		// TODO Auto-generated method stub
		
	}

	private void init() {
		// TODO Auto-generated method stub
		
	}

	//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new MyFrame();
//	}
	public void setHandler1(ClientHandler ch) {
		
		
		//this.ch = ch;
	}
	

}
