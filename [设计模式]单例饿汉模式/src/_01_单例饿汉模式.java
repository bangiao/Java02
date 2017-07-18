class Single
{
	private int m_count = 100;
	// (1) ����һ�� static �Ķ���
	public static Single _single = new Single();
	// (2) ˽�л� ������
	private Single()
	{
		
	}
	// (3) �ṩһ�����е��ⲿ�ӿ�
	public static Single getInstance()
	{
		return _single;
	}
	
	public void setCount(int _count)
	{
		this.m_count = _count;
	}
	
	public int getCount()
	{
		return m_count;
	}
	
}

public class _01_��������ģʽ
{
	public static void main(String[] args)
	{
		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();
		
		if (s1 == s2)
		{
			System.out.println("zhazha xiang tong le ");
		}
		
	}
}
