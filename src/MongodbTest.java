import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * User: iivanovic
 * Date: 05.11.11.
 * Time: 10:28
 */
public class MongodbTest {
    public static void main(String[] args) {
        try {
            Mongo mongo = new Mongo("localhost", 27017);

            DB db = mongo.getDB("db");
            DBCollection collection = db.getCollection("collection");

            for (int i = 0; i < 100000; i++) {
                BasicDBObject document = new BasicDBObject();
                document.put("msg", "record No. " + i + ". hello world mongoDB in Java");
                collection.insert(document);
            }

            // search query
            BasicDBObject searchQuery = new BasicDBObject();
            for (Object o : searchQuery.values()) {
                System.out.println(o.toString());
            }

            // query it
            DBCursor cursor = collection.find(searchQuery);
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }


            System.out.println("records: " + collection.count());
            System.out.println("Done");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

}
