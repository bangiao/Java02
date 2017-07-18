
interface give_gift
{
	void give_dolls();
	void give_flowers();
	void give_chocolate();
}

class school_mm
{
	String m_name;
	int m_age;
	public school_mm(String m_name, int m_age)
	{
		super();
		this.m_name = m_name;
		this.m_age = m_age;
	}
	
	public school_mm()
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
}

class pursuit implements give_gift
{
	school_mm mm;
	
	public pursuit(school_mm mm)
	{
		super();
		this.mm = mm;
	}
	
	@Override
	public void give_dolls()
	{
		// TODO �Զ����ɵķ������
		System.out.println(mm.getM_name() + "����������");
	}

	@Override
	public void give_flowers()
	{
		// TODO �Զ����ɵķ������
		System.out.println(mm.getM_name() + "�����ʻ�");
	}

	@Override
	public void give_chocolate()
	{
		// TODO �Զ����ɵķ������
		System.out.println(mm.getM_name() + "�����ɿ���");
	}
	
}

class Proxy implements give_gift
{
	pursuit gg;
	public Proxy(school_mm mm)
	{
		super();
		this.gg = new pursuit(mm);
	}

	@Override
	public void give_dolls()
	{
		// TODO �Զ����ɵķ������
		gg.give_dolls();
	}

	@Override
	public void give_flowers()
	{
		// TODO �Զ����ɵķ������
		gg.give_flowers();
	}

	@Override
	public void give_chocolate()
	{
		// TODO �Զ����ɵķ������
		gg.give_chocolate();
	}
	
}

public class _Main
{
	public static void main(String[] args)
	{
		school_mm jiaojiao = new school_mm("���", 22);
		
		Proxy daili = new Proxy(jiaojiao);
		
		daili.give_dolls();
		daili.give_flowers();
		daili.give_chocolate();
	}
}
