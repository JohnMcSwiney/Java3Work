package frontend;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import backend.*;
import objects.Shape;

/**
 * @author Johnny McSwiney
 * @author Gia Ngyuen
 * @author Javaria Khan
 * @author Mohummad Bhatti
 *
 *         MenuV3 is the program. Receives inputs from ShapeSorterMain Runs
 *         corresponding code
 */

public class MenuV3 {

	/**
	 * startTime : Marks when sorting began - updated just before sorting begins
	 * endTime : Marks when sorting finishes - updated just before sorted array is
	 * printed runTime : Total runtime for sorting process - updated when endTime is initialized
	 */
	double startTime;
	double endTime;
	double runTime;

	/**
	 * filePath : filepath to be used - inputed in cmd 
	 * sortUsing : determines how what variable will be used when sorting - inputed in cmd 
	 * sortingChoice : determines what sort will be used - inputed in cmd
	 */
	String filePath;
	String sortingChoice;
	String sortUsing;

	/*
	 * sortMe : Holds unsorted array after it's filled with Shapes. Sent to each
	 * sort method and returned in some why by each. Updated with sorted array
	 * after a sort has been run
	 */
	Shape[] sortMe;

	public MenuV3() {

	}

	/**
	 * @author Johnny McSwiney
	 * 
	 *         MenuV3 Uses inputs to load file specified Randomizes and prints out
	 *         randomized unsorted array Decides which sorting algorithm to invoke
	 *         Sends array and sorting choice to each sorting method, and updates
	 *         sortMe Calculates runtime Prints out sorted array Terminates
	 * @param file          - filepath
	 * @param sortingChoice - sorting method to be invoked
	 * @param sortUsing     - what variable will be used to sort
	 * 
	 * 
	 * @param f             - instance of LoadFile - holds key to unsorted array
	 * @param u             - instance of Utilities - holds all sorting methods
	 * 
	 * @exception e - FileNotFound exits program if thrown
	 */
	public MenuV3(String file, String sort, String type) {
		this.filePath = file;
		this.sortingChoice = sort;
		this.sortUsing = type;
		LoadFile f = new LoadFile();
		Utilities u = new Utilities();
		try {

			Shape[] fullShapeArray = f.loadObj(filePath);
			this.sortMe = fullShapeArray;
			System.out.println("Array before Sorting" + "\n");
			printArray(sortMe, sortUsing);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			System.exit(0);
		}
		this.startTime = System.currentTimeMillis();
		switch (sortingChoice.toLowerCase()) {
		case "b":
			System.out.println("\n = = Bubble Sort = = ");
			sortMe = u.bubbleSort(sortMe, 0, sortMe.length - 1, sortUsing);
			break;

		case "s":
			System.out.println("\n = = Selection Sort = = ");
			sortMe = u.selectionSort(sortMe, 0, sortMe.length - 1, sortUsing);
			break;

		case "i":
			System.out.println("\n = = Insertion Sort = = ");
			sortMe = u.insertionSort(sortMe, 0, sortMe.length - 1, sortUsing);
			break;

		case "m":
			System.out.println("\n = = Merge Sort = = ");
			u.mergeSort(sortMe, 0, sortMe.length - 1, sortUsing);
			break;
		case "q":
			System.out.println("\n = = QuickSort = = ");
			sortMe = u.quickSort(sortMe, 0, (sortMe.length - 1), sortUsing);
			break;
		case "z":
			System.out.println("\n = = Gnome Sort = = ");
			u.gnomeSort(sortMe, 0, sortMe.length - 1, sortUsing);
			break;

		}
		if (sortingChoice.toLowerCase() == "m" || sortingChoice.toLowerCase() == "z") {

		} else {
			setEndTime();
			setRunTime();
			printArray(sortMe, sortUsing);
		}

		System.out.println("\n" + "Total Runtime: " + getRunTime() + "ms");

	}

	public Shape[] getSortMe() {
		return sortMe;
	}

	public void setSortMe(Shape[] sortMe) {
		this.sortMe = sortMe;
	}

	public double getEndTime() {
		return endTime;
	}

	public void setEndTime() {
		this.endTime = System.currentTimeMillis();
	}

	public double getRunTime() {
		return runTime;
	}

	public void setRunTime() {
		this.runTime = (endTime - startTime);
	}

	/***
	 * @author Johnny McSwiney
	 * 
	 *         printArray Receives an array to print along with what the system used
	 *         to sort the array Prints out array Terminates
	 * @param temp       - array to be printed
	 * @param sortUsing2 - what variable was used to sort
	 * 
	 * 
	 */
	public void printArray(Shape[] temp, String sortUsing2) {
		switch (sortUsing2.toLowerCase()) {
		case "h":
			System.out.println("\nSorting Using Height: " + " = = = = = = = = = ");
			for (int i = 0; i < temp.length; i++) {
				Shape current = (Shape) temp[i];
				int count = i;
				if (i == 0 || i % 1000 == 0 || i == temp.length - 1) {
					System.out.printf("#%-5d" + "%-18s" + " Height" + ": %12.1f \n", count + 1,
							" " + temp[i].toString(), current.getHeight());
				}

			}
			break;

		case "v":
			System.out.println("\nSorting Using Volume: " + " = = = = = = = = = ");
			for (int i = 0; i < temp.length; i++) {
				Shape current = (Shape) temp[i];
				int count = i;
				if (i == 0 || i % 1000 == 0 || i == temp.length - 1) {
					System.out.printf("#%-5d" + "%-18s" + " Volume" + ": %12.1f \n", count + 1,
							" " + temp[i].toString(), current.calcVolume());
				}
			}
			break;

		case "a":
			System.out.println(" Sorting Using Base Area: \n" + " = = = = = = = = = ");
			for (int i = 0; i < temp.length; i++) {
				Shape current = (Shape) temp[i];
				int count = i;
				if (i == 0 || i % 1000 == 0 || i == temp.length - 1) {
					System.out.printf("#%-5d" + "%-18s" + " Base Area" + ": %12.1f \n", count + 1,
							" " + temp[i].toString(), current.calcBaseArea());
				}
			}
			break;

		}

	}

}
