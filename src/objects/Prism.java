package objects;


/**
* @author Johnny McSwiney
* @author Gia Nguyen
* @author Javaria Khan
* @author Mohummad Bhatti
*
* Creates a Prism object for all prisms and used for sorting algorithms.
*/ 
public class Prism extends Shape {
	
	private double side;
	
	/**
	 * No arguments constructor for the Prism.
	 * 
	 */

	public Prism() {
		
	}
	
	/**
	 * Arguments constructor for the Prism. It takes in the height and side.
	 *
	 * @param height takes in the height for the Prism.
	 * @param side takes in the side for the Prism.
	 * 
	 */
	public Prism(double height,  double side) {
		super(height);
		this.side = side;
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
	 * @param side takes the side
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
	
		return 0;
	}

	@Override
	public double calcBaseArea() {
	
		return 0;
	}
}
