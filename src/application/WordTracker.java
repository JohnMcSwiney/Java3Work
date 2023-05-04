package application;

import java.io.File;

import abstract_data_types.IteratorADT;
import abstract_data_types.ListADT;
import exceptions.TreeException;
import file_handling.FileHandler;
import reporting.Report;
import utilities.BSTReferencedBased;
import utilities.Location;
import utilities.MyArrayList;
import utilities.Word;


public class WordTracker
{
	static final String repositoryLocation = /*"./res/*/"repository.ser";
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Welcome to WordTracker");
		
		argumentParser(args);
		
		System.out.println("Thank you for using WordTracker");
	}
	/**
	 * Parses command line arguments passed through when running the .jar file via command line.
	 * @param commandLineArguments Array of command line arguments
	 */
	private static void argumentParser(String[] commandLineArguments)
	{
		boolean printReportToFile = false;
		
		String reportOutputFileName = null;
		String inputTextFileName = null;
		char reportType = '\u0000'; //null char literal
		
		for (String currentArgument : commandLineArguments)
		{
			char argumentType = currentArgument.toLowerCase().charAt(1);
			
			switch (argumentType)
			{
			case 'p':	reportType = currentArgument.toLowerCase().charAt(2);
						break;
			case 'f':	reportOutputFileName = currentArgument.substring(2);
						printReportToFile = true;
						break;
			case 'o': 	inputTextFileName = currentArgument.substring(2);
						break;
			}
		}
		
		mainCaller(inputTextFileName, reportType, printReportToFile, reportOutputFileName);
	}
	/**
	 * The main caller. 
	 * @param <E> must extend comparable
	 * @param inputTextFileName the filename of the input file to parse and add to the binary search tree
	 * @param reportType the type of report to generate
	 * @param printReportToFile Boolean flag to determine if report is printed to file or printed to console.
	 * @param reportOutputFileName Desired filename of the report output path if that option is selected.
	 */
	private static <E extends Comparable<? super E>> void mainCaller(String inputTextFileName, char reportType, boolean printReportToFile, String reportOutputFileName)
	{
		BSTReferencedBased<Word> binarySearchTree = BSTGeneration(inputTextFileName);
		
		textFileParser(binarySearchTree, inputTextFileName);
		
		MyArrayList<String> finalReport = Report.generateReport(binarySearchTree, reportType);
		
		if (printReportToFile)
		{
			FileHandler.saveTextFile(finalReport, reportOutputFileName);
		}
		else
		{
			Report.displayReport(finalReport);
		}
		
		FileHandler.serialize(binarySearchTree, repositoryLocation);
	}
	/**
	 * Generates a binary search tree 
	 * @param inputTextFileName the filename of the input file to parse and add to the binary search tree
	 * @return binarySearchTree either a binary search tree restored from a .ser file, or an empty binary search tree.
	 */
	@SuppressWarnings("unchecked")
	private static BSTReferencedBased<Word> BSTGeneration(String inputTextFileName)
	{
		Object deserialisedObject = FileHandler.deserialize(new File(repositoryLocation));
		
		BSTReferencedBased<Word> binarySearchTree = null;
		
		if (deserialisedObject instanceof BSTReferencedBased<?>)
		{
			binarySearchTree = (BSTReferencedBased<Word>) deserialisedObject;
		}
		else if (deserialisedObject == null)
		{
			binarySearchTree = new BSTReferencedBased<>();
		}
		
		return binarySearchTree;
	}
	/**
	 * Parses text file to a list of strings
	 * @param <E>
	 * @param binarySearchTree The binary search tree to populate
	 * @param inputTextFileName the filename of the input file to parse and add to the binary search tree
	 */
	private static <E extends Comparable<? super E>> void textFileParser(BSTReferencedBased<Word> binarySearchTree, String inputTextFileName)
	{
		MyArrayList<String> inputFile = FileHandler.loadTextFile(inputTextFileName);
		
		MyArrayList<String> cleanedInputFile = FileHandler.removePunctuation(inputFile);
		
		parseAddToBST(binarySearchTree, cleanedInputFile);
	}
	/**
	 * adds the parsed information to the binary search tree
	 * @param binarySearchTree The binary search tree to populate
	 * @param cleanedInputFile the text file in arraylist form without any punctuation
	 */
	private static void parseAddToBST (BSTReferencedBased<Word> binarySearchTree, MyArrayList<String> cleanedInputFile)
	{
		IteratorADT<String> inputIterator = cleanedInputFile.iterator();
		
		String fileName = inputIterator.next();
		
		int currentLineNumber = 1;
		
		while (inputIterator.hasNext())
		{
			String currentLine = inputIterator.next();
			String [] allWordsOnLine = currentLine.split(" ");
			Word currentWord;
			
			for (String currentRawWord : allWordsOnLine)
			{
				if (currentRawWord.equals(""))
				{
					break;
				}
				currentWord = new Word(currentRawWord.toLowerCase());
				
				try
				{
					if (binarySearchTree.isEmpty())
					{
						currentWord = new Word(currentRawWord, 1, fileName, currentLineNumber);
						
						binarySearchTree.add(currentWord);
					}
					else if (!binarySearchTree.contains(currentWord))
					{
						currentWord = new Word(currentRawWord, 1, fileName, currentLineNumber);
						
						binarySearchTree.add(currentWord);
					}
					else if (binarySearchTree.contains(currentWord))
					{
						currentWord = binarySearchTree.search(currentWord).getContents();
						
						currentWord.setFrequency(currentWord.getFrequency() + 1);
						
						if (currentWord.contains(fileName))
						{
							ListADT<Location> currentWordLocations = currentWord.getLocationsOfOccurence();
							
							IteratorADT<Location> locationIterator = currentWordLocations.iterator();
							
							while (locationIterator.hasNext())
							{
								Location tempLocation = locationIterator.next();
								
								if (tempLocation.getLocationName().equals(fileName))
								{
									if (tempLocation.getLineNumbersOfOccurence().contains(currentLineNumber))
									{
										//do nothing as current line number is already in the location object
									}
									else
									{
										tempLocation.getLineNumbersOfOccurence().add(currentLineNumber);
									}
									
									break;
								}
							}
						}
						else
						{
							Location newLocation = new Location(fileName, currentLineNumber);
							currentWord.getLocationsOfOccurence().add(newLocation);
						}
					}
				} 
				catch (NullPointerException e)
				{
					e.printStackTrace();
				} 
				catch (TreeException e)
				{
					e.printStackTrace();
				}
			}
			
			currentLineNumber++;
		}
	}
}
