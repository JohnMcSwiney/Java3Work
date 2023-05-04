package utilities;

import java.lang.reflect.Array;

import javax.lang.model.type.ArrayType;

import ADT.Iterator;
import ADT.StackADT;

public class MyStack<E> implements StackADT<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 733021355610782032L;
	private int capacity;
	private E[] data = null;
	private int size;

	private E[] elements;

	@SuppressWarnings("unchecked")
	@Override
	public void Stack(int capacity) {
		this.capacity = capacity;
		data = (E[]) new Object[capacity];
		int size = 0;

	}

	@Override
	public void push(E element) throws NullPointerException {
		if (size == capacity) {
			System.out.println("Stack is full");
		} else
			size++;
		data[size - 1] = element;
		System.out.println(element + " was added to the top of the stack");

	}

	@Override
	public E pop() throws NullPointerException {

		if (size == 0) {
			System.out.println("The stack is empty");
		} else

			size--;
		E element = data[size];
		System.out.println(element + " The topmost element was removed from  the stack");

		return element;
	}

	@Override
	public E peek() throws NullPointerException {
		return data[size - 1];
	}

	/*
	 * NOT SURE what it does
	 */
	@Override
	public boolean equals(StackADT<E> that) {
		boolean equals = false;
		Object newArray[] = that.toArray();

		if (size == newArray.length) {
			for (int i = 0; i < size; i++) {
				for (int j = newArray.length - 1; j >= 0; j--) {
					if (data[i] == newArray[j]) {

						equals = true;
					} else {

						equals = false;
						break;
					}
					i++;
				}

			}

		}
		return equals;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyStackIterator();
	}

	private class MyStackIterator implements Iterator {
		private int pos;
		private int size;
		E toReturn;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return pos < size;
		}

		@Override
		public E next() {
			if (pos >= size) {
				System.out.println("No Such element in the stack");
			}else {
				 toReturn = data[pos++];
			}
			
			return toReturn;
		}

	}

	@Override
	public Object[] toArray() {
		// flips inputted elements around.
		// uses the stack in the system currently

		Class<?> clazz = data.getClass().getComponentType();

		E[] newArray = (E[]) Array.newInstance(clazz, size);

		int stackIndex = size;

		if (size > 0) {
			for (int i = 0; i < size; i++) {
				newArray[stackIndex - 1] = data[i];
				stackIndex--;
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

			Class<?> clazz = copy.getClass().getComponentType();
			E[] a = (E[]) Array.newInstance(clazz, copy.length + 1);
			int i = 0;

			for (E element : copy) {
				copy[i] = element;
				i++;
			}
			for (int j = 0; j < copy.length; j++) {
				a[j] = copy[j];
			}
			a[copy.length] = null;
			System.out.println(a[copy.length]);
			copy = a;

		}

		else {
			int i = 0;
			for (E element : copy) {
				if (element == null) {
					return copy;
				} else {
					copy[i] = element;
					i++;
				}
			}

		}
		Class<?> clazz = copy.getClass().getComponentType();
		E[] newArray = (E[]) Array.newInstance(clazz, copy.length);
		int stackIndex = copy.length;

		for (int b = 0; b < copy.length; b++) {
			newArray[stackIndex - 1] = copy[b];
			stackIndex--;
		}

		copy = newArray;
		return copy;

	}

	@Override
	public int search(E object) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == object) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(E obj) throws NullPointerException {

		for (int i = 0; i < data.length; i++) {
			if (data[i] == obj) {
				return true;
			}
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
	public void clear() {
		size = 0;
		data = null;

	}

	public int getCapacity() {
		return capacity;
	}

	public int getSize() {
		return size;
	}

	public E[] getData() {
		return data;
	}

}
