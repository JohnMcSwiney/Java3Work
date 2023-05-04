package objects;

/**
* @author Johnny McSwiney
* @author Gia Nguyen
* @author Javaria Khan
* @author Mohummad Bhatti
*
* Creates a Square Prism object for all square prisms and used for sorting algorithms.
*/ 
public class SquarePrism extends Prism {
	
	/**
	 * No arguments constructor for the Cone.
	 * 
	 */

	public SquarePrism() {
		
	}

	/**
	 * Arguments constructor for the Square Prism. It takes in the height and side.
	 *
	 * @param height takes in the height for the square prism.
	 * @param side takes in the side for the square prism.
	 * 
	 */	
	public SquarePrism(double height, double side) {
		super(height, side);
		calcVolume();
	}
	
	@Override
	public double calcVolume() {
		double volume = 0;
		
		volume = Math.pow(getSide(), 2) * getHeight();

		
		return volume;
		
	}
	
	@Override
	public double calcBaseArea() {
		double baseArea = 0;
		
		baseArea = Math.pow(getSide(), 2);
		
		return baseArea;
		
	
		
	}

	@Override
	public int compare(Shape o1, Shape o2) {
	
		return 0;
	}

	@Override
	public String toString() {
		return "Square Prism";
	}

}
