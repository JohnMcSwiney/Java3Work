package utilities;

import java.lang.reflect.Array;

import ADT.Iterator;
import ADT.QueueADT;
import exceptions.EmptyQueueException;
import exceptions.FullQueueException;

public class MyQueue<E> implements QueueADT<E> {

	private static final long serialVersionUID = 4895599864565933543L;
	private int capacity;
	private int size;
	private E[] data;
	private int front;

	@SuppressWarnings("unchecked")
	@Override
	public void QueueADT(int capacity) {
		this.capacity = capacity;
		data = (E[]) new Object[capacity];
		size = 0;
		front = 0;
	}

	@Override
	public E enqueue(E element) throws NullPointerException, FullQueueException {

		if (size >= capacity) {
			throw new FullQueueException("Queue is full");
		} else {
			size++;
			data[size - 1] = element;

			System.out.println("The element element was added , which is: " + element);
		}

		return element;
	}

	@Override
	public E dequeue() throws NullPointerException, EmptyQueueException {
		if (size < 0) {
			throw new EmptyQueueException("Queue is empty");
		}
		size--;
		front++;
		System.out.println("The element at the front is: " + data[front]);
		return data[front];
	}

	@Override
	public E peek() throws NullPointerException, IndexOutOfBoundsException, EmptyQueueException {
		if (size == 0) {
			throw new EmptyQueueException("Queue is empty");
		}

		if (front == -1) {
			return data[0];
		} else {
			return data[front];
		}

	}

	@Override
	public boolean equals(QueueADT<E> that) {

		Object thatArray[] = that.toArray();
		boolean equals = false;
		if (size == thatArray.length) {
			for (int i = 0; i < size; i++) {
				if (data[i].equals(thatArray[i])) {
					equals = true;
				} else {
					equals = false;
					break;
				}

			}

		}
		return equals;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyQueueIterator();
	}

	private class MyQueueIterator implements Iterator {
		private int pos;
		private int size;

		@Override
		public boolean hasNext() {
			return pos < size;
		}

		@Override
		public E next() throws EmptyQueueException {
			if (pos >= size) {
				throw new EmptyQueueException();
			}
			E toReturn = data[pos++];
			return toReturn;
		}

	}

	@Override
	public Object[] toArray() {
		// flips inputted elements around.
		// uses the stack in the system currently

		Class<?> c1 = data.getClass().getComponentType();

		E[] newArray = (E[]) Array.newInstance(c1, size);

		int queueIndex = size;

		if (size > 0) {
			for (int i = 0; i < size; i++) {
				newArray[i] = data[i];
			}

		}
		return newArray;
	}

	@Override
	public E[] toArray(E[] copy) throws NullPointerException {

		if (copy == null) {
			throw new NullPointerException();
		}
		if (copy.length < size) {
			// if the array is too small, allocate the new array the same component type
			copy = (E[]) Array.newInstance(getClass().getComponentType(), size);
		} else if (copy.length > size) {
			copy[size] = null;
		}
		int i = 0;
		for (E element : copy) {
			copy[i] = element;
			i++;

		}
		return copy;
	}

	@Override
	public boolean isFull() {
		if (size == capacity) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void dequeueAll() {
		size = 0;
		data = null;

	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public E[] getData() {
		return data;
	}

	public void setData(E[] data) {
		this.data = data;
	}

}
