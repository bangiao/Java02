
class Outer
{
	int num = 3;
	
	Object method(int y)
	{
		int x = 10;
		
		class Inner
		{
			void show()
			{
				System.out.println("show: " + y);
			}
		}
		Inner in = new Inner();
		return in;
	}
}


public class _Main
{
	public static void main(String[] args)
	{
		Outer o = new Outer();
		Object obj = o.method(0);
	}
}
