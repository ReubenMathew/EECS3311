package graph;

import java.util.ArrayList;
import java.util.Arrays;
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
				System.out.println(util.Message.M2.toString());
				return -1;
			}
		}

		this.vList.add(vertex);
		return this.vList.indexOf(vertex) + 1;
	}

	@Override
	public boolean addE(Edge<V> e) {

		if (e == null) {
			return false;
		}

		V src = e.getSource();
		V dest = e.getDest();

		// circular edge check
		if (src.equals(dest)) {
			return false;
		}

		for (int i = 0; i < vList.size(); i++) {
			V vertexName = vList.get(i).getV();
			if (vertexName.equals(src)) {
				Vertex<V> newVertex = vList.get(i);
				boolean success = newVertex.addEdge(e);
				vList.set(i, newVertex);
				return success;
			}
		}

		return true;
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

		System.out.println(util.Message.M5.toString());
		return null;

	}

	@Override
	public Edge<V> removeE(Edge<V> e) {

		for (int i = 0; i < this.vList.size(); i++) {
			Vertex<V> vertex = vList.get(i);
			if (e.getSource() == vertex.getV()) {
				return vertex.removeEdge(e.getDest());
			}
		}
		System.out.println(util.Message.M6.toString());
		return null;
	}

	/**
	 * if `index` is out of range: print message `M4` and return null;
	 */
	@Override
	public V getV(int index) {

		if (this.vList.isEmpty()) {
			System.out.println(util.Message.M4.toString());
			return null;
		}

		if (index < 0 || index >= this.vList.size()) {
			System.out.println(util.Message.M4.toString());
			return null;
		}

		return this.vList.get(index).getV();

	}
	
	private V getVertex(int index) {

		if (this.vList.isEmpty()) {
			return null;
		}

		if (index < 0 || index >= this.vList.size()) {
			return null;
		}

		return this.vList.get(index).getV();

	}

	@Override
	public Edge<V> getE(int src, int dest) {

		if (src >= this.vList.size() || dest >= this.vList.size()) {
			System.out.println(util.Message.M4.toString());
			return null;
		}

		return vList.get(src).getEdgeDebug(vList.get(dest).getV());

	}

	@Override
	public ArrayList<ArrayList<V>> branches(V v) {

		ArrayList<ArrayList<V>> branches = new ArrayList<ArrayList<V>>();
		int[][] matrix = this.matrix();

		// find vertex index
		int root = -1;
		for (int i = 0; i < this.vList.size(); i++) {
			if (v.equals(vList.get(i).getV())) {
				root = i;
				break;
			}
		}

		if (root == -1) {
			System.out.println(util.Message.M5.toString());
			return null;
		}

		this.dive(root, matrix, new ArrayList<V>(), branches);

		return branches;
	}

	private ArrayList<V> dive(int root, int[][] matrix, ArrayList<V> branch, ArrayList<ArrayList<V>> branches) {

		branch.add(this.getVertex(root));

		for (int i = 0; i < this.vList.size(); i++) {
			if (matrix[root][i] == 1) {
				ArrayList<V> newBranch = new ArrayList<V>(branch);
				ArrayList<V> toAdd = dive(i, matrix, newBranch, branches);
				if (Arrays.stream(matrix[i]).sum() == 0) {
					branches.add(toAdd);
				}
			}
		}

		return branch;
	}

	@Override
	public int[][] matrix() {

		int size = this.vList.size();

		int[][] matrix = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (this.getE(i, j) != null) {
					matrix[i][j] = 1;
				}
			}
		}

		return matrix;

	}
}