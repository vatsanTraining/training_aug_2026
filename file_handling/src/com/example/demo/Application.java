package com.example.demo;

import java.util.List;

import com.example.demo.exceptions.InvalidCodeException;
import com.example.demo.services.FileService;
import com.example.demo.services.InMemoryService;
import com.example.demo.services.TravelService;

public class Application {

	
	public static void print(TravelService service) {
		
		System.out.println("Printing Using =>"+service.getClass().getName());

		List<TravelPackage> list = service.read();
		
		for(TravelPackage eachPackage: list) {
			
			System.out.println(eachPackage);
		}
		
	}
	
	public static void main(String[] args) {
		
		

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
		
		FileService service = new FileService();
		
		System.out.println("Is Written :=>"+ service.write(turkey));
		
		
		print(service);
		
		InMemoryService memservice = new InMemoryService();
		
		
		memservice.write(turkey);
		memservice.write(ooty);
		
		
		print(memservice);
	}

}
