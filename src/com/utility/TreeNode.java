package com.utility;

public class TreeNode {
	private TreeNode left;
	private TreeNode right;
	private int data;

	public TreeNode(int data) {
		this.left = null;
		this.right = null;
		this.data = data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

	public int getData() {
		return data;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

}
