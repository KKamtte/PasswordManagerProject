package �⸻��������Ʈ;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import client.ClientHandler;

import java.awt.*;
import java.awt.image.*;

public class MyAdd_Business extends JFrame {
	ImageIcon image1 = new ImageIcon("return����.png");
	ImageIcon image2 = new ImageIcon("������3.png");
	ImageIcon image3 = new ImageIcon("����2.png");
	ImageIcon image4 = new ImageIcon("eyes.png");
	JTextField ȸ���1;

	public MyAdd_Business() {
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
				new MyBusinesscard();
				dispose();
			}
		});
		return1.setBounds(10, 25, 70, 50);
		return1.setBorderPainted(false);
		return1.setBackground(new Color(204, 204, 204));
		return1.setBorder(BorderFactory.createEmptyBorder());
		title.add(return1);

		JLabel titleLabel = new JLabel("���� �߰�");
		titleLabel.setFont(new Font("", Font.BOLD, 30));
		titleLabel.setBounds(180, 30, 200, 50);
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

		JLabel ȸ��� = new JLabel("ȸ���");
		ȸ���.setBounds(10, 10, 200, 30);
		ȸ���.setFont(new Font("", Font.PLAIN, 25));
		panel1.add(ȸ���);

		ȸ���1 = new JTextField("ȸ���̸��� �Է��Ͻÿ�. ex)(��)�ؽ�");
		ȸ���1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				ȸ���1.getText();
				ȸ���1.setText("");
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

		ȸ���1.setBounds(10, 50, 440, 30);
		ȸ���1.setFont(new Font("", Font.BOLD, 20));
		panel1.add(ȸ���1);

		
		
		
		getContentPane().add(panel1);

		//

		// 3
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 230, 494, 300);
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panel2.setBackground(Color.gray);

		JLabel name=new JLabel("����:");
		name.setBounds(10,10,60,30);
		name.setFont(new Font("����",Font.BOLD, 25));
		panel2.add(name);
		
		JTextField name2=new JTextField("�̿쵵");
		name2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				name2.getText();
				name2.setText("");
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
		name2.setBounds(90,10,100,35);
		name2.setFont(new Font("����",Font.ITALIC, 20));
		panel2.add(name2);
		
		JLabel ��å=new JLabel("��å:");
		��å.setBounds(10,50,60,30);
		��å.setFont(new Font("����",Font.BOLD, 25));
		panel2.add(��å);
		
		JTextField ��å1=new JTextField("ex)�Ŵ���");
		��å1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				��å1.getText();
				��å1.setText("");
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
		��å1.setBounds(90, 50, 150, 35);
		��å1.setFont(new Font("����",Font.ITALIC, 20));
		panel2.add(��å1);
		
		JLabel �ּ�=new JLabel("�ּ�:");
		�ּ�.setBounds(10,90,60,30);
		�ּ�.setFont(new Font("����",Font.BOLD, 25));
		panel2.add(�ּ�);
		
		JTextField �ּ�1=new JTextField("�ּҸ� �Է��Ͻÿ�");
		�ּ�1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				�ּ�1.getText();
				�ּ�1.setText("");
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
		�ּ�1.setBounds(90, 90, 380, 35);
		�ּ�1.setFont(new Font("����",Font.ITALIC, 20));
		panel2.add(�ּ�1);
		
		JLabel ����ó1=new JLabel("TEL:");
		����ó1.setBounds(10,130,100,30);
		����ó1.setFont(new Font("����",Font.BOLD, 25));
		panel2.add(����ó1);
		
		JTextField ����ó2=new JTextField("ȸ����ȣ��ȣ�� �Է��Ͻÿ�");
		����ó2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				����ó2.getText();
				����ó2.setText("");
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
		����ó2.setBounds(90, 130, 380, 35);
		����ó2.setFont(new Font("����",Font.ITALIC, 20));
		panel2.add(����ó2);
		
		JLabel �ڵ�����ȣ=new JLabel("Phone:");
		�ڵ�����ȣ.setBounds(10,170,100,30);
		�ڵ�����ȣ.setFont(new Font("����",Font.BOLD, 25));
		panel2.add(�ڵ�����ȣ);
		
		JTextField �ڵ�����ȣ2=new JTextField("�ڵ�����ȣ�� �Է��Ͻÿ�");
		�ڵ�����ȣ2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				�ڵ�����ȣ2.getText();
				�ڵ�����ȣ2.setText("");
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
		�ڵ�����ȣ2.setBounds(90, 170, 380, 35);
		�ڵ�����ȣ2.setFont(new Font("����",Font.ITALIC, 20));
		panel2.add(�ڵ�����ȣ2);

		JLabel �ѽ���ȣ=new JLabel("FAX:");
		�ѽ���ȣ.setBounds(10,210,100,30);
		�ѽ���ȣ.setFont(new Font("����",Font.BOLD, 25));
		panel2.add(�ѽ���ȣ);
		
		JTextField �ѽ���ȣ2=new JTextField("�ѽ���ȣ�� �Է��Ͻÿ�");
		�ѽ���ȣ2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				�ѽ���ȣ2.getText();
				�ѽ���ȣ2.setText("");
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
		�ѽ���ȣ2.setBounds(90, 210, 380, 35);
		�ѽ���ȣ2.setFont(new Font("����",Font.ITALIC, 20));
		panel2.add(�ѽ���ȣ2);
		
		JLabel �̸���=new JLabel("e-mail:");
		�̸���.setBounds(10,250,100,30);
		�̸���.setFont(new Font("����",Font.BOLD, 25));
		panel2.add(�̸���);
		
		JTextField �̸���2=new JTextField("�̸����� �Է��Ͻÿ�");
		�̸���2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				�̸���2.getText();
				�̸���2.setText("");
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
		�̸���2.setBounds(90, 250, 380, 35);
		�̸���2.setFont(new Font("����",Font.ITALIC, 20));
		panel2.add(�̸���2);
		
		
		getContentPane().add(panel2);
		

	

		setVisible(true);
		setResizable(false);

	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();// ���õ� ��ư�� �˾Ƴ���
			if (b.getText().equals("����")) {
					new MyBusinesscard();
					dispose();
				} else {
					System.out.println("asdasdasd");

					JOptionPane.showMessageDialog(null, "�ʼ��׸� �߿� ���� �κ��� �ֽ��ϴ�. Ȯ�����ּ���!!", "Ȯ��",
							JOptionPane.INFORMATION_MESSAGE, null);

				}

		}
	}

}
