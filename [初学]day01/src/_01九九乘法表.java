
public class _01¾Å¾Å³Ë·¨±í {
	public static void main(String[] args) {
		// 1 * 1 = 1
		// 2 * 1 = 2  2 * 2 = 4
		for (int i = 1; i < 10; i++)
		{
			for (int j = 1; j < 10; j++)
			{
				int sum = j * i;
				System.out.print(i + " * " + j + " = " + sum + "\t");
				if (i == j)
				{
					System.out.println("");
					break;
				}
			}
		}
	}
}
