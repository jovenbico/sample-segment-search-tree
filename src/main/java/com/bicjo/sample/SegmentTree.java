package com.bicjo.sample;

import java.util.LinkedList;

public class SegmentTree {

	private LinkedList<Node> heap = new LinkedList<>();

	private int min;
	private int max;

	static class Node implements Comparable<Node> {

		private int from;
		private int to;

		public Node(int from, int to) {
			this.from = from;
			this.to = to;
		}

		public int getFrom() {
			return from;
		}

		public int getTo() {
			return to;
		}

		@Override
		public int compareTo(Node obj) {
			return Integer.compare(from, obj.from);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + from;
			result = prime * result + to;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (from != other.from)
				return false;
			if (to != other.to)
				return false;
			return true;
		}
	}

	public void insert(Node node) {

		setMinMax(node);

		heap.add(node);

	}

	private void setMinMax(Node node) {
		if (heap.isEmpty())
			min = node.from;

		min = (node.from < min) ? node.from : min;
		max = (node.to > max) ? node.to : max;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public int getRange() {
		return max - min;
	}

	public void print() {
		System.out.println(min + ":" + max);
		for (Node node : heap) {
			System.out.println("   " + node.from + ":" + node.to);
		}
	}
}
