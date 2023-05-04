/**
 * 
 */
package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ADT.Iterator;
import ADT.StackADT;
import exceptions.EmptyQueueException;

/**
 * @author Dan Nguyen
 * @param <E>
 *
 */
class MyStackTest<E> {
	private StackADT<E> stack;
	private MyStack myStack;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.stack = new MyStack<>();
		this.myStack = new MyStack();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		stack = null;
	}

	/**
	 * Test method for {@link utilities.MyStack#Stack(int)}.
	 */
	@Test
	void testStack() {
		int capacity = 10;
		int size = 0;
		myStack.Stack(capacity);

		assertEquals(10, myStack.getCapacity());
		assertEquals(size, myStack.getSize());

	}

	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPush() {
		myStack.Stack(10);
		myStack.push(10);
		assertEquals(myStack.peek(), 10);
		myStack.pop();
		myStack.push(30);
		assertEquals(myStack.peek(), 30);

	}

	/**
	 * Test method for {@link utilities.MyStack#pop(java.lang.Object)}.
	 */
	@Test
	void testPop() {
		myStack.Stack(10);
		myStack.push(10);
		myStack.push(20);
		myStack.push(30);
		myStack.pop();
		assertEquals(myStack.peek(), 20);
		myStack.pop();
		assertEquals(myStack.pop(), 10);
	}

	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testPeek() {
		myStack.Stack(10);
		myStack.push(10);
		myStack.push(20);
		myStack.push(30);

		assertEquals(myStack.peek(), 30);
		myStack.pop();
		assertEquals(myStack.peek(), 20);
	}

	/**
	 * Test method for {@link utilities.MyStack#equals(ADT.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfE() {
		MyStack s1 = new MyStack();

		s1.Stack(10);
		s1.push("A");
		s1.push("B");
		s1.push("C");
		s1.push("D");

		MyStack s2 = new MyStack();

		s2.Stack(10);
		s2.push("A");
		s2.push("B");
		s2.push("C");
		s2.push("D");

		assertTrue(s1.equals(s2));

	}

	/**
	 * Test method for {@link utilities.MyStack#iterator()}.
	 */
	@Test
	void testIterator() {
		assertNotNull(myStack.iterator());
	}
	

	/**
	 * Test method for {@link utilities.MyStack#toArray()}.
	 */
	@Test
	void testToArray() {
		myStack.Stack(5);
		myStack.push("A");
		myStack.push("B");
		myStack.push("C");

		assertNotNull(myStack.toArray());
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		myStack.Stack(5);
		myStack.push("A");
		myStack.push("B");
		myStack.push("C");

		assertNotNull(myStack.toArray(myStack.getData()));
	}

	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearch() {
		myStack.Stack(10);
		myStack.push(10);
		myStack.push(20);

		assertEquals(myStack.search(10), 0);

	}

	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {

		int capacity = 10;
		int size = 0;

		Object test = new Object();
		myStack.Stack(capacity);
		myStack.push(test);

		assertTrue(myStack.contains(test));

	}

	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	void testSize() {
		int capacity = 10;
		int size = 0;
		myStack.Stack(capacity);
		assertEquals(size, myStack.getSize());
	}

	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(myStack.isEmpty());
		assertEquals(0, this.myStack.getSize());
	}

	/**
	 * Test method for {@link utilities.MyStack#clear()}.
	 */
	@Test
	void testClear() {
		int capacity = 10;
		int size = 0;
		myStack.Stack(capacity);

		assertEquals(size, 0);

	}

	/**
	 * Test method for {@link utilities.MyStack#getCapacity()}.
	 */
	@Test
	void testGetCapacity() {
		int capacity = 10;
		int size = 0;
		myStack.Stack(capacity);

		assertEquals(capacity, myStack.getCapacity());

	}

	/**
	 * Test method for {@link utilities.MyStack#getSize()}.
	 */
	@Test
	void testGetSize() {
		int capacity = 10;
		int size = 0;
		myStack.Stack(capacity);

		assertEquals(size, myStack.getSize());
	}

}
