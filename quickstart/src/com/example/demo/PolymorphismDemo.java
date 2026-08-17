package com.example.demo;

import com.example.demo.ifaces.Function;

public class PolymorphismDemo {

	
	public static void print(Function poly) {
		
		System.out.println(poly.calculate(50));
		
	}
	
	public static void main(String[] args) {

		
		print(new CurrencyConverter());
		print(new TempConverter());
	}

}
