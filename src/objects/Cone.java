package objects;


/**
* @author Johnny McSwiney
* @author Gia Nguyen
* @author Javaria Khan
* @author Mohummad Bhatti
*
* Creates a Cone object for all cones and used for sorting algorithms.
*/ 

public class Cone extends Shape {
	
	private double radius;
	
	/**
	 * No arguments constructor for the Cone.
	 * 
	 */

	public Cone() {
		
	}

	/**
	 * Arguments constructor for the Cone. It takes in the height and radius.
	 *
	 * @param height takes in the height for the cone.
	 * @param radius takes in the radius for the cone.
	 * 
	 */
	public Cone(double height, double radius) {
		super(height);
		this.radius = radius;
		calcVolume();
		calcBaseArea();
		
	}

	
	/**
	 * Gets the radius
	 * @return radius
	 * 
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Sets the radius
	 * @param radius takes the radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}


	
	@Override
	public int compare(Shape o1, Shape o2) {
		// TODO Auto-generated method stub
		return 0;
	}	
	
	@Override
	public double calcVolume() {
		double third = 0.3333333333;
		double volume = third * Math.PI * Math.pow(radius, 2) * getHeight();
		
		return volume;
		
	}
	
	@Override
	public double calcBaseArea() {
		double baseArea = 0;
		
		baseArea = Math.PI * Math.pow(radius, 2);
		
		return baseArea;
		
	
		
	}

	@Override	
	public String toString() {
		return "Cone";
	}
}
