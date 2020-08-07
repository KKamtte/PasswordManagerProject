package client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import DTO.BankDataDTO;
import DTO.CardDataDTO;
import DTO.PwDataDTO;
import DTO.SmDataDTO;
import Security.OTP_Frame;
import �⸻��������Ʈ.MyBankbook;
import �⸻��������Ʈ.MyCard;
import �⸻��������Ʈ.MyCradit_wallet;
import �⸻��������Ʈ.MyFrame;
import �⸻��������Ʈ.MyPassword;
import �⸻��������Ʈ.MySignUp;
import �⸻��������Ʈ.MyStart;
import �⸻��������Ʈ.securityMemo;

/**
 * @author ebonny Ŭ���̾�Ʈ ���� �ٽ� Ŭ����. ���� Guest Ŭ������ �޼����� ������, ������ Guest Ŭ�������� �޽����� �޴´�. �̶� �޽��� �տ��� �ݵ�� prefix �� �ٴ´�.
 * 
 *         in.readLine �� ������ ����� ������ �������� ���� �޽����� ��� �޴´�. �������� ���� �޽����� ����(prefix) �� ���� �����ϰ� prefix ������ String �� ó���Ѵ�. prefix �� ������ ���� ������ String �� ���� ���� �ְ� ���� ���� �ִ�.
 * 
 *         prefix �� ������ ���� ClientHandler ch ������ ���ؼ� Ŭ���̾�Ʈ�� GUI �� ��ȭ��Ų��. (ClientHandler �� �� Ŭ������ GUI �� �߰����� ����ó���� ����Ѵ�)
 */
public class ServerMsgListener extends Thread {
	private ClientHandler ch;
	private BufferedReader in;
	private PrintWriter out;
	private Socket socket;

	
	private static MyPassword mp=null;
	private static securityMemo sm=null;   
	private static OTP_Frame of=null;
	private static MyCard mc = null;
	private static MyBankbook mb = null;
	
	
	 public static MyBankbook getMb() {
		return mb;
	}

	public static void setMb(MyBankbook mb) {
		ServerMsgListener.mb = mb;
	}

	public static MyCard getMc() {
		return mc;
	}

	public static void setMc(MyCard mc) {
		ServerMsgListener.mc = mc;
	}

	public static OTP_Frame getOf() {
		return of;
	}

	public static void setOf(OTP_Frame of) {
		ServerMsgListener.of = of;
	}

	public static securityMemo getSm() {
		return sm;
	}

	public static void setSm(securityMemo sm) {
		ServerMsgListener.sm = sm;
	}

	public static MyPassword getMp() {
		return mp;
	}

	public static void setMp(MyPassword mp) {
		ServerMsgListener.mp = mp;
	}
	
	ServerMsgListener(ClientHandler ch, Socket socket) throws IOException {
		this.ch = ch;
		this.socket = socket;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	}

	@Override
	public void run() {
		
		String msg;
		
		try {
			while ((msg = in.readLine()) != null) {
				System.out.println("msg ���  : "+msg);
				String prefix = msg.substring(0, 4);
				msg = msg.substring(4);
				System.out.println("msg ���  : "+msg);
				if (prefix.equals(Message.LOGIN_CHECKID_SUCCESS)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "����� �� �ֽ��ϴ�");
					MySignUp.setChecked(true);
					
				} else if (prefix.equals(Message.LOGIN_CHECKID_FAIL)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "�̹� �����ϴ� ���̵��Դϴ�");
					MySignUp.setChecked(false);
				}
				
				
				else if (prefix.equals(Message.LOGIN_CHECKNICK_SUCCESS)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "����� �� �ֽ��ϴ�");
					//ch.getJoinDialog().setNickChecked(true);
				} else if (prefix.equals(Message.LOGIN_CHECKNICK_FAIL)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "�̹� �����ϴ� �г����Դϴ�");
					//ch.getJoinDialog().setNickChecked(false);
				} else if (prefix.equals(Message.LOGIN_JOIN_SUCCESS)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "������ ���εǾ����ϴ�");
					ch.myStart.dispose();
					
					ch.setHandler();
					
					
				} else if (prefix.equals(Message.LOGIN_JOIN_FAIL)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "���� ����!!\n�����ڿ��� �����ϼ���", "����", JOptionPane.ERROR_MESSAGE);
				} else if (prefix.equals(Message.LOGIN_FAIL_WRONG_ID)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "���� ���̵��Դϴ�");
					ch.getLoginPanel().focusIdField();
				} else if (prefix.equals(Message.LOGIN_FAIL_WRONG_PWD)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "��ȣ�� Ʋ�Ƚ��ϴ�");
					ch.getLoginPanel().focusPwdField();
				} else if (prefix.equals(Message.LOGIN_FAIL_LOGINED_ID)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "�̹� �α��εǾ� �ֽ��ϴ�");
					ch.getLoginPanel().focusIdField();
				} else if (prefix.equals(Message.LOGIN_SUCCESS)) {
					//OTP ���� ����
					ch.setMember(new Member(msg.split(",")));
					JOptionPane.showMessageDialog(null, "OTP��ȣ�� ��ġ�մϴ�.", "Ȯ��", JOptionPane.DEFAULT_OPTION);
					//â �ݰ� ���� ����
					of.dispose();
					//System.out.println("����� ���� �ĺ���ȣ : "+ClientHandler.getMember().getUserNum());
					new MyFrame(ClientHandler.getMember());
					
				}else if(prefix.equals(Message.GO_TO_OTP_CHECK_FAIL)){
					JOptionPane.showMessageDialog(null, "OTP��ȣ�� ��ġ�����ʽ��ϴ�.", "Ȯ��", JOptionPane.DEFAULT_OPTION);
				}
				else if(prefix.equals(Message.GO_TO_OTP_AGAIN_SUCCESS)){
					JOptionPane.showMessageDialog(null, "OTP�� ������Ͽ����ϴ�.", "Ȯ��", JOptionPane.DEFAULT_OPTION);
				}
				else if (prefix.equals(Message.requestPwData_delete_success)) {
					//ClientHandler.p=mp.getLocation(); 	//�����κп쵵
					mp.dispose();
					new MyFrame(ClientHandler.getMember());
					
					
				}else if (prefix.equals(Message.requestSmData_delete_success)) {
					//ClientHandler.p=sm.getLocation();	//�����κп쵵
					sm.dispose();
					new MyFrame(ClientHandler.getMember());
					
					
				}else if (prefix.equals(Message.requestBankData_delete_success)) {
					//ClientHandler.p=sm.getLocation();	//�����κп쵵
					mb.dispose();
					new MyCradit_wallet(ClientHandler.getMember());
					
					
				}
				else if (prefix.equals(Message.requestCardData_delete_success)) {
					
					mc.dispose();
					new MyCradit_wallet(ClientHandler.getMember());
					
				}
				
				else if (prefix.equals(Message.requestPwData_sucess)) {
					//������ ��ġ
					PwDataDTO.pwDataList.clear();
					System.out.println("========��й�ȣ ���=========");
					//�켱 ��� ����
					String[] tmp =msg.split(",");
					PwDataDTO pd= new PwDataDTO();
					for(int i= 0 ; i<tmp.length;i++){
						System.out.println("tmp["+i+"] : "+tmp[i]);
						
						if (tmp[i].equals("")){
							System.out.println("ǥ���� ���� ����.");
							break;
						}
						
						if( i%5==0){
							pd.setPm_num(Integer.parseInt(tmp[i]));
						}
						else if(i%5==1){
							pd.setSiteName(tmp[i]);
						}else if(i%5==2){
							pd.setUrl(tmp[i]);
						}else if(i%5==3){
							pd.setId(tmp[i]);
						}else if(i%5==4){
							pd.setPw(tmp[i]);
							PwDataDTO.pwDataList.add(new PwDataDTO(pd.getPm_num(),pd.getSiteName(),
									pd.getUrl(), pd.getId(), pd.getPw()));
							System.out.println(i/5+"��° dto �����Ϸ�");
						}
					}
					System.out.println("========��� ����=========");
					//ch.setPwData(new PwData(msg.split(",")));
				}else if (prefix.equals(Message.requestSmData_sucess)) {
					//������ ��ġ
					SmDataDTO.smDataList.clear();
					System.out.println("========�޸� ���=========");
					System.out.println("����� ��ü �޸� : "+msg);
					//�켱 ��� ����
					String[] tmp =msg.split(",,,");
					SmDataDTO sm= new SmDataDTO();
					System.out.println(tmp.length);
					for(int i= 0 ; i<tmp.length;i++){
						System.out.println("tmp["+i+"] : "+tmp[i]);
						if (tmp[i].equals("")){
							System.out.println("ǥ���� ���� ����.");
							break;
						}
							
						if( i%3==0){
							sm.setPm_num(Integer.parseInt(tmp[i]));
						}
						else if(i%3==1){
							sm.setSmTitle(tmp[i]);
						}else if(i%3==2){
							sm.setSmData(tmp[i]);
							SmDataDTO.smDataList.add(new SmDataDTO(sm.getPm_num(),sm.getSmTitle(),
									sm.getSmData()));
							System.out.println(i/3+"��° dto �����Ϸ�");
						}
					}
					System.out.println("========��� ����=========");
					//ch.setPwData(new PwData(msg.split(",")));
				}
				else if (prefix.equals(Message.requestCardData_sucess)) {
					//������ ��ġ
					CardDataDTO.cardDataList.clear();
					System.out.println("========ī�� ������ ���=========");
					System.out.println("����� ��ü �޸� : "+msg);
					//�켱 ��� ����
					String[] tmp =msg.split(",");
					CardDataDTO cd= new CardDataDTO();
					System.out.println(tmp.length);
					for(int i= 0 ; i<tmp.length;i++){
						System.out.println("tmp["+i+"] : "+tmp[i]);
						if (tmp[i].equals("")){
							System.out.println("ǥ���� ���� ����.");
							break;
						}
							
						if( i%12==0){
							cd.setPm_num(Integer.parseInt(tmp[i]));
						}
						else if(i%12==1){
							cd.setC_name(tmp[i]);
						}else if(i%12==2){
							cd.setC_type(tmp[i]);
						}else if(i%12==3){
							cd.setC_num1(tmp[i]);
						}else if(i%12==4){
							cd.setC_num2(tmp[i]);
						}else if(i%12==5){
							cd.setC_num3(tmp[i]);
						}else if(i%12==6){
							cd.setC_num4(tmp[i]);
						}else if(i%12==7){
							cd.setC_end_month(tmp[i]);
						}else if(i%12==8){
							cd.setC_end_year(tmp[i]);
						}else if(i%12==9){
							cd.setC_start_month(tmp[i]);
						}else if(i%12==10){
							cd.setC_start_year(tmp[i]);
						}else if(i%12==11){
							cd.setC_password(tmp[i]);
							CardDataDTO.cardDataList.add(new CardDataDTO
									(cd.getPm_num(), cd.getC_name(), cd.getC_type(), 
											cd.getC_num1(), cd.getC_num2(), cd.getC_num3(),
											cd.getC_num4(), cd.getC_end_month(), cd.getC_end_year(), 
											cd.getC_start_month(), cd.getC_start_year(), cd.getC_password()));
							System.out.println(i/3+"��° dto �����Ϸ�");
						}
					}
					System.out.println("========ī�� ������ ��� ����=========");
					//ch.setPwData(new PwData(msg.split(",")));
				}else if (prefix.equals(Message.GO_TO_OTP)) {
					//otp ����
					System.out.println("otp ���� �ܰ� : "+msg);
					//â �ݰ� ���� ����
					ch.myStart.dispose();
					new OTP_Frame(msg);
				}
				else if (prefix.equals(Message.requestBankData_sucess)) {
					//������ ��ġ
					BankDataDTO.bankDataList.clear();
					System.out.println("========���� ���=========");
					System.out.println("����� ��ü �޸� : "+msg);
					//�켱 ��� ����
					String[] tmp =msg.split(",");
					BankDataDTO bk= new BankDataDTO();
					System.out.println(tmp.length);
					for(int i= 0 ; i<tmp.length;i++){
						System.out.println("tmp["+i+"] : "+tmp[i]);
						if (tmp[i].equals("")){
							System.out.println("ǥ���� ���� ����.");
							break;
						}
							
						if( i%10==0){
							bk.setPm_num(Integer.parseInt(tmp[i]));
						}
						else if(i%10==1){
							bk.setB_name(tmp[i]);
						}else if(i%10==2){
							bk.setB_type(tmp[i]);
						}
						else if(i%10==3){
							bk.setB_num1(tmp[i]);
						}
						else if(i%10==4){
							bk.setB_num2(tmp[i]);
						}
						else if(i%10==5){
							bk.setB_num3(tmp[i]);
						}
						else if(i%10==6){
							bk.setB_num4(tmp[i]);
						}
						else if(i%10==7){
							bk.setB_date(tmp[i]);
						}
						else if(i%10==8){
							bk.setB_department(tmp[i]);
						}
						else if(i%10==9){
							bk.setB_password(tmp[i]);
							BankDataDTO.bankDataList.add(
									new BankDataDTO(bk.getPm_num(), bk.getB_name(), bk.getB_type(),
											bk.getB_num1(), bk.getB_num2(), bk.getB_num3(), bk.getB_num4(),
											bk.getB_date(), bk.getB_department(), bk.getB_password()));
							System.out.println(i/10+"��° dto �����Ϸ�");
						}
						
						
					}
					System.out.println("========��� ����=========");
					//ch.setPwData(new PwData(msg.split(",")));
				}
//				else if (prefix.equals(Message.WAIT_USER_UPDATE)) {
//					//�ƹ��͵� ���� �ʴ´�.
//				} 
//				else if (prefix.equals(Message.WAIT_ROOM_UPDATE)) {
//					ch.getWaitRoom().setRoomList(msg);
//				} else if (prefix.equals(Message.CHAT_USER_UPDATE)) {
//					String tmp[] = msg.split(",");
//					ch.getChatRoom().setUserList(tmp);
//					if (tmp[0].equals(ch.getMember().getName())) {
//						ch.getChatRoom().setKing();
//					}
//				} else if (prefix.equals(Message.WAIT_CHAT_MSG)) {
//					ch.getWaitRoom().appendMsg(msg);
//				} else if (prefix.equals(Message.ROOM_MAKE_SUCCESS)) {
//					ch.openChatRoom(msg);
//				} else if (prefix.equals(Message.ROOM_MAKE_FAIL)) {
//					JOptionPane.showMessageDialog(ch.getFrame(), "���� �̸��� �����մϴ�");
//				} else if (prefix.equals(Message.ROOM_CHAT_MSG)) {
//					ch.getChatRoom().appendMsg(msg);
//				} else if (prefix.equals(Message.ROOM_SET_NAME)) {
//					ch.getChatRoom().setChatBorder("[" + msg + "]");
//				} else if (prefix.equals(Message.ROOM_INVITE_REQUEST)) {
//					String tmp[] = msg.split(",");
//					String roomName = tmp[1];
//					String inviteMsg = "[" + roomName + "] �濡�� �ʴ��Ͽ����ϴ�\n�����Ͻðڽ��ϱ�?";
//					if (JOptionPane.showConfirmDialog(ch.getFrame(), inviteMsg, "�˸�", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
//						ch.enterRoom(roomName);
//					} else {
//						ch.inviteDeny(msg + "," + ch.getMember().getName()); // msg ���� : id,roomName
//					}
//				} else if (prefix.equals(Message.ROOM_INVITE_DENIED)) {
//					JOptionPane.showMessageDialog(ch.getFrame(), msg + "���� �ʴ븦 �����Ͽ����ϴ�");
//				} else if (prefix.equals(Message.ROOM_RETURN_WAITUSER)) {
//					ch.getInviteDialog().setListData(msg);
//				} else if (prefix.equals(Message.GET_ADDR)) {
//					GetFile gf = new GetFile(ch.getFrame(), msg);
//					gf.setVisible(true);
//				} else if (prefix.equals(Message.ROOM_WHISPER_FAIL)) {
//					JOptionPane.showMessageDialog(ch.getFrame(), "[" + msg + "] : �������� �ʴ� ������Դϴ�");
//				} else if (prefix.equals(Message.ROOM_KICKOFF)) {
//					ch.exitChatRoom();
//					JOptionPane.showMessageDialog(ch.getFrame(), "���� ���ϼ̽��ϴ�");
//				} else if (prefix.equals(Message.MOD_UPDATE_SUCCESS)) {
//					JOptionPane.showMessageDialog(ch.getJoinDialog(), "���� �Ϸ�");
//					ch.getJoinDialog().dispose();
//					String tmp[] = msg.split(",");
//					ch.getMember().setAll(tmp);
//					ch.getWaitRoom().setChatBorder("ä��(" + tmp[3] + ")");
//				} 
//					else if (prefix.equals(Message.MOD_UPDATE_FAIL)) {
//					JOptionPane.showMessageDialog(ch.getJoinDialog(), "���� �� ������ �߻��Ͽ����ϴ�");
//				} else if (prefix.equals(Message.ERR_DATABASE)) {
//					JOptionPane.showMessageDialog(ch.getFrame(), msg, "����", JOptionPane.ERROR_MESSAGE);
//				}
			}
		} catch (Exception e) {
			try {
				System.out.println("������ �� �� ������");
				in.close();
				out.close();
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void sendMsg(String msg) {
		System.out.println("�������� ���� �޼��� : "+msg);
		System.out.println(out);
		out.println(msg);
		out.flush();
	}

}
