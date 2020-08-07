package �⸻��������Ʈ;

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
	ImageIcon image1 = new ImageIcon("return����.png");
	ImageIcon image2 = new ImageIcon("������3.png");
	ImageIcon image3 = new ImageIcon("����2.png");
	ImageIcon image4 = new ImageIcon("eyes.png");
	JTextField ����, memo_write2;
	JPanel title, panel1,memo;
	JButton return1,save;
	JLabel titleLabel,����,memo_write;
	
	
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
			titleLabel = new JLabel("�޸��߰�");
		}else if(updateVer==true){
			titleLabel = new JLabel("�޸����");
		}
		
		
		titleLabel.setFont(new Font("", Font.BOLD, 30));
		titleLabel.setBounds(180, 30, 200, 50);
		title.add(titleLabel);
		if(updateVer==false){
			save = new JButton("����");
		}else if(updateVer==true){
			save = new JButton("����");
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

		���� = new JLabel("����");
		����.setBounds(10, 10, 200, 30);
		����.setFont(new Font("", Font.PLAIN, 25));
		panel1.add(����);
		if(updateVer==false){
			���� = new JTextField("�̰��� ������ �����ּ���.");
		}else if(updateVer==true){
			���� = new JTextField(smTitle);
		}
				
		����.setBounds(10, 50, 440, 30);
		����.setFont(new Font("", Font.BOLD, 20));
		panel1.add(����);
		
		getContentPane().add(panel1);
		
		memo=new JPanel();
		memo.setLayout(null);
		memo.setBounds(0, 121, 494, 500);
		memo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		memo.setBackground(Color.gray);
		memo_write =new JLabel("�޸�");
		memo_write.setBounds(10, 110, 200, 30);
		memo_write.setFont(new Font("", Font.PLAIN, 25));
		memo.add(memo_write);
		
		if(updateVer==false){
			memo_write2=new JTextField("�̰��� �޸��ϼ���.");
		}else if(updateVer==true){
			memo_write2=new JTextField(smData);
		}
		
		memo_write2.setBounds(10,150,470,330);
		memo_write2.setFont(new Font("����", Font.PLAIN, 20));
		memo_write2.setHorizontalAlignment(JTextField.LEADING);

		memo.add(memo_write2);

		getContentPane().add(memo);

		setVisible(true);
		setResizable(false);
	}
	private void start() {
		
		//���콺 �����ʵ� ����, memo_write2;
		����.addMouseListener(this);
		memo_write2.addMouseListener(this);
		//��ư �����ʵ�
		save.addActionListener(this);
		return1.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();// ���õ� ��ư�� �˾Ƴ���
		if (src == save) {
			
			
			//������ ������ �����ϱ� insert ���̹Ƿ� ȸ�����԰� ������ ����ϴ�.
			if (!(����.getText().equals("")) && !(memo_write2.getText().equals("")) ) {
				
				
				String en���� = makeEnString(����.getText());
				String enMemo_write2  = makeEnString(memo_write2.getText());
				
				if(updateVer==false){
					//������ ���� msg �ۼ�
					String msg = en���� + ",,," + enMemo_write2 + ",,,"+ClientHandler.getMember().getUserNum();
					System.out.println("������ ���� �޼��� Ȯ�� : "+msg);

					ch.requestaddSmData(msg);
					System.out.println("������� ����Ǿ����ϴ�.");
					new securityMemo(ClientHandler.getMember());
					dispose();
				}else if(updateVer==true){
					//������ ���� msg �ۼ�
					String msg = en���� + ",,," + enMemo_write2 + ",,,"+pm_num;
					System.out.println("������ ���� �޼��� Ȯ�� : "+msg);

					ch.requestupdateSmData(msg);
					System.out.println("������� ����Ǿ����ϴ�.");
					new securityMemo(ClientHandler.getMember());
					dispose();
				}
				
				
			} else {
				System.out.println("asdasdasd");

				JOptionPane.showMessageDialog(null, "�ʼ��׸� �߿� ���� �κ��� �ֽ��ϴ�. Ȯ�����ּ���!!", "Ȯ��",
						JOptionPane.INFORMATION_MESSAGE, null);

			}
		
		} else if (src == return1) {
			new securityMemo(ClientHandler.getMember());
			dispose();
		} 

		else {
			System.out.println("asdasdasd");

			JOptionPane.showMessageDialog(null, "�ʼ��׸� �߿� ���� �κ��� �ֽ��ϴ�. Ȯ�����ּ���!!", "Ȯ��", JOptionPane.INFORMATION_MESSAGE,
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
			Object src = arg0.getSource();// ���õ� ��ư�� �˾Ƴ���
			JTextField empty = (JTextField)src;
			empty.setText(null);
		}else if( updateVer==true){
			//�� ������ �־� 
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	private String makeEnString(String text) {
		Encrypt en = null;
		
		
		try { // ī���1 ��ȣȭ
			en = new Encrypt(text);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("��ȣȭ(ī���1)�� �� : " + en.getEnco());
		//String enī���1 = en.getEnco();
		return en.getEnco();
	}

}
