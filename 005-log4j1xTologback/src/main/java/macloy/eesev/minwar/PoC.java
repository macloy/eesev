package macloy.eesev.minwar;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("test")
@RequestScoped
public class PoC {
   
    @Inject
    private HttpServletRequest request;
    
    /**
     * In a standdard local Servlet-Container call it with:
     * 
     * http://localhost:8080/005-log4j1xTologback/resources/test
     * 
     * @return 
     */
    @GET
    public String show() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("Hello PoC");
        logger.error("Error Hello PoC");
        
        
        return "PoC show works.";
    }
}

