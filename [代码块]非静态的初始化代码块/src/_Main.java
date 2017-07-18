class Person
{
	private String m_name;
	private int m_age;
	private static String m_native;

	public Person()
	{
		super();
		this.setM_age(0);
		this.setM_name("xiaoxiao");
		Person.setM_native("China");
	}

	public Person(String m_name, int m_age)
	{
		super();
		this.setM_name(m_name);
		this.setM_age(m_age);
		Person.setM_native("China");
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

	public static String getM_native()
	{
		return m_native;
	}
	public static void setM_native(String m_native)
	{
		Person.m_native = m_native;
	}

	// 初始化代码块在构造函数调用之前调用
	// 这个就类似于c++的初始化成员列表
	{
		this.setM_age(12);
		this.setM_name("zhazha");
		// 
		setM_name("xixi");
		System.out.println("初始化代码块: " + getM_name());
	}
	// m_native
	// 这个静态的代码块用于初始化类中的静态成员, 
	// 这个 m_native 在类加载的时候被初始化为 null
	// 在类加载的初始化阶段被初始化成 "zhazha"
	// 在这里被非静态代码块初始化成 "xixi"
	// 在构造函数调用 无参构造函数时, 被初始化为 China
	static
	{
		setM_native("zhazha");
		System.out.println("静态代码块: " + getM_native());
	}
}

public class _Main
{
	public static void main(String[] args)
	{
		Person p = new Person();
		System.out.println("age: " + p.getM_age());
		System.out.println("name: " + p.getM_name());
		System.out.println("native: " + Person.getM_native());
	}
}
