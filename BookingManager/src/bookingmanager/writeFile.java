package saveFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/* # @author Tony - s3439530 */
public class writeFile {
	
	public void writecustomerJSON (List<User> data, FileWriter fileWriter, int instances) {
		try {
			fileWriter.write("[");
			int counter = 0;
			
			for(int i = 0;i < data.size(); i++) {
				/* # Iterate through given HashMap for each User. 
				 * # We will save the users as Uid + x, where x is the order it was added */
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				User user = data.get(i);
				/* */
				if(user instanceof Customer) {
					String json = gson.toJson(user);
					fileWriter.write(json);
					counter++;
					if(!(counter==instances)) {
						fileWriter.write(", ");
					}
				}			
				/* */				
				fileWriter.flush();
			}
			fileWriter.write("]");
			fileWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writebusinessJSON (List<User> data, FileWriter fileWriter, int instances) {
		try {
			fileWriter.write("[");
			int counter = 0;
			
			for(int i = 0;i < data.size(); i++) {
				/* # Iterate through given HashMap for each User. 
				 * # We will save the users as Uid + x, where x is the order it was added */
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				User user = data.get(i);
				/* */
				if(user instanceof Business) {
					String json = gson.toJson(user);
					fileWriter.write(json);
					counter++;
					if(!(counter==instances)) {
						fileWriter.write(", ");
					}
				}			
				/* */				
				fileWriter.flush();
			}
			fileWriter.write("]");
			fileWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writetoFile(List<User> data) {
		
		/* # Structure of Data Limitation; Resolve by using two files.
		 * # customer.json : Store all customer users 
		 * # business.json : Store all business users */
		try {
			//Check for file, generate if not found...
			File customerFile = new File("customerDatabase.json");
			File businessFile = new File("businessDatabase.json");
			
			/* # Existence checks of files... */
			if(!customerFile.exists()) {
				customerFile.createNewFile();
			}
			if(!businessFile.exists()) {
				businessFile.createNewFile();
			}
			
			FileWriter fileWriter = new FileWriter(customerFile);
			writecustomerJSON(data, fileWriter, countInstancesOfCustomers(data));
			
			fileWriter = new FileWriter(businessFile);
			writebusinessJSON(data, fileWriter, countInstancesOfBusiness(data));


			
			/* Write File Test */
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/* # Utility Methods */
	
	public int countInstancesOfBusiness(List<User> data) {
		
		/* # Given an abstract Array, find the amount of Business Users */
		int count = 0;
		for(int i = 0 ; i < data.size() ; i++ ) {		
			User user = data.get(i);
			if(user instanceof Business) {
				count++;
			}
		}	
		return count;
	}
	
	public int countInstancesOfCustomers(List<User> data) {
		
		/* # Given an abstract Array, find the amount of Business Users */
		int count = 0;
		for(int i = 0 ; i < data.size() ; i++ ) {		
			User user = data.get(i);
			if(user instanceof Customer) {
				count++;
			}
		}	
		return count;
	}

}
