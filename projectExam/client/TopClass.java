package client;


import �⸻��������Ʈ.MyStart;

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
	//â�� ��ġ�� �����ϴ� �ʵ�� x,y
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
		System.out.println("������ ȣ��");
		new MyStart();
	}
	
	public TopClass(ClientHandler clientHandler) {
		ch = clientHandler;
		System.out.println("������ ȣ��");
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
