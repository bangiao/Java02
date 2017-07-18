
public class _04_01练习_位与或
{
	public static void main(String[] args)
	{
//		int x = 1;
//		int y = 1;
//		// 位与
//		if (x++ == 2 & ++y == 2)
//		{
//			x = 7;
//		}
//		
//		System.out.println("x: " + x + " y: " + y); // x: 2 y: 2
		
//		int x = 1;
//		int y = 1;
//		
//		// 这个是电路学的某个原理, 只要前面一个不正确后面一个就不用再测了
//		if (x++ == 2 && ++y == 2)
//		{
//			x = 7;
//		}
//		
//		System.out.println("x: " + x + " y: " + y); // x: 2 y: 1
		
//		int x = 1;
//		int y = 1;
//		// 位或
//		if (x++ == 1 | ++y == 1)
//		{
//			x = 7;
//		}
//		
//		System.out.println("x: " + x + " y: " + y); // x: 7 y: 2
		
		int x = 1;
		int y = 1;
		
		// 这个是电路学的某个原理, 只要前面一个正确后面一个就不用再测了
		if (x++ == 1 || ++y == 1)
		{
			x = 7;
		}
		
		System.out.println("x: " + x + " y: " + y); // x: 7 y: 1
	}
}
