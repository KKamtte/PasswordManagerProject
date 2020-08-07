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
 * @author ebonny Ŭ���̾�Ʈ �ϳ��� ����ϴ� �������� "�޼��� ������" Ŭ����. Ŭ���̾�Ʈ�� ServerMsgListener
 *         Ŭ������ �޽����� �ְ� �޴´�. ��� �޽����� 4�ڸ��� prefix�� �ٰ�, �� prefix �� ���� � ��Ȳ���� ����
 *         �޽������� �Ǻ��Ѵ�.
 * 
 *         ServerHandler �� ���ο� Ŭ���̾�Ʈ�� �����Ҷ����� �� Ŭ���̾�Ʈ�� ����� Guest �� ���� �ϳ� �����Ѵ�. ��
 *         Guest Ŭ������ �� Ŭ���̾�Ʈ�� �޽����� �޾Ƽ� ServerHandler �� �޽����� ó���� �ѱ��. (prefix ��
 *         ���� ������ ServerHandler �� �޼ҵ带 ȣ��)
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
				System.out.println("Ŭ���̾�Ʈ�κ��� ���� �޼���");
				System.out.println(prefix + " : " + msg);
				if (prefix.equals(Message.LOGIN_REQUEST_CHECKID)) {

					if (server.checkId(msg)) {
						sendMsg(Message.LOGIN_CHECKID_SUCCESS);
					} else {
						sendMsg(Message.LOGIN_CHECKID_FAIL);
					}
				} else if (prefix.equals(Message.requestPwData_add)) {
					// ��й�ȣ ���� ������ �߰� ��û�� ������ ���
					if (server.requestAddpwData(msg)) {
						System.out.println("�Է��ߵ�");
						sendMsg(Message.requestPwData_add_success);
					} else {
						sendMsg(Message.requestPwData_add_fail);
					}
				} else if (prefix.equals(Message.requestPwData_add)) {
					// ��й�ȣ ���� ������ �߰� ��û�� ������ ���
					if (server.requestAddpwData(msg)) {
						System.out.println("�Է��ߵ�");
						sendMsg(Message.requestPwData_add_success);
					} else {
						sendMsg(Message.requestPwData_add_fail);
					}
				} else if (prefix.equals(Message.requestPwData_delete)) {
					// ��й�ȣ ���� ������ ������û�� ���� ���
					if (server.requestDeletePwData(msg)) {
						System.out.println("�Է��ߵ�");
						sendMsg(Message.requestPwData_delete_success);
					} else {
						sendMsg(Message.requestPwData_delete_fail);
					}
				} else if (prefix.equals(Message.requestPwData_update)) {
					// ��й�ȣ ���� ������ ������û�� ���� ���
					if (server.requestUpdatePwData(msg)) {
						System.out.println("�Է��ߵ�");
						sendMsg(Message.requestPwData_update_success);
					} else {
						sendMsg(Message.requestPwData_update_fail);
					}
				}

				else if (prefix.equals(Message.requestCardData_add)) {
					// ī�� ���� ������ �߰� ��û�� ������ ���
					if (server.requestAddCardData(msg)) {
						System.out.println("�Է��ߵ�");
						sendMsg(Message.requestCardData_add_success);
					} else {
						sendMsg(Message.requestCardData_add_fail);
					}
				}else if (prefix.equals(Message.requestCardData_update)) {
					// ��� �޸� ���� ������ ������û�� ���� ���
					if (server.requestUpdateCardData(msg)) {
						System.out.println("�Է��ߵ�");
						sendMsg(Message.requestSmData_update_success);
					} else {
						sendMsg(Message.requestSmData_update_fail);
					}
				} 
				
				else if (prefix.equals(Message.requestCardData_delete)) {
					// ��й�ȣ ���� ������ ������û�� ���� ���
					if (server.requestDeleteCardData(msg)) {
						System.out.println("�Է��ߵ�");
						sendMsg(Message.requestCardData_delete_success);
					} else {
						sendMsg(Message.requestCardData_delete_fail);
					}
				} 
				else if (prefix.equals(Message.requestSmData_add)) {
					// ��� �޸� ���� ������ �߰� ��û�� ������ ���
					System.out.println("==============");
					System.out.println("��и޸� �߰� �޼ҵ�");

					if (server.requestAddSmData(msg)) {
						System.out.println("�Է��ߵ�");
						sendMsg(Message.requestSmData_add_success);
					} else {
						sendMsg(Message.requestSmData_add_fail);
					}
				} else if (prefix.equals(Message.requestSmData_update)) {
					// ��� �޸� ���� ������ ������û�� ���� ���
					if (server.requestUpdateSmData(msg)) {
						System.out.println("�Է��ߵ�");
						sendMsg(Message.requestSmData_update_success);
					} else {
						sendMsg(Message.requestSmData_update_fail);
					}
				} else if (prefix.equals(Message.requestSmData_delete)) {
					// ��и޸� ���� ������ ������û�� ���� ���
					if (server.requestDeleteSMData(msg)) {
						System.out.println("�Է��ߵ�");
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
					System.out.println("ȸ������ ��û ������ ���޿�û ");
					System.out.println("msg : "+msg);
					
					if (server.requestJoin(msg)) {
						System.out.println("�Է��ߵ�");
						sendMsg(Message.LOGIN_JOIN_SUCCESS);
					} else {
						sendMsg(Message.LOGIN_JOIN_FAIL);
					}
				} else if (prefix.equals(Message.LOGIN_REQUEST)) {
					String tmp[] = msg.split(",");

					Member member = server.getMember(tmp[0]);
					System.out.println("�ȳ��ϼ���");
					if (member == null) {
						sendMsg(Message.LOGIN_FAIL_WRONG_ID);
					} else {
						if (!member.getPwd().equals(tmp[1])) {

							sendMsg(Message.LOGIN_FAIL_WRONG_PWD);
						} else {
							if (server.checkIdMap(tmp[0])) {
								sendMsg(Message.LOGIN_FAIL_LOGINED_ID);
							} else {
								System.out.println("1���α��� ����");

								System.out.println("otp ��ȣ�� �����Ͽ� Ŭ���̾�Ʈ�� �����ּҿ� �����ϴ�.");

								String otprs = new NaverMailTest(member.getemail()).getOpt().getMsg();
								// �ش� ������ȣ�� otp��ȣ�� ¦�� �̷Ｍ map�� �ִ´�.
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
								System.out.println("���ۼ���");
								setMember(member);
								server.userLogin(this);
								server.broadcastWaitRoomUpdate();
							}
						}
					}
				} else if (prefix.equals(Message.GO_TO_OTP_CHECK)) {
					System.out.println("����ڰ� ���� �� : " + msg);
					String st[] = msg.split(",");

					System.out.println((String) hm.get(Integer.parseInt(st[1])));
					if (((String) hm.get(Integer.parseInt(st[1]))).equals(st[0])) {
						System.out.println("�Է��ߵ�");
						// sendMsg(Message.GO_TO_OTP_CHECK_SUCCESS);
						System.out.println(sendMg1);
						sendMsg(sendMg1);
						System.out.println("���ۼ���");
						setMember(member);
						server.userLogin(this);
						server.broadcastWaitRoomUpdate();
						hm.remove(Integer.parseInt(st[1]));
					} else {
						System.out.println("Ʋ��");
						
						sendMsg(Message.GO_TO_OTP_CHECK_FAIL);
					}
				}else if (prefix.equals(Message.GO_TO_OTP_AGAIN)) {
					System.out.println("����ڰ� ���� �� : " + msg);
					hm.remove(Integer.parseInt(msg));
					String otprs = new NaverMailTest(member.getemail()).getOpt().getMsg();
					hm.put( Integer.parseInt(msg), otprs);
					System.out.println("�缳�� �Ϸ�");
					
					sendMsg(Message.GO_TO_OTP_AGAIN_SUCCESS);
				}
				

				else if (prefix.equals(Message.requestPwData)) {
					// ������ �޾ƿ���
					System.out.println("====== �佺���� ������ ��û ���� ����======");
					String tmp[] = msg.split(",");
					System.out.println("tmp[0]" + tmp[0]);
					String newTmp = server.getPwData(tmp[0]);

					String sendMg = Message.requestPwData_sucess + newTmp;

					System.out.println(sendMg);

					sendMsg(sendMg);
					System.out.println("���ۼ���");
					setMember(member);
					server.userLogin(this);
					server.broadcastWaitRoomUpdate();
					System.out.println("====== �佺���� ������ ��û ���� ����======");
				} else if (prefix.equals(Message.requestSmData)) {
					// ������ �޾ƿ���
					System.out.println("====== �޸� ������ ��û ���� ����======");
					String tmp[] = msg.split(",,,");
					System.out.println("tmp[0]" + tmp[0]);
					String newTmp = server.getSmData(tmp[0]);

					String sendMg = Message.requestSmData_sucess + newTmp;

					System.out.println(sendMg);

					sendMsg(sendMg);
					System.out.println("���ۼ���");
					setMember(member);
					server.userLogin(this);
					server.broadcastWaitRoomUpdate();
					System.out.println("====== �޸� ������ ��û ���� ����======");
				} else if (prefix.equals(Message.requestBankData)) {
					// ������ �޾ƿ���
					System.out.println("====== ���� ������ ��û ���� ����======");
					String tmp[] = msg.split(",");
					System.out.println("tmp[0]" + tmp[0]);
					String newTmp = server.getBankData(tmp[0]);

					String sendMg = Message.requestBankData_sucess + newTmp;

					System.out.println(sendMg);

					sendMsg(sendMg);
					System.out.println("���ۼ���");
					setMember(member);
					server.userLogin(this);
					server.broadcastWaitRoomUpdate();
					System.out.println("====== ���� ������ ��û ���� ����======");
				} 
				else if (prefix.equals(Message.requestBankData_update)) {
					
						// ��й�ȣ ���� ������ ������û�� ���� ���
						if (server.requestUpdateBankData(msg)) {
							System.out.println("�Է��ߵ�");
							sendMsg(Message.requestPwData_update_success);
						} else {
							sendMsg(Message.requestPwData_update_fail);
						}
					
					
				}
				else if (prefix.equals(Message.requestBankData_delete)) {
					
					// ��й�ȣ ���� ������ ������û�� ���� ���
					if (server.requestDeleteBankData(msg)) {
						System.out.println("�Է��ߵ�");
						sendMsg(Message.requestBankData_delete_success);
					} else {
						sendMsg(Message.requestBankData_delete_fail);
					}
				
				
			}
				
				else if (prefix.equals(Message.requestBankData_add)) {
					// ��� �޸� ���� ������ �߰� ��û�� ������ ���
					System.out.println("==============");
					System.out.println("����޸� �߰� �޼ҵ�");

					if (server.requestAddBankData(msg)) {
						System.out.println("�Է��ߵ�");
						sendMsg(Message.requestSmData_add_success);
					} else {
						sendMsg(Message.requestSmData_add_fail);
					}
				}
				
				
				
				else if (prefix.equals(Message.requestCardData)) {
					// ������ �޾ƿ���
					System.out.println("====== ���� ������ ��û ���� ����======");
					String tmp[] = msg.split(",");
					System.out.println("tmp[0]" + tmp[0]);
					String newTmp = server.getCardData(tmp[0]);

					String sendMg = Message.requestCardData_sucess + newTmp;

					System.out.println(sendMg);

					sendMsg(sendMg);
					System.out.println("���ۼ���");
					setMember(member);
					server.userLogin(this);
					server.broadcastWaitRoomUpdate();
					System.out.println("====== ���� ������ ��û ���� ����======");
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
					server.broadcast_chatRoom(Message.ROOM_CHAT_MSG + "#" + member.getName() + "#���� �����ϼ̽��ϴ�", roomName);
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
			// ������ ���� ��� IOException �� �߻���
			userLeave(false);
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (SQLException e) {
			String errMsg = "��� ���� : " + e.getMessage();
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
		if (member == null) // �α����ϱ� ���� member == null �̴�
			return;
		if (roomName.equals("")) { // roomName �� "" �̸� ���ǿ��� ������ ����
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
			server.broadcast_chatRoom(Message.ROOM_CHAT_MSG + "#" + member.getName() + "#���� �����̽��ϴ�", roomName);
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
