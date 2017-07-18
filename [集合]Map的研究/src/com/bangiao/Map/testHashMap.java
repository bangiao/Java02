package com.bangiao.Map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

class Person
{
	private String m_name;
	private int m_age;
	public Person(String m_name, int m_age)
	{
		super();
		this.setM_name(m_name);
		this.setM_age(m_age);
	}
	public Person()
	{
		super();
		// TODO 自动生成的构造函数存根
	}
	public String getM_name()
	{
		return m_name;
	}
	public void setM_name(String m_name)
	{
		this.m_name = m_name;
	}
	public int getM_age()
	{
		return m_age;
	}
	public void setM_age(int m_age)
	{
		this.m_age = m_age;
	}
	@Override
	public String toString()
	{
		return "Person [m_name=" + m_name + ", m_age=" + m_age + ", getM_name()=" + getM_name() + ", getM_age()="
				+ getM_age() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	@Override
	public int hashCode()
	{
		return this.m_name.hashCode();
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (m_age != other.m_age)
			return false;
		return true;
	}
}

public class testHashMap
{
	// TreeMap
	@Test
	public void test5()
	{
		TreeMap<Integer, String> tMap = new TreeMap<Integer, String>();
		tMap.put(10, "zhazha");
		System.out.println(tMap.get(10));
	}
	
	
	
	// 我们可以用 ConcurrentHashMap 替换 Hashtable???
	// ConcurrentHashMap 是一个同步性能更好的一个集合
	// 但是他是部分函数存在线程同步, 所以效率高
	// 但是 Hashtable 的线程同步更稳定
	// 确实是可以代替的
	// 是我的话, 我就稳
	
	@Test
	public void test4()
	{
		ConcurrentHashMap<Integer, String> curHashMap = 
				new ConcurrentHashMap<Integer, String>();
		curHashMap.put(10, "zhazha");
		Set<Entry<Integer, String>> entry = curHashMap.entrySet();
		for (Entry<Integer, String> en : entry)
		{
			System.out.println(en.getKey());
			System.out.println(en.getValue());
		}
		
	}
	
	
	
	// HashMap 减少碰撞的问题
	// key 为什么使用 String Wrapper 的问题
	// 1. String 底层的元素是 final 类型, 是线程安全的
	// 2. String 内部重写了 HashCode 和 equals 返回的 HashCode值通过 final 的
	// 类型得到的, 所以这个 HashCode的值是不易被改变的
	
	
	// HashMap 中链表的大小超过负载因子(0.75f * ***)因该是超过 8 个节点, 
	// 这个时候这个链表在 jdk1.8 标准中需要被重构成红黑树
	// 面试官问: 你了解 HashMap 的重构大小存在着什么问题么???(就是上面这个过程存在一个问题)
	// 答: 多线程问题
	//		假设有两个线程同时发现这个 HashMap 需要重构了
	// 这个时候两个线程会同时处理这一事件, 将去调整元素的位置, 这个时候可能会发生竞争问题
	// 导致是死锁问题
	// 这个时候你就要反问面试官. 你为什么要在多线程的时候使用 HashMap???有什么理由使用它
	@Test
	public void test3()
	{
		
	}
	
	
	class Test_Object
	{
		private String m_name;
		private int m_age;
		public Test_Object(String m_name, int m_age)
		{
			super();
			this.m_name = m_name;
			this.m_age = m_age;
		}
		public Test_Object()
		{
			super();
			// TODO 自动生成的构造函数存根
		}
		@Override
		public String toString()
		{
			return "Test_Object [m_name=" + m_name + ", m_age=" + m_age + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}
		public String getM_name()
		{
			return m_name;
		}
		public void setM_name(String m_name)
		{
			this.m_name = m_name;
		}
		public int getM_age()
		{
			return m_age;
		}
		public void setM_age(int m_age)
		{
			this.m_age = m_age;
		}
		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + m_age;
			result = prime * result + ((m_name == null) ? 0 : m_name.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Test_Object other = (Test_Object) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (m_age != other.m_age)
				return false;
			if (m_name == null)
			{
				if (other.m_name != null)
					return false;
			}
			else if (!m_name.equals(other.m_name))
				return false;
			return true;
		}
		private testHashMap getOuterType()
		{
			return testHashMap.this;
		}
		
		
	}
	
	// 存入HashMap 的元素中的元素在外部时 HashCode 改变时会发生发生什么???
	// 辣鸡面试题
	@Test
	public void test_HashMap2()
	{
		HashMap<Test_Object, String> vHashMap = new HashMap<Test_Object, String>();
		Test_Object t1 = new Test_Object("zhazha", 10);
		vHashMap.put(t1, "1");
		System.out.println(t1.hashCode());
		t1.setM_age(11);
		System.out.println(t1.hashCode());
		System.out.println(vHashMap.get(t1));
		
	}
	
	// HashCode 相同的两个equals不同的元素
	// HashCode 不同的一个equals和上面两个元素的一种一个相同的元素
	@Test
	public void test_HashMap()
	{
		HashMap<Person, String> vHashMap = new HashMap<Person, String>();
		
		Person p1 = new Person("zhazha", 1);
		Person p2 = new Person("zhazha", 2);
		Person p3 = new Person("xixi", 1);

		System.out.println(p1.hashCode() == p2.hashCode());//同
		System.out.println(p3.hashCode() == p1.hashCode());//不同
		System.out.println(p1.equals(p2));//不同
		System.out.println(p3.equals(p1));//相同
		System.out.println(p3.equals(p2));//不同
		
		vHashMap.put(p1, "a");
		vHashMap.put(p2, "b");
		vHashMap.put(p3, "c");
		
		int h = 0;
		System.out.println((p1 == null) ? 0 : (h = p1.hashCode()) ^ (h >>> 16));
		System.out.println((p3 == null) ? 0 : (h = p3.hashCode()) ^ (h >>> 16));
		System.out.println(vHashMap.get(p1));
		System.out.println(vHashMap.get(p3));
		
		// key 相同, 但是 hashcode不同, 优先找 HashCode 不同, 再找 equals 不同
		// 这种案例不是特意为之肯定不可能实现的 上面的这段代码的 equals 是存在问题的
		// 但是这段代码产生了一个问题, 就是 key 可以有多个的情况, 但是这个 Hash 不同
		// 所以我们对 HashMap 的 key - value 的理解是
		// key 的 HashCode 相同 and key 的equals 也相同 找对应的 value
		// 值得注意的是, 在重写 HashCode 和 equals 的时候要相当的谨慎
	}
}
