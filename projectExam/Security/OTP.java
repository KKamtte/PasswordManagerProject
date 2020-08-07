package Security;

public class OTP {

	//필드
	private String msg="";
	
	//생성자
	public OTP() {
		// TODO Auto-generated constructor stub
		int[] array = new int[5];

		for (int i = 0; i < 5; i++) {
			array[i] = (int) (Math.random() * 10);
			do {
				array[i] = (int) (Math.random() * 10);
			} while (i > 0 && array[i] == array[i - 1]);
			System.out.print(array[i]);
			msg += ""+array[i];
		}
		
		System.out.println(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
