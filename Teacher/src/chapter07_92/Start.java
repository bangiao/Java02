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
				System.out.println(Thread.currentThread().getName() + "�����˵�" + cur_tick + "Ʊ, ʣ��" + tick 
						+ "��Ʊ!");
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
		Thread thr1 = new Thread(target, "������");
		Thread thr2 = new Thread(target, "��ƱƱ");
		Thread thr3 = new Thread(target, "��ţ��");

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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
