/**
 * 
 */
package reporting;

import abstract_data_types.IteratorADT;
import utilities.BSTReferencedBased;
import utilities.Location;
import utilities.MyArrayList;
import utilities.Word;

/**
 * @author BritishWaldo
 *
 */
public class Report
{
	/**
	 * Generates a report for a binary search tree
	 * @param binarySearchTree the binary search tree to use in the generation of the report
	 * @param reportType the type of report to create
	 * @return finalReport an arraylist of strings where each index is a line of the report
	 */
	public static MyArrayList<String> generateReport (BSTReferencedBased<Word> binarySearchTree, char reportType)
	{
		MyArrayList<String> finalReport = null;
		
		switch (reportType)
		{
			case 'f':	finalReport = generateFiles(binarySearchTree);
						break;
			case 'l':	finalReport = generateFilesLines(binarySearchTree);
						break;
			case 'o':	finalReport = generateFilesLinesFrequency(binarySearchTree);
						break;
		}
		
		return finalReport;
	}
	/**
	 * generates the file containing the occurence and location of "words" and adds to finalReport
	 * @param binarySearchTree the binary search tree to use to populate the report
	 * @return finalReport an arraylist of strings where each index is a line of the report
	 */
	private static MyArrayList<String> generateFiles(BSTReferencedBased<Word> binarySearchTree)
	{
		MyArrayList<String> finalReport = new MyArrayList<String>();
		
		IteratorADT<Word> alphabetisedIterator = binarySearchTree.alphabetisedIterator();
		
		String toAdd = String.format("\t\t%s", " Word Occurence Report");
		finalReport.add(toAdd);
		
		toAdd = String.format("\t%s", "Words with location of occurence");
		finalReport.add(toAdd);
		
		toAdd = String.format("%s", "===================================================");
		finalReport.add(toAdd);
		
		toAdd = String.format("%-26s%s", "Word:", "Location:");
		finalReport.add(toAdd);
		
		while (alphabetisedIterator.hasNext())
		{
			Word currentWord = alphabetisedIterator.next();
			IteratorADT<Location> locationIterator = currentWord.getLocationsOfOccurence().iterator();
			
			while (locationIterator.hasNext())
			{
				Location currentLocation = locationIterator.next();
				
				toAdd = String.format("%-26s%s", currentWord.getWord(), currentLocation.getLocationName());
				finalReport.add(toAdd);
			}
		}
		
		return finalReport;
	}
	/**
	 * generates the lines of the file and adds to finalReport
	 * @param binarySearchTree the binary search tree to use to populate the report
	 * @return finalReport an arraylist of strings where each index is a line of the report
	 */
	private static MyArrayList<String> generateFilesLines(BSTReferencedBased<Word> binarySearchTree)
	{
		MyArrayList<String> finalReport = new MyArrayList<String>();
		
		IteratorADT<Word> alphabetisedIterator = binarySearchTree.alphabetisedIterator();
		
		String toAdd = String.format("\t\t\t\t\t%s", " Word Occurence Report");
		finalReport.add(toAdd);
		
		toAdd = String.format("\t\t\t%s", "Words with location & lines of occurence");
		finalReport.add(toAdd);
		
		toAdd = String.format("%s", "========================================"
										+ "======================================");
		finalReport.add(toAdd);
		
		toAdd = String.format("%-26s%-26s%s", "Word:", "Location:", "Lines");
		finalReport.add(toAdd);
		
		while (alphabetisedIterator.hasNext())
		{
			Word currentWord = alphabetisedIterator.next();
			IteratorADT<Location> locationIterator = currentWord.getLocationsOfOccurence().iterator();
			
			while (locationIterator.hasNext())
			{
				Location currentLocation = locationIterator.next();
				
				toAdd = String.format("%-26s%-26s%s", currentWord.getWord(), currentLocation.getLocationName(), currentLocation.printLineNumbers());
				finalReport.add(toAdd);
			}
		}
		
		return finalReport;
	}
	/**
	 * generated the frequency of file lines and adds to finalReport
	 * @param binarySearchTree the binary search tree to use to populate the report
	 * @return finalReport an arraylist of strings where each index is a line of the report
	 */
	private static MyArrayList<String> generateFilesLinesFrequency(BSTReferencedBased<Word> binarySearchTree)
	{
		MyArrayList<String> finalReport = new MyArrayList<String>();
		
		IteratorADT<Word> alphabetisedIterator = binarySearchTree.alphabetisedIterator();
		
		String toAdd = String.format("\t\t\t\t\t\t\t%s", " Word Occurence Report");
		finalReport.add(toAdd);
		
		toAdd = String.format("\t\t\t%s", "Words with frequency, location, & lines of occurence");
		finalReport.add(toAdd);
		
		toAdd = String.format("%s", "============================================="
										+ "=========================================================");
		finalReport.add(toAdd);
		
		toAdd = String.format("%-26s%-16s%-26s%s", "Word:", "Frequency:", "Location:", "Lines");
		finalReport.add(toAdd);
		
		while (alphabetisedIterator.hasNext())
		{
			Word currentWord = alphabetisedIterator.next();
			IteratorADT<Location> locationIterator = currentWord.getLocationsOfOccurence().iterator();
			
			while (locationIterator.hasNext())
			{
				Location currentLocation = locationIterator.next();
				
				toAdd = String.format("%-26s%-16s%-26s%s", currentWord.getWord(), currentWord.getFrequency()
															, currentLocation.getLocationName()
															, currentLocation.printLineNumbers());
				finalReport.add(toAdd);
			}
		}
		
		return finalReport;
	}
	/**
	 * displays the final report with all the information added
	 * @param finalReport an arraylist of strings where each index is a line of the report
	 */
	public static void displayReport(MyArrayList<String> finalReport)
	{
		IteratorADT<String> reportIterator = finalReport.iterator();
		
		while (reportIterator.hasNext())
		{
			System.out.println(reportIterator.next());
		}
	}
}
