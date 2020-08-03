package com.amz.frequent.problems;

public class TreasureIsland2 {
	int minDistance = Integer.MAX_VALUE;

	public static void main(String[] args) {
		char[][] mapLegends = { { 'S', 'O', 'O', 'S', 'S' }, { 'D', 'O', 'D', 'O', 'D' }, { 'O', 'O', 'O', 'O', 'X' },
				{ 'X', 'D', 'D', 'O', 'O' }, { 'X', 'D', 'D', 'D', 'O' } };
		TreasureIsland2 island2 = new TreasureIsland2();
		int rowLength = mapLegends.length;
		int columLength = mapLegends[0].length;
		boolean[][] visitedLand = new boolean[rowLength][columLength];
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < columLength; j++) {
				if (mapLegends[i][j] == 'S')
					island2.findIsland(i, j, mapLegends, visitedLand, 0);
			}
		}
		island2.findIsland(0, 0, mapLegends, visitedLand, 0);
		island2.printMinDistance();
	}

	private void findIsland(int i, int j, char[][] islandMap, boolean[][] visited, int islandDistance) {
		if (i < 0 || j < 0 || i >= islandMap.length || j >= islandMap[0].length || islandMap[i][j] == 'D'
				|| visited[i][j] == true)
			return;
		visited[i][j] = true;
		if (islandMap[i][j] == 'X')
			minDistance = Math.min(minDistance, islandDistance);

		findIsland(i - 1, j, islandMap, visited, islandDistance + 1);
		findIsland(i + 1, j, islandMap, visited, islandDistance + 1);
		findIsland(i, j - 1, islandMap, visited, islandDistance + 1);
		findIsland(i, j + 1, islandMap, visited, islandDistance + 1);

		visited[i][j] = false;
	}

	private void printMinDistance() {
		System.out.println(minDistance);
	}
}
