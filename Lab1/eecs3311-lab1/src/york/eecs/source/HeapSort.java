package york.eecs.source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import york.eecs.source.MapContainsNullValueException;

/**
 * @author song and you
 * @description: @HeapSort uses max heap algorithm to rank a map based on the
 *               values.
 */
public class HeapSort implements MapSort<String, Double> {
	/**
	 * @map to be sorted;
	 */
	public Map<String, Double> map;

	/**
	 * TODO: There are missing methods, you can find clues of these methods from
	 * test cases.
	 */

	/**
	 * @description: Sort a map by the values in ascending order max heap sorting
	 *               algorithm.
	 * @return: Return the corresponding key list of the sorted map.
	 */
	@Override
	public ArrayList<String> sortbyValue() {

		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<Double> values = new ArrayList<Double>();

		// populate keys and values arraylists
		for (Map.Entry<String, Double> entry : this.map.entrySet()) {
			keys.add(entry.getKey());
			values.add(entry.getValue());
		}

		int len = keys.size();

		// If the hashmap has only one set of elements or is empty;
		if (len <= 1) {
			return keys;
		}

		for (int i = (len - 1) / 2; i >= 0; i--) {
			heapify(keys, values, len, i);
		}

		for (int i = len - 1; i >= 0; i--) {
			swap(values, i, 0);
			swap(keys, i, 0);
			heapify(keys, values, i, 0);
		}

		return keys;
	}

	/**
	 * To heapify a subtree rooted with node `i' which is an index in both @keys
	 * and @values. `n' is size of heap.
	 */
	public void heapify(ArrayList<String> keys, ArrayList<Double> values, int index, int i) {
		int root = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		// Compare Left
		if (left < index && values.get(left) > values.get(root)) {
			root = left;
		}
		// Compare Right
		if (right < index && values.get(right) > values.get(root)) {
			root = right;
		}

		if (root != i) {
			swap(values, root, i);
			swap(keys, root, i);
			heapify(keys, values, index, root);
		}

	}

	private <T> void swap(ArrayList<T> list, int x, int y) {
		Collections.swap(list, x, y);
	}

	public void setMap(Map<String, Double> map_to_be_sorted) throws MapContainsNullValueException {
		// Check values for null value exception
		for (Double x : map_to_be_sorted.values()) {
			if (x == null) {
				throw new MapContainsNullValueException("Key or value contains null value");
			}
		}
		this.map = map_to_be_sorted;

	}

	public Map<String, Double> getMap() {
		return this.map;
	}
}