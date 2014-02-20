package kimagure.showtrackermongo.health;

import com.mongodb.MongoClient;
import com.yammer.metrics.core.HealthCheck;

/**
 * Created with IntelliJ IDEA.
 * User: jwoo
 * Date: 2/19/14
 * Time: 8:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class MongoHealthCheck extends HealthCheck {

    private MongoClient mongoClient;

    public MongoHealthCheck(MongoClient mongoClient) {
        super("MongoDBHealthCheck");
        this.mongoClient = mongoClient;
    }

    @Override
    protected Result check() throws Exception {
        mongoClient.getDatabaseNames();
        return Result.healthy();
    }

}
