/*
 * 类的加载过程
 * 
 * 1. 类加载, 直接加载类的二进制数据
 * 2. 连接:
 * 		--验证: 确保加载类的正确性
 * 		--准备: 为类的静态变量分配内存, 并将其初始化默认值(虚拟机数据初始化)
 * 		--解析: 把类的符号引用(对象名.run())变成直接引用(对象名 + run()指针地址)
 * 3. 初始化(用户数据初始化)
 * 		为类的 static 变量初始化值
 * */

/*
 * 静态方法无法直接访问非静态的代码, 只能通过 new 一个对象从而间接访问
 * 非静态方法可以访问静态的方法
 * */

class Single
{
	private static Single m_single = new Single();
	static public int counter1;
	static public int counter2 = 0;

	private Single()
	{
		counter1++;
		counter2++;
	}

	static Single getInstance()
	{
		return Single.m_single;
	}
}

public class _Main
{
	public static void main(String[] args)
	{
		Single s = Single.getInstance();

		System.out.println(Single.counter1);
		System.out.println(Single.counter2);


		//		Single s2 = Single.getInstance();
		//		
		//		if (s.equals(s2))
		//		{
		//			System.out.println("相等");
		//		}
		//		else
		//		{
		//			System.out.println("不相等");
		//		}
	}
}
