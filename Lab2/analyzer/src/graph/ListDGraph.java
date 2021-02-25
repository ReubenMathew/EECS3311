package graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Use LinkedList to implement the directed graph
 * 
 * @param <V>
 * @author wangs and you
 */
public class ListDGraph<V> implements DGraph<V> {

	/** list of the vertices in a graph */
	private LinkedList<Vertex<V>> vList;

	/**
	 * constructor
	 */
	public ListDGraph() {
		vList = new LinkedList<Vertex<V>>();
	}

	/**
	 * Debug function useful for printing list of vertices
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		return vList.toString();
	}

	/**
	 * Adds vertex to list of vertices if vertex already exists, print message `M2`
	 * and return -1; if successful, return index of vertex
	 */
	@Override
	public int addV(V v) {

		Vertex<V> vertex = new Vertex<V>(v);

		// check if vertex is null
		if (v == null) {
			return -1;
		}

		for (int i = 0; i < vList.size(); i++) {
			V vertexName = vList.get(i).getV();
			if (vertexName.equals(v)) {
				System.out.println("M2");
				return -1;
			}
		}

		this.vList.add(vertex);
		return this.vList.indexOf(vertex) + 1;
	}
	
	//	CURRENTLY BROKEN <- FIX IT
	@Override
	public boolean addE(Edge<V> e) {

		if (e == null) {
			return false;
		}

		V src = e.getSource();
		V dest = e.getDest();
		
		if (!this.vList.contains(src) || !this.vList.contains(dest)) {
			System.out.println("M5");
			return false;
		}

		for (int i = 0; i < vList.size(); i++) {
			V vertexName = vList.get(i).getV();
			if (vertexName.equals(src)) {
				return vList.get(i).addEdge(e);
			}
		}

		return false;
	}

	/**
	 * if cannot find vertex: print message `M5` and return null
	 */
	@Override
	public V removeV(V v) {

		if (v == null) {
			return null;
		}

		for (int i = 0; i < vList.size(); i++) {
			V vertexName = vList.get(i).getV();
			if (vertexName.equals(v)) {
				this.vList.remove(i);
				return vertexName;
			}
		}

		System.out.println("M5");
		return null;

	}

	@Override
	public Edge<V> removeE(Edge<V> e) {
		/**
		 * TODO: implement the removeE function;
		 */
		return null;
	}

	/**
	 * if `index` is out of range: print message `M4` and return null;
	 */
	@Override
	public V getV(int index) {

		if (this.vList.isEmpty()) {
			System.out.println("M4");
			return null;
		}

		if (index < 0 || index >= this.vList.size()) {
			System.out.println("M4");
			return null;
		}

		return this.vList.get(index).getV();

	}

	@Override
	public Edge<V> getE(int src, int dest) {
		/**
		 * TODO: implement the getE function;
		 */
		return null;
	}

	@Override
	public ArrayList<ArrayList<V>> branches(V v) {
		/**
		 * TODO: iterate the Graph from a given vertex and return all the branches from
		 * it;
		 */
		return null;
	}

	@Override
	public int[][] matrix() {
		/**
		 * TODO: generate the adjacency matrix of a graph;
		 */
		return null;

	}
}