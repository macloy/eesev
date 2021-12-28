package macloy.eesev.minwar;


import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.apache.log4j.Logger;

@Path("test")
@RequestScoped
public class PoC {
   
    
    /**
     * In a standdard local Servlet-Container call it with:
     * 
     * http://localhost:8080/004-log4j1x/resources/test
     * 
     * @return 
     */
    @GET
    public String show() {
        Logger  logger = Logger.getLogger(PoC.class);
        //Logger logger = LoggerFactory.getLogger(PoC.class);
        logger.debug("Hello PoC Debug");
        logger.info("Hello PoC Info");
        logger.warn("Hello PoC Warn");
        logger.error("Hello PoC Erro");
        
        
        return "PoC show() works.";
    }
}

