package day02;

import java.util.HashMap;

/*
 * HashMap 这个集合是 不可重复的, 可以通过 euqals 和 hashcode 函数 来区分一个容器的对象
 * */

//class Person
//{
//	String name;
//	int id;
//	public Person(String name, int id)
//	{
//		super();
//		this.name = name;
//		this.id = id;
//	}
//
//	@Override
//	public String toString()
//	{
//		return "[" + this.name + ", " + this.id + "]";
//	}
//
//	@Override
//	public int hashCode()
//	{
//		return this.id;
//	}
//
//	@Override
//	public boolean equals(Object obj)
//	{
//		if (obj instanceof Person)
//		{
//			Person p = (Person) obj;
//			return this.id == p.id;
//		}
//		return false;
//	}
//}
//
//public class _01普通对象对比
//{
//	public static void main(String[] args)
//	{
//		HashMap<Person, String> map = new HashMap<Person, String>();
//
//		map.put(new Person("狗娃", 110), "001");
//		map.put(new Person("狗渣", 220), "002");
//		map.put(new Person("狗蛋", 330), "003");
//		map.put(new Person("狗剩", 440), "004");
//		map.put(new Person("大蛋", 330), "005");
//
//		System.out.println("集合的元素 " + map);
//	}
//}



class Point
{
	int x = 0;
	int y = 0;
	public Point(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString()
	{
		// TODO 自动生成的方法存根
		return "x: " + this.x + " y: " + this.y;
	}

	@Override
	public boolean equals(Object obj)
	{
		// TODO 自动生成的方法存根

		if (obj instanceof Point)
		{
			Point p = (Point) obj;
			return p.x == this.x && this.y == p.y;
		}
		return false;
	}
}

public class _01普通对象对比
{
	public static void main(String[] args)
	{
		Point p = new Point(100, 200);
		Point p2 = new Point(100, 200);

		System.out.println(p.equals(p2));
	}
}
