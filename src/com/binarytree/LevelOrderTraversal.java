package com.binarytree;

import com.utility.TraversalUtility;
import com.utility.TreeNode;

public class LevelOrderTraversal {

	public static void main(String[] args) {

		TraversalUtility traversalUtility = new TraversalUtility();

		traversalUtility.root = new TreeNode(1);
		traversalUtility.root.setLeft(new TreeNode(2));
		traversalUtility.root.setRight(new TreeNode(3));
		traversalUtility.root.getLeft().setLeft(new TreeNode(4));
		traversalUtility.root.getLeft().setRight(new TreeNode(5));
		traversalUtility.root.getRight().setLeft(new TreeNode(6));
		traversalUtility.root.getRight().setRight(new TreeNode(7));
		traversalUtility.root.getLeft().getLeft().setLeft(new TreeNode(8));
		traversalUtility.root.getLeft().getLeft().setRight(new TreeNode(9));
		traversalUtility.root.getLeft().getRight().setLeft(new TreeNode(10));
		traversalUtility.root.getLeft().getRight().setRight(new TreeNode(11));
		traversalUtility.root.getRight().getRight().setRight(new TreeNode(15));
		traversalUtility.root.getRight().getRight().setLeft(new TreeNode(14));
		traversalUtility.root.getRight().getLeft().setRight(new TreeNode(13));
		traversalUtility.root.getRight().getLeft().setLeft(new TreeNode(12));
		traversalUtility.printLevelOrder();

	}

}
