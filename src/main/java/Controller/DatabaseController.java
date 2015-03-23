package Controller;

import Entity.DummyData;
import com.google.gson.JsonObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

import java.util.Random;

/**
 * Created by kim.flaethe on 20.03.2015.
 */
public class DatabaseController {

    private int number;

    public Response addToDatabase(CouchDbClient dbClient) {
        Random rand = new Random();
        number = rand.nextInt((1000) + 1);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("data", "Some data");
        jsonObject.addProperty("name", "Some name");
        return dbClient.save(jsonObject);
    }

    public Response removeDocument(CouchDbClient dbClient, String id) {

        DummyData dummyData = new DummyData();
        dummyData = dbClient.find(DummyData.class, id);

        return dbClient.remove(dummyData);
    }
}
