package com.example.demo;

import com.example.demo.ifaces.Function;

public class CurrencyConverter implements Function {

	@Override
	public double calculate(double inr) {
		return inr * 100;
	}

	
}
