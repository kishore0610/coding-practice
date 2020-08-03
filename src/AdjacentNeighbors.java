import java.util.ArrayList;
import java.util.Arrays;

public class AdjacentNeighbors {

	public static void main(String[] args) {
		System.out.println(new AdjacentNeighbors().cellCompete(new int[] { 1, 1, 1, 0, 1, 1, 1, 1 }, 2));
	}

	public ArrayList<Integer> cellCompete(int[] states, int days) {
		ArrayList<Integer> result = new ArrayList<>();
		int length = states.length;
		int indexSize = length - 1;
		int[] tempArray = new int[length];
		for (int i = 0; i < days; i++) {
			for (int j = 0; j < length; j++) {
				tempArray[j] = states[j];
			}
			states[0] = (tempArray[1] == 1) ? 1 : 0;
			for (int k = 1; k < indexSize; k++) {
				if (tempArray[k - 1] != tempArray[k + 1]) {
					states[k] = 1;
				} else {
					states[k] = 0;
				}
			}
			states[indexSize] = (tempArray[indexSize - 1] == 1) ? 1 : 0;
		}
		Arrays.stream(states).forEach(s -> result.add(s));
		return result;

	}

}
