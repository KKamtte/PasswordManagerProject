package Security;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.misc.*;
import java.util.*;

public class Decrypt
{	
	
		private String deString;
		
		
           public String getDeString() {
			return deString;
		}

		public void setDeString(String deString) {
			this.deString = deString;
		}

		
           
           public  Decrypt(String text) throws Exception
           {
        	   
        	   String key = "key";
                     Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                     byte[] keyBytes= new byte[16];
                     byte[] b= key.getBytes("UTF-8");
                     int len= b.length;
                     if (len > keyBytes.length) len = keyBytes.length;
                     System.arraycopy(b, 0, keyBytes, 0, len);
                     SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
                     IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
                     cipher.init(Cipher.DECRYPT_MODE,keySpec,ivSpec);
 
                     BASE64Decoder decoder = new BASE64Decoder();
                     byte [] results = cipher.doFinal(decoder.decodeBuffer(text));
                     
                     
                     deString=new String(results,"UTF-8");
           }
}