package com.bangiao.project;

class MyThrRunImpl implements Runnable
{
//	volatile int num2 = 1;
//	
//	@Override
//	public void run()
//	{
//		// TODO 自动生成的方法存根
//		while (true)
//		{
//			if (num2 <= 100)
//			{
//				System.out.println(Thread.currentThread().getName() + " : " + num2);
//				num2++;
//			}
//			else
//			{
//				break;
//			}
//		}
//	}
	
	
	int num = 1;

	@Override
	public void run()
	{
		while (true)
		{
//			System.out.println(Thread.currentThread().getName() + "等待中...");
			synchronized ("zha")
			{
//				System.out.println(Thread.currentThread().getName() + "notify...");
				"zha".notify();
				if (num <= 100)
				{
					System.out.println(Thread.currentThread().getName() + " : " + num);
					num++;
				}
				else
				{
					break;
				}
				try
				{
//					System.out.println(Thread.currentThread().getName() + "wait...");
					"zha".wait();
				}
				catch (InterruptedException e)
				{
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}
}

public class 线程交替打印
{
	public static void main(String[] args)
	{
		MyThrRunImpl run = new MyThrRunImpl();
		Thread thr = new Thread(run);
		Thread thr2 = new Thread(run);
		thr.setName("线程一");
		thr2.setName("线程二");
		thr.start();
		thr2.start();
		
		try
		{
			thr.join();
			thr2.join();
		}
		catch (InterruptedException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
