package kimagure.showtrackermongo.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.yammer.dropwizard.lifecycle.Managed;

/**
 * Created with IntelliJ IDEA.
 * User: jwoo
 * Date: 2/19/14
 * Time: 7:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class MongoManaged implements Managed {

    private MongoClient mongoClient;
    private DB database;

    public MongoManaged(String host, int port, String database) throws Exception {
        mongoClient = new MongoClient(host, port);
        mongoClient.getDB(database);
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public DB getDatabase() {
        return database;
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {
        mongoClient.close();
    }

}
