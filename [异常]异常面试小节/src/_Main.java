
public class _Main
{
	static void methodA()
	{
		try
		{
			System.out.println("进入方法A");// 1
			throw new RuntimeException("制造异常");//3
		}
		finally
		{
			System.out.println("用 A 方法的finally");// 2
		}
	}
	
	static void methodB()
	{
		try
		{
			System.out.println("进入方法B");
			return ;
		}
		finally
		{
			System.out.println("调用B方法的finally");
		}
	}
	
	static void methodC()
	{
		try
		{
			System.out.println("进入方法C");// 1
			System.out.println("方法C结束");// 2
		}
		finally
		{
			System.out.println("用 C 方法的finally");// 3
		}
	}
	
	public static void main(String[] args)
	{
		try
		{
//			methodA();
			methodB();
//			methodC();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
