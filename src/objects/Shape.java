package objects;

import java.util.Comparator;

/**
* @author Johnny McSwiney
* @author Gia Nguyen
* @author Javaria Khan
* @author Mohummad Bhatti
*
* Creates a basic shape object for all shapes and used for sorting algorithms.
*/ 

public abstract class Shape implements Comparable<Shape>, Comparator<Shape> {
	
	protected double height;
	
	/**
	 * Create no-arg Shape constructor
	 *
	 */
	public Shape() {
		
	}
	
	/**
	 * Create Shape constructor with arguments (every shape will have a height)
	 *
	 * @param height takes in the height for the shape.
	 */
	public Shape(double height) {
		this.height = height;	
	}
	
	/**
	 * Gets the height of the shape.
	 *
	 * @return height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Compares the height of one shape with the height of another shape.
	 * If the height of "this" shape is greater than the current shape, return 1.
	 * If the height of "this" shape is less than the current shape, return -1
	 * If the height of "this" shape is equal to the current shape, return 0.
	 *
	 * @param s the current shape in the array.
	 * @return return 1 if the height of "this" shape is greater than the current shape.
	 * @return return -1 if the height of "this" shape is less than the current shape.
	 * @return return 0 if the height of "this" shape is equal than the current shape.
	 */
	public int compareTo(Shape s){
		
		{
		if( this.getHeight() > s.getHeight() )
		{
			return 1;
		}
		else if( this.getHeight() < s.getHeight() )
		{
			return -1;
		}
		else // this.getHeight == s.getHeight
		{
			return 0;
		}
		}
		
	}
	
	/**
	 * Compares the volume and area (based on whichever one the user chooses) of one shape with the height of another shape.
	 * If the volume or area of "this" shape is greater than the current shape, return 1.
	 * If the volume or area of "this" shape is less than the current shape, return -1
	 * If the volume or area of "this" shape is equal to the current shape, return 0.
	 *
	 * @param shapeOne the first shape in the array
	 * @param shapeTwo the second shape in the array.
	 * @param userCompareChoice the user's input
	 * @return value after comparing both shapes.
	 */
	public static int compare(Shape shapeOne, Shape shapeTwo, String userCompareChoice){
		
		int value = 0;
		if(userCompareChoice.equalsIgnoreCase("V")) {
			if( shapeOne.calcVolume() > shapeTwo.calcVolume() )
			{
				value = 1;
			}
			else if( shapeOne.calcVolume() < shapeTwo.calcVolume() )
			{
				value = -1;
			}
			else // shapeOne.getVolume == shapeTwo.getVolume
			{
				value = 0;
			}
			
		}
		if(userCompareChoice.equalsIgnoreCase("A")) {
			if( shapeOne.calcBaseArea() > shapeTwo.calcBaseArea() )
			{
				value = 1;
			}
			else if( shapeOne.calcBaseArea() < shapeTwo.calcBaseArea() )
			{
				value = -1;
			}
			else // shapeOne.getBaseArea == shapeTwo.getBaseArea
			{
				value = 0;
			}
		}
		
		return value;
		
	}
	
	
	/**
	 * Calculates the volume of the shape.
	 */
	public abstract double calcVolume();
	
	/**
	 * Calculates the volume of the shape.
	 */
	public abstract double calcBaseArea();
		
}


