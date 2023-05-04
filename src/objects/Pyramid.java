package objects;


/**
* @author Johnny McSwiney
* @author Gia Nguyen
* @author Javaria Khan
* @author Mohummad Bhatti
*
* Creates a Pyramid object for all pyramids and used for sorting algorithms.
*/ 

public class Pyramid extends Shape {

	private double side;
	
	/**
	 * No arguments constructor for the Pyramid.
	 *
	 * 
	 */
	 public Pyramid() {
		 
	 }
	 
	 /**
	 * Arguments constructor for the Pyramid. It takes in the height and side.
	 *
	 * @param height takes in the height for the pyramid.
	 * @param side takes in the radius for the pyramid.
	 * 
	 */
	public Pyramid(double height, double side) {
		super(height);
		this.side = side;
		calcVolume();
	
	}
	
	/**
	 * Gets the side 
	 * @return side
	 * 
	 */
	public double getSide() {
		return side;
	}
	
	/**
	 * Sets the side
	 * @return side
	 * 
	 */
	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public int compare(Shape o1, Shape o2) {
		
		return 0;
	}	

	@Override
	public double calcVolume() {
		double volume = 0;
		double third = 0.3333333333;
		volume = third*(side*side)*getHeight();
		
		return volume;
		
	}
	
	@Override
	public double calcBaseArea() {
		double baseArea = 0;
		baseArea = side*side;
		return baseArea;
		
	}

	@Override
	public String toString() {
		return "Pyramid";
	}
}
