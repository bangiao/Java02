
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

public class ��̬�еľ�̬�����
{
	static 
	{
		System.out.println("��̬�еľ�̬����� static block");
	}
	public static void main(String[] args)
	{
		System.out.println(Child.b);
	}
}
