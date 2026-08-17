package com.example.demo;

import java.io.File;
import java.util.List;

import com.example.demo.exceptions.InvalidCodeException;
import com.example.demo.services.FileService;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		var ooty = new TravelPackage();
		
	
		ooty.setClientName("Harish");
		try {
			ooty.setDestination("CBE");
		} catch (InvalidCodeException e) {
			e.printStackTrace();
		} catch(NullPointerException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println(ooty.getFees());
		
//		System.out.println(ooty.getClientName());
//		System.out.println(ooty.getDestination());
//		
		System.out.println(ooty.toString());
		
		
		var turkey =new LuxuryPackage("Karthick","CJT", true);
		
		System.out.println(turkey.getFees());
		
		File file = new File("travel.txt");
		FileService service = new FileService();
		
		System.out.println("Is Written :=>"+ service.writeToFile(file, turkey));
		
		
		List<TravelPackage> list = service.readFromFile(file);
		
		for(TravelPackage eachPackage: list) {
			
			System.out.println(eachPackage);
		}
	}

}
