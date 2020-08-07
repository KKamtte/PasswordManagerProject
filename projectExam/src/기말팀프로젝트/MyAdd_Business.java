package 기말팀프로젝트;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import client.ClientHandler;

import java.awt.*;
import java.awt.image.*;

public class MyAdd_Business extends JFrame {
	ImageIcon image1 = new ImageIcon("return투명.png");
	ImageIcon image2 = new ImageIcon("생성기3.png");
	ImageIcon image3 = new ImageIcon("복사2.png");
	ImageIcon image4 = new ImageIcon("eyes.png");
	JTextField 회사명1;

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

		JLabel titleLabel = new JLabel("명함 추가");
		titleLabel.setFont(new Font("", Font.BOLD, 30));
		titleLabel.setBounds(180, 30, 200, 50);
		title.add(titleLabel);

		JButton save = new JButton("저장");
		save.addActionListener(listener); // 이벤트 달기
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

		JLabel 회사명 = new JLabel("회사명");
		회사명.setBounds(10, 10, 200, 30);
		회사명.setFont(new Font("", Font.PLAIN, 25));
		panel1.add(회사명);

		회사명1 = new JTextField("회사이름을 입력하시오. ex)(주)넥슨");
		회사명1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				회사명1.getText();
				회사명1.setText("");
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

		회사명1.setBounds(10, 50, 440, 30);
		회사명1.setFont(new Font("", Font.BOLD, 20));
		panel1.add(회사명1);

		
		
		
		getContentPane().add(panel1);

		//

		// 3
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 230, 494, 300);
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panel2.setBackground(Color.gray);

		JLabel name=new JLabel("성명:");
		name.setBounds(10,10,60,30);
		name.setFont(new Font("돋움",Font.BOLD, 25));
		panel2.add(name);
		
		JTextField name2=new JTextField("이우도");
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
		name2.setFont(new Font("돋움",Font.ITALIC, 20));
		panel2.add(name2);
		
		JLabel 직책=new JLabel("직책:");
		직책.setBounds(10,50,60,30);
		직책.setFont(new Font("돋움",Font.BOLD, 25));
		panel2.add(직책);
		
		JTextField 직책1=new JTextField("ex)매니저");
		직책1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				직책1.getText();
				직책1.setText("");
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
		직책1.setBounds(90, 50, 150, 35);
		직책1.setFont(new Font("돋움",Font.ITALIC, 20));
		panel2.add(직책1);
		
		JLabel 주소=new JLabel("주소:");
		주소.setBounds(10,90,60,30);
		주소.setFont(new Font("돋움",Font.BOLD, 25));
		panel2.add(주소);
		
		JTextField 주소1=new JTextField("주소를 입력하시오");
		주소1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				주소1.getText();
				주소1.setText("");
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
		주소1.setBounds(90, 90, 380, 35);
		주소1.setFont(new Font("돋움",Font.ITALIC, 20));
		panel2.add(주소1);
		
		JLabel 연락처1=new JLabel("TEL:");
		연락처1.setBounds(10,130,100,30);
		연락처1.setFont(new Font("돋움",Font.BOLD, 25));
		panel2.add(연락처1);
		
		JTextField 연락처2=new JTextField("회사전호번호를 입력하시오");
		연락처2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				연락처2.getText();
				연락처2.setText("");
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
		연락처2.setBounds(90, 130, 380, 35);
		연락처2.setFont(new Font("돋움",Font.ITALIC, 20));
		panel2.add(연락처2);
		
		JLabel 핸드폰번호=new JLabel("Phone:");
		핸드폰번호.setBounds(10,170,100,30);
		핸드폰번호.setFont(new Font("돋움",Font.BOLD, 25));
		panel2.add(핸드폰번호);
		
		JTextField 핸드폰번호2=new JTextField("핸드폰번호를 입력하시오");
		핸드폰번호2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				핸드폰번호2.getText();
				핸드폰번호2.setText("");
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
		핸드폰번호2.setBounds(90, 170, 380, 35);
		핸드폰번호2.setFont(new Font("돋움",Font.ITALIC, 20));
		panel2.add(핸드폰번호2);

		JLabel 팩스번호=new JLabel("FAX:");
		팩스번호.setBounds(10,210,100,30);
		팩스번호.setFont(new Font("돋움",Font.BOLD, 25));
		panel2.add(팩스번호);
		
		JTextField 팩스번호2=new JTextField("팩스번호를 입력하시오");
		팩스번호2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				팩스번호2.getText();
				팩스번호2.setText("");
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
		팩스번호2.setBounds(90, 210, 380, 35);
		팩스번호2.setFont(new Font("돋움",Font.ITALIC, 20));
		panel2.add(팩스번호2);
		
		JLabel 이메일=new JLabel("e-mail:");
		이메일.setBounds(10,250,100,30);
		이메일.setFont(new Font("돋움",Font.BOLD, 25));
		panel2.add(이메일);
		
		JTextField 이메일2=new JTextField("이메일을 입력하시오");
		이메일2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				이메일2.getText();
				이메일2.setText("");
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
		이메일2.setBounds(90, 250, 380, 35);
		이메일2.setFont(new Font("돋움",Font.ITALIC, 20));
		panel2.add(이메일2);
		
		
		getContentPane().add(panel2);
		

	

		setVisible(true);
		setResizable(false);

	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();// 선택된 버튼을 알아낸다
			if (b.getText().equals("저장")) {
					new MyBusinesscard();
					dispose();
				} else {
					System.out.println("asdasdasd");

					JOptionPane.showMessageDialog(null, "필수항목 중에 빠진 부분이 있습니다. 확인해주세요!!", "확인",
							JOptionPane.INFORMATION_MESSAGE, null);

				}

		}
	}

}
