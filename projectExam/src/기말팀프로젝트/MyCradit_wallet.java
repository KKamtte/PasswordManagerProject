package 기말팀프로젝트;

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
	ImageIcon image = new ImageIcon("신용지갑3.png");
	ImageIcon image1 = new ImageIcon("카드.png");
	ImageIcon image2 = new ImageIcon("통장.png");
	private JTextField textField;
	JPanel panel, panel2, 비밀의방패널, panel3;
	JLabel 열쇠, label;
	JButton addBtn, mainBtn, 카드, 통장;

	
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
		panel.setToolTipText("암호 옆자리");
		panel.setLayout(null);
		panel.setBounds(0, 0, 500, 53);
		panel.setBackground(Color.white);

		열쇠 = new JLabel(image);
		열쇠.setBounds(0, 0, 65, 53);
		panel.add(열쇠);
		열쇠.setBorder(BorderFactory.createLineBorder(Color.orange));

		label = new JLabel("신용 지갑");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("굴림", Font.PLAIN, 25));
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

		비밀의방패널 = new JPanel();
		비밀의방패널.setBounds(0, 53, 494, 73);
		비밀의방패널.setBackground(Color.white);
		비밀의방패널.setBorder(BorderFactory.createLineBorder(Color.orange));
		getContentPane().add(비밀의방패널);

		mainBtn = new JButton(new ImageIcon("비밀.png"));// 메인으로 이동 이미지
		비밀의방패널.setLayout(null);
		mainBtn.setBounds(2, 25, 161, 39);
		mainBtn.setBorderPainted(false);
		비밀의방패널.add(mainBtn);

		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(0, 126, 494, 524);
		panel3.setBackground(Color.white);
		panel3.setBorder(BorderFactory.createLineBorder(Color.orange));
		//
		카드 = new JButton(image1);
		카드.setBounds(20, 20, 220, 220);
		카드.setBorder(BorderFactory.createEmptyBorder());
		panel3.add(카드);

		통장 = new JButton(image2);
		통장.setBounds(250, 20, 220, 220);
		통장.setBorder(BorderFactory.createEmptyBorder());
		panel3.add(통장);

		getContentPane().add(panel3);
		setVisible(true);
		setResizable(false);
	}

	private void start() {
		mainBtn.addActionListener(this);
		카드.addActionListener(this);
		통장.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if (src == mainBtn) {
			new MyFrame(ClientHandler.getMember());
			dispose();
		} else if (src == 카드) {
			new MyCard(ClientHandler.getMember());
			dispose();
		} else if (src == 통장) {
			new MyBankbook(ClientHandler.getMember());
			dispose();
		}

	}
}