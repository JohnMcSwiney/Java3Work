/**
 *
 */
package utilities;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ADT.Iterator;
import ADT.ListADT;
import exceptions.EmptyQueueException;

/**
 * @author Dan Nguyen
 *
 */
class MyDLLTest<E> {
	ListADT list;

	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setup() throws Exception {
		list = new MyDLL<>();
	}

	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list.clear();
	}

	/**
	 * Tests MyDLL's size method.
	 */
	@Test
	void testSize() {

		list.add("A");
		list.add("B");
		list.add("C");

		assertEquals(3, list.size());
	}

	/**
	 * Tests MyDLL's clear method.
	 */
	@Test
	void testClear() {

		list.add("A");
		list.add("B");
		list.add("C");

		assertNotNull(list);

		list.clear();

		assertEquals(0, list.size());
	}

	/**
	 * Tests MyDLL's add with index method.
	 */
	@Test
	void testAddIntObject() {

		list.add("A");
		list.add("B");
		list.add("C");
		list.add(1, "X");

		assertEquals("X", list.get(1));
	}

	/**
	 * Tests MyDLL's add method.
	 */
	@Test
	void testAddObject() {

		list.add("A");

		assertEquals("A", list.get(0));
	}

	/**
	 * Tests MyDLL's add all method.
	 */
	@Test
	void testAddAll() {

		list.add("A");
		list.add("B");
		list.add("C");

		ListADT<Object> list2 = new MyDLL<>();

		list2.add("D");
		list2.add("E");
		list2.add("F");

		assertTrue(list.addAll(list2));
	}

	/**
	 * Tests MyDLL's get method.
	 */
	@Test
	void testGet() {

		list.add("A");

		assertEquals("A", list.get(0));
	}

	/**
	 * Tests MyDLL's remove with index method.
	 */
	@Test
	void testRemoveInt() {

		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		list.remove(1);

		assertEquals("C", list.get(1));
	}

	/**
	 * Tests MyDLL's remove by object method.
	 */
	@Test
	void testRemoveObject() {

		list.add("A");
		list.add("B");
		list.add("C");

		assertEquals("B", list.get(1));
	}

	/**
	 * Tests MyDLL's set method.
	 */
	@Test
	void testSet() {

		list.add("A");
		list.add("B");
		list.add("C");

		list.set(2, "X");

		assertEquals("X", list.get(2));
	}

	/**
	 * Tests MyDLL's empty method.
	 */
	@Test
	void testIsEmpty() {

		assertEquals(0, list.size());
	}

	/**
	 * Tests MyDLL's contains method.
	 */
	@Test
	void testContains() {

		list.add("A");
		list.add("B");
		list.add("C");

		assertTrue(list.contains("C"));
		assertFalse(list.contains("X"));
	}

	/**
	 * Tests MyDLL's object to array method.
	 */
	@Test
	void testToArrayObjectArray() {

		list.add("A");
		list.add("B");
		list.add("C");

		assertNotNull(list.toArray());
	}

	/**
	 * Tests MyDLL's element to array method.
	 */
	@Test
	<E> void testToArray() {

		list.add("A");
		list.add("B");
		list.add("C");

		E[] array = (E[]) new Object[10];

		assertNotNull(list.toArray(array));
	}

	@Test
	void testIterator() {
		assertNotNull(list.iterator());
	}

}
