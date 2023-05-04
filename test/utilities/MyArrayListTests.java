/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ADT.ListADT;

/**
 * @author Dan Nguyen
 * @param <E>
 *
 */
class MyArrayListTests {
	ListADT<Object> list;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setup() throws Exception {
		list = new MyArrayList<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list.clear();
	}

	/**
	 * Tests MyArrayList's size method
	 */
	@Test
	void testSize() {


		list.add("boo");
		list.add("yoki");

		assertEquals(2, list.size());
	}

	/**
	 * Tests MyArrayList's clear method
	 */
	@Test
	void testClear() {
//		fail("Not yet implemented");

		list.add("goldfish");
		list.add("frog");
		list.add("gorilla");

		assertNotNull(list);

		list.clear();

		assertEquals(0, list.size());

	}

	/**
	 * Tests MyArrayList's add with index method
	 */
	@Test
	void testAddIndex() {
//		fail("Not yet implemented");

		list.add("purple");
		list.add("green");
		list.add("blue");
		list.add(1, "red");

		assertEquals("red", list.get(1));

	}

	/**
	 * Tests MyArrayList's add method
	 */
	@Test
	void testAdd() {
//		fail("Not yet implemented");

		list.add("riki");

		assertEquals("riki", list.get(0));

	}

	/**
	 * Tests MyArrayList's add all method
	 */
	@Test
	void testAddAll() {
//		fail("Not yet implemented");

		list.add("riki");
		list.add("george");
		list.add("marzhan");

		ListADT<Object> list2 = new MyArrayList<>();

		list2.add("rocky");
		list2.add("paulie");
		list2.add("tiana");

		assertTrue(list.addAll(list2));
	}

	/**
	 * Tests MyArrayList's get method
	 */
	@Test
	void testGet() {
//		fail("Not yet implemented");

		list.add("spike");

		assertEquals("spike", list.get(0));

	}

	/**
	 * Tests MyArrayList's remove with index method
	 */
	@Test
	void testRemoveIndex() {
//		fail("Not yet implemented");

		list.add("kiki");
		list.add("lily");
		list.add("yoki");

		assertEquals("lily", list.remove(1));

	}

	/**
	 * Tests MyArrayList's remove by object method
	 */
	@Test
	void testRemoveObject() {
//		fail("Not yet implemented");

		list.add("luna");
		list.add("ivy");
		list.add("toad");

		assertEquals("luna", (Object) list.remove("luna"));

	}

	/**
	 * Tests MyArrayList's set method
	 */
	@Test
	void testSet() {
//		fail("Not yet implemented");

		list.add("daisy");
		list.add("topaz");
		list.add("sabrina");
		list.add("zhibek");

		list.set(2, "kia");

		assertEquals("kia", list.get(2));

	}

	/**
	 * Tests MyArrayList's is empty method
	 */
	@Test
	void testIsEmpty() {
//		fail("Not yet implemented");

		assertEquals(0, list.size());
	}

	/**
	 * Tests MyArrayList's contains method
	 */
	@Test
	void testContains() {
//		fail("Not yet implemented");

		list.add("marzhan");
		list.add("tiana");
		list.add("george");
		list.add("paulie");

		assertTrue(list.contains("tiana"));
		assertFalse(list.contains("rocky"));
	}

	/**
	 * Tests MyArrayList's object to array method
	 */
	@Test
	void testObjectToArray() {
//		fail("Not yet implemented");

		list.add("way");
		list.add("rocky");
		list.add("daffy");
		list.add("vinza");
		list.add("maang");

		assertNotNull(list.toArray());

	}

	/**
	 * Tests MyArrayList's element to array method
	 */
	@Test
	<E> void testElementToArray() {
//		fail("Not yet implemented");

		list.add("way");
		list.add("rocky");
		list.add("daffy");
		list.add("vinza");
		list.add("maang");

		E[] array1 = (E[]) new Object[10];

		assertNotNull(list.toArray(array1));
	}

	/**
	 * Tests MyArrayList's iterator method
	 */
	@Test
	void testIterator() {
//		fail("Not yet implemented");

		assertNotNull(list.iterator());
	}

}
