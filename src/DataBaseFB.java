import Resources.ClothesAmount;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

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
    //check if username already exists
    public static boolean checkUser(String username) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        return dataMap != null;
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

    //find all exist Customer usernames in database
public static List<String> findAllCustomerUsernames() throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        List<String> usernames = new ArrayList<>();
        response = firebase.get();
        dataMap = response.getBody();
        if(dataMap == null) {
            return usernames;
        }
        for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
            dataMap2 = (Map<String, Object>) entry.getValue();
            if(dataMap2 == null) {
                continue;
            }
            dataMap3 = (Map<String, Object>) dataMap2.get("Data");
            if(dataMap3 == null) {
                continue;
            }
            if(dataMap3.get("Type").equals("Customer")) {
                usernames.add(entry.getKey());
            }
        }
        return usernames;
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
    public static String getCustomerPhone(String username) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException  {
        response = firebase.get( username );
        dataMap = response.getBody();
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        dataMap3 = (Map<String, Object>) dataMap2.get("Customer");
        return (String) dataMap3.get("phone");
    }
    //get worker name
    public static String getWorkerName(String username) throws  FirebaseException,UnsupportedEncodingException{
        response = firebase.get(username);
        dataMap = new LinkedHashMap<>();
        dataMap = response.getBody();
        return (String) dataMap.get("Username");
    }

    //get worker phone
    public static String getWorkerPhone(String username) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException  {
        response = firebase.get( username );
        dataMap = response.getBody();
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        dataMap3 = (Map<String, Object>) dataMap2.get("Worker");
        return (String) dataMap3.get("phone");
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
        int[] arr = new int[16];
        int sum = 0;
        for(int i = 0; i < customer.getClothes().getSize(); i++) {
            arr[i] = temp.printAmount(i);
            sum += arr[i];
        }
        arr[14] = sum;
        arr[15] = -1;
        int size = DataBaseFB.getHistoryAmount(username) + 1;
        dataMap2.put("Order" + size, arr);
        dataMap.put("Data", dataMap2);
        dataMap.put("Username", customer.getName());
        dataMap.put("Password", customer.getPassword());
        response = firebase.put( username, dataMap );

    }
    //set arr[15] = -2
    public static void setHistoryStatus(String username, int index, int x) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        if(dataMap == null) {
            return;
        }
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        if(dataMap2 == null) {
            return;
        }
        int[] arr = new int[16];
        int sum = 0;
        for(int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(Objects.requireNonNull(DataBaseFB.getHistory(username, index)).get(i));
            sum += arr[i];
        }
        arr[14] = sum;
        arr[15] = x;

        dataMap2.put("Order" + index, arr);
        dataMap.put("Data", dataMap2);
        response = firebase.put( username, dataMap );

    }

    public static List<String> getHistory(String username, int index) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException
    {
        response = firebase.get( username );
        dataMap = response.getBody();
        if(dataMap == null) {
            return null;
        }
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        if(dataMap2 == null) {
            return null;
        }
        String temp = dataMap2.get("Order" + index).toString();
        assert temp != null;
        temp = temp.substring(1, temp.length() - 1);
        String[] temp2 = temp.split(",");
        // remove space
        List<String> arrayOfHistory = new ArrayList<>();
        for (String s : temp2) {
            arrayOfHistory.add(s.trim());
        }
        return arrayOfHistory;
    }

    //get history amount
    public static int getHistoryAmount(String username) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
        response = firebase.get( username );
        dataMap = response.getBody();
        if(dataMap == null) {
            return 0;
        }
        dataMap2 = (Map<String, Object>) dataMap.get("Data");
        if(dataMap2 == null) {
            return 0;
        }
        return dataMap2.size() - 2;
    }
}