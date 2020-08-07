package 기말팀프로젝트;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.DigestException;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.AsyncBoxView.ChildLocator;

import Security.Encrypt;
import Security.SHA3;
import client.ClientHandler;

import javax.swing.ImageIcon;

public class MyStart extends JFrame implements ActionListener, MouseListener,KeyListener {
   private Container ContentPane = getContentPane();
   private ImageIcon main = new ImageIcon("메인투명.png");
   private JLabel label;
   private JPanel 로그인패널;
   private JLabel login;
   private JLabel password;
   private JTextField loginId;
   private JPasswordField passwordPW;
   private JButton 회원가입;
   private JButton next;
   private JButton exid;
   private ClientHandler ch;

   public MyStart() {
      init();
      start();
      ch = ClientHandler.getInstance();

   }

   private void init() {
      // TODO Auto-generated method stub
	  //setLocation(ClientHandler.p);
      setTitle("비밀의 방");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setContentPane(ContentPane);
      ContentPane.setBackground(Color.orange);
      setLayout(null);

      label = new JLabel(main);
      label.setBounds(0, 100, 500, 97);
      label.setBackground(Color.orange);
      getContentPane().add(label);

      로그인패널 = new JPanel();
      로그인패널.setLayout(null);
      로그인패널.setBounds(0, 200, 500, 450);
      로그인패널.setBackground(Color.orange);

      login = new JLabel("아이디    :");
      login.setBounds(68, 70, 120, 30);
      login.setFont(new Font("굴림", Font.BOLD, 25));
      로그인패널.add(login);

      password = new JLabel("비밀번호 :");
      password.setBounds(70, 100, 120, 30);
      password.setFont(new Font("굴림", Font.BOLD, 25));
      로그인패널.add(password);

      loginId = new JTextField("*****");
      loginId.setFont(new Font("굴림", Font.BOLD, 25));
      loginId.setBounds(200, 70, 260, 30);
      로그인패널.add(loginId);

      passwordPW = new JPasswordField("******");
      passwordPW.setFont(new Font("굴림", Font.BOLD, 25));
      passwordPW.setBounds(200, 100, 260, 30);
      로그인패널.add(passwordPW);

      회원가입 = new JButton("회원가입");
      회원가입.setBounds(200, 140, 100, 40);
      로그인패널.add(회원가입);

      next = new JButton("로그인");
      next.setBounds(300, 140, 80, 40);
      next.addKeyListener(this);
      로그인패널.add(next);

      exid = new JButton("초기화");
      exid.setBounds(380, 140, 80, 40);
      로그인패널.add(exid);

      ContentPane.add(로그인패널);

      setSize(500, 650);
      setVisible(true);
      setResizable(false);

         
         
      ContentPane.requestFocus();

   }

   private void start() {
      // TODO Auto-generated method stub
      회원가입.addActionListener(this);
      next.addActionListener(this);
      exid.addActionListener(this);
      passwordPW.addMouseListener(this);
      loginId.addMouseListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object src = e.getSource();

      if (src == next) {
         if (loginId.getText().length() == 0) {
            JOptionPane.showMessageDialog(ch.getFrame(), "아이디를 입력하세요");
         } else if (passwordPW.getPassword().length == 0) {
            JOptionPane.showMessageDialog(ch.getFrame(), "암호를 입력하세요");
         } else {
        	 String enID = makeSHAString(loginId.getText());
         	 String enPW = makeSHAString(String.valueOf(passwordPW.getPassword()));
         	
        	 
            System.out.println(enID + "," + enPW);
            ClientHandler.requestLogin(enID + "," + enPW);
         }
      } else if (src == exid) {
         System.exit(0);
      } else if (src == 회원가입) {
         new MySignUp();
         dispose();

      }

   }



   
   



   @Override
   public void mouseClicked(MouseEvent e) {
      // TODO Auto-generated method stub

   }


   @Override
   public void mouseEntered(MouseEvent e) {
      // TODO Auto-generated method stub

   }

   @Override
   public void mouseExited(MouseEvent e) {
      // TODO Auto-generated method stub

   }

   @Override
   public void mousePressed(MouseEvent e) {
      // TODO Auto-generated method stub
      // 뭘 누르든 똑같음

      Object src = e.getSource();// 선택된 버튼을 알아낸다
      JTextField empty = (JTextField) src;
      empty.setText(null);

   }

   @Override
   public void mouseReleased(MouseEvent e) {
      // TODO Auto-generated method stub

   }

   public void close() {
      dispose();
   }

   public void setHandler(ClientHandler ch) {
      // TODO Auto-generated method stub
      System.out.println(ch);
      this.ch = ch;
   }

   @Override
   public void keyPressed(KeyEvent e) {
      // TODO Auto-generated method stub
	   int keyCode = e.getKeyCode();
	      if (keyCode == KeyEvent.VK_ENTER) {
	         if (loginId.getText().length() == 0) {
	            JOptionPane.showMessageDialog(ch.getFrame(), "아이디를 입력하세요");
	         } else if (passwordPW.getPassword().length == 0) {
	            JOptionPane.showMessageDialog(ch.getFrame(), "암호를 입력하세요");
	         } else {
	        	 String enID = makeSHAString(loginId.getText());
	         	 String enPW = makeSHAString(String.valueOf(passwordPW.getPassword()));
	         	
	        	 
	            System.out.println(enID + "," + enPW);
	            ClientHandler.requestLogin(enID + "," + enPW);
	         }
	      }
   }
   private String makeSHAString(String text) {
		SHA3 en = null;

		try { // 사용자정보 암호화(아이디,비밀번호)
			en = new SHA3(text);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("암호화된 값 : " + en.getSHA_String());
		// String en카드명1 = en.getEnco();
		return en.getSHA_String();
	}
  
   @Override
   public void keyReleased(KeyEvent e) {
      // TODO Auto-generated method stub
      
      
   }

   @Override
   public void keyTyped(KeyEvent e) {
      // TODO Auto-generated method stub
     
   }

}