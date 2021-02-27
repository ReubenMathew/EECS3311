package student;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import graph.DGraph;
import graph.Edge;
import graph.ListDGraph;

public class StudentTest {
	DGraph<String> graph = new ListDGraph<String>();

	@Before
	public void setUp() throws Exception {
		graph.addV("1");
		graph.addV("2");
		graph.addV("3");
		graph.addV("4");
		graph.addV("5");

		graph.addE(new Edge<String>("1", "2"));
		graph.addE(new Edge<String>("1", "3"));
		graph.addE(new Edge<String>("2", "3"));
		graph.addE(new Edge<String>("2", "4"));
		graph.addE(new Edge<String>("4", "5"));

	}

	@Test
	public void test_vertex_null() {
		/**
		 * add a null V
		 */
		int index = graph.addV(null);
		Assert.assertEquals(-1, index);

	}

	@Test
	public void test_vertex_add() {
		/**
		 * add an exist V
		 */
		int index;

		index = graph.addV("2");
		Assert.assertEquals(-1, index);

		/**
		 * add a new V
		 */
		try {
			index = graph.addV("10");
			Assert.assertEquals(6, index);
		} catch (AssertionError e) {
			System.out.println(graph.toString());
			throw e;
		}

	}

	@Test
	public void test_vertex_remove() {

		String vertex;

		/**
		 * remove existing vertex
		 */
		vertex = graph.removeV("2");
		Assert.assertEquals("2", vertex);

		/**
		 * remove vertex that doesn't exist
		 */
		try {
			vertex = graph.removeV("12");
			Assert.assertNull(vertex);
		} catch (AssertionError e) {
			System.out.println(graph.toString());
			throw e;
		}

		/**
		 * null handling
		 */
		try {
			vertex = graph.removeV(null);
			Assert.assertNull(vertex);
		} catch (AssertionError e) {
			System.out.println(graph.toString());
			throw e;
		}

	}

	@Test
	public void test_vertex_get() {

		String vertex;

		/**
		 * get existing vertex by index
		 */

		vertex = graph.getV(0);
		Assert.assertEquals("1", vertex);

		/**
		 * get index that is out of bounds
		 */
		try {
			vertex = graph.getV(100);
			Assert.assertNull(vertex);
		} catch (AssertionError e) {
			System.out.println(graph.toString());
			throw e;
		}

		/**
		 * get index that is out of bounds
		 */
		try {
			vertex = graph.getV(-4);
			Assert.assertNull(vertex);
		} catch (AssertionError e) {
			System.out.println(graph.toString());
			throw e;
		}

		/**
		 * Test getting index from empty graph
		 */
		DGraph<String> graph_o = new ListDGraph<String>();
		vertex = graph_o.getV(0);
		Assert.assertNull(vertex);

	}

	@Test
	public void test_edge_null() {
		/**
		 * add a null Edge
		 */
		boolean success = graph.addE(null);
		Assert.assertEquals(false, success);

	}

	@Test
	public void test_edge_add() {

		Edge<String> e = new Edge<String>("2", "3");
		/**
		 * add an existing edge
		 */
		boolean success = graph.addE(e);
		Assert.assertEquals(false, success);

		/**
		 * add a new edge
		 */
		Edge<String> e1 = new Edge<String>("4", "1");
		success = graph.addE(e1);
		Assert.assertEquals(true, success);

	}
	
	@Test
	public void test_edge_add_circular() {

		Edge<String> e = new Edge<String>("2", "2");
		/**
		 * add a circular edge
		 */
		boolean success = graph.addE(e);
		Assert.assertEquals(false, success);

	}

	@Test
	public void test_edge_get() {

		/**
		 * get an existing edge
		 */
		Edge<String> e = new Edge<String>("2", "3");
		Edge<String> success = graph.getE(1, 2);
		Assert.assertNotNull(success);

		/**
		 * get an non-existing edge
		 */
		success = graph.getE(6, 8);
		Assert.assertEquals(null, success);

		/**
		 * get an edge with a non-existing destination
		 */
		success = graph.getE(6, 8);
		Assert.assertEquals(null, success);
	}

	@Test
	public void test_removeE() {

		/**
		 * remove an existing edge
		 */
		Edge<String> e1 = new Edge<String>("1", "4");
		graph.addE(e1);

		Edge<String> e2 = graph.removeE(new Edge<String>("1", "4"));
		Assert.assertEquals(true, e1.equals(e2));

		/**
		 * remove a non-existent edge
		 */
		Edge<String> success = graph.removeE(new Edge<String>("10", "11"));
		Assert.assertEquals(null, success);
	}
	@Test
	public void test_matrix_len5() {
		/**
		 * generate the matrix
		 */
		int[][] matrix = graph.matrix();

		/**
		 * expected matrix `m`
		 */
		int m[][] = new int[5][5];
		m[0][0] = 0;
		m[0][1] = 1;
		m[0][2] = 1;
		m[0][3] = 0;
		m[0][4] = 0;
		m[1][0] = 0;
		m[1][1] = 0;
		m[1][2] = 1;
		m[1][3] = 1;
		m[1][4] = 0;
		m[2][0] = 0;
		m[2][1] = 0;
		m[2][2] = 0;
		m[2][3] = 0;
		m[2][4] = 0;
		m[3][0] = 0;
		m[3][1] = 0;
		m[3][2] = 0;
		m[3][3] = 0;
		m[3][4] = 1;
		m[4][0] = 0;
		m[4][1] = 0;
		m[4][2] = 0;
		m[4][3] = 0;
		m[4][4] = 0;

		System.out.println(m.toString());

		Assert.assertEquals(matrix.length, m.length);
	}

	@Test
	public void test_branches() {
		// Iterate the graph from V "1"
		ArrayList<ArrayList<String>> bs;
		bs = graph.branches("1");

		ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
		ArrayList<String> b1 = new ArrayList<String>();
		b1.add("1");
		b1.add("2");
		b1.add("4");
		b1.add("5");

		ArrayList<String> b2 = new ArrayList<String>();
		b2.add("1");
		b2.add("2");
		b2.add("3");

		ArrayList<String> b3 = new ArrayList<String>();
		b3.add("1");
		b3.add("3");

		expected.add(b1);
		expected.add(b2);
		expected.add(b3);

		Assert.assertEquals(bs.size(), expected.size());
	}

}
