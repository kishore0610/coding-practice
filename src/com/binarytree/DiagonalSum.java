package com.binarytree;

import java.util.HashMap;
import java.util.Map;

import com.utility.TreeNode;

public class DiagonalSum {
	private Map<Integer, Integer> sumMap = new HashMap<>();

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
		
		DiagonalSum diagonalSum = new DiagonalSum();
		diagonalSum.calculateDiagonalSum(root, 0);
		diagonalSum.printSum();
	}

	private void calculateDiagonalSum(TreeNode node, int distance) {
		if (node == null)
			return;
		calculateDiagonalSum(node.getLeft(), distance - 1);
		int value = sumMap.get(distance) == null ? 0 : sumMap.get(distance);
		sumMap.put(distance, value + node.getData());
		calculateDiagonalSum(node.getRight(), distance);

	}

	private void printSum() {
		if (sumMap != null) {
			System.out.println(sumMap.entrySet());
		}
	}

}
