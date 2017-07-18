import java.util.Scanner;

public class _03_最大公约数和最小公倍数
{
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		// 最大公约数
		// 12    15
		// 12 % 1 == 0	continue
		// 12 % 2 == 0	15 % 2 != 0  false
		// 12 % 3 == 0  15 % 3 == 0  true
		// 12 % 4 == 0  15 % 4 != 0  false
		// 12 % 5 != 0  15 % 5 == 0  false
		// ...
		// 12 % i == 0  15 % i == 0 true
		// ...
		// 12 % 12 == 0 false 15 % 12 != 0
		int min_num = num1 < num2 ? num1 : num2;
		int max = 0;
		for (int i = 1; i <= min_num; i++)
		{
			if (0 == (num1 % i))
			{
				if (0 == (num2 % i))
				{
					max = i;
				}
			}
		}
		System.out.println("最大公约数: " + max);
		
		// 最小公倍数
		// 3   4
		// 3 * 2 = 6 % 4  != 0
		// 3 * 3 = 9 % 4  != 0
		// 3 * 4 = 12 % 4 == 0
		int max_num = num1 > num2 ? num1 : num2;
		
		for (int i = 1; i < max_num; i++)
		{
			int min = min_num * i;
			if (0 == (min % max_num))
			{
				System.out.println("最小公倍数: " + min);
				break;
			}
		}
	}
}
