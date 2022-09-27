import java.util.*;
import java.io.*;

public class Main 
{

	static ArrayList<Person> persons = new ArrayList<Person>();
	
	public static void main(String[] args) throws IOException 
	{
		readFile();
		createGroups();
	}
	
	public static void createGroups() throws IOException
	{
		while(true)
		{
			System.out.println("How would you like to organize teams?");
			System.out.println("1. Balanced");
			System.out.println("2. Ranked");
			System.out.println("3. Random");
			Scanner numIn = new Scanner(System.in);
			int choice = numIn.nextInt();
			if(choice == 1)
			{
				generateBalanced();
				break;
			}
			else if(choice == 2)
			{
				generateRanked();
				break;
			}
			else if(choice == 3)
			{
				generateRandom();
				break;
			}
			else
			{
				System.out.println("Invalid Input");
			}
		}
	}
	
	public static void generateBalanced()
	{
		int teamNum = 1;
		for(int i = 0; i < persons.size() * 10; i++)
		{
//			Person a = persons.get(0);
//			Person b = persons.get(persons.size()-1);
//			Person c = persons.get(persons.size()/2);
//			persons.remove(persons.size()-1);
//			persons.remove((persons.size() + 1)/2);
//			persons.remove(0);
			
			System.out.println("Team #" + teamNum + ": " + persons.get(0).getName().substring(0, persons.get(0).getName().length() - 1) + ", " + persons.get(persons.size()-1).getName().substring(0, persons.get(persons.size()-1).getName().length() - 1) + ", " + persons.get(persons.size()/2).getName().substring(0, persons.get(persons.size()/2).getName().length() - 1));
			double totalTime = persons.get(0).getAverage() + persons.get(persons.size()-1).getAverage() + persons.get(persons.size()/2).getAverage();
			int totalMin = ((int)totalTime) / 60;
			double leftoverSec = totalTime % 60;
			
			if(totalMin == 0)
			{
				System.out.print("Total Estimated Time: ");
				System.out.printf("%.2f", leftoverSec);
				System.out.println("");
			}
			else
			{
				if(leftoverSec < 10)
				{
					System.out.print("Total Estimated Time: " + totalMin + ":0");
					System.out.printf("%.2f", leftoverSec);
					System.out.println("");
				}
				else
				{
					System.out.print("Total Estimated Time: " + totalMin + ":");
					System.out.printf("%.2f", leftoverSec);
					System.out.println("");
				}
			}
			teamNum++;
			System.out.println("");
			persons.remove(persons.size()-1);
			persons.remove((persons.size() + 1)/2);
			persons.remove(0);
		}
	}
	
	public static void generateCompetitive()
	{
		
	}
	
	public static void generateRanked()
	{
		int teamNum = 1;
		for(int i = 0; i < persons.size() - 2; i += 3)
		{
			System.out.println("Team #" + teamNum + ": " + persons.get(i).getName().substring(0, persons.get(i).getName().length() - 1) + ", " + persons.get(i+1).getName().substring(0, persons.get(i+1).getName().length() - 1) + ", " + persons.get(i+2).getName().substring(0, persons.get(i+2).getName().length() - 1));
			double totalTime = persons.get(i).getAverage() + persons.get(i+1).getAverage() + persons.get(i+2).getAverage();
			int totalMin = ((int)totalTime) / 60;
			double leftoverSec = totalTime % 60;
			
			if(totalMin == 0)
			{
				System.out.print("Total Estimated Time: ");
				System.out.printf("%.2f", leftoverSec);
				System.out.println("");
			}
			else
			{
				if(leftoverSec < 10)
				{
					System.out.print("Total Estimated Time: " + totalMin + ":0");
					System.out.printf("%.2f", leftoverSec);
					System.out.println("");
				}
				else
				{
					System.out.print("Total Estimated Time: " + totalMin + ":");
					System.out.printf("%.2f", leftoverSec);
					System.out.println("");
				}
			}
			teamNum++;
			System.out.println("");
		}
	}
	
	public static void generateRandom()
	{
		Collections.shuffle(persons);
		generateRanked();
	}
	
	public static void readFile() throws IOException
	{
		//read in the file
		File file = new File("C://Users//escut//eclipse-workspace//3x3TeamGenerator//src//persons.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str;
		
		
		//read each line of the file and store info in an array list
		while((str = br.readLine()) != null)
			{
				String name = "", id = "";
				double average = 100;
				
				str.split("");
				for(int i = 0; i < str.split("	").length; i++)
				{
					if(i == 1) 
					{
						name = (str.split("	")[i]);
						//System.out.println(name);
					}
					else if(i == 2)
					{
						id = (str.split("	")[i]);
					}
					else if(i==4)
					{
						average = Double.parseDouble(str.split("	")[i]);	
					}
				}
				persons.add(new Person(name, id, average));
			}
	}

}
