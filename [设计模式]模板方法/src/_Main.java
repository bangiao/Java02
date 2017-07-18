
public class _Main
{
	public static void main(String[] args)
	{
		SubTmeplate s = new SubTmeplate();
		s.SpendTime();
	}
}

abstract class Template
{
	public abstract void code();
	
	public void SpendTime()
	{
		long start = System.currentTimeMillis();
		this.code();
		long end = System.currentTimeMillis();
		System.out.println("花费时间为: " + (end - start));
	}
}

class SubTmeplate extends Template
{
	@Override
	public void code()
	{
		// TODO 自动生成的方法存根
		boolean flag = false;
		for (int i = 2; i <= 10000; i++)
		{
			for (int j = 2; j <= Math.sqrt(i); j++)
			{
				if (0 == i % j)
				{
					flag = true;
					break;
				}
			}
			if (!flag)
			{
				System.out.println(i);
			}
			flag = false;
		}
	}
	
}
