package psat.server.session;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import psat.client.session.ClientServerBroker;
import psat.server.PSatAPI;
import psat.shared.ConfigInstance;

public class Config {
	
	public static boolean emptySerialisedContent(String sessionid){
		boolean done1 = false;
		boolean done2 = false;
		String fileName2 = PSatAPI.datastore_file_path+"/"+sessionid+"/config/lastSourceAgentName.ser";	
		
		File file = new File(fileName2);
		if(file.delete()){
			done1 = true;
//			ClientServerBroker.messageEvent("updateLogPage", file.getName() + " is deleted!"+"₦"+false,null,null);
		}else{
//			ClientServerBroker.messageEvent("updateLogPage", "Delete operation failed."+"₦"+true,null,null);
		}
		
		fileName2 = PSatAPI.datastore_file_path+"/"+sessionid+"/config/lastTargetAgentName.ser";	
		file = new File(fileName2);
		if(file.delete()){
			done2 = true;
			System.out.println(file.getName() + " is deleted!");
		}else{
//			ClientServerBroker.messageEvent("updateLogPage", "Delete operation failed."+"₦"+true,null,null);
		}
		if(done1 && done2){
			return true;
		}
		else{
			return false;
		}

	}
		
	public static ConfigInstance deserialiseConfigInstance(String sessionid){
		String fileName2 = PSatAPI.datastore_file_path+"/"+sessionid+"/config/configInstance.ser";
		ConfigInstance instance = null;
		
		try {
			File file = new File(fileName2);

			if(file.exists()){
				FileInputStream fileIn = new FileInputStream(file);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				instance = (ConfigInstance) in.readObject();
				in.close();
				fileIn.close();			
			}
			
		} 
		catch (IOException i) {
			System.err.println("IO exception @readProcessedPossibleWorldsPaths");
		} 
		catch (ClassNotFoundException c) {
			System.err.println("String class not found");
		}
		finally{
			
		}
		
		return instance;
	}
	
	public static boolean serialiseConfigInstance(String sessionid, ConfigInstance instance){
		if(PSatAPI.datastore_file_path ==null){
			return false;
		}
				
		String folderName1 = PSatAPI.datastore_file_path;
		String folderName2 = PSatAPI.datastore_file_path+"/"+sessionid;
		String folderName3 = PSatAPI.datastore_file_path+"/"+sessionid+"/config";
		String fileName2 = PSatAPI.datastore_file_path+"/"+sessionid+"/config/configInstance.ser";	
		
		try{			
			File folder1 = new File(folderName1);
			boolean exist1 = false;
			if(folder1.exists()){
				if(folder1.isDirectory()){
					exist1 = true;
				}				
			}
			if(!exist1){
				folder1.mkdir();
			}			
	
			File folder2 = new File(folderName2);
			boolean exist2 = false;
			if(folder2.exists()){
				if(folder2.isDirectory()){
					exist2 = true;
				}				
			}
			if(!exist2){
				folder2.mkdir();
			}
			
			File folder3 = new File(folderName3);
			boolean exist3 = false;
			if(folder3.exists()){
				if(folder3.isDirectory()){
					exist3 = true;
				}				
			}
			if(!exist3){
				folder3.mkdir();
			}
								
			File if_file = new File(fileName2);
	        if(if_file.exists()){
	         if_file.delete();
	        }
	        if_file.createNewFile();
	        FileOutputStream fileOut = new FileOutputStream(fileName2);
	        ObjectOutputStream out = new ObjectOutputStream(fileOut);
	        out.writeObject(instance);
	        out.close();
	        fileOut.close();	         
	      }
		catch(IOException i){
	          i.printStackTrace();
	    }
		
		return true;
	}
	
	public static ServerConfigInstance deserialiseServerConfigInstance(String sessionid){
		String fileName2 = PSatAPI.datastore_file_path+"/"+sessionid+"/config/serverConfigInstance.ser";
		ServerConfigInstance instance = null;
		
		try {
			File file = new File(fileName2);

			if(file.exists()){
				FileInputStream fileIn = new FileInputStream(file);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				instance = (ServerConfigInstance) in.readObject();
				in.close();
				fileIn.close();			
			}
			
		} 
		catch (IOException i) {
			System.err.println("IO exception @readProcessedPossibleWorldsPaths");
		} 
		catch (ClassNotFoundException c) {
			System.err.println("String class not found");
		}
		finally{
		}
		
		return instance;
	}
	
	public static boolean serialiseServerConfigInstance(String sessionid, ServerConfigInstance instance){
		if(PSatAPI.datastore_file_path ==null){
			return false;
		}
		if(instance.sessionid == null){
			instance.sessionid = sessionid;
		}
		String folderName1 = PSatAPI.datastore_file_path;
		String folderName2 = PSatAPI.datastore_file_path+"/"+sessionid;
		String folderName3 = PSatAPI.datastore_file_path+"/"+sessionid+"/config";
		String fileName2 = PSatAPI.datastore_file_path+"/"+sessionid+"/config/serverConfigInstance.ser";	
		
		try{			
			File folder1 = new File(folderName1);
			boolean exist1 = false;
			if(folder1.exists()){
				if(folder1.isDirectory()){
					exist1 = true;
				}				
			}
			if(!exist1){
				folder1.mkdir();
			}			
	
			File folder2 = new File(folderName2);
			boolean exist2 = false;
			if(folder2.exists()){
				if(folder2.isDirectory()){
					exist2 = true;
				}				
			}
			if(!exist2){
				folder2.mkdir();
			}
			
			File folder3 = new File(folderName3);
			boolean exist3 = false;
			if(folder3.exists()){
				if(folder3.isDirectory()){
					exist3 = true;
				}				
			}
			if(!exist3){
				folder3.mkdir();
			}
								
			File if_file = new File(fileName2);
	        if(if_file.exists()){
	         if_file.delete();
	        }
	        if_file.createNewFile();
	        FileOutputStream fileOut = new FileOutputStream(fileName2);
	        ObjectOutputStream out = new ObjectOutputStream(fileOut);
	        out.writeObject(instance);
	        out.close();
	        fileOut.close();	         
	      }
		catch(IOException i){
	          i.printStackTrace();
	    }
		
		return true;
	}
	
	public static void deserialiseProcessPossibleWorldsPathToFile(ConfigInstance sinstance){
		String fileName2 = PSatAPI.datastore_file_path+"/"+sinstance.sessionid+"/config/processedpaths.ser";
		try {
			File file = new File(fileName2);
			if(file.exists()){
				FileInputStream fileIn = new FileInputStream(file);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				String [] processedPossibleWorldsPaths = (String []) in.readObject();
				
				if(processedPossibleWorldsPaths !=null){
					sinstance.processedPossibleWorldsPaths = processedPossibleWorldsPaths;
					
					Properties ppties = new Properties();
					ppties.setProperty("instanceproperty", "processedPossibleWorldsPaths");
					ClientServerBroker.messageEvent("PSatClient.ConfigInstanceUpdateRequest()", null, ppties, processedPossibleWorldsPaths);
					
				}
				in.close();
				fileIn.close();			
			}
			
		} 
		catch (IOException i) {
			System.err.println("IO exception @readProcessedPossibleWorldsPaths");
		} 
		catch (ClassNotFoundException c) {
			System.err.println("String class not found");
		}
		finally{
			
		}
	}
}
