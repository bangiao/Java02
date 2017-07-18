
public class _Main
{
	public static void main(String[] args)
	{
		int i = method1();
		System.out.println(i);
	}
	
	public static int method1()
	{
		try
		{
			return 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 2;
		}
		finally
		{
			System.out.println("Œ“ «Àß∏Á");
			return 3;
		}
	}
}
