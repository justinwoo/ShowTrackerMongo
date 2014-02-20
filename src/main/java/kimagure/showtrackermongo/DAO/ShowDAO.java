package kimagure.showtrackermongo.DAO;

import com.mongodb.DB;

/**
 * Created with IntelliJ IDEA.
 * User: jwoo
 * Date: 2/19/14
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowDAO {

    private DB database;

    public ShowDAO(DB database) {
        this.database = database;
    }


}
