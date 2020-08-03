import com.utility.TrieNode;

public class Trie {
	TrieNode rootNode;

	public void insert(String word) {
		int length = word.length();
		TrieNode temp = rootNode;
		for (int i = 0; i < length; i++) {
			int index = word.charAt(i) - 'a';
			if (temp.characters[index] == null) {
				temp.characters[index] = new TrieNode();
				temp.characters[index].setCharacter(word.charAt(i));
			}
			temp = temp.characters[index];
		}

	}

	public boolean search(String word) {
		int length = word.length();
		TrieNode temp = rootNode;
		for (int i = 0; i < length; i++) {
			int index = word.charAt(i) - 'a';
			if (temp.characters[index] != null && temp.characters[index].getCharacter() == word.charAt(i)) {
				temp = temp.characters[index];
			} else {
				return false;
			}
		}
		return true;
	}

}
