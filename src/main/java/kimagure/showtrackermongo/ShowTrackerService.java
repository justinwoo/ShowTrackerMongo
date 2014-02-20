package kimagure.showtrackermongo;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import kimagure.showtrackermongo.DAO.ShowDAO;
import kimagure.showtrackermongo.health.MongoHealthCheck;
import kimagure.showtrackermongo.mongo.MongoManaged;
import kimagure.showtrackermongo.resources.ShowTrackerResource;

/**
 * Created with IntelliJ IDEA.
 * User: jwoo
 * Date: 2/19/14
 * Time: 7:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowTrackerService extends Service<ShowTrackerConfiguration> {

    public static void main(String[] args) throws Exception {
        new ShowTrackerService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ShowTrackerConfiguration> bootstrap) {
        bootstrap.setName("showtracker-mongo");
        bootstrap.addBundle(new AssetsBundle("/assets", "/"));
    }

    @Override
    public void run(ShowTrackerConfiguration configuration, Environment environment) throws Exception {
        MongoManaged mongoManaged = new MongoManaged(configuration.mongoHost, configuration.mongoPort, configuration.mongoDB);
        environment.manage(mongoManaged);
        environment.addHealthCheck(new MongoHealthCheck(mongoManaged.getMongoClient()));
        ShowDAO showDAO = new ShowDAO(mongoManaged.getDatabase(), configuration.mongoCollection);
        environment.addResource(new ShowTrackerResource(showDAO));
    }

}
