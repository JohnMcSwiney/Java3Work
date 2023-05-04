package objects;


/**
* @author Johnny McSwiney
* @author Gia Nguyen
* @author Javaria Khan
* @author Mohummad Bhatti
*
* Creates a TriangularPrism object for all triangular prisms and used for sorting algorithms.
*/ 

public class TriangularPrism extends Prism {
	
	/**
	 * No arguments constructor for the TriangularPrism.
	 *
	 * 
	 */
	public TriangularPrism() {
		
	}
	
	/**
	 * Arguments constructor for the Triangular Prism. It takes in the height and side.
	 *
	 * @param height takes in the height for the triangular prism.
	 * @param side takes in the side for the triangular prism.
	 * 
	 */	
	public TriangularPrism(double height,  double side) {
		super(height, side);
		/*baseArea = Math.pow(side, 2) * Math.sqrt(3)/4;
		volume = baseArea * height; */
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
		
		baseArea = Math.pow(getSide(), 2) * Math.sqrt(3)/4;
		
		return baseArea;
		
	
		
	}
	
	@Override
	public int compare(Shape o1, Shape o2) {
	
		return 0;
	}

	@Override
	public String toString() {
		return "Triangular Prism";
	}
}
