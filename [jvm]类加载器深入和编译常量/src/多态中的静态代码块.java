
class Parent
{
	static int a = 3;
	
	static 
	{
		System.out.println("Parent  static block");
	}
}

class Child extends Parent
{
	static int b = 4;
	static 
	{
		System.out.println("Child static block");
	}
}

public class 多态中的静态代码块
{
	static 
	{
		System.out.println("多态中的静态代码块 static block");
	}
	public static void main(String[] args)
	{
		System.out.println(Child.b);
	}
}
