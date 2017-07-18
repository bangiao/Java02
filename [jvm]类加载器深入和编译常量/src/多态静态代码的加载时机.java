
class Parent2
{
	static int a = 3;
	static
	{
		System.out.println("Parent2 static block");
	}
}

class Child2 extends Parent2
{
	static int b = 4;
	static 
	{
		System.out.println("Child2 static block");
	}
}

public class 多态静态代码的加载时机
{
	static 
	{
		System.out.println("_Main static block");
	}
	
	public static void main(String[] args)
	{
		Parent2 parent;
		System.out.println("-----------------------------");
		parent = new Parent2();
		System.out.println(Parent2.a);
		System.out.println(Child2.b);
	}
}
