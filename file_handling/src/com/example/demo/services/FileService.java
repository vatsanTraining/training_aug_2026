package com.example.demo.services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.TravelPackage;

public class FileService implements TravelService {

	
	@Override
	public boolean write(TravelPackage travel) {
		
		boolean isWritten = false;
		
		
		File file = new File("travel.txt");

		
		try(PrintWriter writer = new PrintWriter(new FileWriter(file, true));){
			
			
			writer.println(travel);
			
			isWritten =true;
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		return isWritten;
		
	}
	
	@Override
	public List<TravelPackage>  read() {
		
		
		File file = new File("travel.txt");

		List<TravelPackage> list = new ArrayList<>();
		
		
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			
			String line =null;
			
			while((line=reader.readLine())!=null){
				
				String[] values = line.split(",");
				
				TravelPackage obj = new TravelPackage(values[0], values[1]);
				
				list.add(obj);
				
			}
					
					
			
		}catch (Exception e) {

			e.printStackTrace();
		}
		
		return list;
	}
	
}
