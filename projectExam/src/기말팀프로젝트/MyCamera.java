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

public class MyCamera extends JFrame {
	ImageIcon image;
	private JTextField textField;

	public MyCamera() {
		//setLocation(ClientHandler.p);;
		setSize(500, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 500, 53);
		panel.setBackground(Color.white);

		JLabel ���� = new JLabel(new ImageIcon("camera2.png"));
		����.setBounds(0, 0, 65, 53);
		panel.add(����);
		����.setBorder(BorderFactory.createLineBorder(Color.orange));

		JLabel label = new JLabel("��л���");
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

		JButton addBtn = new JButton(new ImageIcon("add.png"));
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new MyAdd_Camera();
				dispose();
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
				new MyWallet();
				dispose();
			}
		});
		mainBtn.setBounds(2, 25, 161, 39);
		mainBtn.setBorderPainted(false);
		����ǹ��г�.add(mainBtn);

		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 126, 494, 57);
		panel3.setBackground(Color.white);
		panel3.setBorder(BorderFactory.createLineBorder(Color.orange));

		JLabel lookBtn=new JLabel(new ImageIcon("��.png"));
		lookBtn.setBounds(0, 126, 65, 53);
		getContentPane().add(lookBtn);
		
		
		textField = new JTextField(15);
		textField.setText("���� �˻�");
		textField.setBounds(65, 0, 474, 57);
		textField.setFont(new Font("���� ���",Font.BOLD,27));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setBorder(BorderFactory.createEmptyBorder());
		panel3.add(textField);
		
		getContentPane().add(panel3);
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setBounds(0, 183, 494, 467);
		panel4.setBackground(Color.white);
		panel4.setBorder(BorderFactory.createLineBorder(Color.orange));
		
		getContentPane().add(panel4);
		
		setVisible(true);
		setResizable(false);
	}
//
//	public static void main(String args[]) {
//		new MyLicense();
//	}
}