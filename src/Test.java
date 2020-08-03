import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.utility.TrieNode;

public class Test {

	public static void main(String[] args) {
		TopNCompetitors topNCompetitors = new TopNCompetitors();
		List<String> c = new ArrayList<>();
		List<String> rev = new ArrayList<>();
		c.add("anacell");
		c.add("betacellular");
		c.add("cetracular");
		c.add("deltacellular");
		c.add("eurocell");
		rev.add("I love anacell Best services; Best services provided by anacell");
		rev.add("betacellular has great services deltacellular");
		rev.add("deltacellular provides much better services than betacellular deltacellular");
		rev.add("cetracular is worse than anacell deltacellular");
		rev.add("Betacellular is better than deltacellular.");
		System.out.println(topNCompetitors.topNCompetitors(5, 3, c, 5, rev));
		
		
		ZombieMatrix zombieMatrix = new ZombieMatrix();
		char[][] location = { { '0', '1', '1', '0', '1' }, { '0', '1', '0', '1', '0' }, { '0', '0', '0', '0', '1' }, { '0', '1', '0', '0', '0' } };
		System.out.println("Hours: " + zombieMatrix.numOfHours(location));

		ArticulationPoint articulationpoint = new ArticulationPoint();
		int numOfNodes = 7;
		// int numOfEdges = 7;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 }, { 2, 5 }, { 5, 6 }, { 3, 4 } };
		List<Integer> res = articulationpoint.getCriticalRouters(numOfNodes, edges);
		for (int i : res)
			System.out.print(i + " ");

		SearchWord searchWord = new SearchWord();
		String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		String search = "mouse";
		System.out.println("\n" + searchWord.suggestedProducts(products, search));

		Trie trie = new Trie();
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };
		trie.rootNode = new TrieNode();
		for (int i = 0; i < keys.length; i++)
			trie.insert(keys[i]);

		System.out.println(trie.search("the"));

		System.out.println(trie.search("these"));

		System.out.println(trie.search("their"));

		System.out.println(trie.search("thaw"));

	}

}

class TopNCompetitors {
	public ArrayList<String> topNCompetitors(int numCompetitors, int topNCompetitors, List<String> competitors, int numReviews, List<String> reviews) {
		Map<String, Integer> occurrencesMap = new HashMap<>();
		for(String review : reviews){
			for(String keyword : competitors){
				int count = StringUtils.countMatches(review.toLowerCase(),keyword.toLowerCase());
				if(occurrencesMap.containsKey(keyword)){
					occurrencesMap.put(keyword, occurrencesMap.get(keyword) + count);
				}
				else{
					occurrencesMap.put(keyword, count);
				}
			}
		}
		List<String> temp = occurrencesMap.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.map(e -> e.getKey())
				.collect(Collectors.toCollection(ArrayList::new));
		
		return new ArrayList<String>(temp.subList(0, topNCompetitors));
	}
}

class ZombieMatrix {
	public int numOfHours(char[][] zombieMatrix) {
		int hoursTaken = 0;
		List<String> alive = new ArrayList<>();
		int rowIndex = zombieMatrix.length - 1;
		int columnIndex = zombieMatrix[0].length - 1;
		do {
			char[][] copyOfMatrix = getCopyOfArray(zombieMatrix);
			for (int i = 0; i <= rowIndex; i++) {
				for (int j = 0; j <= columnIndex; j++) {
					if (copyOfMatrix[i][j] == '0') {

						// Adding the humans
						alive.add(i + "," + j);

						// Checking if a Zombie is above a Human
						if (i > 0 && copyOfMatrix[i - 1][j] == '1') {
							// Zombie attacked the human from top
							zombieMatrix[i][j] = '1';
							// Human has turned as Zombie, hence removing entry from Humans List
							alive.remove(i + "," + j);

						}
						// Checking if a Zombie is at the Left of a Human
						if (j > 0 && copyOfMatrix[i][j - 1] == '1') {
							// Zombie attacked the human from left
							zombieMatrix[i][j] = '1';
							// Human has turned as Zombie, hence removing entry from Humans List
							alive.remove(i + "," + j);

						}
						// Checking if a Zombie is Below a Human
						if (i < rowIndex && copyOfMatrix[i + 1][j] == '1') {
							// Zombie attacked the human from below
							zombieMatrix[i][j] = '1';
							// Human has turned as Zombie, hence removing entry from Humans List
							alive.remove(i + "," + j);

						}
						// Checking if a Zombie is at the Right of Human
						if (j < columnIndex && copyOfMatrix[i][j + 1] == '1') {
							// Zombie attacked the human from right
							zombieMatrix[i][j] = '1';
							// Human has turned as Zombie, hence removing entry from Humans List
							alive.remove(i + "," + j);

						}
					}
				}
			}
			hoursTaken++;
		} while (!alive.isEmpty());
		return hoursTaken;
	}

	private char[][] getCopyOfArray(char[][] matrixA) {
		char[][] matrixB = new char[matrixA.length][matrixA[0].length];
		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA[0].length; j++) {
				matrixB[i][j] = matrixA[i][j];
			}
		}
		return matrixB;
	}

}

class ArticulationPoint {
	public List<Integer> getCriticalRouters(int numOfNodes, int[][] edges) {

		// construct graph
		Map<Integer, Set<Integer>> graph = new HashMap<>();

		// initialize graph
		for (int i = 0; i < numOfNodes; i++)
			graph.put(i, new HashSet<>());

		// add edges to graph
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		List<Integer> result = new ArrayList<>();

		// calculate critical routers
		for (int nodeToRemove = 0; nodeToRemove < numOfNodes; nodeToRemove++) {

			// remove each node and its edges and check if entire graph is connected
			Set<Integer> nodeEdges = graph.get(nodeToRemove);
			int source = 0;
			for (int edge : nodeEdges) {
				graph.get(edge).remove(nodeToRemove);
				source = edge;
			}

			HashSet<Integer> visited = new HashSet<>();
			depthFirstSearch(graph, source, visited);

			if (visited.size() != numOfNodes - 1) {
				// this node was a critical router
				result.add(nodeToRemove);
			}

			// add the edges back
			for (int edge : nodeEdges)
				graph.get(edge).add(nodeToRemove);
		}
		return result;
	}

	private void depthFirstSearch(Map<Integer, Set<Integer>> graph, int source, Set<Integer> visited) {
		if (visited.contains(source))
			return;

		visited.add(source);

		for (int child : graph.get(source))
			depthFirstSearch(graph, child, visited);
	}
}

class SearchWord {
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		int length = searchWord.length();
		List<List<String>> searchResults = new ArrayList<List<String>>();
		for (int i = 1; i <= length; i++) {
			List<String> resultProducts = getList(products, searchWord.substring(0, i));
			resultProducts = resultProducts.size() > 3 ? resultProducts.subList(0, 3) : resultProducts;
			searchResults.add(resultProducts);
		}
		return searchResults;
	}

	private List<String> getList(String[] products, String subString) {
		List<String> resultList = new ArrayList<>();
		for (String product : products) {
			if (product.startsWith(subString))
				resultList.add(product);
		}
		resultList.sort((a1, b1) -> a1.compareTo(b1));
		return resultList;
	}
}