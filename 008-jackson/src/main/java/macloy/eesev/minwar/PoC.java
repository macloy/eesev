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
     * http://localhost:8080/008-jackson/resources/test
     * 
     * @return 
     */
    @GET
    public String show() {
        System.out.println("Jackson test");

        return "Jackson test: show";
    }

}

