package york.eecs.source;

import java.util.ArrayList;
import java.util.Map;
import york.eecs.source.MapContainsNullValueException;

// For debugging
//import java.util.Arrays;

/**
 * @author song and you
 * @description: @BubbleSort uses bubble sorting algorithm to rank a map based
 *               on the values.
 */
public class BubbleSort implements MapSort<String, Integer> {
	/**
	 * @map to be sorted;
	 */
	public Map<String, Integer> map;

	/**
	 * TODO: There are missing methods, you can find clues from test cases.
	 */

	/**
	 * @description: Sort a map by the values in ascending order with bubble sorting
	 *               algorithm.
	 * @return: Return the corresponding key list of the sorted map.
	 */
	@Override
	public ArrayList<String> sortbyValue() {

		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>();

		for (Map.Entry<String, Integer> entry : this.map.entrySet()) {
			keys.add(entry.getKey());
			values.add(entry.getValue());
		}

		// If the hashmap has only one set of elements or is empty;
		if (keys.size() <= 1) {
			return keys;
		}

		// BUBBLE SORT
		for (int i = 0; i < values.size(); i++) {
			for (int j = 0; j < values.size() - i - 1; j++) {
				if (compareHelper(values.get(j), values.get(j + 1))) {
					swap(values, j);
					// swap keys synchonously with values
					swap(keys, j);
				}
			}
		}

		return keys;
	}

	private <T> void swap(ArrayList<T> a, int index) {
		T temp = a.get(index);
		a.remove(index);
		a.add(index, a.get(index));
		a.remove(index + 1);
		a.add(index + 1, temp);
		return;
	}

	private boolean compareHelper(int x, int y) {
		return x > y ? true : false;
	}

	public void setMap(Map<String, Integer> map_to_be_sorted) throws MapContainsNullValueException {
		// Check values for null value exception
		for (Integer x : map_to_be_sorted.values()) {
			if (x == null) {
				throw new MapContainsNullValueException("Key or value contains null value");
			}
		}

		this.map = map_to_be_sorted;

	}

	public Map<String, Integer> getMap() {
		return this.map;
	}
}