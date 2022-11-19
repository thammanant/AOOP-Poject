package net.thegreshams.firebase4j.demo;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public class Demo {

	static Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
	static String firebase_baseUrl = "https://washapp-1fe9f-default-rtdb.asia-southeast1.firebasedatabase.app/";
	// create the firebase
	static Firebase firebase;

	static {
		try {
			firebase = new Firebase( firebase_baseUrl );
		} catch (FirebaseException e) {
			throw new RuntimeException(e);
		}
	}

	static FirebaseResponse response = null;

	public Demo() throws FirebaseException {}

	//put username and password on firebase
	public static void put(String username, String password) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {

		// "PUT" (test-map into a sub-node off of the fb4jDemo-root)
		dataMap = new LinkedHashMap<String, Object>();
		dataMap.put( "Username", username );
		dataMap.put( "Password", password);
		Map<String, Object> dataMap2 = new LinkedHashMap<String, Object>();
		dataMap2.put( "Sub-Key1", "This is the first sub-value" );
		dataMap.put( "Key_3", dataMap2 );
		response = firebase.put( "Customer", dataMap );

	}

	// "PUT" (test-map into the fb4jDemo-root)
//		Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
//		dataMap.put( "PUT-root", "This was PUT into the fb4jDemo-root" );
//		response = firebase.put( dataMap );
//		System.out.println( "\n\nResult of PUT (for the test-PUT to fb4jDemo-root):\n" + response );
//		System.out.println("\n");


	// "GET" (the fb4jDemo-root)
//		response = firebase.get();
//		System.out.println( "\n\nResult of GET:\n" + response );
//		System.out.println("\n");
	// "GET" (the test-PUT)
//		response = firebase.get( "test-PUT" );
//		System.out.println( "\n\nResult of GET (for the test-PUT):\n" + response );
//		System.out.println("\n");


	// "POST" (test-map into a sub-node off of the fb4jDemo-root)
//		response = firebase.post( "test-POST", dataMap );
//		System.out.println( "\n\nResult of POST (for the test-POST):\n" + response );
//		System.out.println("\n");

	//main
	public static void main(String[] args) throws FirebaseException, JacksonUtilityException, JsonParseException, JsonMappingException, IOException {
		put("username", "password");
	}
}




