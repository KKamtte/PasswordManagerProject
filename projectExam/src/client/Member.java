package client;


/**
 * @author ebonny
 * 로그인한 사용자의 정보를 담아두기 위한 클래스
 * 
 */
public class Member {
	private int userNum;
	private String id;
	private String pwd;
	private String name;
	private String email;

	public Member(int userNum, String id, String pwd, String name, String email, String string) {
		this.userNum = userNum;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}

	public Member(String[] info) {
		System.out.println(Integer.parseInt(info[0]));
		System.out.println(info[1]);
		System.out.println(info[2]);
		System.out.println(info[3]);
		System.out.println(info[4]);
		
		userNum = Integer.parseInt(info[0]);
		id = info[1];
		pwd = info[2];
		name = info[3];
		email = info[4];
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public void setAll(String[] tmp) {
		userNum = Integer.parseInt(tmp[0]);
		id = tmp[1];
		pwd = tmp[2];
		name = tmp[3];
		email = tmp[4];
	}

}
