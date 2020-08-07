package 기말팀프로젝트;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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

import DTO.PwDataDTO;
import client.ClientHandler;
import client.Member;
import client.ServerMsgListener;

public class MyPassword extends JFrame implements ActionListener {
	 ImageIcon image;
	   private JTextField textField;
	   Member mb;
	   JPanel panel;
	   JLabel 열쇠;
	   JLabel label;
	   JPanel panel2;
	   JPanel 비밀의방패널;
	   JButton mainBtn;// 리스너 필요
	   JButton addBtn; // 리스너 필요
	   JPanel panel3;
	   JLabel lookBtn;
	    JPanel panel4;

	   
	   
	   public MyPassword(Member member) {
		   System.out.println("-----------");
		   System.out.println("-----------");
		   System.out.println("생성자 생성");
	      mb = member;
	      System.out.println("mb : "+mb);
	      getData();
	      try {
	         Thread.sleep(300l);
	      } catch (InterruptedException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      };
	      System.out.println("init 실행");
	      init();
	      System.out.println("init 종료");
	      start();
	      System.out.println("-----------");
		   System.out.println("-----------");
		   

	   }

	   @Override
	   public void actionPerformed(ActionEvent e ){
	      // TODO Auto-generated method stub
	      Object src = e.getSource();
	      if( src == mainBtn){
	         new MyFrame(ClientHandler.getMember());
	         dispose();
	      }else if(src == addBtn){
	         new MyAdd_pw();
	         dispose();
	      }
	      
	   }

	   private void getData() {
	      // 서버로부터 데이터를 받아와서 찍는 메소드
		   System.out.println("getUserNum : "+mb.getUserNum());
	      ClientHandler.requestPwData(mb.getUserNum());
	   }

	   private void start() {
	      // TODO Auto-generated method stub
	      mainBtn.addActionListener(this);
	      addBtn.addActionListener(this);
	   }

	   //
	   // public static void main(String args[]) {
	   // new MyPassword();
	   //
	   // }
	   private void init() {
	      // TODO Auto-generated method stub
		  // setLocation(ClientHandler.p);
	      setSize(500, 650);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      getContentPane().setLayout(null);
	      
	      PwDataDTO.setMp(this);
	      ServerMsgListener.setMp(this);
	      panel = new JPanel();
	      panel.setToolTipText("암호 옆자리");
	      panel.setLayout(null);
	      panel.setBounds(0, 0, 500, 53);
	      panel.setBackground(Color.white);

	      열쇠 = new JLabel(new ImageIcon("열쇠4.png"));
	      열쇠.setBounds(0, 0, 65, 53);
	      panel.add(열쇠);
	      열쇠.setBorder(BorderFactory.createLineBorder(Color.orange));

	      label = new JLabel("암호");
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

	      addBtn = new JButton(new ImageIcon("add.png"));
	      addBtn.setBounds(2, 1, 52, 50);
	      addBtn.setBorderPainted(false);
	      panel2.add(addBtn);

	      비밀의방패널 = new JPanel();
	      비밀의방패널.setBounds(0, 53, 494, 73);
	      비밀의방패널.setBackground(Color.white);
	      비밀의방패널.setBorder(BorderFactory.createLineBorder(Color.orange));
	      getContentPane().add(비밀의방패널);

	      panel.setBorder(BorderFactory.createLineBorder(Color.orange));
	      getContentPane().add(panel);

	      mainBtn = new JButton(new ImageIcon("비밀.png"));// 메인으로 이동 이미지
	      비밀의방패널.setLayout(null);

	      mainBtn.setBounds(2, 25, 161, 39);
	      mainBtn.setBorderPainted(false);
	      비밀의방패널.add(mainBtn);

	      panel3 = new JPanel();
	      panel3.setBounds(0, 126, 494, 57);
	      panel3.setBackground(Color.white);
	      panel3.setBorder(BorderFactory.createLineBorder(Color.orange));

	      lookBtn = new JLabel(new ImageIcon("돋.png"));
	      lookBtn.setBounds(0, 126, 65, 53);
	      getContentPane().add(lookBtn);

	      textField = new JTextField(15);
	      textField.setText("사이트검색");
	      textField.setBounds(65, 0, 474, 57);
	      textField.setFont(new Font("맑은 고딕", Font.BOLD, 27));
	      textField.setHorizontalAlignment(JTextField.CENTER);
	      textField.setBorder(BorderFactory.createEmptyBorder());
	      panel3.add(textField);

	      getContentPane().add(panel3);

	      panel4 = new JPanel();
	      panel4.setLayout(new GridLayout(6, 1));
	      panel4.setBounds(0, 183, 494, 467);
	      panel4.setBackground(Color.white);
	      panel4.setBorder(BorderFactory.createLineBorder(Color.orange));
	      
	      for(int i= 0; i< PwDataDTO.pwDataList.size();i++){
	         System.out.println(i+"번째 정보출력");
	         System.out.println("이름 : "+PwDataDTO.pwDataList.get(i).getSiteName());
	         panel4.add(PwDataDTO.pwDataList.get(i));
	      }

	      getContentPane().add(panel4);

	      setVisible(true);
	      setResizable(false);
	   }

}