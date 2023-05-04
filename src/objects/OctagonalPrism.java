package objects;



/**
* @author Johnny McSwiney
* @author Gia Nguyen
* @author Javaria Khan
* @author Mohummad Bhatti
*
* Creates a OctagonalPrism object for all octagonal prisms and used for sorting algorithms.
*/ 
public class OctagonalPrism extends Prism {
	
	/**
	 * No arguments constructor for the OctagonalPrism.
	 *
	 * @param height takes in the height for the octagonal prism.
	 * @param side takes in the radius for the octagonal prism.
	 * 
	 */
	 
	 public OctagonalPrism() {
		 
	 }
	 
	/**
	 * Arguments constructor for the OctagonalPrism. It takes in the height and radius.
	 *
	 * @param height takes in the height for the octagonal prism.
	 * @param side takes in the radius for the octagonal prism.
	 * 
	 */
	public OctagonalPrism(double height, double side) {
		super(height, side);
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
		
		baseArea = 2 * (1 + Math.sqrt(2)) * Math.pow(getSide(), 2);
		
		return baseArea;
		
	
		
	}
	
	@Override
	public String toString() {
		return "Octagonal Prism";
	}
}
