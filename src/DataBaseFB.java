import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataBaseFB{
    private static final String url = "https://washapp-1fe9f-default-rtdb.asia-southeast1.firebasedatabase.app/";

    static Firebase firebase;

    static {
        try {
            firebase = new Firebase(url);
        } catch (FirebaseException e) {
            throw new RuntimeException(e);
        }
    }

    static FirebaseResponse response;

    public DataBaseFB() throws FirebaseException {}

    // put
    public static void put(String username, String password, String type) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
        dataMap = new LinkedHashMap<String, Object>();
        dataMap.put( "Username", username );
        dataMap.put( "Password", password);
        Map<String, Object> dataMap2 = new LinkedHashMap<String, Object>();
        if(type.equals("Customer")) {
            dataMap2.put("Customer", new Customer());
            dataMap2.put("Type", "Customer");
        }
        else if(type.equals("Worker")) {
            dataMap2.put("Worker", new Worker());
            dataMap2.put("Type", "Worker");
        }
        dataMap.put("Data", dataMap2);
        response = firebase.put( username, dataMap );
    }

    public static boolean checkUserPass(String username, String password) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        Map<String, Object> dataMap = response.getBody();
        if (dataMap == null) {
            return false;
        }
        String pass = (String) dataMap.get("Password");
        if (pass == null) {
            return false;
        }
        return pass.equals(password);
    }

    //check if user is customer or worker
    public static String checkType(String username) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        //get type in data map
        response = firebase.get( username );
        Map<String, Object> dataMap = response.getBody();
        Map<String, Object> dataMap2 = (Map<String, Object>) dataMap.get("Data");
        String type = (String) dataMap2.get("Type");
        return type;
    }

}