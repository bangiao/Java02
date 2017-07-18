
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
	
	public void print()
	{
		System.out.println(this.getM_name());
		System.out.println(this.getM_age());
	}
}

class Child extends Person
{
	private String m_name;
	
	public Child(String m_name, int m_age, String name)
	{
		super(m_name, m_age);
		// TODO 自动生成的构造函数存根
		this.m_name = name;
	}
	
	public void print()
	{
		super.print();
		System.out.println(this.m_name);
	}
}

public class _Main
{
	public static void main(String[] args)
	{
		Child c = new Child("zhazha", 12, "kankan");
		c.print();
	}
}
