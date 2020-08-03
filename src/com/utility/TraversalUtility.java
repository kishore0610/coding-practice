package com.utility;

import java.util.LinkedList;
import java.util.Queue;

public class TraversalUtility {

	public TreeNode root;

	public void printLevelOrder() {

		if (root == null)
			return;

		Queue<TreeNode> treeQueue = new LinkedList<>();
		treeQueue.add(root);
		int maxWidth = 0;
		while (!treeQueue.isEmpty()) {

			TreeNode node = treeQueue.poll();
			System.out.print(node.getData());

			if (node.getLeft() != null) {
				treeQueue.add(node.getLeft());
			}

			if (node.getRight() != null) {
				treeQueue.add(node.getRight());
			}
			maxWidth = Math.max(maxWidth, treeQueue.size());
		}

		System.out.println("\nMaximum Width is: " + maxWidth);

	}

}
