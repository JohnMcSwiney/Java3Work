/**
 * 
 */
package sorting;

import java.util.Comparator;

/**
 * This class implements the Comparator interface to allow two shapes
 * to be compared by their calculated volume.
 *
 */
public class SortArray
{
	/**
	 * Bubble sort for the given array of comparable objects
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 */
	public static <T extends Comparable<T>> void bubbleSort (T[] inputArray)
	{		
		for (int j = 0; j < inputArray.length - 1; j++)
		{
			for (int i = 0; i < inputArray.length - j - 1; i++)
			{
				if (inputArray[i].compareTo(inputArray[i+1]) < 0)
				{
					T placeholder = inputArray[i];
					
					inputArray[i] = inputArray [i+1];
					
					inputArray[i+1] = placeholder;
				}
			}
		}
	}
	
	/**
	 * Bubble sort for object array using supplied comparator
	 * @param <T> any class
	 * @param inputArray an array of any object type.
	 * @param comparator any comparator that works on generic objects
	 */
	public static <T> void bubbleSort (T[] inputArray,  Comparator<? super T> comparator)
	{	
		for (int j = 0; j < inputArray.length - 1; j++)
		{
			for (int i = 0; i < inputArray.length - j - 1; i++)
			{
				if (comparator.compare(inputArray[i], inputArray[i+1]) < 0)
				{
					T placeholder = inputArray[i];
					
					inputArray[i] = inputArray [i+1];
					
					inputArray[i+1] = placeholder;
				}
			}
		}
	}
	
	/**
	 * Selection sort for the given array of comparable objects
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 */
	public static <T extends Comparable<? super T>> void selectionSort (T[] inputArray)
	{
		for (int i = 0; i < inputArray.length; i++)
		{
			int indexOfMinimum = i;
			
			for (int j = i+1; j < inputArray.length; j++)
			{
				if (inputArray[indexOfMinimum].compareTo(inputArray[j]) < 0)
				{
					indexOfMinimum = j;
				}
			}
			
			T placeholder = inputArray[i];
			
			inputArray[i] = inputArray[indexOfMinimum];
			
			inputArray[indexOfMinimum] = placeholder;
		}
	}
	
	/**
	 * Selection sort for object array using supplied comparator
	 * @param <T> any class
	 * @param inputArray an array of any object type.
	 * @param comparator any comparator that works on generic objects
	 */
	public static <T> void selectionSort (T[] inputArray,  Comparator<? super T> comparator)
	{
		for (int i = 0; i < inputArray.length; i++)
		{
			int indexOfMinimum = i;
			
			for (int j = i+1; j < inputArray.length; j++)
			{
				if (comparator.compare(inputArray[indexOfMinimum], inputArray[j]) < 0)
				{
					indexOfMinimum = j;
				}
			}
			
			T placeholder = inputArray[i];
			
			inputArray[i] = inputArray[indexOfMinimum];
			
			inputArray[indexOfMinimum] = placeholder;
		}
	}
	
	/**
	 * Insertion sort for the given array of comparable objects
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 */
	public static <T extends Comparable<? super T>> void insertionSort (T[] inputArray)
	{
		for (int i = 1; i < inputArray.length; i++)
		{
			T valueToSort = inputArray[i];
			
			int j = i-1;
			
			while (j >= 0 && valueToSort.compareTo(inputArray[j]) > 0)
			{
				inputArray[j+1] = inputArray[j];
				
				j--;
			}
			
			inputArray[j+1] = valueToSort;
		}
	}
	
	/**
	 * Insertion sort for object array using supplied comparator
	 * @param <T> any class
	 * @param inputArray an array of any object type.
	 * @param comparator any comparator that works on generic objects
	 */
	public static <T> void insertionSort (T[] inputArray,  Comparator<? super T> comparator)
	{
		for (int i = 1; i < inputArray.length; i++)
		{
			T valueToSort = inputArray[i];
			
			int j = i-1;
			
			while (j >= 0 && comparator.compare(valueToSort, inputArray[j]) > 0)
			{
				inputArray[j+1] = inputArray[j];
				
				j--;
			}
			
			inputArray[j+1] = valueToSort;
		}
	}
	
	/**
	 * Launching point for a merge sort for the given array of comparable objects
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 */
	public static <T extends Comparable<? super T>> void mergeSort (T[] inputArray)
	{
		mergeRecursion (inputArray, 0, inputArray.length-1);
	}
	
	/**
	 * Acts as the recursive base for all merge sorts 
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 * @param leftIndex the left index of the sub-array
	 * @param rightIndex the right index of the sub-array
	 */
	private static <T extends Comparable<? super T>> void mergeRecursion (T[] inputArray, int leftIndex, int rightIndex)
	{
		// Keep diving array in half until the half is a single object.
		if (leftIndex < rightIndex)
		{
			// find the middle point of the array
			int middleIndex = (leftIndex + rightIndex) / 2;
			
			// mergeSort the left half
			mergeRecursion(inputArray, leftIndex, middleIndex);
			
			//mergeSort the right half
			mergeRecursion(inputArray, middleIndex+1, rightIndex);
			
			//Combine the two halves in proper order
			mergeHalves (inputArray, leftIndex, middleIndex, rightIndex);
		}
	}
	
	/**
	 * Merges sub arrays in the correct order
	 * @param <T> generic class
	 * @param <E> generic array object
	 * @param inputArray an array of any object type that implements the comparable interface
	 * @param leftIndex the left index of the sub-array
	 * @param middleIndex the index of the middle element of the sub-array
	 * @param rightIndex the right index of the sub-array
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<? super T>, E> void mergeHalves (T[] inputArray, int leftIndex, int middleIndex, int rightIndex)
	{
		// find length of left half 
		// when input array only has 2 elements,  left length = (0-0+1) = 1
		int leftLength = middleIndex - leftIndex + 1; 
		
		// find length of right half
		// when input array only has 2 elements, right length = (1-0) = 1
		int rightLength = rightIndex - middleIndex;
		
		// copy each side to it's own temporary array
		E[] leftTempArray = (E[]) new Object[leftLength];
		E[] rightTempArray = (E[]) new Object[rightLength];
		
		for (int i = 0; i < leftTempArray.length; i++)
		{
			leftTempArray[i] = (E)inputArray[leftIndex + i];
		}
		
		for (int i = 0; i < rightTempArray.length; i++)
		{
			rightTempArray[i] = (E)inputArray[(middleIndex + 1) + i];
		}
		
		// Place the two temporary arrays back into the inputArray in sorted order
		// sort order for descending is right > left
		
		// initialise variables to start of each temporary array
		int leftHalfIndex = 0;
		int rightHalfIndex = 0;
		
		// initialise variable to the start of the input array (leftIndex)
		int inputIndex = leftIndex;
		
		// run through each temporary array, placing them in input array in sorted order
		// run loop as long as we haven't exhausted one of the temporary arrays
		while (leftHalfIndex < leftLength && rightHalfIndex < rightLength)
		{
			// if right element is larger than left element, copy into original array
			// increment righthalfindex by 1
			if (((Comparable<? super T>) rightTempArray[rightHalfIndex]).compareTo((T) leftTempArray[leftHalfIndex]) > 0)
			{
				inputArray[inputIndex] = (T) rightTempArray[rightHalfIndex];
				rightHalfIndex++;
			}
			// otherwise copy left element into original array
			// incrememnt lefthalfindex by 1
			else
			{
				inputArray[inputIndex] = (T) leftTempArray[leftHalfIndex];
				leftHalfIndex++;
			}
			// only reaches this point if an element has been placed at the specific index
			// increment input index by 1
			inputIndex++;
		}
		
		//if left half wasn't exhausted, copy all remaining values into original array
		while (leftHalfIndex < leftLength)
		{
			inputArray[inputIndex] = (T) leftTempArray[leftHalfIndex];
			leftHalfIndex++;
			inputIndex++;
		}
		
		// if right half wasn't exhausted, copy all remaining values into original array
		while (rightHalfIndex < rightLength)
		{
			inputArray[inputIndex] = (T) rightTempArray[rightHalfIndex];
			rightHalfIndex++;
			inputIndex++;
		}
	}
	
	/**
	 * Launching point for a merge sort for object array using supplied comparator
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 * @param comparator any comparator that works on generic objects
	 */
	public static <T> void mergeSort (T[] inputArray,  Comparator<? super T> comparator)
	{
		mergeRecursion (inputArray, 0, inputArray.length-1, comparator);
	}
	
	/**
	 * Acts as the recursive base for all merge sorts 
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 * @param leftIndex the left index of the sub-array
	 * @param rightIndex the right index of the sub-array
	 * @param comparator any comparator that works on generic objects
	 */
	private static <T> void mergeRecursion (T[] inputArray, int leftIndex, int rightIndex, Comparator<? super T> comparator)
	{
		// Keep diving array in half until the half is a single object.
		if (leftIndex < rightIndex)
		{
			// find the middle point of the array
			int middleIndex = (leftIndex + rightIndex) / 2;
			
			// mergeSort the left half
			mergeRecursion(inputArray, leftIndex, middleIndex, comparator);
			
			//mergeSort the right half
			mergeRecursion(inputArray, middleIndex+1, rightIndex, comparator);
			
			//Combine the two halves in proper order
			mergeHalves (inputArray, leftIndex, middleIndex, rightIndex, comparator);
		}
	}
	
	/**
	 * Merges sub arrays in the correct order
	 * @param <T> generic class
	 * @param inputArray an array of any object type that implements the comparable interface
	 * @param leftIndex the left index of the sub-array
	 * @param middleIndex the index of the middle element of the sub-array
	 * @param rightIndex the right index of the sub-array
	 * @param comparator any comparator that works on generic objects
	 */
	private static <T> void mergeHalves (T[] inputArray, int leftIndex, int middleIndex, int rightIndex, Comparator<? super T> comparator)
	{
		// find length of left half 
		// when input array only has 2 elements,  left length = (0-0+1) = 1
		int leftLength = middleIndex - leftIndex + 1; 
		
		// find length of right half
		// when input array only has 2 elements, right length = (1-0) = 1
		int rightLength = rightIndex - middleIndex;
		
		// copy each side to it's own temporary array
		@SuppressWarnings("unchecked")
		T[] leftTempArray = (T[]) new Object[leftLength];
		@SuppressWarnings("unchecked")
		T[] rightTempArray = (T[]) new Object[rightLength];
		
		for (int i = 0; i < leftTempArray.length; i++)
		{
			leftTempArray[i] = inputArray[leftIndex + i];
		}
		
		for (int i = 0; i < rightTempArray.length; i++)
		{
			rightTempArray[i] = inputArray[(middleIndex + 1) + i];
		}
		
		// Place the two temporary arrays back into the inputArray in sorted order
		// sort order for descending is right > left
		
		// initialise variables to start of each temporary array
		int leftHalfIndex = 0;
		int rightHalfIndex = 0;
		
		// initialise variable to the start of the input array (leftIndex)
		int inputIndex = leftIndex;
		
		// run through each temporary array, placing them in input array in sorted order
		// run loop as long as we haven't exhausted one of the temporary arrays
		while (leftHalfIndex < leftLength && rightHalfIndex < rightLength)
		{
			// if right element is larger than left element, copy into original array
			// increment righthalfindex by 1
			if (comparator.compare(rightTempArray[rightHalfIndex]
												, leftTempArray[leftHalfIndex]) > 0)
			{
				inputArray[inputIndex] = rightTempArray[rightHalfIndex];
				rightHalfIndex++;
			}
			// otherwise copy left element into original array
			// incrememnt lefthalfindex by 1
			else
			{
				inputArray[inputIndex] = leftTempArray[leftHalfIndex];
				leftHalfIndex++;
			}
			// only reaches this point if an element has been placed at the specific index
			// increment input index by 1
			inputIndex++;
		}
		
		//if left half wasn't exhausted, copy all remaining values into original array
		while (leftHalfIndex < leftLength)
		{
			inputArray[inputIndex] = leftTempArray[leftHalfIndex];
			leftHalfIndex++;
			inputIndex++;
		}
		
		// if right half wasn't exhausted, copy all remaining values into original array
		while (rightHalfIndex < rightLength)
		{
			inputArray[inputIndex] = rightTempArray[rightHalfIndex];
			rightHalfIndex++;
			inputIndex++;
		}
	}
	
	/**
	 * Launching point for a quick sort for the given array of comparable objects
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 */
	public static <T extends Comparable<? super T>> void quickSort (T[] inputArray)
	{
		quickSortRecursion(inputArray, 0, inputArray.length-1);
	}
	
	/**
	 * Acts as the recursive base for all quick sorts 
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 * @param leftIndex the left index of the sub-array
	 * @param rightIndex the right index of the sub-array
	 */
	private static <T extends Comparable<? super T>> void quickSortRecursion (T[] inputArray, int leftIndex, int rightIndex)
	{
		int indexOfSplit = partition(inputArray, leftIndex, rightIndex);
		
		if (leftIndex < indexOfSplit - 1)
		{
			quickSortRecursion(inputArray, leftIndex, indexOfSplit - 1);
		}
		
		if (indexOfSplit < rightIndex)
		{
			quickSortRecursion(inputArray, indexOfSplit, rightIndex);
		}
	}
	
	/**
	 * Sorts sub-arrays into the correct order
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 * @param leftIndex the left index of the sub-array
	 * @param rightIndex the right index of the sub-array
	 * @return the left index to avoid resorting elements
	 */
	private static <T extends Comparable<? super T>> int partition (T[] inputArray, int leftIndex, int rightIndex)
	{
		// set pivot point to be median index in input array
		T pivotObject = inputArray[(rightIndex + leftIndex) / 2];
		
		// run through entire array until left index meets right index
		while (leftIndex <= rightIndex)
		{
			// increase leftIndex until an object with volume lower than pivot object is found
			while (inputArray[leftIndex].compareTo(pivotObject) > 0) 
			{
				leftIndex++;
			}
			// decrease rightIndex until an object with a volume greater than the pivot object is found
			while (pivotObject.compareTo(inputArray[rightIndex]) > 0)
			{
				rightIndex--;
			}
			// if leftIndex is smaller or equal to rightIndex then swap the objects
			if (leftIndex <= rightIndex)
			{
				T tempObject = inputArray[leftIndex];
				
				inputArray[leftIndex] = inputArray[rightIndex];
				
				inputArray[rightIndex] = tempObject;
				
				// increment leftIndex and decrement rightIndex to start process over again until they meet
				leftIndex++;
				rightIndex--;
			}
		}
		
		// return leftIndex (will be equal to rightIndex) so that recursive calls are based off previously sorted elements
		return leftIndex;
	}
	
	/**
	 * Launching point for a quick sort for the given array of comparable objects
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 * @param comparator any comparator that works on generic objects
	 */
	public static <T> void quickSort (T[] inputArray,  Comparator<? super T> comparator)
	{
		quickSortRecursion(inputArray, 0, inputArray.length-1, comparator);
	}
	
	/**
	 * Acts as the recursive base for all quick sorts 
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 * @param leftIndex the left index of the sub-array
	 * @param rightIndex the right index of the sub-array
	 * @param comparator any comparator that works on generic objects
	 */
	private static <T> void quickSortRecursion (T[] inputArray, int leftIndex, int rightIndex, Comparator<? super T> comparator)
	{
		int indexOfSplit = partition(inputArray, leftIndex, rightIndex, comparator);
		
		if (leftIndex < indexOfSplit - 1)
		{
			quickSortRecursion(inputArray, leftIndex, indexOfSplit - 1, comparator);
		}
		
		if (indexOfSplit < rightIndex)
		{
			quickSortRecursion(inputArray, indexOfSplit, rightIndex, comparator);
		}
	}
	
	/**
	 * Sorts sub-arrays into the correct order
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 * @param leftIndex the left index of the sub-array
	 * @param rightIndex the right index of the sub-array
	 * @param comparator any comparator that works on generic objects
	 * @return the left index to avoid resorting elements
	 */
	private static <T> int partition (T[] inputArray, int leftIndex, int rightIndex, Comparator<? super T> comparator)
	{
		// set pivot point to be median index in input array
		T pivotObject = inputArray[(rightIndex + leftIndex) / 2];
		
		// run through entire array until left index meets right index
		while (leftIndex <= rightIndex)
		{
			// increase leftIndex until an object with volume lower than pivot object is found
			while (comparator.compare(inputArray[leftIndex], pivotObject) > 0)
			{
				leftIndex++;
			}
			// decrease rightIndex until an object with a volume greater than the pivot object is found
			while (comparator.compare(pivotObject, inputArray[rightIndex]) > 0)
			{
				rightIndex--;
			}
			// if leftIndex is smaller or equal to rightIndex then swap the objects
			if (leftIndex <= rightIndex)
			{
				T tempObject = inputArray[leftIndex];
				
				inputArray[leftIndex] = inputArray[rightIndex];
				
				inputArray[rightIndex] = tempObject;
				
				// increment leftIndex and decrement rightIndex to start process over again until they meet
				leftIndex++;
				rightIndex--;
			}
		}
		
		// return leftIndex (will be equal to rightIndex) so that recursive calls are based off previously sorted elements
		return leftIndex;
	}
	
	/**
	 * Heap sort for the given array of comparable objects
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 */
	public static <T extends Comparable<? super T>> void heapSort (T[] inputArray)
	{
		// Build min heap
		for (int currentIndex = (inputArray.length / 2) - 1; currentIndex >= 0; currentIndex--)
		{
			// build heap starting at the middle index, working back to 0
			heapCreation(inputArray, inputArray.length, currentIndex);
		}
		
		// once min heap is created, sort the heap
		for (int currentIndex = inputArray.length -1; currentIndex >= 0; currentIndex--)
		{
			T placeholder = inputArray[0];
			inputArray[0] = inputArray[currentIndex];
			inputArray[currentIndex] = placeholder;
			
			// create a heap for the root element
			heapCreation(inputArray, currentIndex, 0);
		}
	}
	
	/**
	 * Heap sort for object array using supplied comparator
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 * @param comparator any comparator that works on generic objects
	 */
	public static <T> void heapSort (T[] inputArray,  Comparator<? super T> comparator)
	{
		// Build min heap
		for (int currentIndex = (inputArray.length / 2) - 1; currentIndex >= 0; currentIndex--)
		{
			// build heap starting at the middle index, working back to 0
			heapCreation(inputArray, inputArray.length, currentIndex, comparator);
		}
		
		// once min heap is created, sort the heap
		for (int currentIndex = inputArray.length -1; currentIndex >= 0; currentIndex--)
		{
			T placeholder = inputArray[0];
			inputArray[0] = inputArray[currentIndex];
			inputArray[currentIndex] = placeholder;
			
			// create a heap for the root element
			heapCreation(inputArray, currentIndex, 0, comparator);
		}
	}
	
	/**
	 * Create a min-heap for the given array of comparable objects
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 * @param maxIndex the max index of the data to be added to the heap
	 * @param startIndex the index at which to start adding data to the heap
	 */
	private static <T extends Comparable<? super T>> void heapCreation (T[] inputArray, int maxIndex, int startIndex)
	{
		int indexOfSmallestElement = startIndex;
		int indexOfLeftChild = (2 * startIndex) + 1;
		int indexOfRightChild = (2 * startIndex) + 2;
		
		// check if the left child is a valid index
		// check if left child is smaller than the currently smallest element
		if (indexOfLeftChild < maxIndex && inputArray[indexOfLeftChild].compareTo(inputArray[indexOfSmallestElement]) < 0)
		{
			indexOfSmallestElement = indexOfLeftChild;
		}

		// check if the right child is a valid index
		// check if right child is smaller than the currently smallest element
		if (indexOfRightChild < maxIndex && inputArray[indexOfRightChild].compareTo(inputArray[indexOfSmallestElement]) < 0)
		{
			indexOfSmallestElement = indexOfRightChild;
		}
		
		// if the method has found a smaller element than the one it started with
		// swap original smallest with new smallest and create a new heap using the original location of the new smallest element
		if (indexOfSmallestElement != startIndex)
		{
			T placeholder = inputArray[startIndex];
			inputArray[startIndex] = inputArray[indexOfSmallestElement];
			inputArray[indexOfSmallestElement] = placeholder;
			
			heapCreation(inputArray, maxIndex, indexOfSmallestElement);
		}
	}
	
	/**
	 * Create a min-heap for the given array of comparable objects
	 * @param <T> any class
	 * @param inputArray an array of any object type that implements the comparable interface
	 * @param maxIndex the max index of the data to be added to the heap
	 * @param startIndex the index at which to start adding data to the heap
	 * @param comparator any comparator that works on generic objects
	 */
	private static <T> void heapCreation (T[] inputArray, int maxIndex, int startIndex, Comparator<? super T> comparator)
	{
		int indexOfSmallestElement = startIndex;
		int indexOfLeftChild = (2 * startIndex) + 1;
		int indexOfRightChild = (2 * startIndex) + 2;
		
		// check if the left child is a valid index
		// check if left child is smaller than the currently smallest element
		if (indexOfLeftChild < maxIndex && comparator.compare(inputArray[indexOfLeftChild], inputArray[indexOfSmallestElement]) < 0)
		{
			indexOfSmallestElement = indexOfLeftChild;
		}

		// check if the right child is a valid index
		// check if right child is smaller than the currently smallest element
		if (indexOfRightChild < maxIndex && comparator.compare(inputArray[indexOfRightChild], inputArray[indexOfSmallestElement]) < 0)
		{
			indexOfSmallestElement = indexOfRightChild;
		}
		
		// if the method has found a smaller element than the one it started with
		// swap original smallest with new smallest and create a new heap using the original location of the new smallest element
		if (indexOfSmallestElement != startIndex)
		{
			T placeholder = inputArray[startIndex];
			inputArray[startIndex] = inputArray[indexOfSmallestElement];
			inputArray[indexOfSmallestElement] = placeholder;
			
			heapCreation(inputArray, maxIndex, indexOfSmallestElement, comparator);
		}
	}
}
