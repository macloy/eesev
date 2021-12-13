package macloy.eesev.minwar;


import java.util.Properties;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
@RequestScoped
public class PoC {
   
    @Inject
    private HttpServletRequest request;
    
    /**
     * In a standdard local Servlet-Container call it with:
     * 
     * http://localhost:8080/003-mailproblems/resources/test
     * 
     * @return 
     */
    @GET
    public String show() {
        System.out.println("Mail test");

        String host = "myhost.de";
        String myAccount = "myaccountname";
        String myPassword = "****";
        String sender = "from@my.server";
        String recipient = "tomy@frien.ds";
        String subject = "Test Test";
        String text = "Text Text";
        
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        //properties.put("mail.smtp.port", "587");        
        //properties.put("mail.debug", "true");
        

        
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, myPassword);
            }
        });
        session.setDebug(true);
        
        
        try {
            Message message = prepareMessage(session, sender, recipient, subject, text);
            Transport.send(message);
            System.out.println("E-Mail sended! ");
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return " Mail sended";
    }

    
    private static Message prepareMessage(Session session, String sender, String recipient, String subject, String text ) throws Exception {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setSubject(subject);
        Multipart multipart = new MimeMultipart();
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(text);
        multipart.addBodyPart(messageBodyPart);
        message.setContent(multipart);
        return message;
    }
}

