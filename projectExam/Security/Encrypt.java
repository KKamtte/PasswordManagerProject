package Security;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.misc.*;
import java.util.*;

public class Encrypt {
	private static String enco;
//	public static void main(String[] args) {
//		try {
//
//			String key = "key";
//
//			Scanner sc = new Scanner(System.in);
//
//			// 암호화부분
//			String ex = sc.nextLine();
//			
//		
//		} catch (Exception ex) {
//			System.out.println("오류");
//		}
//
//	}

	public static String getEnco() {
		return enco;
	}

	public static void setEnco(String enco) {
		Encrypt.enco = enco;
	}

	public Encrypt(String text) throws Exception {

		String key = "key";
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length)
			len = keyBytes.length;
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

		byte[] results = cipher.doFinal(text.getBytes("UTF-8"));
		BASE64Encoder encoder = new BASE64Encoder();
		enco= encoder.encode(results);
	}
}