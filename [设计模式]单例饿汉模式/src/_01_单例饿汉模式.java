class Single
{
	private int m_count = 100;
	// (1) 创建一个 static 的对象
	public static Single _single = new Single();
	// (2) 私有化 构造类
	private Single()
	{
		
	}
	// (3) 提供一个共有的外部接口
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

public class _01_单例饿汉模式
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
