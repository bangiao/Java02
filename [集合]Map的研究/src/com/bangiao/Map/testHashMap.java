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
		// TODO �Զ����ɵĹ��캯�����
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
	
	
	
	// ���ǿ����� ConcurrentHashMap �滻 Hashtable???
	// ConcurrentHashMap ��һ��ͬ�����ܸ��õ�һ������
	// �������ǲ��ֺ��������߳�ͬ��, ����Ч�ʸ�
	// ���� Hashtable ���߳�ͬ�����ȶ�
	// ȷʵ�ǿ��Դ����
	// ���ҵĻ�, �Ҿ���
	
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
	
	
	
	// HashMap ������ײ������
	// key Ϊʲôʹ�� String Wrapper ������
	// 1. String �ײ��Ԫ���� final ����, ���̰߳�ȫ��
	// 2. String �ڲ���д�� HashCode �� equals ���ص� HashCodeֵͨ�� final ��
	// ���͵õ���, ������� HashCode��ֵ�ǲ��ױ��ı��
	
	
	// HashMap ������Ĵ�С������������(0.75f * ***)����ǳ��� 8 ���ڵ�, 
	// ���ʱ����������� jdk1.8 ��׼����Ҫ���ع��ɺ����
	// ���Թ���: ���˽� HashMap ���ع���С������ʲô����ô???(��������������̴���һ������)
	// ��: ���߳�����
	//		�����������߳�ͬʱ������� HashMap ��Ҫ�ع���
	// ���ʱ�������̻߳�ͬʱ������һ�¼�, ��ȥ����Ԫ�ص�λ��, ���ʱ����ܻᷢ����������
	// ��������������
	// ���ʱ�����Ҫ�������Թ�. ��ΪʲôҪ�ڶ��̵߳�ʱ��ʹ�� HashMap???��ʲô����ʹ����
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
			// TODO �Զ����ɵĹ��캯�����
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
	
	// ����HashMap ��Ԫ���е�Ԫ�����ⲿʱ HashCode �ı�ʱ�ᷢ������ʲô???
	// ����������
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
	
	// HashCode ��ͬ������equals��ͬ��Ԫ��
	// HashCode ��ͬ��һ��equals����������Ԫ�ص�һ��һ����ͬ��Ԫ��
	@Test
	public void test_HashMap()
	{
		HashMap<Person, String> vHashMap = new HashMap<Person, String>();
		
		Person p1 = new Person("zhazha", 1);
		Person p2 = new Person("zhazha", 2);
		Person p3 = new Person("xixi", 1);

		System.out.println(p1.hashCode() == p2.hashCode());//ͬ
		System.out.println(p3.hashCode() == p1.hashCode());//��ͬ
		System.out.println(p1.equals(p2));//��ͬ
		System.out.println(p3.equals(p1));//��ͬ
		System.out.println(p3.equals(p2));//��ͬ
		
		vHashMap.put(p1, "a");
		vHashMap.put(p2, "b");
		vHashMap.put(p3, "c");
		
		int h = 0;
		System.out.println((p1 == null) ? 0 : (h = p1.hashCode()) ^ (h >>> 16));
		System.out.println((p3 == null) ? 0 : (h = p3.hashCode()) ^ (h >>> 16));
		System.out.println(vHashMap.get(p1));
		System.out.println(vHashMap.get(p3));
		
		// key ��ͬ, ���� hashcode��ͬ, ������ HashCode ��ͬ, ���� equals ��ͬ
		// ���ְ�����������Ϊ֮�϶�������ʵ�ֵ� �������δ���� equals �Ǵ��������
		// ������δ��������һ������, ���� key �����ж�������, ������� Hash ��ͬ
		// �������Ƕ� HashMap �� key - value �������
		// key �� HashCode ��ͬ and key ��equals Ҳ��ͬ �Ҷ�Ӧ�� value
		// ֵ��ע�����, ����д HashCode �� equals ��ʱ��Ҫ�൱�Ľ���
	}
}
