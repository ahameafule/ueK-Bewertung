package ch.noseryoung.uekbewertung.webContext.domain.mailsending;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lohse
 * This class takes the needed properties to be able to send a mail at the user
 * when a rating was created for him/her
 *
 */

@Component(value = "send a email")
public class MailSender {

	@RequestMapping(value = "/sendemail")
	public String sendEmail(String mailto) throws AddressException, MessagingException, IOException {
		sendmail(mailto);
		return "Email sent successfully";
	}
	
	/**
	 * 
	 * @param mailto
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws IOException
	 */
	private void sendmail(String mailto) throws AddressException, MessagingException, IOException {
		
		//Puts all needed properties
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				
				//sender account
				return new PasswordAuthentication("pablodumboescobar@gmail.com", "Skankhunt42");
			}
		});
		
		Message msg = new MimeMessage(session);
		
		//Sender of the email 
		msg.setFrom(new InternetAddress("pablodumboescobar@gmail.com", false));
		
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailto));
		
		//Title of the email
		msg.setSubject("Best\u00E4tigungsmail \u00fcK");
		msg.setSentDate(new Date());
		
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		//Message input
		messageBodyPart.setContent("Deine \u00fcK-Bewertung wurde erstellt", "text/html");
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		msg.setContent(multipart);
		Transport.send(msg);
	}
}
