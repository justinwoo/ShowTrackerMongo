package kimagure.showtrackermongo.model.response;

import java.util.List;
import kimagure.showtrackermongo.model.Show;

/**
 * Created with IntelliJ IDEA.
 * User: jwoo
 * Date: 2/19/14
 * Time: 7:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowsResponse {
    private List<Show> shows;

    public ShowsResponse() {
    }

    public ShowsResponse(List<Show> shows) {
        this.shows = shows;
    }
}
