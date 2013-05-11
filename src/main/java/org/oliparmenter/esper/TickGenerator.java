package org.oliparmenter.esper;

import java.util.Random;

import org.joda.time.DateTime;


public class TickGenerator {

	private Random rn;
	private double last = 1.5;
	
	public TickGenerator(){
		rn = new Random();
	}
	
	public Tick getTick(){
		
		double mid = getRandom();
		Tick t = new Tick( mid, DateTime.now() );
		
		return t;
	}
	
	private double getRandom(){
		
		double max = last + 0.2;
		double min = last - 0.2;
		
		double n = max - min + 1;
		double i = rn.nextDouble() % n;
		double randomNum = min + i;
		return randomNum;
	}
	
	
}
