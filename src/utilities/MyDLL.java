package utilities;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import ADT.Iterator;
import ADT.ListADT;

public class MyDLL<E> implements ListADT<E> {
	private int size;
	private Node head;
	private Node tail;
	private E[] array;

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = tail = null;
		size = 0;

	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {

		Node newNode = new Node(toAdd);
		// check if the is out of bounds
		Node node = head;
		if (index < size) {

			if (isEmpty()) {
				head = tail = node;
				return true;

			}

			for (int i = 0; i < size; i++) {

				if (i == index) {
					newNode.setNext(node);
					newNode.setPrev(node.getPrev());

					node.getPrev().setNext(newNode);
					node.setPrev(newNode);

				} else {
					node = node.getNext();
				}
			}
			size++;
			return true;

		} else

		{
			throw new IndexOutOfBoundsException();

		}
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		Node node = new Node(toAdd);
		// if the list is empty
		if (isEmpty()) {
			head = tail = node;
			size++;
			return true;

		} else if (!isEmpty()) { // if the list is not empty
			tail.setNext(node);

			node.setPrev(tail);

			tail = node;
			tail.setNext(null);
			size++;
			return true;
		}

		return false;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {

		E newArray = (E) toAdd.toArray();

		if (toAdd.size() == 0) {
			throw new NullPointerException();
		}

		if (toAdd.size() != 0) {
			for (int i = 0; i < toAdd.size(); i++) {
				add(toAdd.get(i));
			}
			return true;
		}

		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		Node current = head;
		if (isEmpty()) {
			return null;
		}

		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}

		return (E) current.getData();
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {

		if (index > size - 1 || index < 0) {
			throw new IndexOutOfBoundsException(
					"The position [ " + index + " ] is greater than the current size " + size + ".");
		}

		Node node = head;
		if (size == 1 && index == 0) {// only 1 element
			clear();
		} else if (index == 0 && size > 1) {// delete first
			head = head.getNext();
			head.setPrev(null);
		} else if (index == size - 1) {// delete last
			node = tail;
			tail.getPrev().setNext(null);
			tail.setPrev(null);

		} else {
			int i = 0;
			while (node != null) {

				if (i == index) {
					node.getNext().setPrev(node.getPrev());
					node.getPrev().setNext(node.getNext());

				} else {
					node = node.getNext();
				}
				i++;
			}

		}

		size--;
		return (E) node;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (size == 0) {
			throw new NullPointerException();
		}
		Node node = head;
		int i = 0;

		while (node != null) {
			if (node.getData().equals(toRemove)) {
				if (node == tail) {
					tail.getPrev().setNext(null);
					tail.setNext(null);

				} else if (node.getPrev() == null) {
					head = head.getNext();
					head.getPrev().setNext(null);
					head.setPrev(null);

				} else if (node != head || node != tail) {
					node.getPrev().setNext(node.getNext());
					node.getNext().setPrev(node.getPrev());

				}

			}
			node= node.getNext();
		}

		size--;
		return (E) node;

	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (size == 0) {
			throw new NullPointerException();
		}
		Node node = head;

		for (int i = 0; i < size; i++) {
			if (i == index) {
				node.setData(toChange);
			} else {
				node = node.getNext();
			}
		}
		return (E) node.getData();
	}

	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		Node current = head;
		if (head != null) {
			while (current != null) {
				if (current.getData().equals(toFind)) {
					return true;
				} else {
					current = current.getNext();
				}
			}
		}
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null) {
			throw new NullPointerException();
		}
		if (toHold.length < size) {
			// if the array is too small, allocate the new array the same component type
			toHold = (E[]) Array.newInstance(getClass().getComponentType(), size);
		} else if (toHold.length > size) {
			toHold[size] = null;
		}
		int i = 0;
		for (E element : toHold) {
			toHold[i] = element;
			i++;

		}
		return toHold;
	}

	@Override
	public Object[] toArray() {

		Node node = head;

		Object[] temp = new Object[size];

		Class<?> c1 = temp.getClass().getComponentType();

		E[] newArray = (E[]) Array.newInstance(c1, size);

		if (size > 0) {
			for (int i = 0; i < size; i++) {
				newArray[i] = (E) node.getData();
				node = node.getNext();
			}

		}
		return newArray;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new myNewIterator();
	}

	public class myNewIterator implements Iterator {
		private int pos;
		private int size;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return pos < size;
		}

		@Override
		public Object next() throws NoSuchElementException {
			if (pos >= size) {
				throw new NoSuchElementException();
			}
			E toReturn = array[pos++];
			return toReturn;
		}

	}

}