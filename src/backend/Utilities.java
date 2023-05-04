package backend;


import frontend.MenuV3;
import objects.Shape;


/**
* @author Johnny McSwiney
* @author Gia Nguyen
* @author Javaria Khan
* @author Mohummad Bhatti
*
* Utility class which contains the sorting algorithms that will sort a collection of comparables
*/ 
public class Utilities extends Shape {

	protected String sortUsing = "";
	
	private MenuV3 menu;
	
	// create getter and setter for sorting type 
	public String getSortUsing() {
		return sortUsing;
	}

	public void setSortUsing(String sortUsing) {
		this.sortUsing = sortUsing;
	}
	
	
	/**
	* Create a no arg utility constructor
	*
	*/

	public Utilities(){
		
	}


	// 2
			/**
			* Insertion Sort function
			*This algorithm compares each element in the array, one element at a time to see if one element is less than another element and swaps their position. 
			*The array is virtually split into a sorted partition and unsorted partition.
			*The elements in the unsorted partition are then checked with each element then they are moved to the sorted side. 
			*This continues for each element in the array until there are no more elements in the unsorted partition, thus the array is sorted.
			* 
			* @param temp[] takes in array that needs to be sorted
			* @param  first takes in the first index of the array
			* @param  last	takes in the last index of the array
			* @param  sortingUsing takes in the type needs to be sort (volume, base area, height)
			* @return temp return the temp that being sorted
			*
			*/

		public Shape[] insertionSort(Shape[] temp,int first, int last, String sortUsing) {
			
			switch(sortUsing.toLowerCase()) {
				case "h":
					//using height
					for (int i = 0; i < temp.length; i++) {

						Shape current = (Shape) temp[i];

						int j = i - 1;

						try {
							while (j >= 0 && ((Shape) temp[j]).compareTo(current) < 0) {
								temp[j + 1] = temp[j];
								j--;
							}
							temp[j + 1] = current;
						}

						catch (ArrayIndexOutOfBoundsException e) {
							e.getMessage();
						}
					}
					
					break;
					
				case "v":
					for (int i = 0; i < temp.length; i++) {

			            Shape current = (Shape) temp[i];

			            int j = i - 1;

			            try {
			                while (j >= 0 && Double.compare(((Shape) temp[j]).calcVolume(), current.calcVolume()) < 0) {
			                    temp[j + 1] = temp[j];
			                    j--;
			                }
			                temp[j + 1] = current;
			            }

			            catch (ArrayIndexOutOfBoundsException e) {
			                e.getMessage();
			            }
			        }
					break;
					
				case "a":
					for (int i = 0; i < temp.length; i++) {

			            Shape current = (Shape) temp[i];

			            int j = i - 1;

			            try {
			                while (j >= 0 && Double.compare(((Shape) temp[j]).calcBaseArea(), current.calcBaseArea()) < 0) {
			                    temp[j + 1] = temp[j];
			                    j--;
			                }
			                temp[j + 1] = current;

			            }

			            catch (ArrayIndexOutOfBoundsException e) {
			                e.getMessage();
			            }
			        }
					break;
				
			}
			return temp;
			
		}
			/**
			* Merge Sort function
			* This algorithm takes the array and splits the array in the middle, 
			  then proceeds to continuously split the subarrays using recursion until each element in the array is separated from one another.
			*
			* From there, the algorithm works backwards and brings back each element together by comparing.
			* If one element is less than the other element and rearranges, accordingly, until all elements are sorted back in one array.
			* @param temp[] takes in array that needs to be sorted
			* @param  first takes in the first index of the array
			* @param  last	takes in the last index of the array
			* @param  sortingUsing takes in the type needs to be sort (volume, base area, height)
			* @return temp return the temp that being sorted
			*
			*/
			public Shape[] mergeSort(Shape[] temp,int first, int last, String sortUsing) {

				
				int tempLength = temp.length;

				if (tempLength < 2) {
					return temp;
				}

				int middle = tempLength / 2;

				Shape[] left = new Shape[middle];

				Shape[] right = new Shape[tempLength - middle];

				for (int i = 0; i < middle; i++) {
					left[i] = temp[i];
				}

				for (int i = middle; i < tempLength; i++) {
					right[i - middle] = temp[i];
				}

				mergeSort(left,first,last, sortUsing);
				mergeSort(right,first, last, sortUsing);
				return merge(temp, left, right, sortUsing);
				
				
			}

			/**
			* Merge  function
			* This function will merge the left side array and the right side array 
			* @param temp[] takes in array that needs to be sorted
			* @param  first takes in the first index of the array
			* @param  last	takes in the last index of the array
			* @param  sortingUsing takes in the type needs to be sort (volume, base area, height)
			* @return temp return the temp that being sorted
			*
			*/
			public Shape[] merge(Shape[] temp, Shape[] left, Shape[] right, String sortUsing) {
				int leftSize = left.length;

				int rightSize = right.length;

				int i = 0;//left
				int j = 0;//right
				int k = 0;//final

				switch(sortUsing.toLowerCase()) {
					case "h":
						while (i < leftSize && j < rightSize) {
							if (left[i].compareTo(right[j]) > 0) {
								temp[k] = left[i];
								i++;
							}
							
							else {
								temp[k] = right[j];
								j++;
							}
							k++;
						}
						break;
						
					case "v":
						
						while (i < leftSize && j < rightSize) {
							if (compare(left[i],right[j], "v") > 0) {
								temp[k] = left[i];
								i++;
							}
							
							else {
								temp[k] = right[j];
								j++;
							}
							k++;
						}
	
						break;
					case "a":
						
						while (i < leftSize && j < rightSize) {
							if (compare(left[i],right[j], "a") > 0) {
								temp[k] = left[i];
								i++;
							}

							else {
								temp[k] = right[j];
								j++;
							}
							k++;
						}
						break;
						
						
						
				}
				
				
				while (i < leftSize) {
					temp[k] = left[i];
					i++;
					k++;
				}

				while (j < rightSize) {
					temp[k] = right[j];
					j++;
					k++;
					}
				
				return temp;
			}

			/**
			* Bubble sort function
			* Bubble sort is going in a linear fashion, if the left side index’s  is smaller than the right side index’s object (it only compares with the next index’s value) , 
			  then switch the position between these 2 indexes. This algorithm will go through the list many times until all the objects are at the right index.
			* @param arr[] takes in array that needs to be sorted
			* @param  first takes in the first index of the array
			* @param  last	takes in the last index of the array
			* @param  compareType takes in the type needs to be sorted (volume, base area, height)
			* @return arr return the array thats being sorted
			*
			*/
				public Shape[] bubbleSort(Shape[] arr,int first, int last, String compareType) {

					int n = arr.length;
					Shape temp = null;

					if (compareType.equalsIgnoreCase("H")) {
						for (int i = 0; i <= n; i++) {
							for (int j = 1; j < (n - i); j++) {
								if (((Shape) arr[j - 1]).compareTo((Shape) arr[j]) == -1) {
									temp = arr[j - 1];
									arr[j - 1] = arr[j];
									arr[j] = temp;

								}
							}
						}
					}

					else if (compareType.equalsIgnoreCase("A") || compareType.equalsIgnoreCase("V")) {
						for (int i = 0; i <= n; i++) {
							for (int j = 1; j < (n - i); j++) {
								if (compare(((Shape) arr[j - 1]), (Shape) arr[j], compareType) == -1) {
									temp = arr[j - 1];
									arr[j - 1] = arr[j];
									arr[j] = temp;

								}
							}
						}
					}
					return arr;
				}
				
			/**
			* Gnome Sort function
			*This algorithm will take an array and compare two values at a time. If they are in the correct order the index will increment to compare the next two values. 
			*If they are not in the correct order, the index will decrement and the previous two values will be compared. 
			*This algorithm will continue to run until the elements are all sorted in the correct order. 
			*The key feature of the algorithm is that it does not use any nested loops, but will use just one while loop to traverse the array.

			* @param arr[] takes in array that needs to be sorted
			* @param  first takes in the first index of the array
			* @param  last	takes in the last index of the array
			* @param  compareType takes in the type needs to be sorted (volume, base area, height)
			* @return arr return the array thats being sorted
			*
			*/
				public Shape[] gnomeSort(Shape[] arr,int first, int last, String compareType) {

					int i = 0;
					int n = arr.length;

					if (compareType.equalsIgnoreCase("H")) {
						while (i < n) {
							if (i == 0)
								i++;
							if (((Shape) arr[i - 1]).compareTo((Shape) arr[i]) == 1)
								i++;
							else {
								Shape temp;
								temp = arr[i];
								arr[i] = arr[i - 1];
								arr[i - 1] = temp;
								i--;
							}
						}
					} else if (compareType.equalsIgnoreCase("A") || compareType.equalsIgnoreCase("V")) {
						while (i < n) {
							if (i == 0)
								i++;
							if (compare(((Shape) arr[i - 1]), (Shape) arr[i], compareType) == 1)
								i++;
							else {
								Shape temp;
								temp = arr[i];
								arr[i] = arr[i - 1];
								arr[i - 1] = temp;
								i--;
							}
						}
					}
					return arr;
				}
				
			/**
			* Selection sort function
			* This type of sorting algorithm takes in the list you want to sort then it will compare with the following index. 
			* If the first index is smaller, then switch the values of the first index and the following index in order to sort it in descending order. 
			* The algorithm will stop sorting when the left side numbers are greater than the right side numbers.
			*
			* @param arr[] takes in array that needs to be sorted
			* @param  first takes in the first index of the array
			* @param  last	takes in the last index of the array
			* @param  type takes in the type needs to be sort (volume, base area, height)
			* @return arr return the array thats being sorted
			*
			*/
				public Shape[] selectionSort(Shape[] arr, int first, int last, String type) {
					for (int i = 0; i < arr.length - 1; i++) {
						int min = i;
						for (int j = i + 1; j < arr.length; j++) {

							if (type.equalsIgnoreCase("h")) {
								if (((Shape) arr[min]).compareTo((Shape) arr[j]) < 0) {
									Shape[] temp = new Shape[arr.length];

									temp[i] = (Shape) arr[i];
									arr[i] = arr[j];
									arr[j] = temp[i];
								}
							} else if (type.equalsIgnoreCase("a") || type.equalsIgnoreCase("v")) {
								if (compare((Shape) arr[min], (Shape) arr[j], "a") < 0) {
									Shape[] temp = new Shape[arr.length];

									temp[i] = (Shape) arr[i];
									arr[i] = arr[j];
									arr[j] = temp[i];
								}
							}
						}

					}
					return arr;

				}

			/**
			* Quick sort function
			*This is the type of sort that take the first index and last index of the list in order to choose a pivot.
 			*We compare every object in the list if it is greater than the pivot will switch to the left side of its and smaller numbers will switch to the right side.
 			*When the pointer of the left side and right side is at the same index, we switch the pivot and that number, which has the same index for 2 pointers(i=j). 
			*It will use recursion until it sorts all the values of the object in the list.

			* @param arr[] takes in array that needs to be sorted
			* @param  low takes in the first index of the array
			* @param  high	takes in the last index of the array
			* @param  compareType takes in the type needs to be sort (volume, base area, height)
			* @return arr return the array thats being sorted
			*
			*/
				public Shape[] quickSort(Shape arr[], int low, int high, String compareType) {
					if (low < high) {
						int pivot = partition(arr, low, high, compareType);
						if (compareType.equalsIgnoreCase("h")) {
							quickSort(arr, low, pivot - 1, "H");
							quickSort(arr, pivot + 1, high, "H");
						} else if (compareType.equalsIgnoreCase("a")) {
							quickSort(arr, low, pivot - 1, "a");
							quickSort(arr, pivot + 1, high, "a");
						} else if (compareType.equalsIgnoreCase("v")) {
							quickSort(arr, low, pivot - 1, "v");
							quickSort(arr, pivot + 1, high, "v");
						}
						

					}
					return arr;
				}
				/**
			* Swap function
			*This is a function that use to swap 2 items index from an array.

			* @param arr[] takes in array that needs to be sorted
			* @param  low takes in the first index of the array
			* 
			@param  high	takes in the last index of the array
			* @return arr return the arr thats being changed
			*
			*/
				private static void swap(Object[] arr, int low, int high) {
					Shape temp = (Shape) arr[low];
					arr[low] = arr[high];
					arr[high] = temp;
				}
		    /**
			* Partition Function
			* Compares the current shape to the pivot of the array.

			* @param arr[] takes in array that needs to be sorted
			* @param  low takes in the first index of the array
			* @param  high	takes in the last index of the array
			* @param  compareType takes in the type needs to be sort (volume, base area, height)
			* @return arr return the array thats being changed
			*
			*/
				private static int partition(Object arr[], int low, int high, String compareType) {
					int i = (low - 1);
					for (int j = low; j < high; j++) {
						switch (compareType.toLowerCase()) {

						case "h": {
							if (((Shape) arr[j]).compareTo((Shape) arr[high]) == 1) {
								i++;
								swap(arr, i, j);
							}
						}
							break;

						case "a": {
							if (compare((Shape) arr[j], (Shape) arr[high], "a") == 1) {
								i++;
								swap(arr, i, j);
							}

						}
							break;

						case "v": {
							if (compare((Shape) arr[j], (Shape) arr[high], "v") == 1) {
								i++;
								swap(arr, i, j);
							}
						}
							break;
						}

					}
					swap(arr, i + 1, high);

					return (i + 1);
				}

	
	
	
	@Override
	public int compare(Shape o1, Shape o2) {
	
		return 0;
	}

	@Override
	public double calcVolume() {
		
		return 0;
	}

	@Override
	public double calcBaseArea() {
	
		return 0;
	}
}
