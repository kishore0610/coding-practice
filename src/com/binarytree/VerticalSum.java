package com.binarytree;

import java.util.HashMap;
import java.util.Map;

import com.utility.TreeNode;

public class VerticalSum {

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
		TreeNode nodeThirteen = new TreeNode(13);
		TreeNode nodeFourteen = new TreeNode(14);
		TreeNode nodeFifteen = new TreeNode(15);
		root.setLeft(nodeTwo);
		root.setRight(nodeThree);
		nodeTwo.setLeft(nodeFour);
		nodeTwo.setRight(nodeFive);
		nodeThree.setLeft(nodeSix);
		nodeThree.setRight(nodeSeven);
		nodeFour.setLeft(nodeEight);
		nodeFour.setRight(nodeNine);
		nodeFive.setLeft(nodeTen);
		nodeFive.setRight(nodeEleven);
		nodeSix.setLeft(nodeTwelve);
		nodeSix.setRight(nodeThirteen);
		nodeSeven.setLeft(nodeFourteen);
		nodeSeven.setRight(nodeFifteen);
		VerticalSum verticalSum = new VerticalSum();
		verticalSum.calculateVerticalSum(root, 0);
		verticalSum.printSum();

	}

	private void calculateVerticalSum(TreeNode node, int distance) {
		if (node == null)
			return;
		calculateVerticalSum(node.getLeft(), distance - 1);
		int value = sumMap.get(distance) == null ? 0 : sumMap.get(distance);
		sumMap.put(distance, value + node.getData());
		calculateVerticalSum(node.getRight(), distance + 1);
	}

	private void printSum() {
		if (sumMap != null) {
			System.out.println(sumMap.entrySet());
		}
	}
}
