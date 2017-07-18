package day02;

import java.util.HashMap;

/*
 * HashMap ��������� �����ظ���, ����ͨ�� euqals �� hashcode ���� ������һ�������Ķ���
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
//public class _01��ͨ����Ա�
//{
//	public static void main(String[] args)
//	{
//		HashMap<Person, String> map = new HashMap<Person, String>();
//
//		map.put(new Person("����", 110), "001");
//		map.put(new Person("����", 220), "002");
//		map.put(new Person("����", 330), "003");
//		map.put(new Person("��ʣ", 440), "004");
//		map.put(new Person("��", 330), "005");
//
//		System.out.println("���ϵ�Ԫ�� " + map);
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
		// TODO �Զ����ɵķ������
		return "x: " + this.x + " y: " + this.y;
	}

	@Override
	public boolean equals(Object obj)
	{
		// TODO �Զ����ɵķ������

		if (obj instanceof Point)
		{
			Point p = (Point) obj;
			return p.x == this.x && this.y == p.y;
		}
		return false;
	}
}

public class _01��ͨ����Ա�
{
	public static void main(String[] args)
	{
		Point p = new Point(100, 200);
		Point p2 = new Point(100, 200);

		System.out.println(p.equals(p2));
	}
}
