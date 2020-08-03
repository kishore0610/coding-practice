package com.amz.frequent.problems;

public class TreasureIsland {

	private int distance = Integer.MAX_VALUE;

	public static void main(String[] args) {
		char[][] routeMap = { { 'O', 'O', 'O', 'O' }, { 'D', 'O', 'D', 'O' }, { 'O', 'O', 'O', 'X' },
				{ 'O', 'D', 'D', 'O' } };
		boolean[][] visited = new boolean[routeMap.length][routeMap[0].length];
		TreasureIsland treasureIsland = new TreasureIsland();
		treasureIsland.minSteps(0, 0, 0, routeMap, visited);
		treasureIsland.printDistance();

	}

	private void minSteps(int i, int j, int levelDistance, char[][] map, boolean[][] visited) {
		if (i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] == 'D' || visited[i][j] == true)
			return;
		visited[i][j] = true;
		boolean found = false;
		if (map[i][j] == 'X') {
			distance = Math.min(distance, levelDistance);
			found = true;
		}
		if (i == 0 && j == 0) {
			levelDistance++;
		}
		minSteps(i, j - 1, levelDistance + 1, map, visited);// left
		minSteps(i, j + 1, levelDistance + 1, map, visited);// right
		minSteps(i - 1, j, levelDistance + 1, map, visited);// up
		minSteps(i + 1, j, levelDistance + 1, map, visited);// down
//		if (found) {
//			for (int k = 0; k < map.length; k++) {
//				for (int l = 0; l < map[0].length; l++) {
//					if (visited[k][l] == true) {
//						System.out.print("(" + k + "," + l + ")");
//					}
//				}
//			}
//			found = false;
//			System.out.println();
//		}
		visited[i][j] = false;
	}

	private void printDistance() {
		System.out.println(distance);
	}
}
