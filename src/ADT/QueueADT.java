package ADT;

import java.io.Serializable;

import exceptions.EmptyQueueException;
import exceptions.FullQueueException;

public interface QueueADT<E> extends Serializable {

	// array based && LinkedList based

	/**
	 * <p>
	 * This QueueADT interface is designed as a base for the Queue data structures.
	 * To use this interface you will need to implement all methods included.
	 * </p>
	 * 
	 * @param <E> This is used to hold the type of elements the Queue will utilize
	 */
	public void QueueADT(int i);

	/**
	 * 
	 * The enqueue method appends the chosen element to the end of the Queue.
	 * 
	 * @param add Element to be appended to this list.
	 * @return The element that will be enqueued
	 * @throws NullPointerException      This exception occurs when the value of
	 *                                   element E is null.
	 * @throws FullQueueException
	 * @throws IndexOutOfBoundsException This exception occurs when the value of the
	 *                                   index is out of the Queue's bounds.
	 */
	public E enqueue(E element) throws NullPointerException, FullQueueException;

	/**
	 * 
	 * The dequeue method removes the first element from the queue, moving all other
	 * elements forward in the queue.
	 * 
	 * @return This will return the element that was removed from the queue.
	 * @throws NullPointerException This exception occurs when the value of element
	 *                              E is null.
	 * @throws EmptyQueueException
	 * 
	 */
	public E dequeue() throws NullPointerException, EmptyQueueException;

	/**
	 * 
	 * The peek method allows viewing the first element in a Queue without making
	 * any alterations to the Queue.
	 * 
	 * @return This will return the first element in the Queue
	 * @throws NullPointerException      This exception occurs when the value of
	 *                                   element E is null.
	 * @throws IndexOutOfBoundsException This exception occurs when the value of the
	 *                                   index is out of the Queue's bounds.
	 * @throws EmptyQueueException
	 */
	public E peek() throws NullPointerException, IndexOutOfBoundsException, EmptyQueueException;

	/**
	 * 
	 * The equals method compares the values of two elements to determine if they
	 * are equal.
	 * 
	 * @param that The element that will be compared to
	 * @return This will return true if both elements are of equal value, otherwise
	 *         returns false.
	 */
	public boolean equals(QueueADT<E> that);

	/**
	 * This will create a iterator to run travel through the elements of the Queue.
	 * 
	 * @return This will return an iterator to traverse the Queue.
	 */
	public Iterator<E> iterator();

	/**
	 * This will create an array of objects containing all the elements of the Queue
	 * in the identical order.
	 * 
	 * @return This returns an array of objects with the elements in the same order
	 *         they were in the Queue.
	 */
	public Object[] toArray();

	/**
	 * This will create an array of elements containing all the elements of the
	 * Queue in the identical order.
	 * 
	 * @param copy The element E array that will be used to create the duplicate
	 *             array.
	 * @return This returns an array of elements with the elements in the same order
	 *         they were in the Queue.
	 * @throws NullPointerException This exception occurs when the value of element
	 *                              E is null.
	 */
	public E[] toArray(E[] copy) throws NullPointerException;

	/**
	 * 
	 * The isFull method is used when a Queue has fixed size. It is used to
	 * determine if the number of elements are at the Queue's maximum capacity or
	 * not.
	 * 
	 * @return This will return true if the number of elements in the Queue is at
	 *         the maximum capacity, otherwise returns false.
	 */
	public boolean isFull();

	/**
	 * The size method is used to view the number of elements in the Queue at the
	 * time of access.
	 * 
	 * @return The amount of elements currently in the Queue.
	 */
	public int size();

	/**
	 * The isEmptymethod is used to determine if a Queue does not contain any
	 * elements.
	 * 
	 * @return This returns true if there are no elements in the Queue, otherwise
	 *         the Queue is not empty.
	 */
	public boolean isEmpty();

	/**
	 * The dequeueAll method is used to clear the Queue. Each element is removed
	 * from queue in the first-in, first-out sequence.
	 */
	public void dequeueAll();
}