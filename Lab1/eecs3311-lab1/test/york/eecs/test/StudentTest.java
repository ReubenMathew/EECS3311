package york.eecs.test;

import york.eecs.source.BubbleSort;
import york.eecs.source.HeapSort;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import york.eecs.source.HeapSort;
import york.eecs.source.BubbleSort;
import york.eecs.source.MapContainsNullValueException;

public class StudentTest {
	/**
	 * TODO: Please write at least 5 test cases for testing @BubbleSort. TODO:
	 * Please write at least 5 test cases for testing @HeapSort.
	 */
	HeapSort heapsort;
	BubbleSort bubble;

	@Before
	public void setUp() throws Exception {
		heapsort = new HeapSort();
		bubble = new BubbleSort();
	}

	/**
	 * Tests for @BubbleSort
	 */
	@Test(expected = MapContainsNullValueException.class)
	public void bubble_test_null_value_exception() {
		Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
		map_to_be_sorted.put("me", null);

		/**
		 * setMap should throw exception due to null value in HashMap
		 */
		bubble.setMap(map_to_be_sorted);
	}

	@Test
	public void bubble_test_one_entry_1() {
		Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
		map_to_be_sorted.put("me", 1);

		/**
		 * setMap should throw exception due to null value in HashMap
		 */
		bubble.setMap(map_to_be_sorted);
		assertEquals(bubble.sortbyValue().size() == 1, bubble.getMap().size() == 1);
	}

	@Test
	public void bubble_test_one_entry_2() {
		Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
		map_to_be_sorted.put("me", 1);

		/**
		 * setMap should throw exception due to null value in HashMap
		 */
		bubble.setMap(map_to_be_sorted);
		assertEquals(bubble.sortbyValue().get(0), "me");
	}

	@Test
	public void bubble_test_two_entries_1() {
		Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
		map_to_be_sorted.put("me", 2);
		map_to_be_sorted.put("you", 1);

		/**
		 * setMap should throw exception due to null value in HashMap
		 */
		bubble.setMap(map_to_be_sorted);
		assertEquals(bubble.sortbyValue().size(), 2);
	}

	@Test
	public void bubble_test_two_entries_2() {
		Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
		map_to_be_sorted.put("me", 2);
		map_to_be_sorted.put("you", 1);

		/**
		 * setMap should throw exception due to null value in HashMap
		 */
		bubble.setMap(map_to_be_sorted);
		assertEquals(bubble.sortbyValue().get(0), "you");
	}

	/**
	 * Tests for @HeapSort
	 */

	@Test(expected = MapContainsNullValueException.class)
	public void heap_test_null_value_exception() {
		Map<String, Double> map_to_be_sorted = new HashMap<String, Double>();
		map_to_be_sorted.put("me", null);

		/**
		 * setMap should throw exception due to null value in HashMap
		 */
		heapsort.setMap(map_to_be_sorted);
	}

	@Test
	public void heap_test_one_entry_1() {
		Map<String, Double> map_to_be_sorted = new HashMap<String, Double>();
		map_to_be_sorted.put("me", 1.1);

		/**
		 * setMap should throw exception due to null value in HashMap
		 */
		heapsort.setMap(map_to_be_sorted);
		assertEquals(heapsort.sortbyValue().size() == 1, heapsort.getMap().size() == 1);
	}

	@Test
	public void heap_test_one_entry_2() {
		Map<String, Double> map_to_be_sorted = new HashMap<String, Double>();
		map_to_be_sorted.put("me", 1.1);

		/**
		 * setMap should throw exception due to null value in HashMap
		 */
		heapsort.setMap(map_to_be_sorted);
		assertEquals(heapsort.sortbyValue().get(0), "me");
	}

	@Test
	public void heap_test_two_entries_1() {
		Map<String, Double> map_to_be_sorted = new HashMap<String, Double>();
		map_to_be_sorted.put("me", 2.1);
		map_to_be_sorted.put("you", 1.1);

		/**
		 * setMap should throw exception due to null value in HashMap
		 */
		heapsort.setMap(map_to_be_sorted);
		assertEquals(heapsort.sortbyValue().size(), 2);
	}

	@Test
	public void heap_test_two_entries_2() {
		Map<String, Double> map_to_be_sorted = new HashMap<String, Double>();
		map_to_be_sorted.put("me", 2.1);
		map_to_be_sorted.put("you", 1.1);

		/**
		 * setMap should throw exception due to null value in HashMap
		 */
		heapsort.setMap(map_to_be_sorted);
		assertEquals(heapsort.sortbyValue().get(0), "you");
	}

	@Test
	public void heap_test_multiple_entries() {
		Map<String, Double> map_to_be_sorted = new HashMap<String, Double>();
		map_to_be_sorted.put("A", Double.MAX_VALUE);
		map_to_be_sorted.put("E", Double.MIN_VALUE);
		map_to_be_sorted.put("C", 100.0);
		map_to_be_sorted.put("D", 52.1);
		map_to_be_sorted.put("B", 1.0);

		/**
		 * Initialize the `map' in bubble with `map_to_be_sorted';
		 */
		heapsort.setMap(map_to_be_sorted);

		/**
		 * Expected results: the order of keys after ranking `map' by value with max
		 * heap algorithm;
		 */
		ArrayList<String> results = new ArrayList<String>();
		results.add("E");
		results.add("B");
		results.add("D");
		results.add("C");
		results.add("A");

		for (int i = 0; i < results.size(); i++) {
			Assert.assertEquals(results.get(i), heapsort.sortbyValue().get(i));
		}
	}

}
