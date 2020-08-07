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
import 기말팀프로젝트.MyBankbook;
import 기말팀프로젝트.MyCard;
import 기말팀프로젝트.MyCradit_wallet;
import 기말팀프로젝트.MyFrame;
import 기말팀프로젝트.MyPassword;
import 기말팀프로젝트.MySignUp;
import 기말팀프로젝트.MyStart;
import 기말팀프로젝트.securityMemo;

/**
 * @author ebonny 클라이언트 측의 핵심 클래스. 서버 Guest 클래스로 메세지를 보내고, 서버의 Guest 클래스에서 메시지를 받는다. 이때 메시지 앞에는 반드시 prefix 가 붙는다.
 * 
 *         in.readLine 은 연결이 끊기기 전까지 서버에서 오는 메시지를 계속 받는다. 서버에서 오는 메시지의 종류(prefix) 에 따라 적절하게 prefix 다음의 String 을 처리한다. prefix 의 종류에 따라 다음의 String 이 있을 수도 있고 없을 수도 있다.
 * 
 *         prefix 의 종류에 따라 ClientHandler ch 변수를 통해서 클라이언트의 GUI 를 변화시킨다. (ClientHandler 는 이 클래스와 GUI 의 중간에서 로직처리를 담당한다)
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
				System.out.println("msg 출력  : "+msg);
				String prefix = msg.substring(0, 4);
				msg = msg.substring(4);
				System.out.println("msg 출력  : "+msg);
				if (prefix.equals(Message.LOGIN_CHECKID_SUCCESS)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "사용할 수 있습니다");
					MySignUp.setChecked(true);
					
				} else if (prefix.equals(Message.LOGIN_CHECKID_FAIL)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "이미 존재하는 아이디입니다");
					MySignUp.setChecked(false);
				}
				
				
				else if (prefix.equals(Message.LOGIN_CHECKNICK_SUCCESS)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "사용할 수 있습니다");
					//ch.getJoinDialog().setNickChecked(true);
				} else if (prefix.equals(Message.LOGIN_CHECKNICK_FAIL)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "이미 존재하는 닉네임입니다");
					//ch.getJoinDialog().setNickChecked(false);
				} else if (prefix.equals(Message.LOGIN_JOIN_SUCCESS)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "가입이 승인되었습니다");
					ch.myStart.dispose();
					
					ch.setHandler();
					
					
				} else if (prefix.equals(Message.LOGIN_JOIN_FAIL)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "가입 실패!!\n관리자에게 문의하세요", "에러", JOptionPane.ERROR_MESSAGE);
				} else if (prefix.equals(Message.LOGIN_FAIL_WRONG_ID)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "없는 아이디입니다");
					ch.getLoginPanel().focusIdField();
				} else if (prefix.equals(Message.LOGIN_FAIL_WRONG_PWD)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "암호가 틀렸습니다");
					ch.getLoginPanel().focusPwdField();
				} else if (prefix.equals(Message.LOGIN_FAIL_LOGINED_ID)) {
					JOptionPane.showMessageDialog(ch.getFrame(), "이미 로그인되어 있습니다");
					ch.getLoginPanel().focusIdField();
				} else if (prefix.equals(Message.LOGIN_SUCCESS)) {
					//OTP 인증 성공
					ch.setMember(new Member(msg.split(",")));
					JOptionPane.showMessageDialog(null, "OTP번호가 일치합니다.", "확인", JOptionPane.DEFAULT_OPTION);
					//창 닫고 새로 열기
					of.dispose();
					//System.out.println("사용자 고유 식별번호 : "+ClientHandler.getMember().getUserNum());
					new MyFrame(ClientHandler.getMember());
					
				}else if(prefix.equals(Message.GO_TO_OTP_CHECK_FAIL)){
					JOptionPane.showMessageDialog(null, "OTP번호가 일치하지않습니다.", "확인", JOptionPane.DEFAULT_OPTION);
				}
				else if(prefix.equals(Message.GO_TO_OTP_AGAIN_SUCCESS)){
					JOptionPane.showMessageDialog(null, "OTP를 재생성하였습니다.", "확인", JOptionPane.DEFAULT_OPTION);
				}
				else if (prefix.equals(Message.requestPwData_delete_success)) {
					//ClientHandler.p=mp.getLocation(); 	//수정부분우도
					mp.dispose();
					new MyFrame(ClientHandler.getMember());
					
					
				}else if (prefix.equals(Message.requestSmData_delete_success)) {
					//ClientHandler.p=sm.getLocation();	//수정부분우도
					sm.dispose();
					new MyFrame(ClientHandler.getMember());
					
					
				}else if (prefix.equals(Message.requestBankData_delete_success)) {
					//ClientHandler.p=sm.getLocation();	//수정부분우도
					mb.dispose();
					new MyCradit_wallet(ClientHandler.getMember());
					
					
				}
				else if (prefix.equals(Message.requestCardData_delete_success)) {
					
					mc.dispose();
					new MyCradit_wallet(ClientHandler.getMember());
					
				}
				
				else if (prefix.equals(Message.requestPwData_sucess)) {
					//데이터 배치
					PwDataDTO.pwDataList.clear();
					System.out.println("========비밀번호 출력=========");
					//우선 출력 먼저
					String[] tmp =msg.split(",");
					PwDataDTO pd= new PwDataDTO();
					for(int i= 0 ; i<tmp.length;i++){
						System.out.println("tmp["+i+"] : "+tmp[i]);
						
						if (tmp[i].equals("")){
							System.out.println("표시할 내용 없다.");
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
							System.out.println(i/5+"번째 dto 생성완료");
						}
					}
					System.out.println("========출력 종료=========");
					//ch.setPwData(new PwData(msg.split(",")));
				}else if (prefix.equals(Message.requestSmData_sucess)) {
					//데이터 배치
					SmDataDTO.smDataList.clear();
					System.out.println("========메모 출력=========");
					System.out.println("출력전 전체 메모 : "+msg);
					//우선 출력 먼저
					String[] tmp =msg.split(",,,");
					SmDataDTO sm= new SmDataDTO();
					System.out.println(tmp.length);
					for(int i= 0 ; i<tmp.length;i++){
						System.out.println("tmp["+i+"] : "+tmp[i]);
						if (tmp[i].equals("")){
							System.out.println("표시할 내용 없다.");
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
							System.out.println(i/3+"번째 dto 생성완료");
						}
					}
					System.out.println("========출력 종료=========");
					//ch.setPwData(new PwData(msg.split(",")));
				}
				else if (prefix.equals(Message.requestCardData_sucess)) {
					//데이터 배치
					CardDataDTO.cardDataList.clear();
					System.out.println("========카드 데이터 출력=========");
					System.out.println("출력전 전체 메모 : "+msg);
					//우선 출력 먼저
					String[] tmp =msg.split(",");
					CardDataDTO cd= new CardDataDTO();
					System.out.println(tmp.length);
					for(int i= 0 ; i<tmp.length;i++){
						System.out.println("tmp["+i+"] : "+tmp[i]);
						if (tmp[i].equals("")){
							System.out.println("표시할 내용 없다.");
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
							System.out.println(i/3+"번째 dto 생성완료");
						}
					}
					System.out.println("========카드 데이터 출력 종료=========");
					//ch.setPwData(new PwData(msg.split(",")));
				}else if (prefix.equals(Message.GO_TO_OTP)) {
					//otp 실행
					System.out.println("otp 인증 단계 : "+msg);
					//창 닫고 새로 열기
					ch.myStart.dispose();
					new OTP_Frame(msg);
				}
				else if (prefix.equals(Message.requestBankData_sucess)) {
					//데이터 배치
					BankDataDTO.bankDataList.clear();
					System.out.println("========통장 출력=========");
					System.out.println("출력전 전체 메모 : "+msg);
					//우선 출력 먼저
					String[] tmp =msg.split(",");
					BankDataDTO bk= new BankDataDTO();
					System.out.println(tmp.length);
					for(int i= 0 ; i<tmp.length;i++){
						System.out.println("tmp["+i+"] : "+tmp[i]);
						if (tmp[i].equals("")){
							System.out.println("표시할 내용 없다.");
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
							System.out.println(i/10+"번째 dto 생성완료");
						}
						
						
					}
					System.out.println("========출력 종료=========");
					//ch.setPwData(new PwData(msg.split(",")));
				}
//				else if (prefix.equals(Message.WAIT_USER_UPDATE)) {
//					//아무것도 하지 않는다.
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
//					JOptionPane.showMessageDialog(ch.getFrame(), "같은 이름이 존재합니다");
//				} else if (prefix.equals(Message.ROOM_CHAT_MSG)) {
//					ch.getChatRoom().appendMsg(msg);
//				} else if (prefix.equals(Message.ROOM_SET_NAME)) {
//					ch.getChatRoom().setChatBorder("[" + msg + "]");
//				} else if (prefix.equals(Message.ROOM_INVITE_REQUEST)) {
//					String tmp[] = msg.split(",");
//					String roomName = tmp[1];
//					String inviteMsg = "[" + roomName + "] 방에서 초대하였습니다\n입장하시겠습니까?";
//					if (JOptionPane.showConfirmDialog(ch.getFrame(), inviteMsg, "알림", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
//						ch.enterRoom(roomName);
//					} else {
//						ch.inviteDeny(msg + "," + ch.getMember().getName()); // msg 내용 : id,roomName
//					}
//				} else if (prefix.equals(Message.ROOM_INVITE_DENIED)) {
//					JOptionPane.showMessageDialog(ch.getFrame(), msg + "님이 초대를 거절하였습니다");
//				} else if (prefix.equals(Message.ROOM_RETURN_WAITUSER)) {
//					ch.getInviteDialog().setListData(msg);
//				} else if (prefix.equals(Message.GET_ADDR)) {
//					GetFile gf = new GetFile(ch.getFrame(), msg);
//					gf.setVisible(true);
//				} else if (prefix.equals(Message.ROOM_WHISPER_FAIL)) {
//					JOptionPane.showMessageDialog(ch.getFrame(), "[" + msg + "] : 존재하지 않는 사용자입니다");
//				} else if (prefix.equals(Message.ROOM_KICKOFF)) {
//					ch.exitChatRoom();
//					JOptionPane.showMessageDialog(ch.getFrame(), "강퇴 당하셨습니다");
//				} else if (prefix.equals(Message.MOD_UPDATE_SUCCESS)) {
//					JOptionPane.showMessageDialog(ch.getJoinDialog(), "수정 완료");
//					ch.getJoinDialog().dispose();
//					String tmp[] = msg.split(",");
//					ch.getMember().setAll(tmp);
//					ch.getWaitRoom().setChatBorder("채팅(" + tmp[3] + ")");
//				} 
//					else if (prefix.equals(Message.MOD_UPDATE_FAIL)) {
//					JOptionPane.showMessageDialog(ch.getJoinDialog(), "수정 중 오류가 발생하였습니다");
//				} else if (prefix.equals(Message.ERR_DATABASE)) {
//					JOptionPane.showMessageDialog(ch.getFrame(), msg, "에러", JOptionPane.ERROR_MESSAGE);
//				}
			}
		} catch (Exception e) {
			try {
				System.out.println("휴지를 앙 문 정지원");
				in.close();
				out.close();
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void sendMsg(String msg) {
		System.out.println("보내기전 최종 메세지 : "+msg);
		System.out.println(out);
		out.println(msg);
		out.flush();
	}

}
