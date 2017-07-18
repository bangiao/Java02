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

	// ��ʼ��������ڹ��캯������֮ǰ����
	// �����������c++�ĳ�ʼ����Ա�б�
	{
		this.setM_age(12);
		this.setM_name("zhazha");
		// 
		setM_name("xixi");
		System.out.println("��ʼ�������: " + getM_name());
	}
	// m_native
	// �����̬�Ĵ�������ڳ�ʼ�����еľ�̬��Ա, 
	// ��� m_native ������ص�ʱ�򱻳�ʼ��Ϊ null
	// ������صĳ�ʼ���׶α���ʼ���� "zhazha"
	// �����ﱻ�Ǿ�̬������ʼ���� "xixi"
	// �ڹ��캯������ �޲ι��캯��ʱ, ����ʼ��Ϊ China
	static
	{
		setM_native("zhazha");
		System.out.println("��̬�����: " + getM_native());
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
