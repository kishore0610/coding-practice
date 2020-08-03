package com.amz.frequent.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfIslands {
	static int numOfRow;
	static int numOfColumns;

	public static void main(String[] args) {
		// char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };

		numOfRow = grid.length;
		numOfColumns = grid[0].length;
		int count = 0;
		for (int i = 0; i < numOfRow; i++) {
			for (int j = 0; j < numOfColumns; j++) {
				if (grid[i][j] == '1')
					count += dfs(grid, i, j);
			}
		}
		System.out.println(count);
		String[] logs = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
		List<String> letterLogs = new ArrayList<>();
		ArrayList<String> digitLogs = new ArrayList<>();
		if (logs == null || logs.length == 0)
			return;
		for (int i = 0; i < logs.length; i++) {
			if (logs[i].split(" ")[1].matches("[a-z]+")) {
				letterLogs.add(logs[i]);
			} else {
				digitLogs.add(logs[i]);
			}
		}
		Collections.sort(letterLogs, (a1, a2) -> {
			return a1.substring(a1.indexOf(" ")).compareTo(a2.substring(a2.indexOf(" ")));
		});
		letterLogs.addAll(digitLogs);
		letterLogs.toArray();
		System.out.println(letterLogs);

	}

	static int dfs(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= numOfRow || j >= numOfColumns || grid[i][j] == '0')
			return 0;
		else {
			grid[i][j] = '0';
			dfs(grid, i - 1, j);
			dfs(grid, i + 1, j);
			dfs(grid, i, j - 1);
			dfs(grid, i, j + 1);
		}
		return 1;
	}

}
