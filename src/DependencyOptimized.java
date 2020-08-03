import java.util.*;

public class DependencyOptimized {

	public static void main(String[] args) {

		String[] edges = { "0 -1", "1 0", "2 0", "3 1 2" };
		Map<Integer, LinkedList<Integer>> dependencyMap = new HashMap<>();
		Set<Integer> courses = new HashSet<>();
		for (int i = 0; i < edges.length; i++) {
			String[] courseId = edges[i].split(" ");
			int course1 = Integer.parseInt(courseId[0]);
			courses.add(course1);
			for (int j = 1; j < courseId.length; j++) {
				int course2 = Integer.parseInt(courseId[j]);
				courses.add(course2);
				if (!dependencyMap.containsKey(course1)) {
					LinkedList<Integer> dependencyList = new LinkedList<>();
					dependencyList.add(course2);
					dependencyMap.put(course1, dependencyList);
				} else {
					LinkedList<Integer> dependencyList = dependencyMap.get(course1);
					dependencyList.add(course2);
					dependencyMap.put(course1, dependencyList);
				}

			}

		}
		HashSet<Integer> visited = new HashSet<>();
		Queue<Integer> order = new LinkedList<>();
		DependencyOptimized d = new DependencyOptimized();
		for (Integer i : courses) {
			if (!visited.contains(i)) {
				d.depthFirstSearch(order, visited, dependencyMap, i);
			}
		}
		while (!order.isEmpty()) {
			System.out.println(order.poll());
		}
	}

	private void depthFirstSearch(Queue<Integer> order, HashSet<Integer> visited, Map<Integer, LinkedList<Integer>> dependencyMap, int course) {
		if (visited.contains(course))
			return;
		if (!dependencyMap.containsKey(course)) {
			order.add(course);
			visited.add(course);
		} else {
			LinkedList<Integer> list = dependencyMap.get(course);
			for (Integer i : list) {
				depthFirstSearch(order, visited, dependencyMap, i);
				if (!visited.contains(course)) {
					order.add(course);
					visited.add(course);
				}
			}
		}
	}

}
