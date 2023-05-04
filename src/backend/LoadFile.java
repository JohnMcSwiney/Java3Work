package backend;

import java.util.Scanner;

import objects.*;

import java.io.*;

/**
 * @author Johnny McSwiney
 * @author Gia Ngyuen
 * @author Javaria Khan
 * @author Mohummad Bhatti
 *
 *         LoadFile fills an array with shape objects using the file chosen
 * 
 */
public class LoadFile {
//  Supported files in system   			v v v v v v v v v v v 
//	String[] filePathArray = new String[] { "C:/temp/polyfor1.txt", 
//											"C:/temp/polyfor3.txt", 
//											"C:/temp/polyfor5.txt", 
//											"C:/temp/polyNameBIG.txt" };

	// arrayLength : defines shapeObjList size - set when the first line of the file
	// is read
	int arrayLength;

	// counter : iterated every time an object is added to the array
	int counter = 0;

	// shapeObjList : holds objects loaded from file
	Shape[] shapeObjList;

	public LoadFile() {

	}

	/***
	 * @author Johnny McSwiney
	 * 
	 *         printArray
	 *         Receives an file path, creates array of designated length. 
	 *         Reads file and creates corresponding objects
	 * @param path - path of file
	 * 
	 * @return shapeObjList - returns a filled unsorted array of various shape
	 *         objects
	 * 
	 * @exception e - FileNotFound exits program if thrown
	 * 
	 *              
	 */
	public Shape[] loadObj(String path) throws FileNotFoundException {
		// shhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
		path = "C:/temp/" + path;
		Scanner leggomie = new Scanner(new File(path));

		while (leggomie.hasNext()) {

			String line = leggomie.nextLine();
			String[] fields = line.split(" ");
			this.arrayLength = Integer.parseInt(fields[0]);
			shapeObjList = new Shape[arrayLength];

			for (int i1 = 0; i1 < fields.length; i1++) {
				double height, radius, side;

				switch (fields[i1]) {

				case "Cone":
					height = Double.parseDouble(fields[i1 + 1]);
					radius = Double.parseDouble(fields[i1 + 2]);

					Cone cone = new Cone(height, radius);
					shapeObjList[counter] = cone;

					counter++;
					break;

				case "Cylinder":
					height = Double.parseDouble(fields[i1 + 1]);
					radius = Double.parseDouble(fields[i1 + 2]);

					Cylinder cylinder = new Cylinder(height, radius);
					shapeObjList[counter] = cylinder;

					counter++;
					break;

				case "OctagonalPrism":
					height = Double.parseDouble(fields[i1 + 1]);
					side = Double.parseDouble(fields[i1 + 2]);

					OctagonalPrism octagonalPrism = new OctagonalPrism(height, side);
					shapeObjList[counter] = octagonalPrism;

					counter++;
					break;

				case "PentagonalPrism":
					height = Double.parseDouble(fields[i1 + 1]);
					side = Double.parseDouble(fields[i1 + 2]);

					PentagonalPrism pentagonalPrism = new PentagonalPrism(height, side);
					shapeObjList[counter] = pentagonalPrism;

					counter++;
					break;

				case "Pyramid":
					height = Double.parseDouble(fields[i1 + 1]);
					side = Double.parseDouble(fields[i1 + 2]);

					Pyramid pyramid = new Pyramid(height, side);
					shapeObjList[counter] = pyramid;

					counter++;
					break;

				case "SquarePrism":
					height = Double.parseDouble(fields[i1 + 1]);
					side = Double.parseDouble(fields[i1 + 2]);

					SquarePrism squarePrism = new SquarePrism(height, side);
					shapeObjList[counter] = squarePrism;

					counter++;
					break;

				case "TriangularPrism":
					height = Double.parseDouble(fields[i1 + 1]);
					side = Double.parseDouble(fields[i1 + 2]);

					TriangularPrism triangularPrism = new TriangularPrism(height, side);
					shapeObjList[counter] = triangularPrism;

					counter++;
					break;

				default:
					break;

				}
			}

		}
		leggomie.close();
		return shapeObjList;
	}

	public Shape[] getShapeObjList() {
		return shapeObjList;
	}

}
