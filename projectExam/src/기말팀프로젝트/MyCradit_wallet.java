package �⸻��������Ʈ;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import client.ClientHandler;
import client.Member;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class MyCradit_wallet extends JFrame implements ActionListener {
	ImageIcon image = new ImageIcon("�ſ�����3.png");
	ImageIcon image1 = new ImageIcon("ī��.png");
	ImageIcon image2 = new ImageIcon("����.png");
	private JTextField textField;
	JPanel panel, panel2, ����ǹ��г�, panel3;
	JLabel ����, label;
	JButton addBtn, mainBtn, ī��, ����;

	
	Member mb;
	private ClientHandler ch;
	
	public MyCradit_wallet(Member member) {
		
		ch= ClientHandler.getInstance();
		
		mb =  member;
		
		init();
		start();
	}

	private void init() {
	//	setLocation(ClientHandler.p);;
		setSize(500, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setToolTipText("��ȣ ���ڸ�");
		panel.setLayout(null);
		panel.setBounds(0, 0, 500, 53);
		panel.setBackground(Color.white);

		���� = new JLabel(image);
		����.setBounds(0, 0, 65, 53);
		panel.add(����);
		����.setBorder(BorderFactory.createLineBorder(Color.orange));

		label = new JLabel("�ſ� ����");
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

		addBtn = new JButton(new ImageIcon("select.png"));
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

		mainBtn = new JButton(new ImageIcon("���.png"));// �������� �̵� �̹���
		����ǹ��г�.setLayout(null);
		mainBtn.setBounds(2, 25, 161, 39);
		mainBtn.setBorderPainted(false);
		����ǹ��г�.add(mainBtn);

		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(0, 126, 494, 524);
		panel3.setBackground(Color.white);
		panel3.setBorder(BorderFactory.createLineBorder(Color.orange));
		//
		ī�� = new JButton(image1);
		ī��.setBounds(20, 20, 220, 220);
		ī��.setBorder(BorderFactory.createEmptyBorder());
		panel3.add(ī��);

		���� = new JButton(image2);
		����.setBounds(250, 20, 220, 220);
		����.setBorder(BorderFactory.createEmptyBorder());
		panel3.add(����);

		getContentPane().add(panel3);
		setVisible(true);
		setResizable(false);
	}

	private void start() {
		mainBtn.addActionListener(this);
		ī��.addActionListener(this);
		����.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if (src == mainBtn) {
			new MyFrame(ClientHandler.getMember());
			dispose();
		} else if (src == ī��) {
			new MyCard(ClientHandler.getMember());
			dispose();
		} else if (src == ����) {
			new MyBankbook(ClientHandler.getMember());
			dispose();
		}

	}
}