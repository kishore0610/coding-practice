package com.java.tutorials;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TestClass {

	public static void main(String[] args) {
		List<ComparableSortingTest> test = new ArrayList<>();
		test.add(new ComparableSortingTest(0, 0, 30));
		test.add(new ComparableSortingTest(0, 1, 20));
		test.add(new ComparableSortingTest(0, 2, 20));
		test.add(new ComparableSortingTest(0, 3, 40));
		System.out.println("Before Sorting:");
		for(ComparableSortingTest t : test){
			System.out.println(t.i+","+t.j+" is "+t.sum);
		}
		System.out.println("After Sorting:");
		Collections.sort(test);
		for(ComparableSortingTest t : test){
			System.out.println(t.i+","+t.j+" is "+t.sum);
		}
		
		Optional.ofNullable(test);
	}

}
