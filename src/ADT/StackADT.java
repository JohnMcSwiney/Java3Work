package ADT;

import java.io.Serializable;

public interface StackADT<E> extends Serializable {

	public void Stack(int i);

	/**
	 * Add the specified element at the top in this list.
	 * 
	 * @param element The element that you want to add in the list.
	 * @return a stack that has a element.
	 * @throws NullPointerException If the specified element is <code>null</code>
	 *                              and the list implementation does not support
	 *                              having <code>null</code> elements.
	 * 
	 */
	public void push(E element) throws NullPointerException;

	/**
	 * Remove the specified element at the top in this list.
	 * 
	 * @param element Remove the element from the topmost of the list.
	 * 
	 * @throws NullPointerException If the specified element is null and the list
	 *                              implementation does not support having
	 *                              <code>null</code> elements.
	 * 
	 */
	public E pop() throws NullPointerException;

	/**
	 * Access the specified element at the topmost in this list without removing the
	 * element.
	 * 
	 * @param element Access the element from the topmost of the list.
	 * @return a stack that a element.
	 * @throws NullPointerException If the specified element is null and the list
	 *                              implementation does not support having null
	 *                              elements.
	 * 
	 */
	public E peek() throws NullPointerException;

	/*
	 * Two stacks must contain equal items appearing in the same order.
	 * 
	 * @param that the stack you want to compare if it's equal with the current
	 * stack
	 * 
	 * @return <code>true<code> if these stacks contain equal items
	 */
	public boolean equals(StackADT<E> that);

	/*
	 * Searching for the position of the object.
	 * 
	 * @param object Is the object you are searching
	 * 
	 * @return The position of the element in a list/ stack
	 */
	public int search(E object);

	/**
	 * Returns an iterator over the elements in this list, in proper sequence.
	 * 
	 * @return An iterator over the elements in this list, in proper sequence. NB:
	 *         The return is of type , not
	 * 
	 */
	public Iterator<E> iterator();

	/**
	 * Returns an array containing all of the elements in this stack in proper
	 * sequence. Obeys the general contract of the
	 * 
	 * 
	 * @return An array containing all of the elements in this list in proper
	 *         sequence.
	 */
	public Object[] toArray();

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the
	 * 
	 * 
	 * @param toHold The array into which the elements of this list are to be
	 *               stored, if it is big enough; otherwise, a new array of the same
	 *               runtime type is allocated for this purpose.
	 * @return An array containing the elements of this list.
	 * @throws NullPointerException If the specified array is null.
	 */
	public E[] toArray(E[] copy) throws NullPointerException;

	/**
	 * Returns true if this list contains the specified element. More formally,
	 * returns true if and only if this list contains at least one element e.
	 * 
	 * @param toFind The element whose presence in this list is to be tested.
	 * @return <code>true</code> if this list contains the specified element.
	 * @throws NullPointerException If the specified element is null and the list
	 *                              implementation does not support having null
	 *                              elements.
	 */
	public boolean contains(E obj) throws NullPointerException;

	/**
	 * The size method will return the current element count contained in the list.
	 * 
	 * @return The current element count.
	 */
	public int size();

	/**
	 * Returns <code>true</code> if this list contains no elements.
	 * 
	 * @return <code>true</code> if this list contains no elements.
	 */
	public boolean isEmpty();

	/**
	 * Removes all of the elements from this list. This list will be empty after
	 * this call returns.
	 */
	public void clear();

}
