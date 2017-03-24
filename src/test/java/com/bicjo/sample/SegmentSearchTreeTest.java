package com.bicjo.sample;

import org.junit.Test;

import com.bicjo.sample.SegmentTree.Node;

public class SegmentSearchTreeTest {

	@Test
	public void x_test() throws Exception {
		XSegmentSearchTree tree = new XSegmentSearchTree();

		tree.insert(68224494, 68228495);
		tree.insert(68228510, 68231155);
		tree.insert(68231170, 68231192);
		tree.print();
		tree.insert(68231214, 68231321);
		tree.print();
	}

	@Test
	public void heap_test() throws Exception {
		SegmentTreeBuilder builder = new SegmentTreeBuilder(100);

		builder.insert(2, 3);
		builder.insert(0, 1);
		builder.insert(4, 5);
		builder.insert(0, 1);

		for (Node node : builder.getHeap()) {
			System.out.println(node.getFrom() + ":" + node.getTo());
		}
	}

	@Test
	public void builder_test() throws Exception {

		SegmentTreeBuilder builder = new SegmentTreeBuilder(100);

		builder.insert(2, 3);
		builder.insert(0, 1);
		builder.insert(4, 5);
		builder.insert(0, 1);
		builder.insert(5, 100);
		builder.insert(200, 250);

		for (SegmentTree tree : builder.build()) {
			tree.print();
		}
	}

}
