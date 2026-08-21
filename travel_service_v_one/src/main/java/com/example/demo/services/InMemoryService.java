package com.example.demo.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.*;

@Service
//@Primary
public class InMemoryService implements TravelService {
	
	
	private List<TravelPackage> list;
	
	

	public InMemoryService() {
		super();
		
		System.out.println("$$$$$$   In Memory Service Called");
		this.list = new ArrayList<>();
	}

	@Override
	public boolean write(TravelPackage travel) {
		return list.add(travel);
	}

	@Override
	public List<TravelPackage> read() {
		return list;
	}

}
