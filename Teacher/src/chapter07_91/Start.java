package chapter07_91;

class MyRunnable  implements Runnable
{
	@Override
	public synchronized void run()
	{
		int len = 0;
		System.out.println(Thread.currentThread().getName() + "选手拿到了接力棒");
		// TODO 自动生成的方法存根
		while (100 != len)
		{
			System.out.println(Thread.currentThread().getName() + "跑了" + (len+=10));
		}
	}
	
}

public class Start
{
	public static void main(String[] args)
	{
		MyRunnable myRun = new MyRunnable();
		for (int i = 0; i < 10; i++)
		{
			new Thread(myRun).start();
		}
	}
}
