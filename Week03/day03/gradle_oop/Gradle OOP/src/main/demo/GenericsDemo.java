package main.demo;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {
	
	public static void main(String[] args) {
		List<Number> numbers = new ArrayList<>();
		
		Number num1 = new Integer(42);
		numbers.add(num1);
		numbers.add(new Double(3.14159));
		
		
	}

}
