
public class _05_三木运算符
{
	// 5 获取三个数中的较大数, 使用三目运算
	public static void main(String[] args)
	{
		int a = 10;
		int b = 20;
		int c  = 35;
		
		int max = c > (a > b ? a : b) ? c : (a > b ? a : b); 
		
		System.out.println("max: " + max);
	}
}
