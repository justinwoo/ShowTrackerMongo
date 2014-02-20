package kimagure.showtrackermongo.resources;

import com.yammer.metrics.annotation.Timed;
import kimagure.showtrackermongo.DAO.ShowDAO;
import kimagure.showtrackermongo.core.model.Show;
import kimagure.showtrackermongo.core.response.ShowPayload;
import kimagure.showtrackermongo.core.response.ShowsPayload;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jwoo
 * Date: 2/19/14
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ShowTrackerResource {

    private ShowDAO showDAO;

    public ShowTrackerResource(ShowDAO showDAO) {
        this.showDAO = showDAO;
    }

    @GET
    @Timed
    @Path("/shows")
    public ShowsPayload getAllShows() {
        List<Show> shows = showDAO.findAll();
        return new ShowsPayload(shows);
    }

    @GET
    @Timed
    @Path("/shows/{id}")
    public ShowPayload getShowById(@PathParam("id") String id) {
        Show show = showDAO.findById(id);
        return new ShowPayload(show);
    }

    @PUT
    @Timed
    @Path("/shows/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putShow(@PathParam("id") String id, ShowPayload showPayload) {
        showDAO.update(id, showPayload.getShow());
    }

    @DELETE
    @Timed
    @Path("/shows/{id}")
    public void deleteShow(@PathParam("id") String id) {
        showDAO.delete(id);
    }

    @POST
    @Timed
    @Path("/shows")
    @Consumes(MediaType.APPLICATION_JSON)
    public void postShow(ShowPayload showPayload) {
        showDAO.persist(showPayload.getShow());
    }


}
