package chapter07_92;

class MyRun2 implements Runnable
{
	private static volatile int tick = 10;
	private static volatile int cur_tick = 0;
	@Override
	public void run()
	{
		while (true)
		{
			synchronized (this)
			{
				if (0 == tick)
				{
					break;
				}
				tick--;
				cur_tick++;
				System.out.println(Thread.currentThread().getName() + "抢到了第" + cur_tick + "票, 剩余" + tick 
						+ "张票!");
				Thread.yield();
			}
		}
	}
}

public class Start
{
	public static void main(String[] args)
	{
		MyRun2 target = new MyRun2();
		Thread thr1 = new Thread(target, "桃跑跑");
		Thread thr2 = new Thread(target, "张票票");
		Thread thr3 = new Thread(target, "黄牛党");

		thr1.start();
		thr2.start();
		thr3.start();
		
		try
		{
			thr1.join();
			thr2.join();
			thr3.join();
		}
		catch (InterruptedException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
