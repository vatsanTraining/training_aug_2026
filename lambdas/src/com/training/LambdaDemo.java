package com.training;

import java.util.List;
import java.util.function.Consumer;

public class LambdaDemo {

	public static void main(String[] args) {
	
		
		List<String> list = List.of("Ram","Shyam","Shiv","Sandeep","Vikas");
		
		
		//Consumer<String> cons = (e)-> System.out.println(e);
		
		
		//list.forEach(cons);
		
		
		list.forEach(System.out::println);
		
		list.forEach((e)->System.out.println(e));
		
		
		
		
	}

}
