package macloy.eesev.minwar;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
@RequestScoped
public class MinWar {
   
    @Inject
    private HttpServletRequest request;
    
    /**
     * In a standdard local Servlet-Container call it with:
     * 
     * http://localhost:8080/001-minwar/resources/test
     * 
     * @return 
     */
    @GET
    public String show() {
        return "MinWar test works.";
    }
}

