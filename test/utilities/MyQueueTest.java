/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ADT.Iterator;
import exceptions.EmptyQueueException;
import exceptions.FullQueueException;

/**
 * @author dannguyen
 *
 */
class MyQueueTest<E> {

	MyQueue queue = new MyQueue();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		queue.QueueADT(100);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		queue.dequeueAll();
	}

	/**
	 * Tests MyQueue's QueueADT method
	 */
	@Test
	void testQueueADT() {

		assertEquals(100, queue.getCapacity());
		assertEquals(0, queue.size());

	}

	/**
	 * Tests MyQueue's Enqueue method
	 * 
	 * @throws FullQueueException
	 * @throws NullPointerException
	 * @throws EmptyQueueException
	 * @throws IndexOutOfBoundsException
	 */
	@Test
	void testEnqueue() throws NullPointerException, FullQueueException, IndexOutOfBoundsException, EmptyQueueException {
//		fail("Not yet implemented");

		queue.enqueue("boo");

		assertEquals("boo", queue.peek());

	}

	/**
	 * Tests MyQueue's Dequeue method
	 * @throws FullQueueException 
	 * @throws NullPointerException 
	 * @throws EmptyQueueException 
	 */
	@Test
	void testDequeue() throws NullPointerException, FullQueueException, EmptyQueueException {
		// fail("Not yet implemented");

		queue.enqueue(9);
		queue.enqueue(14);
		queue.dequeue();

		assertEquals(14, queue.peek());

	}

	/**
	 * Tests MyQueue's Peek method
	 * @throws FullQueueException 
	 * @throws NullPointerException 
	 * @throws EmptyQueueException 
	 * @throws IndexOutOfBoundsException 
	 */
	@Test
	void testPeek() throws NullPointerException, FullQueueException, IndexOutOfBoundsException, EmptyQueueException {

		queue.enqueue("yoki");
		queue.enqueue("ramen");
		queue.dequeue();
		assertEquals("ramen", queue.peek());
	}

	/**
	 * Tests MyQueue's Equals method
	 * @throws FullQueueException 
	 * @throws NullPointerException 
	 */
	@Test
	void testEquals() throws NullPointerException, FullQueueException {

		MyQueue queueOne = new MyQueue();
		queueOne.QueueADT(20);
		queueOne.enqueue(2);
		queueOne.enqueue(4);
		queueOne.enqueue(6);
		queueOne.enqueue(8);
		MyQueue queueTwo = new MyQueue();

		queueTwo.QueueADT(20);
		queueTwo.enqueue(2);
		queueTwo.enqueue(4);
		queueTwo.enqueue(6);
		queueTwo.enqueue(8);

		assertTrue(queueTwo.equals(queueOne));

	}

	/**
	 * Tests MyQueue's Iterator method
	 */
	@Test
	void testIteratorEmpty() {
		assertNotNull(queue.iterator());
	}



	/**
	 * Tests MyQueue's ToArray Method that return an Object Array method
	 * @throws FullQueueException 
	 * @throws NullPointerException 
	 */
	@Test
	void testObjectToArray() throws NullPointerException, FullQueueException {

		queue.enqueue(22);
		queue.enqueue(23);
		queue.enqueue(24);
		queue.enqueue(25);

		assertNotNull(queue.toArray());

	}

	/**
	 * Tests MyQueue's ToArray Method that return an Element Array method
	 * @throws FullQueueException 
	 * @throws NullPointerException 
	 */
	@Test
	void testElementToArray() throws NullPointerException, FullQueueException {

		queue.enqueue(32);
		queue.enqueue(33);
		queue.enqueue(34);
		queue.enqueue(35);

		assertNotNull(queue.toArray(queue.getData()));

	}

	/**
	 * Tests MyQueue's Is Full method
	 * @throws FullQueueException 
	 * @throws NullPointerException 
	 */
	@Test
	void testIsFull() throws NullPointerException, FullQueueException {

		MyQueue queueFull = new MyQueue();

		queueFull.QueueADT(3);

		queueFull.enqueue(11);
		queueFull.enqueue(22);

		assertFalse(queueFull.isFull());

		queueFull.enqueue(33);

		assertTrue(queueFull.isFull());
	}

	/**
	 * Tests MyQueue's Size method
	 * @throws FullQueueException 
	 * @throws NullPointerException 
	 */
	@Test
	void testSize() throws NullPointerException, FullQueueException {

		MyQueue queueSize = new MyQueue();

		queueSize.QueueADT(100);

		queueSize.enqueue("a");
		queueSize.enqueue("b");
		queueSize.enqueue("c");

		assertNotEquals(4, queueSize.size());

		queueSize.enqueue("d");

		assertEquals(4, queueSize.size());

	}

	/**
	 * Tests MyQueue's Is Empty method
	 * @throws FullQueueException 
	 * @throws NullPointerException 
	 */
	@Test
	void testIsEmpty() throws NullPointerException, FullQueueException {

		MyQueue queueEmpty = new MyQueue();

		queueEmpty.QueueADT(3);

		assertTrue(queueEmpty.isEmpty());

		queueEmpty.enqueue(11);
		queueEmpty.enqueue(22);

		assertFalse(queueEmpty.isEmpty());
	}

	/**
	 * Tests MyQueue's Dequeue All method
	 * 
	 * @throws FullQueueException
	 * @throws NullPointerException
	 */
	@Test
	void testDequeueAll() throws NullPointerException, FullQueueException {

		queue.enqueue(10);
		queue.enqueue(20);
		assertNotEquals(0, queue.size());

		queue.dequeueAll();

		assertEquals(0, queue.size());
	}

}
