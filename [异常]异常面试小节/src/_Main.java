
public class _Main
{
	static void methodA()
	{
		try
		{
			System.out.println("���뷽��A");// 1
			throw new RuntimeException("�����쳣");//3
		}
		finally
		{
			System.out.println("�� A ������finally");// 2
		}
	}
	
	static void methodB()
	{
		try
		{
			System.out.println("���뷽��B");
			return ;
		}
		finally
		{
			System.out.println("����B������finally");
		}
	}
	
	static void methodC()
	{
		try
		{
			System.out.println("���뷽��C");// 1
			System.out.println("����C����");// 2
		}
		finally
		{
			System.out.println("�� C ������finally");// 3
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
