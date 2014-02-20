package kimagure.showtrackermongo.core.response;

import java.util.List;
import kimagure.showtrackermongo.core.model.Show;

/**
 * Created with IntelliJ IDEA.
 * User: jwoo
 * Date: 2/19/14
 * Time: 7:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowsPayload {

    private List<Show> shows;

    public ShowsPayload() {
    }

    public ShowsPayload(List<Show> shows) {
        this.shows = shows;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

}
