import java.util.*;
import java.io.*;

public class Main 
{

	public static void main(String[] args) throws IOException 
	{
		readFile();
	}
	
	public static void readFile() throws IOException
	{
		//read in the file
		File file = new File("C://Users//escut//eclipse-workspace//3x3TeamGenerator//src//persons.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str;
		//print out file for testing
		while((str = br.readLine()) != null)
			{
				System.out.println(str);
			}
	}

}
