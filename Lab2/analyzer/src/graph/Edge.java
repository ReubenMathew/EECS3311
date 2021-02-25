package graph;

import java.util.Objects;

/**
 * The edge class; an edge has one source vertex and one destination vertex;
 * 
 * @author wangs and you
 * @param <V>
 */
public class Edge<V> {

	/** source of an edge */
	private V src;
	/** destination of an edge */
	private V dest;

	/**
	 * @param src
	 * @param dest
	 */
	public Edge(V src, V dest) {
		this.src = src;
		this.dest = dest;
	}

	/**
	 * get the source of this edge
	 * 
	 * @return
	 */
	public V getSource() {
		return this.src;
	}

	/**
	 * get the destination of this edge
	 * 
	 * @return
	 */
	public V getDest() {
		return this.dest;
	}

	/**
	 * @param o
	 * @return
	 */
	public boolean equals(Edge<V> o) {
		if (this == o)
			return true;

		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Edge<V> edge = (Edge<V>) o;

		return Objects.equals(this.src, edge.src) && Objects.equals(this.dest, edge.dest);
	}

	@Override
	public String toString() {
		String ret = String.format("src: %s , dest: %s", src, dest);
		return ret;
	}
}