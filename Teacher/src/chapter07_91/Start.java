package chapter07_91;

class MyRunnable  implements Runnable
{
	@Override
	public synchronized void run()
	{
		int len = 0;
		System.out.println(Thread.currentThread().getName() + "ѡ���õ��˽�����");
		// TODO �Զ����ɵķ������
		while (100 != len)
		{
			System.out.println(Thread.currentThread().getName() + "����" + (len+=10));
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
