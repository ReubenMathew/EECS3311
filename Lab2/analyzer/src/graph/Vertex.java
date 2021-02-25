package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * The vertex class; a Vertex object has a vertex and a list of edges started
 * from it;
 * 
 * @author wangs and you
 * @param <V>
 */
public class Vertex<V> {

	/** vertex */
	private V v;
	/** edges started from this vertex */
	private List<Edge<V>> edgeList;

	/**
	 * constructor
	 * 
	 * @param v
	 */
	public Vertex(V v) {
		this.v = v;
		this.edgeList = new LinkedList<Edge<V>>();
	}

	public V getV() {
		return v;
	}

	public List<Edge<V>> getEdgeList() {
		return edgeList;
	}

	/**
	 * add an edge to the edge list of this vertex. if add successfully return true;
	 * if edge exists: print `M3` and return false; if `e`'s src is not this vertex:
	 * print `M5` and return false;
	 * 
	 * @param e
	 */
	public boolean addEdge(Edge<V> e) {
		if (edgeList.contains(e)) {
			System.out.println("M3");
			return false;
		} else if (!e.getSource().equals(this)) {
			System.out.println("M5");
			return false;
		} else {
			this.edgeList.add(e);
			return true;
		}
	}

	/**
	 * get an edge between this vertex and the destination V "dest"; if 'dest' does
	 * not exist: print `M5` and return null; if edge does not exist: print `M6` and
	 * return null;
	 * 
	 * @param dest
	 * @return
	 */
	public Edge<V> getEdge(V dest) {
		/**
		 * TODO: get the edge between this vertex and the destination V "dest";
		 */
		return null;
	}

	/**
	 * remove an edge from the edge list of this vertex if 'dest' exists return the
	 * removed edge; if 'dest' does not exist: print `M5` and return null; if edge
	 * does not exist: print `M6` and return null;
	 * 
	 * @param dest
	 * @return removed Edge<V>
	 */
	public Edge<V> removeEdge(V dest) {
		/**
		 * TODO: removed an edge
		 */
		return null;
	}

	/**
	 * @param o
	 * @return boolean
	 */
	public boolean equals(Vertex<V> o) {
		/**
		 * TODO: implement the comparison between two vertices IFF `v` and `edgeList`
		 * are the same return true
		 */
		if (this == o)
			return true;

		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Vertex<V> newVertex = (Vertex<V>) o;

		return Objects.equals(this.v, newVertex.v) && Objects.equals(this.edgeList, newVertex.edgeList);
	}

	@Override
	public String toString() {
		String ret = String.format("v : %s , edges: %s", v, edgeList.toString());
		return ret;
	}
}