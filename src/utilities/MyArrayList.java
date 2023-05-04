package utilities;

import java.lang.reflect.Array;

import ADT.Iterator;
import ADT.ListADT;

public class MyArrayList<E> implements ListADT<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 105230250866964144L;
	private E[] array = null;
	private int size;

	public MyArrayList() {
		array = (E[]) new Object[10];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		array = null;
		size = 0;

	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (array == null) {
			throw new NullPointerException();
		}
		if (size < array.length) {
			for (int i = size - 1; i > 0; i--) {
				// int i=0;i>size; i--;
				array[i + 1] = array[i];
			}
			array[index] = toAdd;

			size++;
			return true;
		}
		return false;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (array == null) {
			throw new NullPointerException();
		}

		if (size < array.length) {
			add(size, toAdd);
			return true;
		}
		return false;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {

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
		if (index > array.length && index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} else {
			return remove(get(index));
		}

	}

	@Override
	public E remove(Object toRemove) throws NullPointerException {

		boolean isRemoved = false;

		if (array == null) {
			throw new NullPointerException();
		}
		Object[] updated = array;
		for (int i = 0; i < size; i++) {
			// Looks for selected object in array
			if (array[i] == toRemove && isRemoved == false) {
				updated[i] = array[i + 1];
				isRemoved = true;
			} // when found the rest of the array is shifted over
			else if (isRemoved == true) {
				// when the end is reached
				if (array[i + 1] == null) {
					updated[i] = array[i + 1];
					this.array = (E[]) updated;
					this.size = i;
					return (E) toRemove;
				} else {
					updated[i] = array[i + 1];
				}
			}
		}

		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (array == null) {
			throw new NullPointerException();
		}
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();

		}
		if (array != null) {
			array[index] = toChange;
		}
		return array[index];
	}

	@Override
	public boolean isEmpty() {
		if (array != null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {

		for (int i = 0; i < array.length; i++) {
			if (array[i] == toFind) {
				return true;
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

		Object[] newArray = new Object[array.length];

		for (int i = 0; i < newArray.length; i++) {

			newArray[i] = array[i];
		}

		return newArray;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyArrayListIterator();
	}

	private class MyArrayListIterator implements Iterator {
		private int pos;
		private int size;

		@Override
		public boolean hasNext() {
			return pos < size;
		}

		@Override
		public E next() {
			if (pos >= size) {
				System.out.println("No such element in the array");
			}
			E toReturn = array[pos++];
			return toReturn;
		}

	}

}