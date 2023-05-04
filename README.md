# Assignment 3

## Description

This program parses an input text file, adds each unique word to a 
Binary Search Tree with the location(file name), and line number that
the word was found on.

The program will also create a report of all the words contained 
within the Binary Search Tree in 3 different formats, and the report
can be saved to a text file if the correct command line argument
is used.

As the program finishes running the Binary Search Tree will be serialised and saved to file so that there is a hard copy of the state
of the tree which means as more input files are parsed the Tree will 
contain a historical archive of them.

## Instructions

### Installation

* Download the .jar file.

### Usage

1. Place WordTracker.jar file in the same parent folder as the input file to be parsed.
2. Open the command line to the current directory.
3. Run the .jar file using the appropriate arguments, see example and explanation below.
	* java -jar WordTracker.jar -oInputFile.txt -pf -fOutputFile.txt
4. Console will display the specified report either via console or 
via save it directly to the output file.

#### Arguments

##### -p Report Type
- F - to print in alphabetic order all words along with the corresponding list of files in which the words occur
- L - to print in alphabetic order all words along with the corresponding list of files and numbers of the lines in which the word occur
- O -to print in alphabetic order all words along with the corresponding list of files, numbers of the lines in which the word occur and the frequency of occurrence of the words

##### -o Input File
- inputFile.txt the input file to parse
	
###### -f Output File
- optional argument used to direct report to be saved directly to	output file rather than displayed in console.

## Completeness

* 100%

## Known deficiencies

* None

## Missing functionality

* None

## Authors

Gia Nguyen, Mohummad Bhatti, Javaria Khan, Johnny Smith

## Version History

* 1.0
    * Initial working version that meets all assignment criteria.
