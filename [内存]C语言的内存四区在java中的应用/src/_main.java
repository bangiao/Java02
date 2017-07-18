class Person
{
	private String name;
	private int age;
	static String country = "CN";
	public Person(String name, int age)
	{
		super();
		this.name = name;
		this.age = age;
	}
	
	public void show()
	{
		System.out.println(Person.country + "+" + this.name + ":" + this.age);
	}
	
	public static void method()
	{
		System.out.println(Person.country);
	}
	
}


// 一个类中只存在    属性和方法

// 内部类在 类中被解释为 属性

class Perosn
{
	static void _print()
	{
		System.out.println("111");
	}
}

public class _main
{
	class Inner
	{
		void show()
		{
			System.out.println("zhazha");
		}
	}
	
	public static void main(String[] args)
	{
		Person.method();
		Person p = new Person("java", 20);
		p.show();
		
		_main.Inner i = new _main().new Inner();
	}
}
