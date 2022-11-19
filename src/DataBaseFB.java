import Resources.ClothesAmount;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

public class DataBaseFB{
    private static final String url = "https://washapp-1fe9f-default-rtdb.asia-southeast1.firebasedatabase.app/";

    static Firebase firebase;
    private static Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
    private static Map<String, Object> dataMap2 = new LinkedHashMap<String, Object>();
    private static Map<String, Object> dataMap3 = new LinkedHashMap<String, Object>();

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
            Vector<ClothesAmount> temp = new Vector<>();
            dataMap2.put("History",temp);
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
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        String type = (String) dataMap2.get("Type");
        return type;
    }

    //get customer data
    public static Customer getCustomerData(String username) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        Customer customer = (Customer) dataMap2.get("Customer");
        return customer;
    }

    //get worker data
    public static Worker getWorkerData(String username) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        Worker worker = (Worker) dataMap2.get("Worker");
        return worker;
    }

    //update customer data
    public static void updateCustomerData(String username, Customer customer) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        dataMap = new LinkedHashMap<String, Object>();
        dataMap.put( "Username", username );
        dataMap2 = new LinkedHashMap<String, Object>();
        dataMap2.put("Customer", customer);
        dataMap2.put("Type", "Customer");
        dataMap.put("Data", dataMap2);
        response = firebase.put( username, dataMap );
    }

    //update worker data
    public static void updateWorkerData(String username, Worker worker) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        dataMap = new LinkedHashMap<String, Object>();
        dataMap.put( "Username", username );
        dataMap2 = new LinkedHashMap<String, Object>();
        dataMap2.put("Worker", worker);
        dataMap2.put("Type", "Worker");
        dataMap.put("Data", dataMap2);
        response = firebase.put( username, dataMap );
    }

    //add clothesAmount to history
    public static void addHistory(String username, ClothesAmount clothesAmount) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        dataMap3 = (Map<String, Object>) dataMap2.get("Customer");
        Vector<ClothesAmount> history = (Vector<ClothesAmount>) dataMap3.get("History");
        history.add(clothesAmount);
        dataMap3.put("History", history);
        dataMap2.put("Customer", dataMap3);
        dataMap.put("Data", dataMap2);
        response = firebase.put( username, dataMap );
    }

    //get history
    public static Vector<ClothesAmount> getHistory(String username) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        dataMap3 = (Map<String, Object>) dataMap2.get("Customer");
        Vector<ClothesAmount> history = (Vector<ClothesAmount>) dataMap3.get("History");
        return history;
    }

    //find all exist username in database
    public static Vector<String> getAllUsername() throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get();
        dataMap = response.getBody();
        Vector<String> usernames = new Vector<>();
        for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
            usernames.add(entry.getKey());
        }
        return usernames;
    }

    //set customer status
    public static void setCustomerStatus(String username, String status) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        dataMap3 = (Map<String, Object>) dataMap2.get("Customer");
        dataMap3.put("Status", status);
        dataMap2.put("Customer", dataMap3);
        dataMap.put("Data", dataMap2);
        response = firebase.put( username, dataMap );
    }

    //get customer status
    public static String getCustomerStatus(String username) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        dataMap3 = (Map<String, Object>) dataMap2.get("Customer");
        String status = (String) dataMap3.get("Status");
        return status;
    }

    //set customer phone number
    public static void setPhoneNumber(String username, String phoneNumber) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        dataMap3 = (Map<String, Object>) dataMap2.get("Customer");
        dataMap3.put("PhoneNumber", phoneNumber);
        dataMap2.put("Customer", dataMap3);
        dataMap.put("Data", dataMap2);
        response = firebase.put( username, dataMap );
    }

    //set customer address
    public static void setAddress(String username, String address) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        dataMap3 = (Map<String, Object>) dataMap2.get("Customer");
        dataMap3.put("Address", address);
        dataMap2.put("Customer", dataMap3);
        dataMap.put("Data", dataMap2);
        response = firebase.put( username, dataMap );
    }

    //get customer address
    public static String getAddress(String username) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        dataMap3 = (Map<String, Object>) dataMap2.get("Customer");
        String address = (String) dataMap3.get("Address");
        return address;
    }

    //get customer name

}