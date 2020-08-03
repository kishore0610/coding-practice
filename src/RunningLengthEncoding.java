
public class RunningLengthEncoding {

	public static void main(String[] args) {
		System.out.println(new RunningLengthEncoding().returnEncodedString("baaaaabbbbddddccc"));
	}

	private String returnEncodedString(String input) {
		if (input == null || input.length() == 0)
			return "";
		StringBuilder encodedString = new StringBuilder("");
		char[] charArray = input.toCharArray();
		int length = charArray.length;
		char previousCharacter = 0;
		int counter = 0;
		for (int i = 0; i < length; i++) {
			if (previousCharacter == charArray[i])
				counter++;
			else {
				if (previousCharacter != 0) {
					encodedString.append(counter).append(previousCharacter);
				}
				previousCharacter = charArray[i];
				counter = 1;
			}
		}
		encodedString.append(counter).append(previousCharacter);
		return encodedString.toString();
	}
}
