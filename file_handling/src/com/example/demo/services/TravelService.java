package com.example.demo.services;

import java.io.File;
import java.util.List;

import com.example.demo.TravelPackage;

public interface TravelService {
   
	public boolean write(TravelPackage travel);
	public List<TravelPackage> read();
	
	
}