package com.sorting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

import com.utility.GraphUtil;

public class TopologicalSort {

	public static void main(String[] args) {

		LinkedList<Integer> vertex7 = new LinkedList<>();
		LinkedList<Integer> vertex1 = new LinkedList<>();
		LinkedList<Integer> vertex2 = new LinkedList<>();
		LinkedList<Integer> vertex3 = new LinkedList<>();
		LinkedList<Integer> vertex4 = new LinkedList<>();
		LinkedList<Integer> vertex6 = new LinkedList<>();
		vertex6.add(2);
		vertex6.add(7);
		vertex4.add(7);
		vertex4.add(1);
		vertex2.add(3);
		vertex3.add(1);

		Map<Integer, LinkedList<Integer>> map = new HashMap<>();
		map.put(7, vertex7);
		map.put(1, vertex1);
		map.put(2, vertex2);
		map.put(3, vertex3);
		map.put(4, vertex4);
		map.put(6, vertex6);

		Stack<Integer> stack = new Stack<>();
		TopologicalSort sort = new TopologicalSort();

		Map<Integer, Boolean> visitedMap = new HashMap<>();
		visitedMap.put(7, false);
		visitedMap.put(1, false);
		visitedMap.put(2, false);
		visitedMap.put(3, false);
		visitedMap.put(4, false);
		visitedMap.put(6, false);

		for (Map.Entry<Integer, LinkedList<Integer>> entry : map.entrySet()) {
			int key = entry.getKey();
			if (!visitedMap.get(key))
				sort.findNeighbors(stack, key, map, visitedMap);
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		System.out.print("\n");
		GraphUtil graphUtil = new GraphUtil(6);
		graphUtil.addEdge(5, 2);
		graphUtil.addEdge(5, 0);
		graphUtil.addEdge(4, 0);
		graphUtil.addEdge(4, 1);
		graphUtil.addEdge(2, 3);
		graphUtil.addEdge(3, 1);
		graphUtil.printOrder();

	}

	private void findNeighbors(Stack<Integer> stack, int vertex, Map<Integer, LinkedList<Integer>> map,
			Map<Integer, Boolean> visitedMap) {
		visitedMap.put(vertex, true);
		Iterator<Integer> iterator = map.get(vertex).iterator();
		while (iterator.hasNext()) {
			int key = iterator.next();
			if (!visitedMap.get(key))
				findNeighbors(stack, key, map, visitedMap);
		}
		stack.push(vertex);
	}

}
