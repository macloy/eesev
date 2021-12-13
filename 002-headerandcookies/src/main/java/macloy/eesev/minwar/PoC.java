package macloy.eesev.minwar;


import java.util.Enumeration;
import java.util.StringJoiner;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
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
     * http://localhost:8080/002-headerandcookies/resources/test
     * 
     * @return 
     */
    @GET
    public String show() {
        StringJoiner sj = new StringJoiner("<br/>");
        
        String rawCookie = request.getHeader("Cookie");
        sj.add("Raw Cookies:");
        sj.add(rawCookie);
        
        sj.add("Cookies:");
        Cookie[] cookies = request.getCookies();
        for (Cookie aCookie : cookies) {
            sj.add(aCookie.getName()+"="+aCookie.getValue()+";");
        }
        
        sj.add("------------------------- HEADERS -------------------");
        
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            sj.add(key+"="+request.getHeader(key)+";");
        }
        
        return sj.toString();
    }
}

