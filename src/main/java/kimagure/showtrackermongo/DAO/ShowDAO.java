package kimagure.showtrackermongo.DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import kimagure.showtrackermongo.core.model.Show;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: jwoo
 * Date: 2/19/14
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowDAO {

    private DB database;
    private String collection;

    public ShowDAO(DB database, String collection) {
        this.database = database;
        this.collection = collection;
    }

    public Show findById(String queryId) {
        BasicDBObject query = new BasicDBObject("id", queryId);
        DBObject result = database.getCollection(collection).findOne(query);
        return createShowFromDBObject(result);
    }

    public List<Show> findAll() {
        DBCursor results = database.getCollection(collection).find();
        List<Show> shows = new ArrayList<>();
        for (DBObject result : results) {
            shows.add(createShowFromDBObject(result));
        }
        return shows;
    }

    public void persist(Show show) {
        BasicDBObject newDoc = createBasicDBObjectFromShow(show);
        database.getCollection(collection).insert(newDoc);
    }

    public void delete(String queryId) {
        BasicDBObject query = new BasicDBObject("id", queryId);
        database.getCollection(collection).remove(query);
    }

    public void update(String queryId, Show partialShow) {
        BasicDBObject query = new BasicDBObject("id", queryId);
        BasicDBObject update = new BasicDBObject("id", queryId)
                                         .append("title", partialShow.getTitle())
                                         .append("episode", partialShow.getEpisode());
        database.getCollection(collection).update(query, update);
    }

    private Show createShowFromDBObject(DBObject result) {
        String id = (String) result.get("id");
        String title = (String) result.get("title");
        Integer episode = (Integer) result.get("episode");
        return new Show(id, title, episode);
    }

    private BasicDBObject createBasicDBObjectFromShow(Show show) {
        BasicDBObject doc = new BasicDBObject("id", show.getId())
                                .append("title", show.getTitle())
                                .append("episode", show.getEpisode());
        return doc;
    }


}
