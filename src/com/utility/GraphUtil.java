package com.utility;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphUtil {
	private LinkedList<Integer> graph[];
	private int numOfVertices;

	@SuppressWarnings("unchecked")
	public GraphUtil(int graphSize) {
		this.numOfVertices = graphSize;
		this.graph = new LinkedList[graphSize];
		loadGraph(graphSize);
	}

	private void loadGraph(int size) {
		for (int i = 0; i < size; i++) {
			graph[i] = new LinkedList<>();
		}
	}

	public void addEdge(int vertex1, int vertex2) {
		graph[vertex1].add(vertex2);
	}

	public void printOrder() {
		Stack<Integer> graphSequence = new Stack<>();
		boolean visitedRecord[] = new boolean[numOfVertices];
		for (int j = numOfVertices - 1; j > -1; j--) {
			if (visitedRecord[j] != true)
				findNeighbors(visitedRecord, j, graphSequence);
		}
		while (!graphSequence.isEmpty()) {
			System.out.print(graphSequence.pop());
		}
	}

	private void findNeighbors(boolean[] visited, int neighbor, Stack<Integer> orderedSequence) {
		visited[neighbor] = true;
		Iterator<Integer> it = graph[neighbor].iterator();
		while (it.hasNext()) {
			int temp = (int) it.next();
			if (visited[temp] != true)
				findNeighbors(visited, temp, orderedSequence);
		}
		orderedSequence.push(neighbor);
	}
}
