
public class _02_1到100的所有质素 {
	public static void main(String[] args) {
		// 只能被 1 和 它本身 整除的数 是 质素
		
		int j = 0;
		for (int i = 2; i < 101; i++)
		{
			for (j = 2; j < i; j++)
			{
				// 可以被整除的数不是质数, 如果有的话, 提前跳出
				if (0 == (i % j))
				{
					break;
				}
			}
			// 如果 j == i 就表示 上面的循环没有执行 这个时候 j == i
			if (j == i)
			{
				System.out.print(i + " ");
			}
		}
	}
}
