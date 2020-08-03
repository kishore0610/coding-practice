package com.java.tutorials;

public class ComparableSortingTest implements Comparable<ComparableSortingTest> {
	int i;
	int j;
	int sum;

	public ComparableSortingTest(int i, int j, int sum) {
		this.i = i;
		this.j = j;
		this.sum = sum;
	}

	@Override
	public int compareTo(ComparableSortingTest o) {
		if (this.sum < o.sum)
			return 1;
		if (this.sum > o.sum)
			return -1;
		return 0;
	}

}
