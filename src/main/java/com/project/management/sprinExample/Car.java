package com.project.management.sprinExample;

public class Car {

	Engine e;
	Doors d;
	Tires t;
	
	public Car(Engine e, Doors d, Tires t) {
		super();
		this.e = e;
		this.d = d;
		this.t = t;
	}

	public void printCarDetails() {
		System.out.println(this.e + " " + this.d);
	}
	
}
