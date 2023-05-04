
package driver;

import frontend.*;

import java.lang.reflect.Method;

import backend.*;

/**
 * @author Johnny McSwiney
 * @author Gia Ngyuen
 * @author Javaria Khan
 * @author Mohummad Bhatti
 *
 * Invokes MenuV3 and starts program
 * program is built to be run in cmd
 */
public class ShapeSorterMain {
	/**
	 * @param args
     * @throws Exception
	 *	arguments are:
	 * 	-f for file name (Currently doesn't work and will only allow files from C:/temp/)
	 *  
	 *  -t What you're sorting using 
	 *  -th : Height
	 *  -tv : Volume
	 *  -ta : Base Area
	 *  
	 *  -s : Sort being used by program
	 *  -sb : Bubble Sort
	 *  -ss : Selection Sort
	 *  -si : Insertion Sort
	 *  -sm : Merge Sort
	 *  -sq : Quick Sort
	 *  -sz : Gnome/Stupid Sort
	 */
	public static void main(String[] args) throws Exception{
		String filepath = "";
		String type = "";
		String sort = "";
		
		for(int i = 0; i < args.length; i++) {
			if(args[i].startsWith("-f")) {
				filepath = args[i].substring(2);
			}
			if(args[i].startsWith("-t")) {
				type = args[i].substring(2);
			}
			if(args[i].startsWith("-s")) {
				sort = args[i].substring(2);
				}
			
		}
		
		MenuV3 menu = new MenuV3(filepath, sort, type);

	}
}
