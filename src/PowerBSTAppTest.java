/**
Write PowerBSTApp to read in CSV file and store data items within a traditional unsorted array
@author Mahmoodah Jaffer - JFFMAH001
@since 27 February 2019
*/

/**
	PowerBSTApp is an app that returns the power and voltage of a specified date/time given by user according to the data in the file
	cleaned_data.csv. If the date/time cannot be found then the app will return "Date/time not found". If no specific date/time is given 
	then all date/time, power and voltage of all the date/time's will be returned. The data is stored in a BinaryTree as opposed to an 
	array so that it won't take as many comparison operations to find the specified value. 
*/
import java.io.*;



public class PowerBSTAppTest
{
	public static BinarySearchTree powerdata;

	public static void main (String [] args) throws IOException
	{

		/**
		The main method takes in the argument which would be the date time and uses the agument to 
		call either the printAllDateTimes function or the printDateTime
		*/
		if (args.length==0){
			printAllDateTimes();
		}
		else{

				printDateTime(args[0]);

		}

	}

		private static BinarySearchTree fileData (String filename) throws FileNotFoundException, IOException
		{
			/**
			Method fileData reads in CSV file and stores the voltage, power and voltage data required from CSV file into a
			BinarySearchTree to store each element
			@param filename String
			@returns powerdata BinaryTree of type BinarySearchTree
			@exception FileNotFoundException
			@exception IOException
			@see FileNotFoundException
			@see IOException
			*/
			BinarySearchTree powerdata = new BinarySearchTree(); //500 element array with PowerStation type to store the reuired data from CSV file


			FileReader read = new FileReader(filename); //reads in data from CSV file
			BufferedReader bread = new BufferedReader(read);// read is wraaped in the BufferedReader

			String firstline = bread.readLine(); //reads first line of text file - nothing will be done with this line because it holds no useful data
			String line = bread.readLine(); // second line of CSV file is read 

			while (line!=null)
			{
				String [] data = line.split(","); //the data from line is split by the commas and is being stored in an array 

				String datetime = data[0]; //sets variable datetime to the first element in data array - Date/Time
				String power = data[1];//sets variable power to the second element in data array - Global Active Power
				String voltage = data[3];//sets variable voltage to the fourth element in data array - Voltage

				powerdata.insert(new PowerStation(datetime,power,voltage)); //Powerstation object will store the datetime, power and voltage in element of linepos


				line = bread.readLine(); //reads next line in CSV file
			}
			return powerdata;

		
		}

		private static void printDateTime( String dateTime) throws IOException{
			/**
			Method searches for datetime given using the find function in the class BinarySeachTree and returns the corresponding voltage and power 
			@param dateTime String
			@returns void
			@exception IOException
			@see IOException
			*/

			if(((fileData("cleaned_data.csv")).find(dateTime))==null){
				System.out.println("Date/time not found");
				System.out.println(fileData("cleaned_data.csv").Counter());
			}
			else{
				System.out.print(fileData("cleaned_data.csv").Counter());
			}

		}

		private static void printAllDateTimes() throws IOException{
			/**
			Method printAllDateTimes dispalys all elements of the BinarySearchTree using the display function in the BinarySearchTree class
			@param None
			@returns void
			@exception IOException
			@see IOException
			*/
			(fileData("cleaned_data.csv")).display();
		}



}