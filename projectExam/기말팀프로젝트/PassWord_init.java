package �⸻��������Ʈ;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import client.ClientHandler;

public class PassWord_init extends JFrame {
	ImageIcon image;
	private JTextField textField;
	JLabel ��й�ȣ���;

	public PassWord_init() {
		setSize(500, 650);
		setLocation(500, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setToolTipText("��ȣ ���ڸ�");
		panel.setLayout(null);
		panel.setBounds(0, 0, 500, 53);
		panel.setBackground(Color.white);

		JLabel ���� = new JLabel(new ImageIcon("������2.png"));
		����.setBounds(0, 0, 65, 53);
		panel.add(����);
		����.setBorder(BorderFactory.createLineBorder(Color.orange));

		JLabel label = new JLabel("������");
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

		JPanel �����г� = new JPanel();
		�����г�.setLayout(null);
		�����г�.setBounds(0, 126, 494, 524);
		�����г�.setBackground(Color.white);
		�����г�.setBorder(BorderFactory.createLineBorder(Color.orange));
		
		JLabel label2 =new JLabel("���ȷ��� ����");
		JLabel label2_2=new JLabel("��й�ȣ�� �����ϼ��� !!!");
		label2.setFont(new Font("����", Font.PLAIN, 20));
		label2_2.setFont(new Font("����", Font.PLAIN, 20));
		label2.setBounds(20,20,250,30);
		label2_2.setBounds(20,60,400,30);
		�����г�.add(label2);
		�����г�.add(label2_2);
		
		JPanel �������г�=new JPanel();
		�������г�.setLayout(null);
		�������г�.setBounds(40,160,410,250);
		�������г�.setBackground(Color.WHITE);
		�������г�.setBorder(BorderFactory.createLineBorder(Color.black,20));
		�����г�.add(�������г�);
		
		JPanel �������г�2=new JPanel();
		�������г�2.setLayout(null);
		�������г�2.setBounds(30, 30, 350, 190);
		�������г�.add(�������г�2);
		
		��й�ȣ���=new JLabel("��й�ȣ ��¶�");
		��й�ȣ���.setFont(new Font("", Font.BOLD, 19));
		��й�ȣ���.setForeground(Color.RED);
		��й�ȣ���.setHorizontalAlignment(SwingConstants.LEFT);
		��й�ȣ���.setBounds(0,0,350,100);
		��й�ȣ���.setBorder(BorderFactory.createLineBorder(Color.black,10));
		�������г�2.add(��й�ȣ���);
		
		JButton �����ϱ�=new JButton(new ImageIcon("����.png"));
		�����ϱ�.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JLabel msg = new JLabel(); 
				msg.setText("��й�ȣ�� �����Ͻðڽ��ϱ�?");
				if (JOptionPane.showConfirmDialog(null, msg, "Ȯ��", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
						
						
						//System.out.println(��й�ȣ���);
								
						Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						String copyString = ��й�ȣ���.getText();
						if(copyString != null)
						{
						     StringSelection contents = new StringSelection(copyString);
						     clipboard.setContents(contents, null);
						}		
				}
				else {
					System.out.println("���⿩��222");
				}
			}
		});
		�����ϱ�.setBounds(250,10,90,80);
		�����ϱ�.setBorder(BorderFactory.createEmptyBorder());
		�������г�2.add(�����ϱ�);
		
		JButton �����ϱ�2=new JButton(new ImageIcon("�����ϱ�2.png"));
		�����ϱ�2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pwd_algorithm pa= new Pwd_algorithm();
				
				System.out.println("��й�ȣ ���� ��ư Ŭ���� �̺�Ʈ");
				
			}
		});
		�����ϱ�2.setBounds(0,100,350,90);
		�����ϱ�2.setBorder(BorderFactory.createEmptyBorder());
		�������г�2.add(�����ϱ�2);
		
		getContentPane().add(�����г�);
		
		setVisible(true);
		setResizable(false);
	}

	public class Pwd_algorithm {
		public Pwd_algorithm() {

			String[] num = new String[20]; // �迭 0~16���� ����
			String result = "";
			int counter = 0;
			int[] spe = { 33, 64, 35, 36, 37, 94, 38, 42 };// Ư������ �迭
			int i = (int) (Math.random() * 4) + 12; // 8~14������ ����
													// ����(Ư������/�ҹ���/�빮�� ��
													// �ΰ����� ���� ��Ȳ ���)
			// System.out.println("i="+i);
			char aString = 0; // ��ȣ�� �ޱ����� ��Ʈ��
			int upper = 0, lower = 0, special = 0; // �ҹ���/�빮��/Ư������ ���� Ȯ��
			String str;

			for (int k = 0; k < i; k++) {
				aString = (char) ((Math.random() * 60) + 65); // A~Z/Ư������/a~z
																// ��������
																// �Է�
				/* ��,��,Ư������ ����Ȯ�� */
				if (aString < 91)
					upper++;
				else if (aString > 96 && aString < 123)
					lower++;
				else
					special++;

				/* Ư�����ڸ� ���ںκ��� Ư�����ڷ� ��ȯ���ִ� �۾� */
				if (aString == 91)
					aString = 33; // !�� ��ȯ
				if (aString == 92)
					aString = 64; // @�� ��ȯ
				if (aString == 93)
					aString = 35; // #�� ��ȯ
				if (aString == 95)
					aString = 36; // $�� ��ȯ
				if (aString == 96)
					aString = 37; // %�� ��ȯ
				if (aString == 123)
					aString = 38; // &�� ��ȯ
				if (aString == 124)
					aString = 42; // *�� ��ȯ
				str = String.valueOf(aString);
				num[k] = str;
				// System.out.println("num["+k+"]="+num[k]);
				System.out.print(num[k]);
				result += num[k];
			}

			/* ��й�ȣ ������ �������� ���� ��� */
			if (upper == 0) { // �빮�ڰ� ���°��
				i++;
				aString = (char) ((Math.random() * 26) + 65);
				num[i] = String.valueOf(aString);
				System.out.print(num[i]);
				result += num[i];
			}
			if (lower == 0) { // �ҹ��ڰ� ���°��
				i++;
				aString = (char) ((Math.random() * 26) + 97);
				num[i] = String.valueOf(aString);
				System.out.print(num[i]);
				result += num[i];
			}
			if (special == 0) { // Ư�����ڰ� ���°��
				i++;
				int j = (int) (Math.random() * 7);
				aString = (char) spe[j];
				num[i] = String.valueOf(aString);
				System.out.print(num[i]);
				result += num[i];
			}

			System.out.println("");
			System.out.println("result : " + result);
			��й�ȣ���.setText(result);
			// System.out.println("�빮��="+upper + "�ҹ���="+lower+"Ư������="+special);
		}

	}
}