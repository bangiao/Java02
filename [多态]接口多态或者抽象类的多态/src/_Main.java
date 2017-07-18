import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

interface AbsBase
{
	public void print();
}

class Car implements AbsBase
{
	@Override
	public void print()
	{
		System.out.println("Car interface");
	}
}

abstract class Person
{
	abstract void printf();
}

class Child extends Person
{
	@Override
	void printf()
	{
		System.out.println("Person abstract");
	}
}

class People
{
	void printg()
	{
		System.out.println("People");
	}
}

class Teacher extends People
{
	void printg()
	{
		System.out.println("Teacher");
	}
}

public class _Main
{
	public static void main(String[] args)
	{
		AbsBase absBase = new Car();
		Person pBase = new Child();
		People people = new Teacher();
		
		absBase.print();
		pBase.printf();
		people.printg();
		
		
		List<String> list = new ArrayList<>();
		List<String> list2 = new Vector<>();
		List<String> list3 = new LinkedList<>();
		Set<String> set = new HashSet<>();
		set.add("zhazha");
		set.add("zhazha");
		Set<String> set1 = new TreeSet<>();
		Set<String> set2 = new LinkedHashSet<>();
		
		Map<Integer, String> map = new TreeMap<Integer, String>();
		Map<Integer, String> map1 = new HashMap<Integer, String>();
		Map<Integer, String> map2 = new Hashtable<Integer, String>();
	}
}
