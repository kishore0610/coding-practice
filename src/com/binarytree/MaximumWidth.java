package com.binarytree;

import java.util.LinkedList;
import com.utility.TreeNode;
import java.util.Queue;

public class MaximumWidth {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		TreeNode nodeTwo = new TreeNode(2);
		TreeNode nodeThree = new TreeNode(3);
		TreeNode nodeFour = new TreeNode(4);
		TreeNode nodeFive = new TreeNode(5);
		TreeNode nodeSix = new TreeNode(6);
		TreeNode nodeSeven = new TreeNode(7);
		TreeNode nodeEight = new TreeNode(8);
		TreeNode nodeNine = new TreeNode(9);
		TreeNode nodeTen = new TreeNode(10);
		TreeNode nodeEleven = new TreeNode(11);
		TreeNode nodeTwelve = new TreeNode(12);

		root.setLeft(nodeTwo);
		root.setRight(nodeThree);

		nodeTwo.setLeft(nodeNine);
		nodeTwo.setRight(nodeSix);

		nodeThree.setLeft(nodeFour);
		nodeThree.setRight(nodeFive);

		nodeFour.setLeft(nodeEight);
		nodeFour.setRight(nodeNine);

		nodeSix.setLeft(nodeEleven);
		nodeNine.setRight(nodeTen);

		nodeFour.setLeft(nodeTwelve);
		nodeFour.setRight(nodeSeven);
		System.out.println("Maximum Width is: " + new MaximumWidth().getMaxWidth(root));
	}

	private int getMaxWidth(TreeNode node) {
		if (node == null)
			return 0;
		int maxWidth = 0;
		Queue<TreeNode> qNode = new LinkedList<>();
		qNode.add(node);
		while (!qNode.isEmpty()) {
			int count = qNode.size();
			maxWidth = Math.max(count, maxWidth);
			while (count > 0) {
				TreeNode tempNode = qNode.remove();
				if (tempNode.getLeft() != null)
					qNode.add(tempNode.getLeft());
				if (tempNode.getRight() != null)
					qNode.add(tempNode.getRight());
				count--;
			}
		}
		return maxWidth;
	}

}
