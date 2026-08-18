package com.example.demo.services;

import com.example.demo.model.TravelPackage;

import java.util.*;

public interface TravelService {
   
	public boolean write(TravelPackage travel);
	public List<TravelPackage> read();
	
	
}

