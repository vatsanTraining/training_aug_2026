package com.example.demo;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TravelPackage ooty = new TravelPackage();
	
		ooty.setClientName("Harish");
		ooty.setDestination("CBE");
		
		System.out.println(ooty.getFees());
		
//		System.out.println(ooty.getClientName());
//		System.out.println(ooty.getDestination());
//		
		System.out.println(ooty.toString());
		
		
		LuxuryPackage turkey =new LuxuryPackage("Harish","CBE", true);
		
		System.out.println(turkey.getFees());
		
	}

}
