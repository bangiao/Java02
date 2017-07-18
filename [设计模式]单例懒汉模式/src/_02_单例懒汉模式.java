
class Single
{
	// (1)  创建一个 static 对象
	private static Single s;
	
	// (2) 构造函数私有化
	private Single() { }
	// (3) 创建出一个对象外部的静态函数
	public static Single getInstance()
	{
		// 线程锁
		synchronized ("锁")
		{
			if (s == null)
			{
				s = new Single();
			}
		}
		// 解锁
		return s;
	}
	
}

public class _02_单例懒汉模式
{
	public static void main(String[] args)
	{
		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();
		
		if (s1 == s2)
		{
			System.out.println("the same s1 == s2");
		}
	}
}
