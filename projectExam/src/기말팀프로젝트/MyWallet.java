package �⸻��������Ʈ;

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
	ImageIcon image1=new ImageIcon("����.png");
	ImageIcon image2=new ImageIcon("camera.png");
	ImageIcon image3=new ImageIcon("�����.png");
	ImageIcon image4=new ImageIcon("������.png");
	private JTextField textField;

	public MyWallet() {
		//setLocation(ClientHandler.p);
		setSize(500, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setToolTipText("��ȣ ���ڸ�");
		panel.setLayout(null);
		panel.setBounds(0, 0, 500, 53);
		panel.setBackground(Color.white);

		JLabel ���� = new JLabel(new ImageIcon("����2.png"));
		����.setBounds(0, 0, 65, 53);
		panel.add(����);
		����.setBorder(BorderFactory.createLineBorder(Color.orange));

		JLabel label = new JLabel("����");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("����", Font.PLAIN, 25));
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
				System.out.println("���⿡ �÷��� ���� �߰�");
			}
		});
		addBtn.setBounds(2, 1, 52, 50);
		addBtn.setBorderPainted(false);
		panel2.add(addBtn);

		panel.setBorder(BorderFactory.createLineBorder(Color.orange));
		getContentPane().add(panel);

		JPanel ����ǹ��г� = new JPanel();
		����ǹ��г�.setBounds(0, 53, 494, 73);
		����ǹ��г�.setBackground(Color.white);
		����ǹ��г�.setBorder(BorderFactory.createLineBorder(Color.orange));
		getContentPane().add(����ǹ��г�);

		JButton mainBtn = new JButton(new ImageIcon("���.png"));// �������� �̵� �̹���
		����ǹ��г�.setLayout(null);
		mainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyFrame(ClientHandler.getMember());
				dispose();
			}
		});
		mainBtn.setBounds(2, 25, 161, 39);
		mainBtn.setBorderPainted(false);
		����ǹ��г�.add(mainBtn);

		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(0, 126, 494, 524);
		panel3.setBackground(Color.white);
		panel3.setBorder(BorderFactory.createLineBorder(Color.orange));
		//
		JButton ����=new JButton(image1);
		����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyBusinesscard();
				dispose();
			}
		});
		����.setBounds(20, 20, 220, 220);
		����.setBorder(BorderFactory.createEmptyBorder());
		panel3.add(����);
		
		JButton ����=new JButton(image2);
		����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyCamera();
				dispose();
			}
		});
		����.setBounds(250,10,220,220);
		����.setBorder(BorderFactory.createEmptyBorder());
		panel3.add(����);
		
		JButton �����=new JButton(image3);
		�����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyMemberShip();
				dispose();
			}
		});
		�����.setBounds(20,250,220,220);
		�����.setBorder(BorderFactory.createEmptyBorder());
		panel3.add(�����);
		
		JButton ������=new JButton(image4);
		������.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyLicense();
				dispose();
			}
		});
		������.setBounds(265,260,190,190);
		������.setBorder(BorderFactory.createEmptyBorder());
		panel3.add(������);
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