package server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import client.Member;
import server.database.DBManager;

/**
 * @author ebonny
 * Query 담당 클래스
 */
public class MemberDAO {

	private static MemberDAO instance;
	private PreparedStatement checkIDStmt;
	private PreparedStatement checkNickStmt;
	private PreparedStatement getStmt;
	private PreparedStatement joinStmt;
	private PreparedStatement updateStmt;
	private PreparedStatement pwdataGetStmt;
	private PreparedStatement pwdataAddStmt;
	private PreparedStatement pwdataUpdateStmt;
	private PreparedStatement pwdatadeleteStmt;
	
	private PreparedStatement smdataGetStmt;
	private PreparedStatement smdataAddStmt;
	private PreparedStatement smdataUpdateStmt;
	private PreparedStatement smdataDeleteStmt;
	
	private PreparedStatement bankdataAddStmt;
	private PreparedStatement bankdataGetStmt;
	private PreparedStatement bankdataUpdateStmt;
	private PreparedStatement bankdataDeleteStmt;
	
	private PreparedStatement carddataGetStmt;
	private PreparedStatement carddataAddStmt;
	private PreparedStatement carddataUpdateStmt;
	private PreparedStatement carddataDeleteStmt;
	
	private MemberDAO(DBManager dbmgr) throws SQLException {
		String checkId = "select u_num  from usertable  where U_MASTERID  = ?";
		String checkNick = "select id from usertable where nick = ?";
		String getMember = "select * from usertable where U_MASTERID = ?";
		
		String join = "insert into usertable values(usertable_seq.nextval, ?,?,?,?,?)";
		
		String update = "update usertable set id = ?, pwd = ?, name = ?, nick = ?, phone = ? where id = ?";

		String pwGetData = "select * from accountTable2 where a_masternum = ?";
		String pwAddData = "insert into accountTable2 values(accountTable2_seq.nextval,?,?,?,?,?)";
		String pwUpdateData = "update accounttable2 set a_id =? ,a_pw=?,a_address=?,a_address_name=? where a_num=?";
		String pwdeleteDate= "delete from accounttable2 where a_num=?";
				
		String memoGetData = "select * from secretMemo1 where s_masternum = ?";
		String memoAddData = "insert into secretMemo1 values( secretMemo1_seq.nextval,?,?,?)";
		String memoUpdateData = "update secretMemo1 set s_memotitle =? ,s_memodata=? where s_num=?";
		String memoDeleteDate= "delete from secretMemo1 where s_num=?";
		
		String cardGetData="select * from cardtable where c_masternum = ?";
		String cardAddData="insert into cardtable values(cardtable_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
		String cardUpdateData = "update cardtable set c_password=? where c_num=?";
		String cardDeleteData = "delete from cardtable where c_num=?";
		
		String bankGetData="select * from bankTable1 where b_masternum = ?";
		String bankAddData="insert into bankTable1 values(userTable1_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
		String bankUpdateData = "update bankTable1 set b_password=? where b_num=?";
		String bankDeleteData = "delete from bankTable1 where a_num=?";
		
		
		checkIDStmt = dbmgr.create(checkId);
		checkNickStmt = dbmgr.create(checkNick);
		getStmt = dbmgr.create(getMember);
		joinStmt = dbmgr.create(join);
		updateStmt = dbmgr.create(update);
		pwdataGetStmt =dbmgr.create(pwGetData);
		pwdataAddStmt=dbmgr.create(pwAddData);
		pwdataUpdateStmt=dbmgr.create(pwUpdateData);
		pwdatadeleteStmt= dbmgr.create(pwdeleteDate);
		smdataAddStmt=dbmgr.create(memoAddData);
		smdataGetStmt=dbmgr.create(memoGetData);
		smdataUpdateStmt=dbmgr.create(memoUpdateData);
		smdataDeleteStmt=dbmgr.create(memoDeleteDate);
		bankdataAddStmt=dbmgr.create(bankAddData);
		bankdataGetStmt=dbmgr.create(bankGetData);
		bankdataUpdateStmt=dbmgr.create(bankUpdateData);
		bankdataDeleteStmt=dbmgr.create(bankDeleteData);
		
		carddataAddStmt=dbmgr.create(cardAddData);
		carddataGetStmt=dbmgr.create(cardGetData);
		carddataUpdateStmt=dbmgr.create(cardUpdateData);
		carddataDeleteStmt=dbmgr.create(cardDeleteData);
		
	}

	synchronized public static MemberDAO getInstance(DBManager dbmgr) throws SQLException {
		if (instance == null)
			instance = new MemberDAO(dbmgr);
		return instance;
	}

	public Member getMember(String id) throws SQLException {
		Member member = null;
		
		getStmt.setString(1, id);
		
		ResultSet rs = getStmt.executeQuery();
		System.out.println("쿼리문 전송 바로 전1");
		if (rs.next()){
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getString(6));
			member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));	
		}
		return member;
	}
	
	public String getBankData(String string) throws SQLException{
		// TODO Auto-generated method stub
		String sendString = "";
		
		
		bankdataGetStmt.setInt(1,Integer.parseInt(string));
		
		
		ResultSet rs = bankdataGetStmt.executeQuery();
		System.out.println("전송성공");
		while(rs.next()){
			System.out.println(rs.getInt(1));
			sendString +=rs.getInt(1)+",";
			System.out.println(rs.getString(2));
			sendString +=rs.getString(2)+",";
			System.out.println(rs.getString(3));
			sendString +=rs.getString(3)+",";
			System.out.println(rs.getString(4));
			sendString +=rs.getString(4)+",";
			System.out.println(rs.getString(5));
			sendString +=rs.getString(5)+",";
			System.out.println(rs.getString(6));
			sendString +=rs.getString(6)+",";
			System.out.println(rs.getString(7));
			sendString +=rs.getString(7)+",";
			System.out.println(rs.getString(8));
			sendString +=rs.getString(8)+",";
			System.out.println(rs.getString(9));
			sendString +=rs.getString(9)+",";
			System.out.println(rs.getString(10));
			sendString +=rs.getString(10)+",";
			
			
		}
		System.out.println(sendString);
		return sendString;
	}
	public String getPwData(String string) throws SQLException{
		// TODO Auto-generated method stub
		String sendString = "";
		
		
		pwdataGetStmt.setInt(1,Integer.parseInt(string));
		
		
		ResultSet rs = pwdataGetStmt.executeQuery();
		System.out.println("전송성공");
		while(rs.next()){
			System.out.println(rs.getInt(1));
			sendString +=rs.getInt(1)+",";
			System.out.println(rs.getString(2));
			sendString +=rs.getString(2)+",";
			System.out.println(rs.getString(3));
			sendString +=rs.getString(3)+",";
			System.out.println(rs.getString(4));
			sendString +=rs.getString(4)+",";
			System.out.println(rs.getString(5));
			sendString +=rs.getString(5)+",";
			
		}
		System.out.println(sendString);
		return sendString;
	}
	
	

	/**
	 * 
	 * @param string 유저 고유 식별번호
	 * @return 사용자에게 전송할 데이터 String
	 * @throws SQLException
	 * 
	 * 	비밀 메모를 디비로 부터 받아와 클라이언트에게 전송할 String을 만들어서 반환해주는 메소드
	 */
	public String getSmData(String string) throws SQLException{
		// TODO Auto-generated method stub
		String sendString = "";
		
		
		smdataGetStmt.setInt(1,Integer.parseInt(string));
		
		
		ResultSet rs = smdataGetStmt.executeQuery();
		System.out.println("전송성공");
		while(rs.next()){
			System.out.println(rs.getInt(1));
			sendString +=rs.getInt(1)+",,,";
			System.out.println(rs.getString(2));
			sendString +=rs.getString(2)+",,,";
			System.out.println(rs.getString(3));
			sendString +=rs.getString(3)+",,,";
			
			
			
		}
		System.out.println(sendString);
		return sendString;
	}
	public boolean checkId(String id) throws SQLException {
		
		checkIDStmt.setString(1, id);
		return !checkIDStmt.executeQuery().next();

	}

	public boolean checkNick(String nick) throws SQLException {
		checkNickStmt.setString(1, nick);
		return !checkNickStmt.executeQuery().next();
	}

	public boolean requestJoin(String[] msg) throws SQLException {
		System.out.println(msg[0]);
		System.out.println(msg[1]);
		System.out.println(msg[2]);
		System.out.println(msg[3]);
		System.out.println(msg[4]);
		
		
		
		joinStmt.setString(1, msg[0]);//아이디
		joinStmt.setString(2, msg[1]);//비밀번호
		joinStmt.setString(3, msg[2]);//이름
		joinStmt.setString(4, msg[3]);//이메일
		joinStmt.setString(5, msg[4]);//전화번호
		return joinStmt.executeUpdate() != 0;
	}

	public boolean updateMember(String[] info) throws SQLException {
		updateStmt.setString(1, info[0]);
		updateStmt.setString(2, info[1]);
		updateStmt.setString(3, info[2]);
		updateStmt.setString(4, info[3]);
		updateStmt.setString(5, info[4]);
		updateStmt.setString(6, info[0]);
		return updateStmt.executeUpdate() != 0;
	}

	public boolean requestAddpwData(String[] msg) throws SQLException{
		// TODO Auto-generated method stub
		System.out.println("쿼리문 전송전 최종 확인");
		System.out.println(msg[0]);
		System.out.println(msg[1]);
		System.out.println(msg[2]);
		System.out.println(msg[3]);
		System.out.println(msg[4]);
		
		
		
		pwdataAddStmt.setString(1, msg[0]);//아이디
		pwdataAddStmt.setString(2, msg[1]);//비밀번호
		pwdataAddStmt.setString(3, msg[2]);//주소
		pwdataAddStmt.setString(4, msg[3]);//사이트이름
		pwdataAddStmt.setString(5, msg[4]);//사용자 고유 식별 번호
		
		return pwdataAddStmt.executeUpdate() != 0;
	}

	public boolean requestAddSmData(String[] msg) throws SQLException{
		// TODO Auto-generated method stub
		System.out.println("쿼리문 전송전 최종 확인");
		System.out.println(msg[0]);
		System.out.println(msg[1]);
		System.out.println(msg[2]);
		
		
		
		smdataAddStmt.setString(1, msg[0]);//제목
		smdataAddStmt.setString(2, msg[1]);//내용
		smdataAddStmt.setInt(3, Integer.parseInt(msg[2]));//사용자 고유 식별 번호
		
		
		return smdataAddStmt.executeUpdate() != 0;
	}

	public boolean requestAddCardData(String[] msg) throws SQLException{
		System.out.println("카드 추가 퀴리 전송전 최종 확인");

		for(int i =0; i<msg.length;i++){
			System.out.println("["+i+"]번째 값  :"+msg[i]);
		}
		
		
		
		carddataAddStmt.setString(1, msg[0]);//통장이름
		carddataAddStmt.setString(2, msg[1]);//종류
		carddataAddStmt.setString(3, msg[2]);//계좌번호1
		carddataAddStmt.setString(4, msg[3]);//계좌번호2
		carddataAddStmt.setString(5, msg[4]);//계좌번호3
		carddataAddStmt.setString(6, msg[5]);//계좌번호4
		carddataAddStmt.setString(7, msg[6]);//만료일 달
		carddataAddStmt.setString(8, msg[7]);//만료일 년
		carddataAddStmt.setString(9, msg[8]);//발급일 달
		carddataAddStmt.setString(10, msg[9]);//발급일 년
		carddataAddStmt.setString(11, msg[10]);//비밀번호
		carddataAddStmt.setString(12, msg[11]);//사용자 고유 식별 번호
		
		return carddataAddStmt.executeUpdate() != 0;
		
	}

	public boolean requestAddBankData(String[] msg) throws SQLException{
		// TODO Auto-generated method stub
				System.out.println("쿼리문 전송전 최종 확인");

				for(int i =0; i<msg.length;i++){
					System.out.println("["+i+"]번째 값  :"+msg[i]);
				}
				
				
				
				bankdataAddStmt.setString(1, msg[0]);//통장이름
				bankdataAddStmt.setString(2, msg[1]);//종류
				bankdataAddStmt.setString(3, msg[2]);//계좌번호1
				bankdataAddStmt.setString(4, msg[3]);//계좌번호2
				bankdataAddStmt.setString(5, msg[4]);//계좌번호3
				bankdataAddStmt.setString(6, msg[5]);//계좌번호4
				bankdataAddStmt.setString(7, msg[6]);//발행일
				bankdataAddStmt.setString(8, msg[7]);//관리지점
				bankdataAddStmt.setString(9, msg[8]);//비밀번호
				bankdataAddStmt.setString(10, msg[9]);//사용자 고유 식별 번호
				
				return bankdataAddStmt.executeUpdate() != 0;
				
	}

	public String getCardData(String string) throws SQLException{
		// TODO Auto-generated method stub
		String sendString = "";
		
		
		carddataGetStmt.setInt(1,Integer.parseInt(string));
		
		
		ResultSet rs = carddataGetStmt.executeQuery();
		System.out.println("전송성공");
		while(rs.next()){
			System.out.println(rs.getInt(1));
			sendString +=rs.getInt(1)+",";
			System.out.println(rs.getString(2));
			sendString +=rs.getString(2)+",";
			System.out.println(rs.getString(3));
			sendString +=rs.getString(3)+",";
			System.out.println(rs.getString(4));
			sendString +=rs.getString(4)+",";
			System.out.println(rs.getString(5));
			sendString +=rs.getString(5)+",";
			System.out.println(rs.getString(6));
			sendString +=rs.getString(6)+",";
			System.out.println(rs.getString(7));
			sendString +=rs.getString(7)+",";
			System.out.println(rs.getString(8));
			sendString +=rs.getString(8)+",";
			System.out.println(rs.getString(9));
			sendString +=rs.getString(9)+",";
			System.out.println(rs.getString(10));
			sendString +=rs.getString(10)+",";
			System.out.println(rs.getString(11));
			sendString +=rs.getString(11)+",";
			System.out.println(rs.getString(12));
			sendString +=rs.getString(12)+",";
			
		}
		System.out.println(sendString);
		return sendString;
	}

	public boolean requestUpdatepwData(String[] msg) throws SQLException{
		// TODO Auto-generated method stub
		System.out.println("수정문 쿼리문 전송전 최종 확인");
		System.out.println(msg[0]);
		System.out.println(msg[1]);
		System.out.println(msg[2]);
		System.out.println(msg[3]);
		System.out.println(msg[4]);
		
		
		
		pwdataUpdateStmt.setString(1, msg[0]);//아이디
		pwdataUpdateStmt.setString(2, msg[1]);//비밀번호
		pwdataUpdateStmt.setString(3, msg[2]);//주소
		pwdataUpdateStmt.setString(4, msg[3]);//사이트이름
		pwdataUpdateStmt.setString(5, msg[4]);//고유 번호
		
		return pwdataUpdateStmt.executeUpdate() != 0;
	}

	public boolean requestDeletepwData(String[] msg) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("수정문 쿼리문 전송전 최종 확인");
		System.out.println(msg[0]);
		
		pwdatadeleteStmt.setString(1,msg[0]);
		return pwdatadeleteStmt.executeUpdate() != 0;
	}

	public boolean requestUpdateSmData(String[] msg) throws SQLException{
		System.out.println("쿼리문 전송전 최종 확인");
		System.out.println(msg[0]);
		System.out.println(msg[1]);
		System.out.println(msg[2]);
		
		
		
		smdataUpdateStmt.setString(1, msg[0]);//제목
		smdataUpdateStmt.setString(2, msg[1]);//내용
		smdataUpdateStmt.setInt(3, Integer.parseInt(msg[2]));//사용자 고유 식별 번호
		
		
		return smdataUpdateStmt.executeUpdate() != 0;
	}

	public boolean requestDeleteSMData(String[] msg) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("수정문 쿼리문 전송전 최종 확인");
		System.out.println(msg[0]);
		
		smdataDeleteStmt.setString(1,msg[0]);
		return smdataDeleteStmt.executeUpdate() != 0;
	}

	public boolean checkOTP(String[] split) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean requestUpdateCardData(String[] msg) throws SQLException {
		System.out.println("쿼리문 전송전 최종 확인");
		System.out.println(msg[0]);
		System.out.println(msg[1]);
	
		
		
		
		carddataUpdateStmt.setString(1, msg[0]);//제목
		carddataUpdateStmt.setInt(2, Integer.parseInt(msg[1]));//사용자 고유 식별 번호
		
		
		return carddataUpdateStmt.executeUpdate() != 0;
	}

	public boolean requestDeletecardData(String[] msg) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("수정문 쿼리문 전송전 최종 확인");
		System.out.println(msg[0]);
		
		carddataDeleteStmt.setString(1,msg[0]);
		return carddataDeleteStmt.executeUpdate() != 0;
	}

	public boolean requestUpdateBankData(String[] msg) throws SQLException {
		System.out.println("쿼리문 전송전 최종 확인");
		System.out.println(msg[0]);
		System.out.println(msg[1]);
	
		
		
		
		bankdataUpdateStmt.setString(1, msg[0]);//제목
		bankdataUpdateStmt.setInt(2, Integer.parseInt(msg[1]));//사용자 고유 식별 번호
		
		
		return bankdataUpdateStmt.executeUpdate() != 0;
	}

	public boolean requestDeleteBankData(String[] msg) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("수정문 쿼리문 전송전 최종 확인");
		System.out.println(msg[0]);
		
		bankdataDeleteStmt.setString(1,msg[0]);
		return bankdataDeleteStmt.executeUpdate() != 0;
	}



	

	
}
