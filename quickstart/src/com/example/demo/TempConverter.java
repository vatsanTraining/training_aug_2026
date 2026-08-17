package com.example.demo;

import com.example.demo.ifaces.Function;

public class TempConverter implements Function {

	@Override
	public double calculate(double faren) {

		return faren*200;
	}

	
	
}
