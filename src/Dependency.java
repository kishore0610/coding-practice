import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Dependency {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		int numOfCourses = 5;
		String[] edges = { "0 4", "1 0", "2 0", "3 1 2" };
		LinkedList[] dependency = new LinkedList[numOfCourses];
		for (int i = 0; i < edges.length; i++) {
			String[] courseId = edges[i].split(" ");
			int course1 = Integer.parseInt(courseId[0]);
			for (int j = 1; j < courseId.length; j++) {
				int course2 = Integer.parseInt(courseId[j]);
				if (dependency[course1] == null) {
					dependency[course1] = new LinkedList<>();
				}
				dependency[course1].add(course2);
			}

		}
		HashSet<Integer> visited = new HashSet<>();
		Queue<Integer> order = new LinkedList<>();
		Dependency d = new Dependency();
		for (int i = 0; i < numOfCourses; i++) {
			if (!visited.contains(i)) {
				d.depthFirstSearch(order, visited, dependency, i);
			}
		}
		while (!order.isEmpty()) {
			System.out.println(order.poll());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void depthFirstSearch(Queue<Integer> order, HashSet<Integer> visited, LinkedList[] dependency, int course) {
		if (visited.contains(course))
			return;
		if (dependency[course] == null) {
			order.add(course);
			visited.add(course);
		} else {
			LinkedList<Integer> list = dependency[course];
			for (Integer i : list) {
				depthFirstSearch(order, visited, dependency, i);
				if (!visited.contains(course)) {
					order.add(course);
					visited.add(course);
				}
			}
		}
	}

}
