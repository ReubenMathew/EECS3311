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

		graph.addE(new Edge<String>("1", "2"));
		graph.addE(new Edge<String>("1", "3"));
		graph.addE(new Edge<String>("2", "3"));
		graph.addE(new Edge<String>("2", "4"));
		graph.toString();
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
			Assert.assertEquals(5, index);
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

}
