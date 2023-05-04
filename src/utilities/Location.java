/**
 * 
 */
package utilities;

import abstract_data_types.IteratorADT;
import abstract_data_types.ListADT;

import java.io.Serializable;

public class Location implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6629858026703085729L;
	
	private String locationName;
	
	private ListADT<Integer> lineNumbersOfOccurence;

	/**
	 * 
	 */
	public Location()
	{
		this.locationName = null;
		this.lineNumbersOfOccurence = null;
	}
	
	/**
	 * 
	 */
	public Location(String inputLocationName, ListADT<Integer> inputLineNumbersOfOccurence)
	{
		this.locationName = inputLocationName;
		this.lineNumbersOfOccurence = inputLineNumbersOfOccurence;
	}
	
	/**
	 * 
	 */
	public Location(String inputLocationName, int inputLineNumber)
	{
		this.locationName = inputLocationName;
		
		this.lineNumbersOfOccurence = new MyArrayList<Integer>();
		
		this.lineNumbersOfOccurence.add(new Integer(inputLineNumber));
	}

	/**
	 * @return the locationFileName
	 */
	public String getLocationName()
	{
		return this.locationName;
	}

	/**
	 * @param inputLocationFileName the locationFileName to set
	 */
	public void setLocationName(String inputLocationName)
	{
		this.locationName = inputLocationName;
	}

	/**
	 * @return the lineNumbersOfOccurence
	 */
	public ListADT<Integer> getLineNumbersOfOccurence()
	{
		return lineNumbersOfOccurence;
	}

	/**
	 * @param inputLineNumbersOfOccurence the lineNumbersOfOccurence to set
	 */
	public void setLineNumbersOfOccurence(ListADT<Integer> inputLineNumbersOfOccurence)
	{
		this.lineNumbersOfOccurence = inputLineNumbersOfOccurence;
	}
	
	public void addLineNumber(int inputLineNumber)
	{
		this.lineNumbersOfOccurence.add(new Integer(inputLineNumber));
	}

	@Override
	public boolean equals(Object inputObj)
	{
		if (inputObj instanceof Location)
		{
			Location tempLocation = (Location) inputObj;
			
			return this.locationName.equals(tempLocation.getLocationName());
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * @return a string output with all line occurences of the word.
	 */
	public String printLineNumbers()
	{
		String output = "";
		
		IteratorADT<Integer> lineNumberIterator = this.lineNumbersOfOccurence.iterator();
		
		while (lineNumberIterator.hasNext())
		{
			output += lineNumberIterator.next() + ",";
		}
		
		output = output.substring(0, output.length()-1);
		
		return output;
	}
}
