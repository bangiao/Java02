package com.bangiao.project;

class MyThrRunImpl implements Runnable
{
//	volatile int num2 = 1;
//	
//	@Override
//	public void run()
//	{
//		// TODO �Զ����ɵķ������
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
//			System.out.println(Thread.currentThread().getName() + "�ȴ���...");
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
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
	}
}

public class �߳̽����ӡ
{
	public static void main(String[] args)
	{
		MyThrRunImpl run = new MyThrRunImpl();
		Thread thr = new Thread(run);
		Thread thr2 = new Thread(run);
		thr.setName("�߳�һ");
		thr2.setName("�̶߳�");
		thr.start();
		thr2.start();
		
		try
		{
			thr.join();
			thr2.join();
		}
		catch (InterruptedException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
