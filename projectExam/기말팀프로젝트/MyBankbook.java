package �⸻��������Ʈ;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import DTO.BankDataDTO;
import DTO.PwDataDTO;
import client.ClientHandler;
import client.Member;
import client.ServerMsgListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class MyBankbook extends JFrame implements ActionListener {
	ImageIcon image = new ImageIcon("����2.png");
	ImageIcon image2 = new ImageIcon("add.png");
	ImageIcon image3 = new ImageIcon("���.png");
	ImageIcon image4 = new ImageIcon("��.png");

	JPanel panel, panel2, ����ǹ��г�, panel3, panel4;
	JLabel ����, label, lookBtn;
	JButton addBtn, mainBtn;
	private JTextField textField;
	 Member mb;
	public MyBankbook(Member member) {
		
		 mb = member;

	      getData();
	      try {
	         Thread.sleep(500l);
	      } catch (InterruptedException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      };
		
		init();
		start();
	}

	private void getData() {
		// TODO Auto-generated method stub
		 ClientHandler.requestBankData(mb.getUserNum());
	}

	private void init() {
		//setLocation(ClientHandler.p);;
		setSize(500, 650);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		ServerMsgListener.setMb(this);
		BankDataDTO.setMb(this);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 500, 53);
		panel.setBackground(Color.white);

		���� = new JLabel(image);
		����.setBounds(0, 0, 65, 53);
		panel.add(����);
		����.setBorder(BorderFactory.createLineBorder(Color.orange));

		label = new JLabel("����");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("����", Font.PLAIN, 25));
		label.setBounds(160, 0, 185, 57);
		panel.add(label);

		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(442, 0, 55, 51);
		panel2.setBorder(BorderFactory.createLineBorder(Color.orange));
		panel.add(panel2);

		addBtn = new JButton(image2);
		addBtn.setBounds(2, 1, 52, 50);
		addBtn.setBorderPainted(false);
		panel2.add(addBtn);

		panel.setBorder(BorderFactory.createLineBorder(Color.orange));
		getContentPane().add(panel);

		����ǹ��г� = new JPanel();
		����ǹ��г�.setBounds(0, 53, 494, 73);
		����ǹ��г�.setBackground(Color.white);
		����ǹ��г�.setBorder(BorderFactory.createLineBorder(Color.orange));
		getContentPane().add(����ǹ��г�);

		mainBtn = new JButton(image3);// �������� �̵� �̹���
		����ǹ��г�.setLayout(null);
		mainBtn.setBounds(2, 25, 161, 39);
		mainBtn.setBorderPainted(false);
		����ǹ��г�.add(mainBtn);

		panel3 = new JPanel();
		panel3.setBounds(0, 126, 494, 57);
		panel3.setBackground(Color.white);
		panel3.setBorder(BorderFactory.createLineBorder(Color.orange));

		lookBtn = new JLabel(image4);
		lookBtn.setBounds(0, 126, 65, 53);
		getContentPane().add(lookBtn);

		textField = new JTextField(15);
		textField.setText("���� �˻�");
		textField.setBounds(65, 0, 474, 57);
		textField.setFont(new Font("���� ���", Font.BOLD, 27));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setBorder(BorderFactory.createEmptyBorder());
		panel3.add(textField);

		getContentPane().add(panel3);

		panel4 = new JPanel();
		panel4.setLayout(new GridLayout(6, 1));
		panel4.setBounds(0, 183, 494, 467);
		panel4.setBackground(Color.white);
		panel4.setBorder(BorderFactory.createLineBorder(Color.orange));
		for(int i= 0; i< BankDataDTO.bankDataList.size();i++){
	         System.out.println(i+"��° �������");
	         panel4.add(BankDataDTO.bankDataList.get(i));
	         System.out.println("����");
	      }

		getContentPane().add(panel4);

		setVisible(true);
		setResizable(false);
	}

	private void start() {
		mainBtn.addActionListener(this);
		addBtn.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if (src == mainBtn) {
			new MyCradit_wallet(ClientHandler.getMember());
			dispose();
		} else if (src == addBtn) {
			new MyAdd_Bankbook();
			dispose();
		}

	}
}