package day02;

class Parent
{
	static
	{
		System.out.println("A");
	}
	
	public Parent()
	{
		System.out.println("B");
	}
	
	{
		System.out.println("C");
	}
}

class Child extends Parent
{
	static 
	{
		System.out.println("D");
	}

	public Child()
	{
		System.out.println("E");
	}
	
	{
		System.out.println("F");
	}
}

public class _02_语句块的使用和优先级
{
	public static void main(String[] args)
	{
		new Child();
	}
}
