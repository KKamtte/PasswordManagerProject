package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;

import Security.NaverMailTest;
import Security.OTP;
import client.Member;
import client.Message;

/**
 * @author ebonny 클라이언트 하나를 담당하는 서버측의 "메세지 리스너" 클래스. 클라이언트의 ServerMsgListener
 *         클래스아 메시지를 주고 받는다. 모든 메시지는 4자리의 prefix가 붙고, 이 prefix 에 따라 어떤 상황에서 오는
 *         메시지인지 판별한다.
 * 
 *         ServerHandler 로 새로운 클라이언트가 접속할때마다 그 클라이언트를 담당할 Guest 를 새로 하나 생성한다. 각
 *         Guest 클래스는 각 클라이언트의 메시지를 받아서 ServerHandler 로 메시지의 처리를 넘긴다. (prefix 에
 *         따라 적절한 ServerHandler 의 메소드를 호출)
 */
public class Guest extends Thread {

	private ServerHandler server;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private Member member;
	private String roomName = "";
	private static String sendMg1;
	private static HashMap<Integer, String> hm = new HashMap<Integer, String>();

	public Guest(ServerHandler server, Socket socket) throws IOException {
		this.server = server;
		this.socket = socket;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	}

	@Override
	public void run() {
		String msg;
		String prefix;
		try {
			while ((msg = in.readLine()) != null) {
				
				prefix = msg.substring(0, 4);
				msg = msg.substring(4);
				System.out.println("클라이언트로부터 받은 메세지");
				System.out.println(prefix + " : " + msg);
				if (prefix.equals(Message.LOGIN_REQUEST_CHECKID)) {

					if (server.checkId(msg)) {
						sendMsg(Message.LOGIN_CHECKID_SUCCESS);
					} else {
						sendMsg(Message.LOGIN_CHECKID_FAIL);
					}
				} else if (prefix.equals(Message.requestPwData_add)) {
					// 비밀번호 관련 데이터 추가 요청이 들어었을 경우
					if (server.requestAddpwData(msg)) {
						System.out.println("입력잘됨");
						sendMsg(Message.requestPwData_add_success);
					} else {
						sendMsg(Message.requestPwData_add_fail);
					}
				} else if (prefix.equals(Message.requestPwData_add)) {
					// 비밀번호 관련 데이터 추가 요청이 들어었을 경우
					if (server.requestAddpwData(msg)) {
						System.out.println("입력잘됨");
						sendMsg(Message.requestPwData_add_success);
					} else {
						sendMsg(Message.requestPwData_add_fail);
					}
				} else if (prefix.equals(Message.requestPwData_delete)) {
					// 비밀번호 관련 데이터 삭제요청이 들어온 경우
					if (server.requestDeletePwData(msg)) {
						System.out.println("입력잘됨");
						sendMsg(Message.requestPwData_delete_success);
					} else {
						sendMsg(Message.requestPwData_delete_fail);
					}
				} else if (prefix.equals(Message.requestPwData_update)) {
					// 비밀번호 관련 데이터 수정요청이 들어온 경우
					if (server.requestUpdatePwData(msg)) {
						System.out.println("입력잘됨");
						sendMsg(Message.requestPwData_update_success);
					} else {
						sendMsg(Message.requestPwData_update_fail);
					}
				}

				else if (prefix.equals(Message.requestCardData_add)) {
					// 카드 관련 데이터 추가 요청이 들어었을 경우
					if (server.requestAddCardData(msg)) {
						System.out.println("입력잘됨");
						sendMsg(Message.requestCardData_add_success);
					} else {
						sendMsg(Message.requestCardData_add_fail);
					}
				}else if (prefix.equals(Message.requestCardData_update)) {
					// 비밀 메모 관련 데이터 수정요청이 들어온 경우
					if (server.requestUpdateCardData(msg)) {
						System.out.println("입력잘됨");
						sendMsg(Message.requestSmData_update_success);
					} else {
						sendMsg(Message.requestSmData_update_fail);
					}
				} 
				
				else if (prefix.equals(Message.requestCardData_delete)) {
					// 비밀번호 관련 데이터 삭제요청이 들어온 경우
					if (server.requestDeleteCardData(msg)) {
						System.out.println("입력잘됨");
						sendMsg(Message.requestCardData_delete_success);
					} else {
						sendMsg(Message.requestCardData_delete_fail);
					}
				} 
				else if (prefix.equals(Message.requestSmData_add)) {
					// 비밀 메모 관련 데이터 추가 요청이 들어왔을 경우
					System.out.println("==============");
					System.out.println("비밀메모 추가 메소드");

					if (server.requestAddSmData(msg)) {
						System.out.println("입력잘됨");
						sendMsg(Message.requestSmData_add_success);
					} else {
						sendMsg(Message.requestSmData_add_fail);
					}
				} else if (prefix.equals(Message.requestSmData_update)) {
					// 비밀 메모 관련 데이터 수정요청이 들어온 경우
					if (server.requestUpdateSmData(msg)) {
						System.out.println("입력잘됨");
						sendMsg(Message.requestSmData_update_success);
					} else {
						sendMsg(Message.requestSmData_update_fail);
					}
				} else if (prefix.equals(Message.requestSmData_delete)) {
					// 비밀메모 관련 데이터 삭제요청이 들어온 경우
					if (server.requestDeleteSMData(msg)) {
						System.out.println("입력잘됨");
						sendMsg(Message.requestSmData_delete_success);
					} else {
						sendMsg(Message.requestSmData_delete_fail);
					}
				} else if (prefix.equals(Message.LOGIN_REQUEST_CHECKNICK)) {
					if (server.checkNick(msg)) {
						sendMsg(Message.LOGIN_CHECKNICK_SUCCESS);
					} else {
						sendMsg(Message.LOGIN_CHECKNICK_FAIL);
					}
				} else if (prefix.equals(Message.LOGIN_REQUEST_JOIN)) {
					System.out.println("회원가입 요청 쿼리문 전달요청 ");
					System.out.println("msg : "+msg);
					
					if (server.requestJoin(msg)) {
						System.out.println("입력잘됨");
						sendMsg(Message.LOGIN_JOIN_SUCCESS);
					} else {
						sendMsg(Message.LOGIN_JOIN_FAIL);
					}
				} else if (prefix.equals(Message.LOGIN_REQUEST)) {
					String tmp[] = msg.split(",");

					Member member = server.getMember(tmp[0]);
					System.out.println("안녕하세요");
					if (member == null) {
						sendMsg(Message.LOGIN_FAIL_WRONG_ID);
					} else {
						if (!member.getPwd().equals(tmp[1])) {

							sendMsg(Message.LOGIN_FAIL_WRONG_PWD);
						} else {
							if (server.checkIdMap(tmp[0])) {
								sendMsg(Message.LOGIN_FAIL_LOGINED_ID);
							} else {
								System.out.println("1차로그인 성공");

								System.out.println("otp 번호를 생성하여 클라이언트의 메일주소에 보냅니다.");

								String otprs = new NaverMailTest(member.getemail()).getOpt().getMsg();
								// 해당 유저번호와 otp번호를 짝을 이뤄서 map에 넣는다.
								System.out.println("member.getUserNum() : " + member.getUserNum());
								System.out.println("otprs : " + otprs);
								hm.put((Integer) member.getUserNum(), otprs);
								sendMg1 = Message.LOGIN_SUCCESS + member.getUserNum() + "," + member.getId() + ","
										+ member.getPwd() + "," + member.getName() + "," + member.getemail();
								// String sendMg = Message.LOGIN_SUCCESS +
								// member.getUserNum() + "," + member.getId() +
								// ","
								// + member.getPwd() + "," + member.getName() +
								// "," + member.getemail();
								String sendMg = Message.GO_TO_OTP + member.getUserNum();
								System.out.println(sendMg);

								sendMsg(sendMg);
								System.out.println("전송성공");
								setMember(member);
								server.userLogin(this);
								server.broadcastWaitRoomUpdate();
							}
						}
					}
				} else if (prefix.equals(Message.GO_TO_OTP_CHECK)) {
					System.out.println("사용자가 보낸 값 : " + msg);
					String st[] = msg.split(",");

					System.out.println((String) hm.get(Integer.parseInt(st[1])));
					if (((String) hm.get(Integer.parseInt(st[1]))).equals(st[0])) {
						System.out.println("입력잘됨");
						// sendMsg(Message.GO_TO_OTP_CHECK_SUCCESS);
						System.out.println(sendMg1);
						sendMsg(sendMg1);
						System.out.println("전송성공");
						setMember(member);
						server.userLogin(this);
						server.broadcastWaitRoomUpdate();
						hm.remove(Integer.parseInt(st[1]));
					} else {
						System.out.println("틀림");
						
						sendMsg(Message.GO_TO_OTP_CHECK_FAIL);
					}
				}else if (prefix.equals(Message.GO_TO_OTP_AGAIN)) {
					System.out.println("사용자가 보낸 값 : " + msg);
					hm.remove(Integer.parseInt(msg));
					String otprs = new NaverMailTest(member.getemail()).getOpt().getMsg();
					hm.put( Integer.parseInt(msg), otprs);
					System.out.println("재설정 완료");
					
					sendMsg(Message.GO_TO_OTP_AGAIN_SUCCESS);
				}
				

				else if (prefix.equals(Message.requestPwData)) {
					// 데이터 받아오기
					System.out.println("====== 페스워드 데이터 요청 구간 시작======");
					String tmp[] = msg.split(",");
					System.out.println("tmp[0]" + tmp[0]);
					String newTmp = server.getPwData(tmp[0]);

					String sendMg = Message.requestPwData_sucess + newTmp;

					System.out.println(sendMg);

					sendMsg(sendMg);
					System.out.println("전송성공");
					setMember(member);
					server.userLogin(this);
					server.broadcastWaitRoomUpdate();
					System.out.println("====== 페스워드 데이터 요청 구간 종료======");
				} else if (prefix.equals(Message.requestSmData)) {
					// 데이터 받아오기
					System.out.println("====== 메모 데이터 요청 구간 시작======");
					String tmp[] = msg.split(",,,");
					System.out.println("tmp[0]" + tmp[0]);
					String newTmp = server.getSmData(tmp[0]);

					String sendMg = Message.requestSmData_sucess + newTmp;

					System.out.println(sendMg);

					sendMsg(sendMg);
					System.out.println("전송성공");
					setMember(member);
					server.userLogin(this);
					server.broadcastWaitRoomUpdate();
					System.out.println("====== 메모 데이터 요청 구간 종료======");
				} else if (prefix.equals(Message.requestBankData)) {
					// 데이터 받아오기
					System.out.println("====== 통장 데이터 요청 구간 시작======");
					String tmp[] = msg.split(",");
					System.out.println("tmp[0]" + tmp[0]);
					String newTmp = server.getBankData(tmp[0]);

					String sendMg = Message.requestBankData_sucess + newTmp;

					System.out.println(sendMg);

					sendMsg(sendMg);
					System.out.println("전송성공");
					setMember(member);
					server.userLogin(this);
					server.broadcastWaitRoomUpdate();
					System.out.println("====== 통장 데이터 요청 구간 종료======");
				} 
				else if (prefix.equals(Message.requestBankData_update)) {
					
						// 비밀번호 관련 데이터 수정요청이 들어온 경우
						if (server.requestUpdateBankData(msg)) {
							System.out.println("입력잘됨");
							sendMsg(Message.requestPwData_update_success);
						} else {
							sendMsg(Message.requestPwData_update_fail);
						}
					
					
				}
				else if (prefix.equals(Message.requestBankData_delete)) {
					
					// 비밀번호 관련 데이터 수정요청이 들어온 경우
					if (server.requestDeleteBankData(msg)) {
						System.out.println("입력잘됨");
						sendMsg(Message.requestBankData_delete_success);
					} else {
						sendMsg(Message.requestBankData_delete_fail);
					}
				
				
			}
				
				else if (prefix.equals(Message.requestBankData_add)) {
					// 비밀 메모 관련 데이터 추가 요청이 들어왔을 경우
					System.out.println("==============");
					System.out.println("통장메모 추가 메소드");

					if (server.requestAddBankData(msg)) {
						System.out.println("입력잘됨");
						sendMsg(Message.requestSmData_add_success);
					} else {
						sendMsg(Message.requestSmData_add_fail);
					}
				}
				
				
				
				else if (prefix.equals(Message.requestCardData)) {
					// 데이터 받아오기
					System.out.println("====== 통장 데이터 요청 구간 시작======");
					String tmp[] = msg.split(",");
					System.out.println("tmp[0]" + tmp[0]);
					String newTmp = server.getCardData(tmp[0]);

					String sendMg = Message.requestCardData_sucess + newTmp;

					System.out.println(sendMg);

					sendMsg(sendMg);
					System.out.println("전송성공");
					setMember(member);
					server.userLogin(this);
					server.broadcastWaitRoomUpdate();
					System.out.println("====== 통장 데이터 요청 구간 종료======");
				}

				else if (prefix.equals(Message.WAIT_USER_OUT)) {
					userLeave(false);
				} else if (prefix.equals(Message.WAIT_CHAT_MSG)) {
					server.broadcast_waitRoom(Message.WAIT_CHAT_MSG + msg);
				} else if (prefix.equals(Message.ROOM_REQUEST_MAKE)) {
					if (server.addRoom(msg)) {
						roomName = msg;
						sendMsg(Message.ROOM_MAKE_SUCCESS + roomName);
						server.addUserToRoom(this, roomName);
						server.removeUserFromWait(this);
						server.broadcastChatRoomUpdate(roomName);
						server.broadcastWaitRoomUpdate();
						sendMsg(Message.ROOM_SET_NAME + roomName);
					} else {
						sendMsg(Message.ROOM_MAKE_FAIL);
					}
				} else if (prefix.equals(Message.ROOM_USER_OUT)) {
					userLeave(false);
				} else if (prefix.equals(Message.ROOM_USER_IN)) {
					roomName = msg;
					server.addUserToRoom(this, msg);
					server.removeUserFromWait(this);
					server.broadcastChatRoomUpdate(msg);
					server.broadcastWaitRoomUpdate();
					server.broadcast_chatRoom(Message.ROOM_CHAT_MSG + "#" + member.getName() + "#님이 입장하셨습니다", roomName);
					sendMsg(Message.ROOM_SET_NAME + roomName);
				} else if (prefix.equals(Message.ROOM_CHAT_MSG)) {
					server.broadcast_chatRoom(Message.ROOM_CHAT_MSG + msg, roomName);
				} else if (prefix.equals(Message.ROOM_INVITE_USER)) {
					server.inviteUser(member.getId(), msg, roomName);
				} else if (prefix.equals(Message.ROOM_INVITE_DENY)) {
					String tmp[] = msg.split(",");
					server.inviteDeny(tmp[0], tmp[1], tmp[2]);
				} else if (prefix.equals(Message.ROOM_REQUEST_WAITUSER)) {
					server.returnWaitUsers(this);
				} else if (prefix.equals(Message.LOGOUT)) {
					userLeave(true);
				} else if (prefix.equals(Message.GET_ADDR)) {
					server.getAddr(this, msg, roomName);
				} else if (prefix.equals(Message.ROOM_CHAT_WHISPER)) {
					int index = msg.indexOf(",");
					String nick = msg.substring(0, index);
					msg = msg.substring(index + 1);
					server.sendWhisper(this, nick, msg, roomName);
				} else if (prefix.equals(Message.ROOM_KICKOFF)) {
					server.kickOff(msg, roomName);
				} else if (prefix.equals(Message.MOD_UPDATE_USERINFO)) {
					String[] tmp = msg.split(","); // msg =
													// id,pwd,name,nick,phone
					String beforeNick = member.getName();
					String afterNick = tmp[3];
					if (server.modUserInfo(tmp)) {
						sendMsg(Message.MOD_UPDATE_SUCCESS + msg);
						if (!beforeNick.equals(afterNick)) {
							member.setName(afterNick);
							if (roomName.equals("")) {
								server.broadcastWait_userUpdate();
							} else {
								server.broadcastChatRoomUpdate(roomName);
							}
						}
					} else {
						sendMsg(Message.MOD_UPDATE_FAIL);
					}
				}
			}
		} catch (IOException e) {
			// 연결이 끊길 경우 IOException 이 발생함
			userLeave(false);
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (SQLException e) {
			String errMsg = "디비 에러 : " + e.getMessage();
			System.out.println(errMsg);
			sendMsg(Message.ERR_DATABASE + errMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void sendMsg(String msg) {
		out.println(msg);
		out.flush();
	}

	private void userLeave(boolean isLogout) {
		if (member == null) // 로그인하기 전엔 member == null 이다
			return;
		if (roomName.equals("")) { // roomName 이 "" 이면 대기실에서 나가는 것임
			server.removeUserFromWait(this);
			server.removeUserFromIdMap(member.getId());
			server.broadcastWaitRoomUpdate();
		} else {
			if (isLogout) {
				server.removeUserFromIdMap(member.getId());
			} else {
				server.addUserToWait(this);
			}
			server.removeUserFromRoom(this, roomName);
			server.broadcastWaitRoomUpdate();
			server.broadcastChatRoomUpdate(roomName);
			server.broadcast_chatRoom(Message.ROOM_CHAT_MSG + "#" + member.getName() + "#님이 나가셨습니다", roomName);
			roomName = "";
		}
	}

	public Member getMember() {
		return member;
	}

	public Socket getSocket() {
		return socket;
	}
}
