package �⸻��������Ʈ;

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
	   JLabel ����;
	   JLabel label;
	   JPanel panel2;
	   JPanel ����ǹ��г�;
	   JButton mainBtn;// ������ �ʿ�
	   JButton addBtn; // ������ �ʿ�
	   JPanel panel3;
	   JLabel lookBtn;
	    JPanel panel4;

	   
	   
	   public MyPassword(Member member) {
		   System.out.println("-----------");
		   System.out.println("-----------");
		   System.out.println("������ ����");
	      mb = member;
	      System.out.println("mb : "+mb);
	      getData();
	      try {
	         Thread.sleep(300l);
	      } catch (InterruptedException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      };
	      System.out.println("init ����");
	      init();
	      System.out.println("init ����");
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
	      // �����κ��� �����͸� �޾ƿͼ� ��� �޼ҵ�
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
	      panel.setToolTipText("��ȣ ���ڸ�");
	      panel.setLayout(null);
	      panel.setBounds(0, 0, 500, 53);
	      panel.setBackground(Color.white);

	      ���� = new JLabel(new ImageIcon("����4.png"));
	      ����.setBounds(0, 0, 65, 53);
	      panel.add(����);
	      ����.setBorder(BorderFactory.createLineBorder(Color.orange));

	      label = new JLabel("��ȣ");
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

	      addBtn = new JButton(new ImageIcon("add.png"));
	      addBtn.setBounds(2, 1, 52, 50);
	      addBtn.setBorderPainted(false);
	      panel2.add(addBtn);

	      ����ǹ��г� = new JPanel();
	      ����ǹ��г�.setBounds(0, 53, 494, 73);
	      ����ǹ��г�.setBackground(Color.white);
	      ����ǹ��г�.setBorder(BorderFactory.createLineBorder(Color.orange));
	      getContentPane().add(����ǹ��г�);

	      panel.setBorder(BorderFactory.createLineBorder(Color.orange));
	      getContentPane().add(panel);

	      mainBtn = new JButton(new ImageIcon("���.png"));// �������� �̵� �̹���
	      ����ǹ��г�.setLayout(null);

	      mainBtn.setBounds(2, 25, 161, 39);
	      mainBtn.setBorderPainted(false);
	      ����ǹ��г�.add(mainBtn);

	      panel3 = new JPanel();
	      panel3.setBounds(0, 126, 494, 57);
	      panel3.setBackground(Color.white);
	      panel3.setBorder(BorderFactory.createLineBorder(Color.orange));

	      lookBtn = new JLabel(new ImageIcon("��.png"));
	      lookBtn.setBounds(0, 126, 65, 53);
	      getContentPane().add(lookBtn);

	      textField = new JTextField(15);
	      textField.setText("����Ʈ�˻�");
	      textField.setBounds(65, 0, 474, 57);
	      textField.setFont(new Font("���� ���", Font.BOLD, 27));
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
	         System.out.println(i+"��° �������");
	         System.out.println("�̸� : "+PwDataDTO.pwDataList.get(i).getSiteName());
	         panel4.add(PwDataDTO.pwDataList.get(i));
	      }

	      getContentPane().add(panel4);

	      setVisible(true);
	      setResizable(false);
	   }

}