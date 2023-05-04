/**
 * 
 */
package utilities;

import java.util.NoSuchElementException;

import abstract_data_types.IteratorADT;
import abstract_data_types.ListADT;

public class MyArrayList<E> implements ListADT<E>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2194962780183568720L;
	
	private int size;
	
	private E[] internalArray;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public MyArrayList()
	{
		this.size = 0;
		internalArray = (E[]) new Object[1];
	}

	@Override
	public int size()
	{
		return this.size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear()
	{
		this.internalArray = (E[]) new Object[1];
		this.size = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(int inputIndex, E inputToAdd) throws NullPointerException, IndexOutOfBoundsException
	{
		 if (inputToAdd == null)
		 {
			 throw new NullPointerException();
		 }
		
		 if (inputIndex > this.size() || inputIndex < 0)
		 {
			 throw new IndexOutOfBoundsException();
		 }
		 
		 if (inputIndex == this.size()) 
		 {
			 E[] tempCopyOfOriginal = this.internalArray;
			 
			 this.internalArray = (E[]) new Object[this.size()+1];
			 
			 this.size++;
			 
			 for(int i = 0 ; i < tempCopyOfOriginal.length ; i++)
			 {
				 this.internalArray[i] = tempCopyOfOriginal[i];
			 }
			 
			 this.internalArray[this.size()-1] = inputToAdd;
			 
			 return true;
		 }
		 else
		 {
			 E[] tempCopyOfOriginal = this.internalArray;
			 
			 this.size++;
			 
			 this.internalArray = (E[]) new Object[this.size()];			 
			 
			 for(int i = 0 ; i < inputIndex ; i++)
			 {
				 this.internalArray[i] = tempCopyOfOriginal[i];
			 }
			 
			 this.internalArray[inputIndex] = inputToAdd;
			 
			 for (int i = inputIndex ; i < tempCopyOfOriginal.length ; i++)
			 {
				 if (tempCopyOfOriginal[i] != null)
				 {
					 this.internalArray[i + 1] = tempCopyOfOriginal[i];
				 }
			 }
			 
			 return true;
		 }
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E inputToAdd) throws NullPointerException
	{
		if (inputToAdd == null)
		{
			throw new NullPointerException();
		}
				
		E[] tempArray = (E[]) new Object[this.size()+1];
		
		for (int i = 0 ; i < this.size() ; i++)
		{
			tempArray[i] = internalArray[i];
		}
		
		this.internalArray = tempArray;
		
		this.internalArray[this.size()] = inputToAdd;
		
		this.size++;
		
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(ListADT<? extends E> inputToAdd) throws NullPointerException
	{
		if (inputToAdd == null)
		{
			throw new NullPointerException();
		}
		
		E[] tempInternalArray = this.internalArray;
		
		this.internalArray = (E[]) new Object[this.size() + inputToAdd.size()];
		
		for (int i = 0 ; i < this.size(); i++)
		{
			this.internalArray[i] = tempInternalArray[i];
		}
		
		for (int i = 0 ; i < this.size() + inputToAdd.size() ; i++)
		{
			this.internalArray[this.size() + i] = inputToAdd.get(i);
		}
		
		this.size += inputToAdd.size();
		
		return true;
	}

	@Override
	public E get(int inputIndex) throws IndexOutOfBoundsException
	{
		if (inputIndex < 0 || inputIndex > this.size())
		{
			throw new IndexOutOfBoundsException();
		}
		
		return this.internalArray[inputIndex];
	}

	@Override
	public E remove(int inputIndex) throws IndexOutOfBoundsException
	{
		E elementToReturn = this.internalArray[inputIndex];
		
		for (int i = inputIndex+1 ; i < this.size() ; i++)
		{
			this.internalArray[i-1] = this.internalArray[i];
		}
		
		this.internalArray[this.size()-1] = null;
		
		this.size--;
		
		return elementToReturn;
	}

	@Override
	public E remove(E inputToRemove) throws NullPointerException
	{
		if (inputToRemove == null)
		{
			throw new NullPointerException();
		}
		
		E elementToReturn = null;
		
		int indexOfElementToRemove = -1;
		
		for (int i = 0 ; i < this.size() ; i++)
		{
			if (inputToRemove.equals(this.internalArray[i]))
			{
				indexOfElementToRemove = i;
				elementToReturn = this.internalArray[i];
			}
		}
		
		if (indexOfElementToRemove != -1)
		{
			this.remove(indexOfElementToRemove);
		}
		
		this.size--;
		
		return elementToReturn;
	}

	@Override
	public E set(int inputIndex, E inputToChange) throws NullPointerException, IndexOutOfBoundsException
	{
		if (inputToChange == null)
		{
			throw new NullPointerException();
		}
		
		if (inputIndex > this.size() || inputIndex < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		E oldElement = this.internalArray[inputIndex];
		
		this.internalArray[inputIndex] = inputToChange;
		
		return oldElement;
	}

	@Override
	public boolean isEmpty()
	{
		if (this.size == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean contains(E inputToFind) throws NullPointerException
	{
		if (inputToFind == null)
		{
			throw new NullPointerException();
		}
				
		for (int i = 0 ; i < this.size() ; i++)
		{
			if (internalArray[i] == null)
			{
				
			}
			else if (internalArray[i].equals(inputToFind))
			{
				return true;
			}
		}
		
		return false;
	}
	
//	public E search(E inputToFind) throws NullPointerException
//	{
//		if (inputToFind == null)
//		{
//			throw new NullPointerException();
//		}
//		
//		for (int i = 0 ; i < this.size() ; i++)
//		{
//			if (internalArray[i] == null)
//			{
//				
//			}
//			else if (internalArray[i].equals(inputToFind))
//			{
//				return internalArray[i];
//			}
//		}
//		
//		return null;
//	}

	@SuppressWarnings("unchecked")
	
	public E[] toArray(E[] arrayToReturn) throws NullPointerException
	{
		if (arrayToReturn.length < this.size())
		{
			arrayToReturn = (E[]) new Comparable[this.size()];
		}
		
		for (int i = 0 ; i < this.size() ; i++)
		{
			arrayToReturn[i] = (E) this.internalArray[i];
		}

		return arrayToReturn;
	}

	@Override
	public Object[] toArray()
	{
		Object[] arrayToReturn = new Object[this.size()];
		
		for (int i = 0 ; i < this.size() ; i++)
		{
			arrayToReturn[i] = internalArray[i];
		}
		
		return arrayToReturn;
	}

	@Override
	public IteratorADT<E> iterator()
	{
		return new ArrayBasedIterator();
	}

	/*******************************INNER CLASSES*********************************/
	private class ArrayBasedIterator implements IteratorADT<E>
	{
		//Attributes
		private E[] 		copyOfElements;
		private int 		position;
		
		//Constructors
		@SuppressWarnings("unchecked")
		public ArrayBasedIterator()
		{
			copyOfElements = (E[]) (new Object[size()]);
			System.arraycopy(internalArray, 0, copyOfElements, 0, copyOfElements.length);
		}
		
		/* (non-Javadoc)
		 * @see linearUtilities.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext()
		{
			return position < copyOfElements.length;
		}
	
		/* (non-Javadoc)
		 * @see linearUtilities.Iterator#next()
		 */
		@Override
		public E next() throws NoSuchElementException
		{
			E toReturn = copyOfElements[position];
			position++;
			return toReturn;
		}
	}
	/************************END OF INNER CLASSES*********************************/
}
