package york.eecs.test;

import york.eecs.source.BubbleSort;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import york.eecs.source.BubbleSort;
import york.eecs.source.MapContainsNullValueException;

public class StudentTest {
	/**
	 * TODO: Please write at least 5 test cases for testing @BubbleSort. TODO:
	 * Please write at least 5 test cases for testing @HeapSort.
	 */

	public static void main(String[] args) {
		BubbleSort bubble = new BubbleSort();

		Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
		map_to_be_sorted.put("tom", 99);
		map_to_be_sorted.put("james", 30);
		map_to_be_sorted.put("sam", 67);
		map_to_be_sorted.put("allen", 107);

		/**
		 * Initialize the `map' in @BubbleSort with `map_to_be_sorted'.
		 */
		bubble.setMap(map_to_be_sorted);
		bubble.sortbyValue();
	}
}
