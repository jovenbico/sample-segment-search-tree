package com.bicjo.sample;

public class XSegmentSearchTree {

	private Node root;

	static class Node {
		Node parent;
		Node left;
		Node right;

		int from;
		int to;
		int range;

		public Node(Node parent, int from, int to) {
			this.parent = parent;
			this.from = from;
			this.to = to;
			this.range = to - from;
		}
	}

	public void insert(int from, int to) {
		this.root = insert(root, null, from, to);
	}

	private Node insert(Node root, Node parent, int from, int to) {
		if (root == null) {
			root = new Node(parent, from, to);
		} else {
			if (from < root.from) {
				root.left = insert(root.left, root, from, to);
			} else {
				root.right = insert(root.right, root, from, to);
			}
		}
		return root;
	}

	public void print() {
		print(null, root);
		System.out.println();
	}

	private void print(String a, Node node) {
		if (node != null) {
			print("l", node.left);
			System.out.println(a + ":" + node.from + " : " + node.to);
			print("r", node.right);
		}
	}
}
