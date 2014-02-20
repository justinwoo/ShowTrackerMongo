package kimagure.showtrackermongo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created with IntelliJ IDEA.
 * User: jwoo
 * Date: 2/19/14
 * Time: 7:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowTrackerConfiguration extends Configuration {

    @JsonProperty
    public String mongoHost = "localhost";

    @JsonProperty
    @Min(1)
    @Max(65535)
    public int mongoPort = 27017;

    @JsonProperty
    public String mongoDB = "showtracker";

}
