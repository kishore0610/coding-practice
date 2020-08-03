package com.amz.frequent.problems;

public class MoviesOnFlight {

	public static void main(String[] args) {
		int[] movieDurations = { 90, 85, 75, 60, 120, 150, 125 };
		int flightDuration = 250;
		int entertainmentDuration = flightDuration - 30;
		int max = 0;
		int sum = 0;
		int length = movieDurations.length;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				sum = movieDurations[i] + movieDurations[j];
				if (sum <= entertainmentDuration) {
					max = Math.max(max, sum);
				}
			}
		}
		System.out.println(max);
	}

}
