package client;

public class PwData {
	private int accountNum;
	private String accountID;
	private String accountPw;
	private String accountAddress;
	private int accountMasternum;
	
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getAccountPw() {
		return accountPw;
	}
	public void setAccountPw(String accountPw) {
		this.accountPw = accountPw;
	}
	public String getAccountAddress() {
		return accountAddress;
	}
	public void setAccountAddress(String accountAddress) {
		this.accountAddress = accountAddress;
	}
	public int getAccountMasternum() {
		return accountMasternum;
	}
	public void setAccountMasternum(int accountMasternum) {
		this.accountMasternum = accountMasternum;
	}
	public PwData(int accountNum, String accountID, String accountPw, String accountAddress, int accountMasternum) {
		super();
		this.accountNum = accountNum;
		this.accountID = accountID;
		this.accountPw = accountPw;
		this.accountAddress = accountAddress;
		this.accountMasternum = accountMasternum;
	}
	public PwData(String[] info) {
		
		
		accountNum = Integer.parseInt(info[0]);
		accountID = info[1];
		accountPw = info[2];
		accountAddress = info[3];
		accountMasternum = Integer.parseInt(info[4]);
	}
	public void setAll(String[] tmp) {
		accountNum = Integer.parseInt(tmp[0]);
		accountID = tmp[1];
		accountPw = tmp[2];
		accountAddress = tmp[3];
		accountMasternum = Integer.parseInt(tmp[4]);
	}
	

}
