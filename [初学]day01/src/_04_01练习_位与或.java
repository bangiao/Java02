
public class _04_01��ϰ_λ���
{
	public static void main(String[] args)
	{
//		int x = 1;
//		int y = 1;
//		// λ��
//		if (x++ == 2 & ++y == 2)
//		{
//			x = 7;
//		}
//		
//		System.out.println("x: " + x + " y: " + y); // x: 2 y: 2
		
//		int x = 1;
//		int y = 1;
//		
//		// ����ǵ�·ѧ��ĳ��ԭ��, ֻҪǰ��һ������ȷ����һ���Ͳ����ٲ���
//		if (x++ == 2 && ++y == 2)
//		{
//			x = 7;
//		}
//		
//		System.out.println("x: " + x + " y: " + y); // x: 2 y: 1
		
//		int x = 1;
//		int y = 1;
//		// λ��
//		if (x++ == 1 | ++y == 1)
//		{
//			x = 7;
//		}
//		
//		System.out.println("x: " + x + " y: " + y); // x: 7 y: 2
		
		int x = 1;
		int y = 1;
		
		// ����ǵ�·ѧ��ĳ��ԭ��, ֻҪǰ��һ����ȷ����һ���Ͳ����ٲ���
		if (x++ == 1 || ++y == 1)
		{
			x = 7;
		}
		
		System.out.println("x: " + x + " y: " + y); // x: 7 y: 1
	}
}
