import Resources.ClothesAmount;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

public class DataBaseFB{
    private static final String url = "https://washapp-1fe9f-default-rtdb.asia-southeast1.firebasedatabase.app/";

    static Firebase firebase;
    private static Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
    private static Map<String, Object> dataMap2 = new LinkedHashMap<String, Object>();
    private static Map<String, Object> dataMap3 = new LinkedHashMap<String, Object>();
    private static Map<String, Object> dataMap4 = new LinkedHashMap<String, Object>();

    static {
        try {
            firebase = new Firebase(url);
        } catch (FirebaseException e) {
            throw new RuntimeException(e);
        }
    }

    static FirebaseResponse response;

    public DataBaseFB() throws FirebaseException {}

    // create a new user and add to database
    public static void addNewUser(String username, String password, String type) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
        dataMap = new LinkedHashMap<String, Object>();
        dataMap.put( "Username", username );
        dataMap.put( "Password", password);
        dataMap2 = new LinkedHashMap<String, Object>();
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

    // check if user exists
    public static boolean checkUserPass(String username, String password) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
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
        dataMap = response.getBody();
        if(dataMap == null) {
            return null;
        }
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        if(dataMap2 == null) {
            return null;
        }
        return (String) dataMap2.get("Type");
    }

    //update customer data
    public static void updateCustomerData(String username, Customer customer) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        if(dataMap == null) {
            return;
        }
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        if(dataMap2 == null) {
            return;
        }
        dataMap2.put("Customer", customer);
        dataMap.put("Data", dataMap2);
        dataMap.put("Password", customer.getPassword());
        response = firebase.put( username, dataMap );
    }

    //update worker data
    public static void updateWorkerData(String username, Worker worker) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        if(dataMap == null) {
            return;
        }
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        if(dataMap2 == null) {
            return;
        }
        dataMap2.put("Worker", worker);
        dataMap.put("Data", dataMap2);
        dataMap.put("Password", worker.getPassword());
        response = firebase.put( username, dataMap );
    }

    //find all exist username in database
    public static Vector<String> getAllUsername() throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get();
        dataMap = response.getBody();
        Vector<String> temp = new Vector<>();
        for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
            temp.add(entry.getKey());
        }
        return temp;
    }

    //get customer name
    public static String getCustomerName(String username) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        return (String) dataMap.get("Username");
    }

    //get customer address
    public static String getCustomerAddress(String username) throws FirebaseException, UnsupportedEncodingException {
        response = firebase.get( username );
        dataMap = response.getBody();
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        dataMap3 = (Map<String, Object>) dataMap2.get("Customer");
        return (String) dataMap3.get("address");

    }
    //get customer phone
    public static String getCustomerPhone(String username) throws FirebaseException, UnsupportedEncodingException {
        response = firebase.get( username );
        dataMap = response.getBody();
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        dataMap3 = (Map<String, Object>) dataMap2.get("Customer");
        return (String) dataMap3.get("phone");
    }

    //get history
    public static Vector<ClothesAmount> getHistory(String username) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        return (Vector<ClothesAmount>) dataMap2.get("History");
    }

    //add clothesAmount to history
    public static void addHistory(String username, ClothesAmount temp, Customer customer) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        if(dataMap == null) {
            return;
        }
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        if(dataMap2 == null) {
            return;
        }
        dataMap2.put("History", DataBaseFB.makeVec(temp));
        dataMap.put("Data", dataMap2);
        dataMap.put("Username", customer.getName());
        dataMap.put("Password", customer.getPassword());
        response = firebase.put( username, dataMap );
    }

    public static int[] makeVec(ClothesAmount temp){
        int[] arr = new int[14];
        for (int i = 0; i < temp.getSize(); i++) {
            arr[i] = temp.printAmount(i);
        }
        return arr;
    }
}