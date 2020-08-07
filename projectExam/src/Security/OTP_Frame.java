package Security;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.ClientHandler;
import client.Member;
import client.ServerMsgListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.mail.MessagingException;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class OTP_Frame extends JFrame implements ActionListener {
	JButton button1, button2;
	static boolean ok = false;
	private JPanel contentPane;
	private JTextField textField;
	// private final Action CheckOTP = new SwingAction_1();
	private static OTP otp = null;
	// private final Action reOTP = new SwingAction_1();

	private ClientHandler ch;
	String memberNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OTP_Frame frame = new OTP_Frame();
					NaverMailTest NMT = new NaverMailTest();
					otp = NMT.getOpt();
					System.out.println("otp ���� ���� ����" + otp);

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OTP_Frame() {
		init1();
		start1();

	}

//	public OTP_Frame(Member member) {
//		// TODO Auto-generated constructor stub
//		System.out.println("otp ������ ����");
//		this.memberNum=member;
//		init1();
//		start1();
//
//	}

	public OTP_Frame(String msg) {
		// TODO Auto-generated constructor stub
		System.out.println("otp ������ ����");
		this.memberNum=msg;
		init1();
		start1();
		ch = ClientHandler.getInstance();
	}

	private void init1() {
		
		ServerMsgListener.setOf(this);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 155);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel OTPguideLabel = new JLabel("OTP ��ȣ�� �Է��Ͻÿ�");
		OTPguideLabel.setFont(new Font("����", Font.PLAIN, 20));
		OTPguideLabel.setBounds(56, 10, 203, 38);
		contentPane.add(OTPguideLabel);

		textField = new JTextField();
		textField.setBounds(45, 58, 129, 38);
		contentPane.add(textField);
		textField.setColumns(5);

		button1 = new JButton("������");

		button1.setBounds(186, 58, 73, 17);
		contentPane.add(button1);

		button2 = new JButton("Ȯ��");

		button2.setBounds(186, 80, 73, 16);
		contentPane.add(button2);
	}

	private void start1() {
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	// private class SwingAction extends AbstractAction {
	// public SwingAction() {
	// putValue(NAME, "Ȯ��");
	// }
	//
	// public void actionPerformed(ActionEvent e) {
	// String n = textField.getText();
	// if (n.equals(OTP.getMsg())) { // ��ġ�Ҷ�
	// System.out.println("�Է°�:" + n);
	// System.out.println("OTP:" + OTP.getMsg());
	// ok = true;
	// JOptionPane.showMessageDialog(null, "OTP��ȣ�� ��ġ�մϴ�.", "Ȯ��",
	// JOptionPane.DEFAULT_OPTION);
	// dispose();
	// }
	//
	// else { // ����ġ
	// System.out.println("�Է°�:" + n);
	// System.out.println("OTP:" + OTP.getMsg());
	// JOptionPane.showMessageDialog(null, "OTP��ȣ�� ��ġ�����ʽ��ϴ�.", "Ȯ��",
	// JOptionPane.DEFAULT_OPTION);
	// }
	// }
	// }
	//
	// private class SwingAction_1 extends AbstractAction { // ������
	// public SwingAction_1() {
	// putValue(NAME, "������");
	// putValue(SHORT_DESCRIPTION, "Some short description");
	// }
	//
	// public void actionPerformed(ActionEvent e) {
	// OTP = new OTP();
	//
	// }
	// }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();// ���õ� ��ư�� �˾Ƴ���
		String n = textField.getText();
		if (src == button2) {
			//Ȯ�� ����
//			if (n.equals(otp.getMsg())) { // ��ġ�Ҷ�
//				System.out.println("�Է°�:" + n);
//				System.out.println("OTP:" + otp.getMsg());
//				ok = true;
//				JOptionPane.showMessageDialog(null, "OTP��ȣ�� ��ġ�մϴ�.", "Ȯ��", JOptionPane.DEFAULT_OPTION);
//				dispose();
//			} else { // ����ġ
//				System.out.println("�Է°�:" + n);
//				System.out.println("OTP:" + otp.getMsg());
//				JOptionPane.showMessageDialog(null, "OTP��ȣ�� ��ġ�����ʽ��ϴ�.", "Ȯ��", JOptionPane.DEFAULT_OPTION);
//			}
			String msg = n+","
					+ memberNum;
			
			System.out.println("������ ���� �޼��� Ȯ�� : " + msg);
			//���� ���Ӱ� �߰�
			ch.requestOTPcheck(msg);
			
		} else if (src == button1) {
			//������ ��Ź
			String msg = 
					 memberNum;
			
			System.out.println("������ ���� �޼��� Ȯ�� : " + msg);
			//���� ���Ӱ� �߰�
			ch.requestOTPagain(msg);
		}
	}

}