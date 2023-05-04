package objects;



/**
* @author Johnny McSwiney
* @author Gia Nguyen
* @author Javaria Khan
* @author Mohummad Bhatti
*
* Creates a Cylinder object for all cylinders and used for sorting algorithms.
*/ 
public class Cylinder extends Shape {
	
	private double radius;
	

	/**
	 * No arguments constructor for the Cylinder.
	 *
	 * 
	 */

	public Cylinder() {
		
	}
	
	/**
	 * Arguments constructor for the Cylinder. It takes in the height and radius.
	 *
	 * @param height takes in the height for the cylinder.
	 * @param radius takes in the radius for the cylinder.
	 * 
	 */
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
		calcVolume();
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
	public double calcVolume() {
		double volume;
		
		volume = Math.PI * Math.pow(radius, 2) * getHeight();

		
		return volume;
		
	}
	
	@Override
	public double calcBaseArea() {
		double baseArea = 0;
		
		baseArea = Math.PI * Math.pow(radius, 2);
		
		return baseArea;
		
	
		
	}

	@Override
	public int compare(Shape o1, Shape o2) {
		
		return 0;
	}

	public String toString() {
		return "Cylinder";
	}
}
