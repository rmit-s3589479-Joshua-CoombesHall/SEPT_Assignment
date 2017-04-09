package bookingmanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class readFile {
	
	private static final Type USER_TYPE = new TypeToken<List<User>>() {}.getType();
	private static final Type CUSTOMER_TYPE = new TypeToken<List<Customer>>() {}.getType();
	private static final Type BUSINESS_TYPE = new TypeToken<List<Business>>() {}.getType();
	
	public List<Customer> loadCustomers() {
		List<Customer> customers = new ArrayList<>();
		
		File file = new File("customerDatabase.json");
		System.out.println("# Loading Customers #");
		try {
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new FileReader(file));		
			customers = gson.fromJson(reader, CUSTOMER_TYPE);
			
			for(int i = 0 ; i < customers.size(); i ++ ) {
				System.out.println(customers.get(i).getFirstName());
			}
			System.out.println(customers);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return customers;	
	}
	
	public List<Business> loadBusiness() {
		List<Business> businesses = new ArrayList<>();
		
		File file = new File("businessDatabase.json");
		System.out.println("# Loading Businesses #");
		try {
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new FileReader(file));		
			businesses = gson.fromJson(reader, BUSINESS_TYPE);
			
			for(int i = 0 ; i < businesses.size(); i ++ ) {
				System.out.println(businesses.get(i).getName());
			}
			System.out.println(businesses);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		
		return businesses;
	}
	
	public ArrayList<User> readFromFile() {
      ArrayList<User> jointArray = new ArrayList();
      jointArray.addAll(loadCustomers());
      jointArray.addAll(loadBusiness());

		return jointArray;
	}

}
