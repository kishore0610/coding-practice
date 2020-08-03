public class FindGCD {

	public static void main(String args[]) {
		int[] arr = { 2, 3, 4, 5, 6 };
		int gcd = arr[0];
		FindGCD findGcd = new FindGCD();

		for (int i = 1; i < arr.length; i++) {
			gcd = findGcd.getGCD(arr[i], gcd);
			System.out.println("is: " + gcd);
			if (gcd == 1)
				break;
		}

		System.out.println(gcd);
	}

	private int getGCD(int a, int b) {
		System.out.println("" + a + " & " + b);
		if (a == 0)
			return b;
		return getGCD(b % a, a);
	}
}
