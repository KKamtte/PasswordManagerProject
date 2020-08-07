package client;



/**
 * @author ebonny
 * 클라이언트의 ServerMsgListener 와 서버의 Guest 가 서로 메시지를 주고 받을 때
 * 어떤 상황에 대한 메시지인지에 판단하기 위해 사용하는 상수들을 정의.
 * 
 *	참고로 interface 의 멤버변수는 자동으로 public static final 의 속성이 붙는다.
 */
public interface Message {
	int FILE_PORT = 2011;		// 파일 전송시 사용할 포트번호
	int CHAT_PORT = 2002;		// 채팅에 사용할 포트번호
	String SERVER_URL = "192.168.63.225";
	int LOGIN_CHECK = 100;
	int MOD_CHECK = 101;
	int MODE_MODIFY = 102;	// JoinDialog 를 정보수정 모드로 열 경우에 사용
	int MODE_JOIN = 103;		// JoinDialog 를 가입 모드로 열 경우에 사용
	
	String LOGIN_REQUEST_CHECKID = "1000";
	String LOGIN_REQUEST_CHECKNICK = "1001";
	String LOGIN_CHECKID_SUCCESS = "1002";
	String LOGIN_CHECKID_FAIL = "1003";
	String LOGIN_CHECKNICK_SUCCESS = "1004";
	String LOGIN_CHECKNICK_FAIL = "1005";
	String LOGIN_REQUEST_JOIN = "1006";
	String LOGIN_JOIN_SUCCESS = "1007";
	String LOGIN_JOIN_FAIL = "1008";
	String LOGIN_REQUEST = "1009";
	String LOGIN_SUCCESS = "1010";
	String LOGIN_FAIL_WRONG_ID = "1011";
	String LOGIN_FAIL_WRONG_PWD = "1012";
	String LOGIN_FAIL_LOGINED_ID = "1013";
	
	String GO_TO_OTP = "1100";
	String GO_TO_OTP_CHECK = "1101";
	String GO_TO_OTP_CHECK_SUCCESS = "1101";
	String GO_TO_OTP_CHECK_FAIL = "1102";
	String GO_TO_OTP_AGAIN = "1103";
	String GO_TO_OTP_AGAIN_SUCCESS = "1104";
	String GO_TO_OTP_AGAIN_FAIL = "1105";
	
	String WAIT_USER_UPDATE = "2000";
	String WAIT_ROOM_UPDATE = "2001";
	String WAIT_USER_OUT = "2002";
	String WAIT_CHAT_MSG = "2003";
	
	String CHAT_USER_UPDATE = "3000";
	String ROOM_REQUEST_MAKE = "3001";
	String ROOM_MAKE_SUCCESS = "3002";
	String ROOM_MAKE_FAIL = "3003";
	String ROOM_USER_OUT = "3004";
	String ROOM_USER_IN = "3005";
	String ROOM_CHAT_MSG = "3006";
	String ROOM_SET_NAME = "3007";
	String ROOM_INVITE_USER = "3008";
	String ROOM_INVITE_REQUEST = "3009";
	String ROOM_INVITE_DENY = "3010";
	String ROOM_INVITE_DENIED = "3011";
	String ROOM_REQUEST_WAITUSER = "3012";
	String ROOM_RETURN_WAITUSER = "3012";
	String ROOM_CHAT_WHISPER = "3013";
	String ROOM_WHISPER_FAIL = "3014";
	String ROOM_KICKOFF = "3015";
	
	String LOGOUT = "4000";
	String GET_ADDR = "4001";
	String MOD_REQUEST_CHECKNICK = "4002";
	String MOD_UPDATE_USERINFO = "4003";
	String MOD_UPDATE_SUCCESS = "4004";
	String MOD_UPDATE_FAIL = "4005";
	String ERR_DATABASE = "4006";
	
	String requestPwData= "5000";
	String requestPwData_sucess= "5001";
	String requestPwData_add="5002";
	String requestPwData_add_success ="5003";
	String requestPwData_add_fail ="5004" ;
	String requestPwData_delete="5005";
	String requestPwData_delete_success="5006";
	String requestPwData_delete_fail="5007";
	String requestPwData_update = "5008";
	String requestPwData_update_success = "5009";
	String requestPwData_update_fail = "5010";
	

	
	
	String requestSmData="6000";
	String requestSmData_sucess="6001";
	String requestSmData_add="6002";
	String requestSmData_add_success="6003";
	String requestSmData_add_fail="6004";
	String requestSmData_delete="6005";
	String requestSmData_delete_success="6006";
	String requestSmData_delete_fail="6007";
	String requestSmData_update = "6008";
	String requestSmData_update_success = "6009";
	String requestSmData_update_fail = "6010";
	
	String requestCardData = "7000";
	String requestCardData_sucess="7001";
	String requestCardData_add="7002";
	String requestCardData_add_success="7003";
	String requestCardData_add_fail="7004";
	String requestCardData_delete="7005";
	String requestCardData_delete_success="7006";
	String requestCardData_delete_fail="7007";
	String requestCardData_update="7008";
	String requestCardData_update_success="7009";
	String requestCardData_update_fail="7010";
	
	
	String requestBankData="8000";
	String requestBankData_sucess="8001";
	String requestBankData_add="8002";
	String requestBankData_add_success="8003";
	String requestBankData_add_fail="8004";
	String requestBankData_delete="8005";
	String requestBankData_delete_success="8006";
	String requestBankData_delete_fail="8007";
	String requestBankData_update="8008";
	String requestBankData_update_success="8009";
	String requestBankData_update_fail="8010";
	
	
	
}
