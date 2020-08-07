package client;

import java.awt.Point;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import �⸻��������Ʈ.MyFrame;
import �⸻��������Ʈ.MyStart;

/**
 * @author ebonny GUI ȯ��� ServerMsgListener �� �߰��ٸ� ����
 * 
 *         ä�ù�, ����, �α���â, ����â ���� GUIȯ�濡�� �߻��ϴ� �̺�Ʈ�� ó���� ServerMsgListener ��
 *         sendMsg �� ���� ������ �޽����� �����Ѵ�.
 * 
 *         ServerMsgListener �� �޽����� ���� �� �޽����� ������ ���� GUI �� ��ȭ��Ű�µ� (ä�ó��� ������Ʈ,
 *         ������� ������Ʈ, �� ��� ������Ʈ ��) �� �� �� Ŭ������ getChatRoom(), getWaitRoom() ����
 *         �޼ҵ带 �̿��ؼ� GUI �� �����Ѵ�.
 * 
 *         ��Ȱ�� �߰��ٸ� ������ ���ؼ� ��� GUI(���̾�α� �� Panel)���� ��������� ������.
 */
public class ClientHandler {
	private static final ClientHandler instance = new ClientHandler();
	private static ServerMsgListener sml;
	//private JoinDialog joinDialog;
//	private MainFrame frame;
	private LoginPanel loginPanel;
//	private WaitRoom waitRoom;
	private static Member member;
//	private ChatRoom chatRoom;
//	private InviteDialog inviteDialog;
//	private PwdDialog pwdDialog;
public static Point p;
	

	// �߰� ����
	public MyStart myStart;
	private MyFrame myFrame;

	public static void main(String[] args) {
		ClientHandler.getInstance().startClient();
	}

	private ClientHandler() {

		myStart = new MyStart();
		myStart.setHandler(this);
	}
	public void setHandler(){
		
		myStart.setHandler(this);
	}
	

	public static ClientHandler getInstance() {
		return instance;
	}

	public void startClient() {
		openLogin();
	}

	private void openLogin() {
		Socket socket = null;
		
		try {
			socket = new Socket(Message.SERVER_URL, Message.CHAT_PORT);
			System.out.println(socket);
			sml = new ServerMsgListener(this, socket);
			sml.start();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "������ ������ �� �����ϴ�");
		}
	}

//	public void openJoin() {
//		joinDialog = new JoinDialog(frame, "ȸ������", true, Message.MODE_JOIN);
//		joinDialog.setVisible(true);
//	}

	public void requestJoin(String msg) {
		sml.sendMsg(Message.LOGIN_REQUEST_JOIN + msg);
	}
	

	public MyStart getFrame() {
		return myStart;
	}
//
	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	public void requestCheckId(String id) {
		System.out.println(id);
		sml.sendMsg(Message.LOGIN_REQUEST_CHECKID + id);
	}

	public void requestCheckNick(String nick, int checkMode) {
		switch (checkMode) {
		case Message.LOGIN_CHECK:
			sml.sendMsg(Message.LOGIN_REQUEST_CHECKNICK + nick);
			break;
		case Message.MOD_CHECK:
			sml.sendMsg(Message.MOD_REQUEST_CHECKNICK + nick);
			break;
		}
	}

	
	public static void requestLogin(String msg) {
		System.out.println(msg);
		sml.sendMsg(Message.LOGIN_REQUEST + msg);
	}

//	public void openWaitRoom() {
//		waitRoom = new WaitRoom();
//		frame.setPanel(waitRoom);
//		frame.setMenuItemEnabled(true);
//		if (member != null) {
//			waitRoom.setChatBorder("ä��(" + member.getName() + ")");
//		}
//		waitRoom.focusText();
//	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
//	public WaitRoom getWaitRoom() {
//		return waitRoom;
//	}
//
	public void logout() {
		sml.sendMsg(Message.LOGOUT);
		
		
	}

//	public void sendWaitChat(String txt) {
//		sml.sendMsg(Message.WAIT_CHAT_MSG + txt);
//	}

	public static Member getMember() {
		return member;
	}

//	public void makeRoom(String roomName) {
//		sml.sendMsg(Message.ROOM_REQUEST_MAKE + roomName);
//	}

//	public void openChatRoom(String msg) {
//		chatRoom = new ChatRoom();
//		frame.setPanel(chatRoom);
//		chatRoom.focusText();
//	}

//	public void exitChatRoom() {
//		openWaitRoom();
//		sml.sendMsg(Message.ROOM_USER_OUT);
//	}

//	public void enterRoom(String roomName) {
//		openChatRoom(roomName);
//		sml.sendMsg(Message.ROOM_USER_IN + roomName);
//	}

//	public ChatRoom getChatRoom() {
//		return chatRoom;
//	}

//	public void sendRoomChat(String text) {
//		sml.sendMsg(Message.ROOM_CHAT_MSG + text);
//	}
//
//	public void invite(String nick) {
//		sml.sendMsg(Message.ROOM_INVITE_USER + nick);
//	}
//
//	public void inviteDeny(String msg) {
//		sml.sendMsg(Message.ROOM_INVITE_DENY + msg);
//	}

//	public void openInvite() {
//		inviteDialog = new InviteDialog(frame, "�ʴ�", true);
//		sml.sendMsg(Message.ROOM_REQUEST_WAITUSER);
//		inviteDialog.setVisible(true);
//	}

//	public InviteDialog getInviteDialog() {
//		return inviteDialog;
//	}

//	public void exitWaitRoom() {
//		sml.sendMsg(Message.WAIT_USER_OUT);
//		frame.dispose();
//		System.exit(0);
//	}

//	public void sendfile(String nick) {
//		sml.sendMsg(Message.GET_ADDR + nick);
//	}
//
//	public void sendWhisper(String nick, String msg) {
//		sml.sendMsg(Message.ROOM_CHAT_WHISPER + nick + "," + msg);
//	}
//
//	public void kickOff(String nick) {
//		sml.sendMsg(Message.ROOM_KICKOFF + nick);
//	}
//
//	public void requestModify(String msg) {
//		sml.sendMsg(Message.MOD_UPDATE_USERINFO + msg);
//	}

	public static void requestPwData(int userNum) {

		sml.sendMsg(Message.requestPwData + userNum);
	}

//	public void openModify() {
//		joinDialog = new JoinDialog(frame, "���� ����", true, Message.MODE_MODIFY);
//		joinDialog.setVisible(true);
//	}
//
//	public void openPwdCheck() {
//		pwdDialog = new PwdDialog(frame);
//		pwdDialog.setVisible(true);
//	}

//	public void moveMyFrame() {
//		// TODO Auto-generated method stub
//
//		// myFrame.setHandler();
//	}

	public void closeStart(ClientHandler ch) {

		myStart.close();

	}
	public void requestupdatePwData(String msg) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.requestPwData_update + msg);
	}
	public void requestaddPwData(String msg) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.requestPwData_add + msg);
	}

	public void requestaddSmData(String msg) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.requestSmData_add + msg);
	}

	public static void requestSmData(int userNum) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.requestSmData + userNum);
		
	}

	public static void requestCardData(int userNum) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.requestCardData + userNum);
	}

	public void requestaddCardData(String msg) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.requestCardData_add + msg);
	}

	public void requestaddBankData(String msg) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.requestBankData_add + msg);
	}

	public static void requestBankData(int userNum) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.requestBankData + userNum);
	}

	public void requestdeletePwData(String msg) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.requestPwData_delete + msg);
	}

	public void requestupdateSmData(String msg) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.requestSmData_update + msg);
	}

	public void requestdeleteSMData(String msg) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.requestSmData_delete + msg);
	}

	public void requestOTPcheck(String msg) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.GO_TO_OTP_CHECK +msg);
		
	}
	public void requestOTPagain(String msg) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.GO_TO_OTP_AGAIN +msg);
	}

	public void requestUpdateCardData(String msg) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.requestCardData_update + msg);
	}

	public void requestdeleteCardData(String msg) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.requestCardData_delete + msg);
	}

	public void requestUpdateBankData(String msg) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.requestBankData_update + msg);
	}

	public void requestdeleteBankData(String msg) {
		// TODO Auto-generated method stub
		sml.sendMsg(Message.requestBankData_delete + msg);
	}
		
	

}
