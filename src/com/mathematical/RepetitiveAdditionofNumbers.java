package com.mathematical;

public class RepetitiveAdditionofNumbers {

	public static void main(String[] args) {
		int number = 999999999;

		while (number > 9) {
			number = new RepetitiveAdditionofNumbers().getSumOfDigits(number);
			System.out.println(number);
		}
		System.out.println("Sum of Digits is: " + number);
	}

	private int getSumOfDigits(int value) {
		if (value < 10)
			return value;
		int remainder = 0;
		int sum = 0;
		while (value > 0) {
			remainder = value % 10;
			sum += remainder;
			value = value / 10;
		}
		return sum;
	}
}
