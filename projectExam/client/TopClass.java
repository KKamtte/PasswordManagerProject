package client;


import 기말팀프로젝트.MyStart;

public class TopClass {
	private static int b = 0;
	public static TopClass hd=null;
	private static int pk = -1;
	private ClientHandler ch;
	
	public static int getPk() {
		return pk;
	}

	public static void setPk(int pk) {
		TopClass.pk = pk;
	}
	//창의 위치를 저장하는 필드들 x,y
	private int x = 0;
	private int y = 0;
	  public static int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	public static void increaseB(){
		b++;
	}
	public TopClass(){
		System.out.println("생성자 호출");
		new MyStart();
	}
	
	public TopClass(ClientHandler clientHandler) {
		ch = clientHandler;
		System.out.println("생성자 호출");
		new MyStart();
	}

	public void setHandler(ClientHandler ch) {
		this.ch = ch;
		System.out.println(ch);
	}
//	public static void main(String[] args) {
//		System.out.println(b);
//		hd = new TopClass();
//		new MyStart(a);
//	}
}
