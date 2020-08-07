package client;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author ebonny
 * 맨 처음 실행되는 로그인 창.
 * Frame 은 ClientHandler 의 멤버변수인 MainFrmae 을 사용하며
 * MainFrame 의 setPanel 을 이용해서 JPanel 을 상속받은 ChatRoom, WiatRoom LoginPanel 들이 번갈아가며 frame에 얹힌다. 
 */
public class LoginPanel extends JPanel implements ActionListener {
	private JTextField idField;
	private JPasswordField pwdField;
	private JButton btnLogin;
	private JButton btnClose;
	private ClientHandler ch;

	private void init() {
		setLayout(null);

		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(12, 221, 40, 15);
		add(lblId);

		JLabel lblPwd = new JLabel("암호");
		lblPwd.setBounds(12, 246, 40, 15);
		add(lblPwd);

		idField = new JTextField();
		idField.setBounds(64, 218, 116, 21);
		add(idField);
		idField.setColumns(10);

		pwdField = new JPasswordField();
		pwdField.setBounds(64, 243, 116, 21);
		add(pwdField);
		pwdField.setColumns(10);

		btnLogin = new JButton("로그인");
		btnLogin.setBounds(12, 274, 80, 37);
		add(btnLogin);

		btnClose = new JButton("취소");
		btnClose.setBounds(100, 274, 80, 37);
		add(btnClose);

		JPanel panel = new ImagePanel();
		panel.setBounds(0, 0, 195, 211);
		add(panel);
	}

	private void start() {
		pwdField.addActionListener(this);
		btnLogin.addActionListener(this);
		btnClose.addActionListener(this);
	}

	public LoginPanel() {
		init();
		start();
		ch = ClientHandler.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == pwdField || src == btnLogin) {
			if (idField.getText().length() == 0) {
				JOptionPane.showMessageDialog(ch.getFrame(), "아이디를 입력하세요");
			} else if (pwdField.getPassword().length == 0) {
				JOptionPane.showMessageDialog(ch.getFrame(), "암호를 입력하세요");
			} else {
				ch.requestLogin(idField.getText() + "," + String.valueOf(pwdField.getPassword()));
			}
		} else if (src == btnClose) {
			System.exit(0);
		}
	}

	public void setId(String id) {
		idField.setText(id);
	}

	public void focusIdField() {
		idField.requestFocus();
		idField.selectAll();
	}

	public void focusPwdField() {
		pwdField.requestFocus();
	}

	public void setPwdField(String string) {
		pwdField.setText(string);
	}

	private class ImagePanel extends JPanel {
		private Image img;

		private ImagePanel() {
			img = Toolkit.getDefaultToolkit().getImage("./img/penguin_s.png");
			MediaTracker tracker = new MediaTracker(this);
			try {
				tracker.addImage(img, 0);
				tracker.waitForAll();
				if (tracker.isErrorAny()) {
					JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
			}
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getSize().width, getSize().height, this);
			setOpaque(false);
		}
	}
}
