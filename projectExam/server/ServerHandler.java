package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import client.Member;
import server.database.DBManager;
import server.database.OracleManager;
import client.Message;

/**
 * @author ebonny 서버측의 주요 로직처리를 담당. Guest 클래스에서 메시지를 받은 후 prefix의 종류에 따라
 *         ServerHandler의 적절한 함수를 호출한다. 3개의 중요한 Collection 을 멤버변수로 가진다. - guests
 *         : 대기실의 유저들을 저장 - roomMap : 채팅방의 유저들을 저장 - idMap : 로그인한 모든 유저들의 id 와
 *         ip 주소를 저장(ip주소는 파일전송때 사용됨)
 */
public class ServerHandler extends Thread {
	List<Guest> guests;
	private HashMap<String, String> idMap;
	private HashMap<String, ArrayList<Guest>> roomMap;
	private MemberDAO dao;

	public static void main(String[] args) {
		try {
			new ServerHandler(new OracleManager()).start();
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public ServerHandler(DBManager dbmgr) {
		guests = new ArrayList<Guest>();
		idMap = new HashMap<String, String>();
		roomMap = new HashMap<String, ArrayList<Guest>>();
		try {
			dao = MemberDAO.getInstance(dbmgr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		ServerSocket ss = null;
		Socket socket = null;
		try {
			ss = new ServerSocket(Message.CHAT_PORT);
			System.out.println("서버 시작됨 ...");
			while (true) {
				socket = ss.accept();
				Guest guest = new Guest(this, socket);
				guest.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean checkId(String id) throws SQLException {
		System.out.println(id);
		return dao.checkId(id);
	}

	public boolean checkNick(String nick) throws SQLException {
		return dao.checkNick(nick);
	}

	public boolean requestJoin(String msg) throws SQLException {
		return dao.requestJoin(msg.split(","));
	}

	public boolean requestAddpwData(String msg) throws SQLException {
		return dao.requestAddpwData(msg.split(","));
	}

	public boolean requestAddSmData(String msg) throws SQLException {
		// TODO Auto-generated method stub
		return dao.requestAddSmData(msg.split(",,,"));
	}

	public boolean requestAddCardData(String msg) throws SQLException {
		return dao.requestAddCardData(msg.split(","));
	}

	public Member getMember(String id) throws SQLException {
		System.out.println("안녕하세요 meber getMeber");
		System.out.println(id);
		Member member = dao.getMember(id);
		return member;
	}

	public String getPwData(String string) throws SQLException {
		String sendString = dao.getPwData(string);

		return sendString;

	}

	public void addUserToWait(Guest guest) {
		guests.add(guest);
	}

	public void userLogin(Guest guest) {
		guests.add(guest);
		idMap.put(guest.getMember().getId(), guest.getSocket().getInetAddress().getHostAddress());
	}

	public void broadcastWaitRoomUpdate() {
		broadcastWait_userUpdate();
		broadcastWait_roomUpdate();
	}

	public void broadcastWait_userUpdate() {
		String msg = "";
		Iterator<Guest> it = guests.iterator();
		while (it.hasNext()) {
			Guest g = it.next();
			msg += g.getMember().getName() + ",";
		}
		broadcast_waitRoom(Message.WAIT_USER_UPDATE + msg);
	}

	public void broadcastWait_roomUpdate() {
		String msg2 = "";
		Set<String> set = roomMap.keySet();
		Iterator<String> it2 = set.iterator();
		while (it2.hasNext()) {
			String roomName = it2.next();
			ArrayList<Guest> list = roomMap.get(roomName);
			msg2 += roomName + " : " + list.size() + "명,";
		}
		broadcast_waitRoom(Message.WAIT_ROOM_UPDATE + msg2);
	}

	public void broadcast_waitRoom(String msg) {
		Iterator<Guest> it = guests.iterator();
		while (it.hasNext()) {
			Guest guest = it.next();
			guest.sendMsg(msg);
		}
	}

	public void broadcast_chatRoom(String msg, String roomName) {
		ArrayList<Guest> list = roomMap.get(roomName);
		if (list == null)
			return;
		Iterator<Guest> it = list.iterator();
		while (it.hasNext()) {
			Guest g = it.next();
			g.sendMsg(msg);
		}
	}

	public void removeUserFromWait(Guest guest) {
		guests.remove(guest);
	}

	public void removeUserFromIdMap(String id) {
		idMap.remove(id);
	}

	public void removeUserFromRoom(Guest guest, String roomName) {
		ArrayList<Guest> list = roomMap.get(roomName);
		if (list == null)
			return;
		list.remove(guest);
		if (list.size() == 0)
			roomMap.remove(roomName);
	}

	public void broadcastChatRoomUpdate(String roomName) {
		String msg = "";
		ArrayList<Guest> list = roomMap.get(roomName);
		if (list == null)
			return;
		Iterator<Guest> it = list.iterator();
		while (it.hasNext()) {
			Guest g = it.next();
			msg += g.getMember().getName() + ",";
		}
		broadcast_chatRoom(Message.CHAT_USER_UPDATE + msg, roomName);
	}

	public boolean checkRoomName(String roomName) {
		return !roomMap.containsKey(roomName);
	}

	public boolean addRoom(String roomName) {
		if (roomMap.containsKey(roomName)) {
			return false;
		} else {
			roomMap.put(roomName, new ArrayList<Guest>());
			return true;
		}
	}

	public void addUserToRoom(Guest g, String roomName) {
		ArrayList<Guest> list = roomMap.get(roomName);
		list.add(g);
	}

	public boolean checkIdMap(String id) {
		return idMap.containsKey(id);
	}

	public void inviteUser(String inviterId, String receiverNick, String roomName) {
		for (Guest g : guests) {
			if (g.getMember().getName().equals(receiverNick)) {
				g.sendMsg(Message.ROOM_INVITE_REQUEST + inviterId + "," + roomName);
				break;
			}
		}
	}

	public void inviteDeny(String inviterId, String roomName, String denierNick) {
		ArrayList<Guest> list = roomMap.get(roomName);
		for (Guest g : list) {
			if (g.getMember().getId().equals(inviterId)) {
				g.sendMsg(Message.ROOM_INVITE_DENIED + denierNick);
				break;
			}
		}
	}

	public void returnWaitUsers(Guest guest) {
		String msg = "";
		for (Guest g : guests) {
			msg += g.getMember().getName() + ",";
		}
		guest.sendMsg(Message.ROOM_RETURN_WAITUSER + msg);
	}

	public void getAddr(Guest guest, String nick, String roomName) {
		ArrayList<Guest> list = roomMap.get(roomName);
		for (Guest g : list) {
			if (g.getMember().getName().equals(nick)) {
				g.sendMsg(Message.GET_ADDR + idMap.get(guest.getMember().getId()));
				break;
			}
		}
	}

	public void sendWhisper(Guest sender, String receiverNick, String msg, String roomName) {
		String senderNick = sender.getMember().getName();
		ArrayList<Guest> users = roomMap.get(roomName);
		Guest receiver = null;

		Iterator<Guest> it = users.iterator();
		while (it.hasNext()) {
			Guest g = it.next();
			if (g.getMember().getName().equals(receiverNick)) {
				receiver = g;
				break;
			}
		}
		if (receiver == null) {
			sender.sendMsg(Message.ROOM_WHISPER_FAIL + receiverNick);
		} else {
			msg = "[" + senderNick + "]\t▶ " + msg;
			sender.sendMsg(Message.ROOM_CHAT_MSG + msg);
			receiver.sendMsg(Message.ROOM_CHAT_MSG + msg);
		}
	}

	public void kickOff(String nick, String roomName) {
		ArrayList<Guest> list = roomMap.get(roomName);
		for (Guest g : list) {
			if (g.getMember().getName().equals(nick)) {
				g.sendMsg(Message.ROOM_KICKOFF);
				break;
			}
		}
	}

	public boolean modUserInfo(String[] tmp) throws SQLException {
		return dao.updateMember(tmp);
	}

	public String getSmData(String string) throws SQLException {
		String sendString = dao.getSmData(string);

		return sendString;

	}

	public boolean requestAddBankData(String msg) throws SQLException {
		// TODO Auto-generated method stub
		return dao.requestAddBankData(msg.split(","));
	}

	public String getBankData(String string) throws SQLException {
		String sendString = dao.getBankData(string);

		return sendString;
	}
	

	public String getCardData(String string)throws SQLException {
		// TODO Auto-generated method stub
		String sendString = dao.getCardData(string);

		return sendString;
	}

	public boolean requestUpdatePwData(String msg) throws SQLException {
		return dao.requestUpdatepwData(msg.split(","));
	}

	public boolean requestDeletePwData(String msg) throws SQLException {
		return dao.requestDeletepwData(msg.split(","));
	}

	public boolean requestUpdateSmData(String msg) throws SQLException {
		return dao.requestUpdateSmData(msg.split(",,,"));
	}

	public boolean requestDeleteSMData(String msg) throws SQLException {
		return dao.requestDeleteSMData(msg.split(",,,"));
	}

	public boolean requestUpdateCardData(String msg) throws SQLException {
		return dao.requestUpdateCardData(msg.split(","));
	}

	public boolean requestDeleteCardData(String msg) throws SQLException{
		return dao.requestDeletecardData(msg.split(","));
	}

	public boolean requestUpdateBankData(String msg) throws SQLException {
		return dao.requestUpdateBankData(msg.split(","));
		
	}

	public boolean requestDeleteBankData(String msg) throws SQLException {
		return dao.requestDeleteBankData(msg.split(","));
	}

	

}
