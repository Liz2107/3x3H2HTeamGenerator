
public class Person 
{
	
	private String name;
	private String id;
	private double average;
	
	public Person(String n, String i, double a)
	{
		name = n;
		id = i;
		average = a;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getId()
	{
		return id;
	}
	public void setId()
	{
		this.id = id;
	}
	
	public double getAverage()
	{
		return average;
	}
	public void setAverage(double average)
	{
		this.average = average;
	}	
}
