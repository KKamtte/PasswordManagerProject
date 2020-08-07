package 기말팀프로젝트;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import DTO.PwDataDTO;
import DTO.SmDataDTO;
import Security.Encrypt;
import client.ClientHandler;

import java.awt.*;
import java.awt.image.*;

public class MyAdd_memo extends JFrame implements ActionListener, MouseListener{
	ImageIcon image1 = new ImageIcon("return투명.png");
	ImageIcon image2 = new ImageIcon("생성기3.png");
	ImageIcon image3 = new ImageIcon("복사2.png");
	ImageIcon image4 = new ImageIcon("eyes.png");
	JTextField 주제, memo_write2;
	JPanel title, panel1,memo;
	JButton return1,save;
	JLabel titleLabel,직함,memo_write;
	
	
	int pm_num;
	String smTitle;
	String smData;
	boolean updateVer = false;
	
	private ClientHandler ch;
	
	public MyAdd_memo() {
		init();
		start();
		ch= ClientHandler.getInstance();

	}
	public MyAdd_memo(int pm_num, String smTitle, String smData) {
		// TODO Auto-generated constructor stub
		this.pm_num=pm_num;
		this.smTitle=smTitle;
		this.smData=smData;
		
		updateVer=true;
		init();
		start();
		ch = ClientHandler.getInstance();
		
	}
	private void init(){
		//setLocation(ClientHandler.p);;
		setSize(500, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		// 1
		 title = new JPanel();
		title.setLayout(null);
		title.setBounds(0, 0, 500, 120);
		title.setBackground(new Color(204, 204, 204));

		return1 = new JButton(image1);
		return1.setBounds(10, 25, 70, 50);
		return1.setBorderPainted(false);
		return1.setBackground(new Color(204, 204, 204));
		return1.setBorder(BorderFactory.createEmptyBorder());
		title.add(return1);

		if(updateVer==false){
			titleLabel = new JLabel("메모추가");
		}else if(updateVer==true){
			titleLabel = new JLabel("메모수정");
		}
		
		
		titleLabel.setFont(new Font("", Font.BOLD, 30));
		titleLabel.setBounds(180, 30, 200, 50);
		title.add(titleLabel);
		if(updateVer==false){
			save = new JButton("저장");
		}else if(updateVer==true){
			save = new JButton("수정");
		}
		
		save.setBounds(420, 25, 70, 50);
		save.setFont(new Font("", Font.BOLD, 20));
		save.setBackground(new Color(204, 204, 204));
		save.setBorder(BorderFactory.createEmptyBorder());
		title.add(save);

		getContentPane().add(title);
		//

		// 2

		 panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0, 120, 494, 100);
		panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panel1.setBackground(Color.gray);

		직함 = new JLabel("주제");
		직함.setBounds(10, 10, 200, 30);
		직함.setFont(new Font("", Font.PLAIN, 25));
		panel1.add(직함);
		if(updateVer==false){
			주제 = new JTextField("이곳에 주제를 적어주세요.");
		}else if(updateVer==true){
			주제 = new JTextField(smTitle);
		}
				
		주제.setBounds(10, 50, 440, 30);
		주제.setFont(new Font("", Font.BOLD, 20));
		panel1.add(주제);
		
		getContentPane().add(panel1);
		
		memo=new JPanel();
		memo.setLayout(null);
		memo.setBounds(0, 121, 494, 500);
		memo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		memo.setBackground(Color.gray);
		memo_write =new JLabel("메모");
		memo_write.setBounds(10, 110, 200, 30);
		memo_write.setFont(new Font("", Font.PLAIN, 25));
		memo.add(memo_write);
		
		if(updateVer==false){
			memo_write2=new JTextField("이곳에 메모하세요.");
		}else if(updateVer==true){
			memo_write2=new JTextField(smData);
		}
		
		memo_write2.setBounds(10,150,470,330);
		memo_write2.setFont(new Font("돋움", Font.PLAIN, 20));
		memo_write2.setHorizontalAlignment(JTextField.LEADING);

		memo.add(memo_write2);

		getContentPane().add(memo);

		setVisible(true);
		setResizable(false);
	}
	private void start() {
		
		//마우스 리스너들 주제, memo_write2;
		주제.addMouseListener(this);
		memo_write2.addMouseListener(this);
		//버튼 리스너들
		save.addActionListener(this);
		return1.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();// 선택된 버튼을 알아낸다
		if (src == save) {
			
			
			//값들을 서버로 전송하기 insert 문이므로 회원가입과 형식이 비슷하다.
			if (!(주제.getText().equals("")) && !(memo_write2.getText().equals("")) ) {
				
				
				String en주제 = makeEnString(주제.getText());
				String enMemo_write2  = makeEnString(memo_write2.getText());
				
				if(updateVer==false){
					//서버로 보낼 msg 작성
					String msg = en주제 + ",,," + enMemo_write2 + ",,,"+ClientHandler.getMember().getUserNum();
					System.out.println("서버로 보낼 메세지 확인 : "+msg);

					ch.requestaddSmData(msg);
					System.out.println("내용들이 저장되었습니다.");
					new securityMemo(ClientHandler.getMember());
					dispose();
				}else if(updateVer==true){
					//서버로 보낼 msg 작성
					String msg = en주제 + ",,," + enMemo_write2 + ",,,"+pm_num;
					System.out.println("서버로 보낼 메세지 확인 : "+msg);

					ch.requestupdateSmData(msg);
					System.out.println("내용들이 저장되었습니다.");
					new securityMemo(ClientHandler.getMember());
					dispose();
				}
				
				
			} else {
				System.out.println("asdasdasd");

				JOptionPane.showMessageDialog(null, "필수항목 중에 빠진 부분이 있습니다. 확인해주세요!!", "확인",
						JOptionPane.INFORMATION_MESSAGE, null);

			}
		
		} else if (src == return1) {
			new securityMemo(ClientHandler.getMember());
			dispose();
		} 

		else {
			System.out.println("asdasdasd");

			JOptionPane.showMessageDialog(null, "필수항목 중에 빠진 부분이 있습니다. 확인해주세요!!", "확인", JOptionPane.INFORMATION_MESSAGE,
					null);

		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		if(updateVer==false){
			Object src = arg0.getSource();// 선택된 버튼을 알아낸다
			JTextField empty = (JTextField)src;
			empty.setText(null);
		}else if( updateVer==true){
			//걍 가만히 있어 
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	private String makeEnString(String text) {
		Encrypt en = null;
		
		
		try { // 카드명1 암호화
			en = new Encrypt(text);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("암호화(카드명1)된 값 : " + en.getEnco());
		//String en카드명1 = en.getEnco();
		return en.getEnco();
	}

}
