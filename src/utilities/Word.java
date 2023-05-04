/**
 * 
 */
package utilities;

import java.io.Serializable;

import abstract_data_types.ListADT;

public class Word implements Serializable, Comparable<Word>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7413957276184102547L;
	
	private String word;
	private int frequency;
	
	private ListADT<Location> locationsOfOccurence;
	
	public Word()
	{
		this.word = null;
		this.frequency = 0;
		
		this.locationsOfOccurence = null;
	}
	
	public Word(String inputWord)
	{
		this();
		
		this.word = inputWord;
	}
	
	public Word(String inputWord, int inputFrequency, ListADT<Location> inputLocationsOfOccurence)
	{
		this.word = inputWord;
		this.frequency = inputFrequency;
		
		this.locationsOfOccurence = inputLocationsOfOccurence;
	}
	
	public Word(String inputWord, int inputFrequency, String inputLocation, int inputLineNumber)
	{
		this.word = inputWord;
		this.frequency = inputFrequency;
		
		this.locationsOfOccurence = new MyArrayList<Location>();
		Location tempLocation = new Location(inputLocation, inputLineNumber);
		
		this.locationsOfOccurence.add(tempLocation);
	}

	/**
	 * @return the word
	 */
	public String getWord()
	{
		return word;
	}

	/**
	 * @param inputWord the word to set
	 */
	public void setWord(String inputWord)
	{
		this.word = inputWord;
	}

	/**
	 * @return the frequency
	 */
	public int getFrequency()
	{
		return frequency;
	}

	/**
	 * @param inputFrequency the frequency to set
	 */
	public void setFrequency(int inputFrequency)
	{
		this.frequency = inputFrequency;
	}

	/**
	 * @return the locationsOfOccurence
	 */
	public ListADT<Location> getLocationsOfOccurence()
	{
		return locationsOfOccurence;
	}

	/**
	 * @param inputLocationsOfOccurence the locationsOfOccurence to set
	 */
	public void setLocationsOfOccurence(ListADT<Location> inputLocationsOfOccurence)
	{
		this.locationsOfOccurence = inputLocationsOfOccurence;
	}

	@Override
	public int compareTo(Word inputWord)
	{
		return this.word.compareToIgnoreCase(inputWord.getWord());
	}
	
	/**
	 * 
	 * @param inputLocation the location to search for
	 * @return true if the the word contains the location provided
	 */
	public boolean contains(String inputLocation)
	{
		return this.locationsOfOccurence.contains(new Location(inputLocation, -1));
	}
}
