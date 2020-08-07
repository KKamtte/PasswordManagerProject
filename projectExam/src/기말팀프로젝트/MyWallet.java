package 기말팀프로젝트;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import client.ClientHandler;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class MyWallet extends JFrame {
	ImageIcon image1=new ImageIcon("명함.png");
	ImageIcon image2=new ImageIcon("camera.png");
	ImageIcon image3=new ImageIcon("멤버십.png");
	ImageIcon image4=new ImageIcon("면허증.png");
	private JTextField textField;

	public MyWallet() {
		//setLocation(ClientHandler.p);
		setSize(500, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setToolTipText("암호 옆자리");
		panel.setLayout(null);
		panel.setBounds(0, 0, 500, 53);
		panel.setBackground(Color.white);

		JLabel 열쇠 = new JLabel(new ImageIcon("지갑2.png"));
		열쇠.setBounds(0, 0, 65, 53);
		panel.add(열쇠);
		열쇠.setBorder(BorderFactory.createLineBorder(Color.orange));

		JLabel label = new JLabel("지갑");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("굴림", Font.PLAIN, 25));
		label.setBounds(160, 0, 185, 57);
		panel.add(label);

		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(442, 0, 55, 51);
		panel2.setBorder(BorderFactory.createLineBorder(Color.orange));
		panel.add(panel2);

		JButton addBtn = new JButton(new ImageIcon("select.png"));
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("여기에 플러스 내용 추가");
			}
		});
		addBtn.setBounds(2, 1, 52, 50);
		addBtn.setBorderPainted(false);
		panel2.add(addBtn);

		panel.setBorder(BorderFactory.createLineBorder(Color.orange));
		getContentPane().add(panel);

		JPanel 비밀의방패널 = new JPanel();
		비밀의방패널.setBounds(0, 53, 494, 73);
		비밀의방패널.setBackground(Color.white);
		비밀의방패널.setBorder(BorderFactory.createLineBorder(Color.orange));
		getContentPane().add(비밀의방패널);

		JButton mainBtn = new JButton(new ImageIcon("비밀.png"));// 메인으로 이동 이미지
		비밀의방패널.setLayout(null);
		mainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyFrame(ClientHandler.getMember());
				dispose();
			}
		});
		mainBtn.setBounds(2, 25, 161, 39);
		mainBtn.setBorderPainted(false);
		비밀의방패널.add(mainBtn);

		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(0, 126, 494, 524);
		panel3.setBackground(Color.white);
		panel3.setBorder(BorderFactory.createLineBorder(Color.orange));
		//
		JButton 명함=new JButton(image1);
		명함.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyBusinesscard();
				dispose();
			}
		});
		명함.setBounds(20, 20, 220, 220);
		명함.setBorder(BorderFactory.createEmptyBorder());
		panel3.add(명함);
		
		JButton 사진=new JButton(image2);
		사진.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyCamera();
				dispose();
			}
		});
		사진.setBounds(250,10,220,220);
		사진.setBorder(BorderFactory.createEmptyBorder());
		panel3.add(사진);
		
		JButton 멤버십=new JButton(image3);
		멤버십.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyMemberShip();
				dispose();
			}
		});
		멤버십.setBounds(20,250,220,220);
		멤버십.setBorder(BorderFactory.createEmptyBorder());
		panel3.add(멤버십);
		
		JButton 면허증=new JButton(image4);
		면허증.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyLicense();
				dispose();
			}
		});
		면허증.setBounds(265,260,190,190);
		면허증.setBorder(BorderFactory.createEmptyBorder());
		panel3.add(면허증);
		//
		getContentPane().add(panel3);
		setVisible(true);
		setResizable(false);
	}
//
//	public static void main(String args[]) {
//		new MyWallet();
//	}
}