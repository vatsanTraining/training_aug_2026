package com.example.demo.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.*;
public class InMemoryService implements TravelService {
	
	
	private List<TravelPackage> list;
	
	

	public InMemoryService() {
		super();
		
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
