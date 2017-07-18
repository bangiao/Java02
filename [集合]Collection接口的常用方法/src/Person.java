
public class Person
{
	private String m_name;
	private Integer m_age;
	public Person(String m_name, Integer m_age)
	{
		super();
		this.m_name = m_name;
		this.m_age = m_age;
	}
	@Override
	public String toString()
	{
		return "Person [m_name=" + m_name + ", m_age=" + m_age + "]";
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		else if (null == obj)
		{
			return false;
		}
		if (obj.getClass() != this.getClass())
		{
			return false;
		}
		Person p = (Person) obj;
		if (m_age == null)
		{
			if (p.m_age != null)
			{
				return false;
			}
		}
		else if (!p.m_age.equals(this.m_age))
		{
			return false;
		}
		if (m_name == null)
		{
			if (p.m_name != null)
			{
				return false;
			}
		}
		if (!p.m_name.equals(this.m_name))
		{
			return false;
		}
		return true;
	}
	
	public String getM_name()
	{
		return m_name;
	}
	public void setM_name(String m_name)
	{
		this.m_name = m_name;
	}
	public Integer getM_age()
	{
		return m_age;
	}
	public void setM_age(Integer m_age)
	{
		this.m_age = m_age;
	}
	
	
	
}
