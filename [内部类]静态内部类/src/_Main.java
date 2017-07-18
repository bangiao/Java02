
class Person
{
	private String m_name;
	private int m_age;
	
	static class Head
	{
		private String m_name;
		private String m_big;
		public String getM_name()
		{
			return m_name;
		}
		public void setM_name(String m_name)
		{
			this.m_name = m_name;
		}
		public String getM_big()
		{
			return m_big;
		}
		public void setM_big(String m_big)
		{
			this.m_big = m_big;
		}
	}
	
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
}

public class _Main
{
		public static void main(String[] args)
		{
			Person p = new Person();
			Person.Head he = new Person.Head();
		}
}
