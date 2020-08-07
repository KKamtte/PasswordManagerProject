package �⸻��������Ʈ;

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
   private ImageIcon main = new ImageIcon("��������.png");
   private JLabel label;
   private JPanel �α����г�;
   private JLabel login;
   private JLabel password;
   private JTextField loginId;
   private JPasswordField passwordPW;
   private JButton ȸ������;
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
      setTitle("����� ��");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setContentPane(ContentPane);
      ContentPane.setBackground(Color.orange);
      setLayout(null);

      label = new JLabel(main);
      label.setBounds(0, 100, 500, 97);
      label.setBackground(Color.orange);
      getContentPane().add(label);

      �α����г� = new JPanel();
      �α����г�.setLayout(null);
      �α����г�.setBounds(0, 200, 500, 450);
      �α����г�.setBackground(Color.orange);

      login = new JLabel("���̵�    :");
      login.setBounds(68, 70, 120, 30);
      login.setFont(new Font("����", Font.BOLD, 25));
      �α����г�.add(login);

      password = new JLabel("��й�ȣ :");
      password.setBounds(70, 100, 120, 30);
      password.setFont(new Font("����", Font.BOLD, 25));
      �α����г�.add(password);

      loginId = new JTextField("*****");
      loginId.setFont(new Font("����", Font.BOLD, 25));
      loginId.setBounds(200, 70, 260, 30);
      �α����г�.add(loginId);

      passwordPW = new JPasswordField("******");
      passwordPW.setFont(new Font("����", Font.BOLD, 25));
      passwordPW.setBounds(200, 100, 260, 30);
      �α����г�.add(passwordPW);

      ȸ������ = new JButton("ȸ������");
      ȸ������.setBounds(200, 140, 100, 40);
      �α����г�.add(ȸ������);

      next = new JButton("�α���");
      next.setBounds(300, 140, 80, 40);
      next.addKeyListener(this);
      �α����г�.add(next);

      exid = new JButton("�ʱ�ȭ");
      exid.setBounds(380, 140, 80, 40);
      �α����г�.add(exid);

      ContentPane.add(�α����г�);

      setSize(500, 650);
      setVisible(true);
      setResizable(false);

         
         
      ContentPane.requestFocus();

   }

   private void start() {
      // TODO Auto-generated method stub
      ȸ������.addActionListener(this);
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
            JOptionPane.showMessageDialog(ch.getFrame(), "���̵� �Է��ϼ���");
         } else if (passwordPW.getPassword().length == 0) {
            JOptionPane.showMessageDialog(ch.getFrame(), "��ȣ�� �Է��ϼ���");
         } else {
        	 String enID = makeSHAString(loginId.getText());
         	 String enPW = makeSHAString(String.valueOf(passwordPW.getPassword()));
         	
        	 
            System.out.println(enID + "," + enPW);
            ClientHandler.requestLogin(enID + "," + enPW);
         }
      } else if (src == exid) {
         System.exit(0);
      } else if (src == ȸ������) {
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
      // �� ������ �Ȱ���

      Object src = e.getSource();// ���õ� ��ư�� �˾Ƴ���
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
	            JOptionPane.showMessageDialog(ch.getFrame(), "���̵� �Է��ϼ���");
	         } else if (passwordPW.getPassword().length == 0) {
	            JOptionPane.showMessageDialog(ch.getFrame(), "��ȣ�� �Է��ϼ���");
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

		try { // ��������� ��ȣȭ(���̵�,��й�ȣ)
			en = new SHA3(text);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("��ȣȭ�� �� : " + en.getSHA_String());
		// String enī���1 = en.getEnco();
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