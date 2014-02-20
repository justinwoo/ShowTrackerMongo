package kimagure.showtrackermongo.core.response;

import kimagure.showtrackermongo.core.model.Show;

/**
 * Created with IntelliJ IDEA.
 * User: jwoo
 * Date: 2/19/14
 * Time: 11:05 PM
 */
public class ShowPayload {

    private Show show;

    public ShowPayload() {
    }

    public ShowPayload(Show show) {
        this.show = show;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

}
