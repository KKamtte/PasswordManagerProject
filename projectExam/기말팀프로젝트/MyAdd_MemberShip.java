package �⸻��������Ʈ;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import client.ClientHandler;

import java.awt.*;
import java.awt.image.*;

public class MyAdd_MemberShip extends JFrame {
	ImageIcon image1 = new ImageIcon("return����.png");
	ImageIcon image2 = new ImageIcon("������3.png");
	ImageIcon image3 = new ImageIcon("����2.png");
	ImageIcon image4 = new ImageIcon("eyes.png");
	JTextField ����;

	public MyAdd_MemberShip() {
		//setLocation(ClientHandler.p);;
		setSize(500, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		MyActionListener listener = new MyActionListener();
		// 1
		JPanel title = new JPanel();
		title.setLayout(null);
		title.setBounds(0, 0, 500, 120);
		title.setBackground(new Color(204, 204, 204));

		JButton return1 = new JButton(image1);
		return1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MyMemberShip();
				dispose();
			}
		});
		return1.setBounds(10, 25, 70, 50);
		return1.setBorderPainted(false);
		return1.setBackground(new Color(204, 204, 204));
		return1.setBorder(BorderFactory.createEmptyBorder());
		title.add(return1);

		JLabel titleLabel = new JLabel("����� ī�� �߰�");
		titleLabel.setFont(new Font("", Font.BOLD, 30));
		titleLabel.setBounds(130, 30, 240, 50);
		title.add(titleLabel);

		JButton save = new JButton("����");
		save.addActionListener(listener); // �̺�Ʈ �ޱ�
		save.setBounds(420, 25, 70, 50);
		save.setFont(new Font("", Font.BOLD, 20));
		save.setBackground(new Color(204, 204, 204));
		save.setBorder(BorderFactory.createEmptyBorder());
		title.add(save);

		getContentPane().add(title);
		//

		// 2

		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0, 120, 494, 100);
		panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panel1.setBackground(Color.gray);

		JLabel ���� = new JLabel("����� ī�� ");
		����.setBounds(10, 10, 200, 30);
		����.setFont(new Font("", Font.PLAIN, 25));
		panel1.add(����);

		���� = new JTextField("�̰��� ����� ī�� �̸��� �����ּ���.");
		����.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				����.getText();
				����.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		����.setBounds(10, 50, 440, 30);
		����.setFont(new Font("", Font.BOLD, 20));
		panel1.add(����);
		
		getContentPane().add(panel1);
		
		JPanel memo=new JPanel();
		memo.setLayout(null);
		memo.setBounds(0, 121, 494, 490);
		memo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		memo.setBackground(Color.gray);
		
		JLabel memo_write =new JLabel("�Ʒ��� ��ư�� ������");
		memo_write.setBounds(10, 110, 230, 30);
		memo_write.setFont(new Font("", Font.PLAIN, 25));
		memo_write.setOpaque(true);
		memo_write.setBackground(Color.RED);
		memo.add(memo_write);
		
		JLabel memo_write2=new JLabel("����� ī�带 �����Ҽ� �ֽ��ϴ�.");
		memo_write2.setBounds(10,150,370,30);
		memo_write2.setFont(new Font("", Font.PLAIN, 25));
		memo_write2.setOpaque(true);
		memo_write2.setBackground(Color.RED);
		memo.add(memo_write2);
		
		JButton �����ҷ�����=new JButton("���� �ҷ�����");
//		�����ҷ�����.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//					���⿡ �׸��ǿ��� �ߴ� ���� ��ư�� �����ؼ� ������ �ҷ��� �� �ֵ��� ���� !
//			}
//		});
		�����ҷ�����.setBounds(50,250,200,100);
		memo.add(�����ҷ�����);

		getContentPane().add(memo);


		setVisible(true);
		setResizable(false);

	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();// ���õ� ��ư�� �˾Ƴ���
			if (b.getText().equals("����")) {
				
				System.out.println("������� ����Ǿ����ϴ�.");
				new MyMemberShip();
				dispose();
			} else {
				System.out.println("asdasdasd");

				JOptionPane.showMessageDialog(null, "�ʼ��׸� �߿� ���� �κ��� �ֽ��ϴ�. Ȯ�����ּ���!!", "Ȯ��",
						JOptionPane.INFORMATION_MESSAGE, null);

			}

		}
	}

}
