package Controller;

import Entity.DummyData;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

import java.util.Random;

/**
 * Created by kim.flaethe on 20.03.2015.
 */
public class DatabaseController {

    private int number;

    public Response addToDatabase(CouchDbClient dbClient){
        Random rand = new Random();
        number = rand.nextInt((1000) + 1);

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("data", "Some data");
            jsonObject.addProperty("name", "Some name");
            return dbClient.save(jsonObject);
    }

    public String removeDocument(CouchDbClient dbClient, String id){

        try {
            DummyData dummyData = new DummyData();
            dummyData = dbClient.find(DummyData.class, id);


            dbClient.remove(dummyData);

            return "Dummydata deleted";
        } catch (Exception e){
            e.printStackTrace();
            return "Could not delete document with id: " + id;
        }
    }
}
