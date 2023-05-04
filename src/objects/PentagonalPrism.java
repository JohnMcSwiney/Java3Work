package objects;

/**
* @author Johnny McSwiney
* @author Gia Nguyen
* @author Javaria Khan
* @author Mohummad Bhatti
*
* Creates a Pentagonal Prism object for all pentagonal prisms and used for sorting algorithms.
*/ 
public class PentagonalPrism extends Prism {
	

	/**
	 * No arguments constructor for the Pentagonal Prism.
	 *
	 * 
	 */

	public PentagonalPrism() {
		
	}


	/**
	 * Arguments constructor for the Pentagonal Prism. It takes in the height and side.
	 *
	 * @param height takes in the height for the pentagonal prism.
	 * @param side takes in the side for the pentagonal prism.
	 * 
	 */	
	public PentagonalPrism(double height,  double side) {
		super(height,  side);
		calcVolume();
		
	}
	

	@Override
	public double calcVolume() {
		double volume = 0;
		
		volume = calcBaseArea() * getHeight();

		
		return volume;
		
	}
	
	@Override
	public double calcBaseArea() {
		double baseArea = 0;
		
		baseArea = (5 * (Math.pow(getSide(), 2)) * (Math.tan(Math.toRadians(54)))) / 4;
		
		return baseArea;
		
	
		
	}
	@Override
	public String toString() {
		return "Pentagonal Prism";
	}
}
