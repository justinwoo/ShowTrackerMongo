package kimagure.showtrackermongo.resources;

import com.yammer.metrics.annotation.Timed;
import kimagure.showtrackermongo.DAO.ShowDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: jwoo
 * Date: 2/19/14
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class ShowTrackerResource {

    private ShowDAO showDAO;

    public ShowTrackerResource(ShowDAO showDAO) {
        this.showDAO = showDAO;
    }

    @GET
    @Timed
    public String sayHello() {
        return "hello\n";
    }

}
