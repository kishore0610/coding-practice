
public class ReverseNumber {

	public static void main(String[] args) {
		int x = 1534236469;
		System.out.print(x + " -> ");
		int reverseNumber = 0;
		boolean negative = false;
		if (x < 0) {
			negative = true;
			x = x * (-1);
		}
		while (x > 0) {
			reverseNumber = 10 * reverseNumber + (x % 10);
			x = x / 10;
		}
		if (negative) {
			reverseNumber = reverseNumber * (-1);
		}
		System.out.print(reverseNumber);
	}

}
