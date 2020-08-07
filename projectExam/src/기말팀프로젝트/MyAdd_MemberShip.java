package 기말팀프로젝트;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import client.ClientHandler;

import java.awt.*;
import java.awt.image.*;

public class MyAdd_MemberShip extends JFrame {
	ImageIcon image1 = new ImageIcon("return투명.png");
	ImageIcon image2 = new ImageIcon("생성기3.png");
	ImageIcon image3 = new ImageIcon("복사2.png");
	ImageIcon image4 = new ImageIcon("eyes.png");
	JTextField 제목;

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

		JLabel titleLabel = new JLabel("멤버쉽 카드 추가");
		titleLabel.setFont(new Font("", Font.BOLD, 30));
		titleLabel.setBounds(130, 30, 240, 50);
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

		JLabel 직함 = new JLabel("멤버쉽 카드 ");
		직함.setBounds(10, 10, 200, 30);
		직함.setFont(new Font("", Font.PLAIN, 25));
		panel1.add(직함);

		제목 = new JTextField("이곳에 멤버쉽 카드 이름을 적어주세요.");
		제목.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				제목.getText();
				제목.setText("");
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

		제목.setBounds(10, 50, 440, 30);
		제목.setFont(new Font("", Font.BOLD, 20));
		panel1.add(제목);
		
		getContentPane().add(panel1);
		
		JPanel memo=new JPanel();
		memo.setLayout(null);
		memo.setBounds(0, 121, 494, 490);
		memo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		memo.setBackground(Color.gray);
		
		JLabel memo_write =new JLabel("아래의 버튼을 눌러서");
		memo_write.setBounds(10, 110, 230, 30);
		memo_write.setFont(new Font("", Font.PLAIN, 25));
		memo_write.setOpaque(true);
		memo_write.setBackground(Color.RED);
		memo.add(memo_write);
		
		JLabel memo_write2=new JLabel("멤버쉽 카드를 저장할수 있습니다.");
		memo_write2.setBounds(10,150,370,30);
		memo_write2.setFont(new Font("", Font.PLAIN, 25));
		memo_write2.setOpaque(true);
		memo_write2.setBackground(Color.RED);
		memo.add(memo_write2);
		
		JButton 사진불러오기=new JButton("사진 불러오기");
//		사진불러오기.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//					여기에 그림판에서 했던 열기 버튼을 구현해서 사진을 불러올 수 있도록 하자 !
//			}
//		});
		사진불러오기.setBounds(50,250,200,100);
		memo.add(사진불러오기);

		getContentPane().add(memo);


		setVisible(true);
		setResizable(false);

	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();// 선택된 버튼을 알아낸다
			if (b.getText().equals("저장")) {
				
				System.out.println("내용들이 저장되었습니다.");
				new MyMemberShip();
				dispose();
			} else {
				System.out.println("asdasdasd");

				JOptionPane.showMessageDialog(null, "필수항목 중에 빠진 부분이 있습니다. 확인해주세요!!", "확인",
						JOptionPane.INFORMATION_MESSAGE, null);

			}

		}
	}

}
