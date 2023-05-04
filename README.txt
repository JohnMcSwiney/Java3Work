INSTRUCTIONS TO RUN

Create a folder named temp on your c drive - navigate to it using cmd
** Also place the file to be loaded in the temp folder

run this command:
java -jar Sort.jar -f* -t* -s*

Commands are as follows

-f is the file to be used by the program
	-fpolyfor1.txt
	-fpolyfor3.txt
	-fpolyfor5.txt
	-fpolyNameBIG.txt

-t is the variable that will be used to sort with
	-th : Height
	-tv : Volume
	-ta : Base Area

-s is the sorting algorithm to be used by the program
	-sb : Bubble Sort
	-ss : Selection Sort
	-si : Insertion Sort
	-sm : Merge Sort
	-sq : Quick Sort
	-sz : Gnome/Stupid Sort


**To launch this program, the latest version of Eclipse is required.


ALGORITHMS SECTION
1. Quick Sort
* This is the type of sort that take the first index and last index of the list in order to choose a pivot. We compare every object in the list if it is greater than the pivot will switch to the left side of its and smaller numbers will switch to the right side. When the pointer of the left side and right side is at the same index, we switch the pivot and that number, which has the same index for 2 pointers(i=j). It will use recursion until it sorts all the values of the object in the list.
2. Selection sort
-This type of sorting algorithm takes in the list you want to sort then it will compare with the following index. If the first index is smaller, then switch the values of the first index and the following index in order to sort it in descending order. And it will stop sorting when the left side numbers are greater than the right side numbers.
3. Merge Sort
* This algorithm takes the array and splits the array in the middle, then proceeds to continuously split the subarrays using recursion until each element in the array is separated from one another. From there, the algorithm works backwards and brings back each element together by comparing if one element is less than the other element and rearranges accordingly, until all elements are sorted back in one array.
4. Insertion Sort
* This algorithm compares each element in the array, one element at a time to see if one element is less than another element and swaps their position. The array is virtually split into a sorted partition and unsorted partition. The elements in the unsorted partition are then checked with each element then they are moved to the sorted side. This continues for each element in the array until there are no more elements in the unsorted partition, thus the array is sorted.
5. Bubble Sort
* Bubble sort is going in a linear fashion, if the left side index’s  is smaller than the right side index’s object (it only compares with the next index’s value) , then switch the position between these 2 indexes. This algorithm will go through the list many times until all the objects are at the right index.
6. Gnome Sort
* This algorithm will take an array and compare two values at a time. If they are in the correct order the index will increment to compare the next two values. If they are not in the correct order, the index will decrement and the previous two values will be compared. This algorithm will continue to run until the elements are all sorted in the correct order. The key feature of the algorithm is that it does not use any nested loops, but will use just one while loop to traverse the array. 



ASSIGNMENT COMPLETENESS


The project is around 95% complete. Based on the marking criteria, the project contains most of the required functionalities. This project does not generate objects using reflection.