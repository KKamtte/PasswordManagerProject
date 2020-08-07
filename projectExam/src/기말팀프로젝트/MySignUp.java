package 기말팀프로젝트;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Security.Encrypt;
import Security.SHA3;
import client.ClientHandler;

/**
 * 
 * @author 우도네 팀 ㅇㄹ
 *
 */
public class MySignUp extends JFrame implements ActionListener, MouseListener {
   private String user_name;
   private String email;
   private String member_id;
   private String member_password;
   private String member_password2;
   private String phone_number;
   JPanel title;
   JLabel label;
   JPanel text;
   JLabel a;
   JLabel b;
   ImageIcon main = new ImageIcon("메인투명.png");
   JLabel c;
   JLabel d;
   JLabel e_mail;
   JLabel phonenumber;
   JButton PwCheckBt;
   JButton 중복확인Bt;
   JButton 회원가입Bt;
   
   boolean pwChecked = false;
   JTextField userNameF;
   JTextField memberIdF;
   JPasswordField memberPasswordF;
   JPasswordField memberPasswordF2;
   JTextField emailF;
   JTextField phoneNumberF;
   private ClientHandler ch;
   private static boolean checked=false;
   public static boolean isChecked() {
	return checked;
}

public static void setChecked(boolean checked) {
	MySignUp.checked = checked;
}

MySignUp() {

      init();
      start();
      ch = ClientHandler.getInstance();

   }

   private void start() {
      // TODO Auto-generated method stub

      중복확인Bt.addActionListener(this);
      PwCheckBt.addActionListener(this);
      회원가입Bt.addActionListener(this);
      //,,,,,
      userNameF.addMouseListener(this);
      memberIdF.addMouseListener(this);
      memberPasswordF.addMouseListener(this);
      memberPasswordF2.addMouseListener(this);
      emailF.addMouseListener(this);
      phoneNumberF.addMouseListener(this);
   }

   private void init() {
      // TODO Auto-generated method stub
      setSize(500, 650);
      Container contentPane = getContentPane();
      contentPane.setLayout(null);


      title = new JPanel();
      title.setLayout(null);
      title.setBounds(0, 0, 500, 100);
      title.setBackground(Color.orange);

      label = new JLabel(main);
      label.setBounds(0, 10, 500, 90);
      title.add(label);

      contentPane.add(title);

      text = new JPanel();
      text.setBounds(0, 100, 500, 550);
      text.setBackground(new Color(255, 204, 102));
      text.setLayout(null);

      a = new JLabel("이름");
      a.setBounds(40, 10, 100, 45);
      a.setFont(new Font("견고딕", 20, 20));
      text.add(a);

      userNameF = new JTextField("이름을 입력하시오");
      userNameF.setBounds(130, 10, 300, 45);
      userNameF.setFont(new Font("견고딕", 20, 20));
      userNameF.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0)));
      text.add(userNameF);
      

      b = new JLabel("ID");
      b.setBounds(45, 80, 100, 45);
      b.setFont(new Font("견고딕", 20, 20));
      text.add(b);

      memberIdF = new JTextField("아이디 입력하시오");
      memberIdF.setBounds(130, 80, 200, 45);
      memberIdF.setFont(new Font("견고딕", 20, 20));
      memberIdF.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0)));
      text.add(memberIdF);

      중복확인Bt = new JButton("중복확인");
      중복확인Bt.setBounds(340, 80, 90, 45);

      text.add(중복확인Bt);

      c = new JLabel("PW");
      c.setBounds(45, 150, 100, 45);
      c.setFont(new Font("견고딕", 20, 20));
      text.add(c);

      memberPasswordF = new JPasswordField("비밀번호를 입력하시오");
      memberPasswordF.setFont(new Font("견고딕", 20, 20));
      memberPasswordF.setBounds(130, 150, 200, 45);
      memberPasswordF.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0)));
      memberPasswordF.setEchoChar('*');
      text.add(memberPasswordF);

      d = new JLabel("PW 확인");
      d.setBounds(45, 220, 100, 45);
      d.setFont(new Font("견고딕", 20, 20));
      text.add(d);

      memberPasswordF2 = new JPasswordField("동일한 비밀번호를 입력하시오");
      memberPasswordF2.setEchoChar('*');
      memberPasswordF2.setFont(new Font("견고딕", 20, 20));
      memberPasswordF2.setBounds(130, 220, 200, 45);
      memberPasswordF2.setBorder(BorderFactory.createEmptyBorder());
      text.add(memberPasswordF2);

      PwCheckBt = new JButton("확인");

      PwCheckBt.setBounds(340, 220, 90, 45);
      text.add(PwCheckBt);

      e_mail = new JLabel("e-mail");
      e_mail.setBounds(45, 290, 100, 45);
      e_mail.setFont(new Font("견고딕", 20, 20));
      text.add(e_mail);

      emailF = new JTextField("이메일을 입력하시오");
      emailF.setBounds(130, 290, 300, 45);
      emailF.setFont(new Font("견고딕", 20, 20));
      emailF.setBorder(BorderFactory.createEmptyBorder());
      text.add(emailF);

      phonenumber = new JLabel("전화번호");
      phonenumber.setBounds(45, 360, 100, 45);
      phonenumber.setFont(new Font("견고딕", 20, 20));
      text.add(phonenumber);

      phoneNumberF = new JTextField("핸드폰 번호를 입력하시오");
      phoneNumberF.setBounds(130, 360, 300, 45);
      phoneNumberF.setFont(new Font("견고딕", 20, 20));
      phoneNumberF.setBorder(BorderFactory.createEmptyBorder());
      text.add(phoneNumberF);

      회원가입Bt = new JButton("회원 가입");
      회원가입Bt.setBounds(140, 450, 230, 45);
      회원가입Bt.setBorderPainted(false);

      text.add(회원가입Bt);
      contentPane.add(text);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
   }

   public String getuser_name() {
      return user_name;
   }

   public void setuser_name(String user_name) {
      this.user_name = user_name;
   }

   public String getmember_id() {
      return member_id;
   }

   public void setmember_id(String member_id) {
      this.member_id = member_id;
   }

   public String getPassword() {
      System.out.println("mem_pw " + member_password);
      return member_password;
   }

   public void setPassword(String member_password) {
      System.out.println(member_password);
      this.member_password = member_password;
   }

   public String getPassword2() {
      return member_password2;
   }

   public void setPassword2(String member_password2) {
      this.member_password2 = member_password2;
   }

   public String getemail() {
      return email;
   }

   public void setemail(String email) {
      this.email = email;
   }

   public String getphone_number() {
      return phone_number;
   }

   public void setphone_number(String phone_number) {
      this.phone_number = phone_number;
   }

//   class MyActionListener implements ActionListener {
//      String pw1 = getPassword();
//      String pw2 = getPassword2();
//
//      public void actionPerformed(ActionEvent e) {
//         JButton b = (JButton) e.getSource();// 선택된 버튼을 알아낸다
//         if (b.getText().equals("확인")) {
//            if (pw1 == pw2) {
//               JOptionPane.showMessageDialog(null, "비밀번호가 일치 합니다. <3", "완료", JOptionPane.DEFAULT_OPTION);
//               System.out.println(member_password + " " + member_password2);
//
//            } else {
//               JOptionPane.showMessageDialog(null, "비밀번호가 일치 하지 않습니다.", "오류", JOptionPane.CLOSED_OPTION);
//               System.out.println(member_password + " " + member_password2);
//            }
//            System.out.println("d");
//         }
//      }
//   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      Object src = e.getSource();
      // private JTextField loginId;
      // private JPasswordField passwordPW;
     
    
 	 
      if (src == 중복확인Bt) {
    	  String enID = makeSHAString(memberIdF.getText());
    	  
         if (memberIdF.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "아이디를 입력하십시오.", "오류", JOptionPane.ERROR_MESSAGE);
         } else if(!enID.equals("")){ //서버와 아이디 체크
        	 ch.requestCheckId(enID);
        	 try {
				Thread.sleep(300l);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	 
         } else {
             JOptionPane.showMessageDialog(null, "중복된 아이디가 있습니다", "오류", JOptionPane.DEFAULT_OPTION);
          }
      } else if (src == PwCheckBt) {
    	  String enPW = makeSHAString(memberPasswordF.getText());
      	 String enPW2 = makeSHAString(memberPasswordF2.getText());
         if (enPW.equals(enPW2)) {
            JOptionPane.showMessageDialog(null, "비밀번호가 일치 합니다. <3", "완료", JOptionPane.DEFAULT_OPTION);
            pwChecked = true;
            System.out.println(enPW + " " + enPW2);

         } else {
            JOptionPane.showMessageDialog(null, "비밀번호가 일치 하지 않습니다.", "오류", JOptionPane.CLOSED_OPTION);
            System.out.println(enPW + " " + enPW2);
         }
      } else if (src == 회원가입Bt) {
         String pwd1 = String.valueOf(memberPasswordF.getPassword());
         String pwd2 = String.valueOf(memberPasswordF2.getPassword());
         if (!checked) {
            JOptionPane.showMessageDialog(this, "아이디 중복확인을 하세요");
            memberIdF.requestFocus();
         } else if (pwd1.length() < 4 || pwd1.length() > 16) {
            JOptionPane.showMessageDialog(this, "암호는 4자이상 16자 이하");
            memberPasswordF.requestFocus();
         } else if (!pwChecked) {
             JOptionPane.showMessageDialog(this, "비밀번호 일치여부를 확인해주세요");
             PwCheckBt.requestFocus();
          }else if (!pwd2.equals(pwd1)) {
            JOptionPane.showMessageDialog(this, "암호가 일치하지 않습니다");
            memberPasswordF2.requestFocus();
         } else if (userNameF.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "이름을 입력하세요");
            userNameF.requestFocus();
         } else if (emailF.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "이메일을 입력하세요");
            emailF.requestFocus();
         } else if (phoneNumberF.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "핸드폰번호를 입력하세요");
            phoneNumberF.requestFocus();
         } else {
        	  //사용자 정보 암호화
         	 String enID = makeSHAString(memberIdF.getText());
         	 String enPW = makeSHAString(memberPasswordF.getText());
         	 String enPW2 = makeSHAString(memberPasswordF2.getText());
         	 String enName = makeEnString(userNameF.getText());
         	 String enEmail = makeEnString(emailF.getText());
         	 String enPNum = makeEnString(phoneNumberF.getText());
            // 서버로 보낼 msg 작성
            String msg = enID + "," + enPW + ","
                  + enName + "," + enEmail + "," + enPNum;
            System.out.println("서버로 보낼 메세지 확인 : " + msg);
            ch.requestJoin(msg);
            JOptionPane.showMessageDialog(null, "환영합니다^^ 로그인 하시오.", "가입완료", JOptionPane.INFORMATION_MESSAGE);
            new MyStart();
            dispose();
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
   
   private String makeEnString(String text) {
		Encrypt en = null;

		try { // 사용자정보 암호화(이름,이메일,전화번호)
			en = new Encrypt(text);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("암호화된 값 : " + en.getEnco());
		// String en카드명1 = en.getEnco();
		return en.getEnco();
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
}