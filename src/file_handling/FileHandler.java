package file_handling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import abstract_data_types.IteratorADT;
import utilities.MyArrayList;

public class FileHandler
{	
	/**
	 * A load file method utilizing the BufferedReader.
	 * @param inputFilePath the file path of the input text file
	 * @return an arraylist of strings from the input file
	 */
	public static MyArrayList<String> loadTextFile(String inputFilePath)
	{
		MyArrayList<String> parsedInputFile = new MyArrayList<>();
		
		parsedInputFile.add(inputFilePath);

		//File inputFile = new File("./res/"+inputFilePath);
		File inputFile = new File("./"+inputFilePath);
		
		try
		{
			FileReader inputFileReader = new FileReader(inputFile);
			BufferedReader bufferedInputFile = new BufferedReader(inputFileReader);
			
			while(bufferedInputFile.ready())
			{
				String inputLine = bufferedInputFile.readLine();
				parsedInputFile.add(inputLine);
			}
			
			bufferedInputFile.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return parsedInputFile;
	}
	/**
	 * removes unnecessary punctuation 
	 * @param inputFile an arraylist of strings from the input file
	 * @return an arraylist of strings from the input file cleaned of punctuation
	 */
	public static MyArrayList<String> removePunctuation(MyArrayList<String> inputFile)
	{
		String[] punctuationArray = {".", ",", "?", "!", ";", ":", "?", "!", "(", ")", "{", "}", "[", "]", "\"", "--", "'", "-"
										, "\n", "  ", "#", "$", "%", "=", "*", "^", "@", "<", ">", "/", "\\", "+", "_", "|"};
		
		for (int i = 1 ; i < inputFile.size() ; i++)
		{
			String tempString = inputFile.get(i);

			for (String currentPunctuation : punctuationArray)
			{
				if (currentPunctuation.equals("--"))
				{
					tempString = tempString.replace(currentPunctuation, " ");
				}
				else if (currentPunctuation.equals("'"))
				{
					if (tempString.length() > 0)
					{
						if (tempString.charAt(0) == '\'')
						{
							tempString = tempString.substring(1);
						}
						if (tempString.charAt(tempString.length()-1) == '\'')
						{
							tempString = tempString.substring(0, tempString.length()-2);
						}
					}
					tempString = tempString.replace(" '", " ");
					tempString = tempString.replace(" '", " ");
					tempString = tempString.replace("' ", " ");
					tempString = tempString.replace("' ", " ");
				}
				else if (currentPunctuation.equals("-"))
				{
					tempString = tempString.replace(" -", " ");
					tempString = tempString.replace("- ", " ");
					if (tempString.length() > 0)
					{
						if (tempString.charAt(0) == '-')
						{
							tempString = tempString.substring(1);
						}
						if (tempString.charAt(tempString.length()-1) == '-')
						{
							tempString = tempString.substring(0, tempString.length()-2);
						}
					}
				}
				else if (currentPunctuation.equals("  "))
				{
					tempString = tempString.replace(currentPunctuation, " ");
				}
				else
				{
					tempString = tempString.replace(currentPunctuation, "");
				}
				
			}
			inputFile.set(i, tempString);
		}
		
		return inputFile;
	}
	
	/**
	 * Saves a supplied arrayList to file
	 * pre condition 1: each node of arraylist is a single line to be output 
	 * pre condition 2: no new line characters exist within the contents of the arraylist (unless used for special formatting)
	 * @param listToSave the arraylist of strings to save to the file 
	 * @param inputReportOutputFileName the file path of the desired output file
	 */
	public static void saveTextFile(MyArrayList<String> listToSave, String inputReportOutputFileName)
	{
		//File outputFile = new File("./res/"+inputReportOutputFileName);
		File outputFile = new File(inputReportOutputFileName);
		
		try
		{
			FileWriter fileWriter = new FileWriter(outputFile);
			BufferedWriter	bufferedWriter = new BufferedWriter(fileWriter);
			
			IteratorADT<String> reportIterator = listToSave.iterator();
			
			while (reportIterator.hasNext())
			{
				bufferedWriter.write(reportIterator.next());
				bufferedWriter.newLine();
			}
			
			bufferedWriter.close();
			fileWriter.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * serializes
	 * @param <E>
	 * @param inputToSave the object to serialize to file
	 * @param outputObjectFileName the file name of the output file to serialise the object to
	 */
	public static <E extends Serializable> void serialize(E inputToSave, String outputObjectFileName)
	{
		File outputObjectFile = new File(outputObjectFileName);
		
		try
		{			
			FileOutputStream outputStream = new FileOutputStream(outputObjectFile);
			
			ObjectOutputStream objectOutput = new ObjectOutputStream(outputStream);
			
			objectOutput.writeObject(inputToSave);
			
			objectOutput.close();
			outputStream.close();
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * deserializes
	 * @param <E>
	 * @param inputSerializedObjectFile the file path to the .ser file that contains a serialised object.
	 * @return a deserialised object
	 */
	public static Object deserialize(File inputSerializedObjectFile)
	{
		
		if (inputSerializedObjectFile.exists())
		{
			try
			{
				FileInputStream inputStream = new FileInputStream(inputSerializedObjectFile);
				
				ObjectInputStream objectInput = new ObjectInputStream(inputStream);
				
				Object incomingObject = objectInput.readObject();
				
				objectInput.close();
				inputStream.close();
				
				return incomingObject;
			} 
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		
		return null;
	}
}
