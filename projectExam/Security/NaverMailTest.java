package Security;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class NaverMailTest {
	
	private OTP opt;
	public OTP getOpt() {
		return opt;
	}
	public void setOpt(OTP opt) {
		this.opt = opt;
	}
	public NaverMailTest() throws MessagingException{
		// TODO Auto-generated constructor stub
        // ���� ���� ����
        String host = "smtp.naver.com";
        final String username = "2c6829";
        final String password = "pp442200";
        int port=465;
         
         opt =  new OTP();
        // ���� ����
        String st = "swye199@naver.com";
        String recipient = st;
        String subject = "GST�α��� OTP��ȣ�Դϴ�.";
        String body = opt.getMsg();
         
        
        Properties props = System.getProperties();
         
         
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.trust", host);
          
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            String un=username;
            String pw=password;
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(un, pw);
            }
        });
        session.setDebug(true); //for debug
          
        Message mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress("2c6829@naver.com"));
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        mimeMessage.setSubject(subject);
        mimeMessage.setText(body);
        Transport.send(mimeMessage);
	}
//    public static void main(String args[]) throws MessagingException{
//        // ���� ���� ����
//        String host = "smtp.naver.com";
//        final String username = "2c6829";
//        final String password = "pp442200";
//        int port=465;
//         
//        OTP opt =  new OTP();
//        // ���� ����
//        String st = "2c6829@naver.com";
//        String recipient = st;
//        String subject = "GST�α��� OTP��ȣ�Դϴ�.";
//        
//       
//        String body = opt.getMsg();
//         
//        
//        Properties props = System.getProperties();
//         
//         
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.port", port);
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.ssl.enable", "true");
//        props.put("mail.smtp.ssl.trust", host);
//          
//        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//            String un=username;
//            String pw=password;
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(un, pw);
//            }
//        });
//        session.setDebug(true); //for debug
//          
//        Message mimeMessage = new MimeMessage(session);
//        mimeMessage.setFrom(new InternetAddress("2c6829@naver.com"));
//        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
//        mimeMessage.setSubject(subject);
//        mimeMessage.setText(body);
//        Transport.send(mimeMessage);
//    }
	public NaverMailTest(String getemail) throws MessagingException{
		// TODO Auto-generated constructor stub
        // ���� ���� ����
        String host = "smtp.naver.com";
        final String username = "2c6829";
        final String password = "pp442200";
        int port=465;
         
        
        
        String deC_getemail = makedeString(getemail);
        
         opt =  new OTP();
        // ���� ����
        String st = deC_getemail;
        String recipient = st;
        String subject = "GST�α��� OTP��ȣ�Դϴ�.";
        String body = opt.getMsg();
         
        
        Properties props = System.getProperties();
         
         
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.trust", host);
          
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            String un=username;
            String pw=password;
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(un, pw);
            }
        });
        session.setDebug(true); //for debug
          
        Message mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress("2c6829@naver.com"));
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        mimeMessage.setSubject(subject);
        mimeMessage.setText(body);
        Transport.send(mimeMessage);
	}
	private String makedeString(String st) {
		Decrypt de = null;
		try { // ����Ʈ ��ȣȭ
			de = new Decrypt(st);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("��ȣȭ(pw����Ʈ)�� �� : " + de.getDeString());
		String desiteName = de.getDeString();
		return desiteName;
	}
}