package com.bicjo.sample;

import java.util.LinkedList;
import java.util.List;

import com.bicjo.sample.SegmentTree.Node;

public class SegmentTreeBuilder {

	private LinkedList<Node> heap = new LinkedList<>();
	private int minSegmentRange;

	public SegmentTreeBuilder(int minSegmentRange) {
		this.minSegmentRange = minSegmentRange;
	}

	public List<SegmentTree> build() {
		List<SegmentTree> treeList = new LinkedList<>();

		SegmentTree tree = new SegmentTree();
		treeList.add(tree);
		for (Node nextNode : heap) {
			if (tree.getRange() >= minSegmentRange) {
				tree = new SegmentTree();
				treeList.add(tree);
			}
			tree.insert(nextNode);
		}

		return treeList;
	}

	public LinkedList<Node> getHeap() {
		return heap;
	}

	public void insert(int from, int to) {

		Node node = new Node(from, to);

		if (heap.isEmpty()) {
			heap.add(node);
		} else {
			heapAdd(node);
		}

	}

	private void heapAdd(Node node) {
		if (heap.contains(node)) {
			return;
		}

		for (int pos = 0, heapSize = heap.size(); pos < heapSize; pos++) {
			Node posNode = heap.get(pos);
			if (posNode.compareTo(node) > 0) {
				heap.add(pos, node);
				break;
			}
		}

		if (!heap.contains(node)) {
			heap.addLast(node);
		}
	}
}
