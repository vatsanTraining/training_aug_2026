package com.example.demo;

import com.example.demo.exceptions.InvalidCodeException;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		var ooty = new TravelPackage();
		
	
		ooty.setClientName("Harish");
		try {
			ooty.setDestination("CBI");
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
		
		
		var turkey =new LuxuryPackage("Harish","CBE", true);
		
		System.out.println(turkey.getFees());
		
	}

}
