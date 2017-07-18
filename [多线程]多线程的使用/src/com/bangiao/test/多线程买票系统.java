package com.bangiao.test;

class Window extends Thread
{
	public static int NTICK = 100;
	public void run()
	{
		while (true)
		{
			System.out.println(this.getClass());
			synchronized (this.getClass())
			{
				if (NTICK > 0)
				{
					System.out.println(Thread.currentThread().getName() + "售票, 票号为:" + NTICK);
					NTICK--;
				}
				else
				{
					break;
				}
			}
		}
	}
}

public class 多线程买票系统
{
	public static void main(String[] args)
	{
		Window w1 = new Window();
		Window w2 = new Window();
		Window w3 = new Window();

		w1.setName("窗口1");
		w2.setName("窗口2");
		w3.setName("窗口3");

		w1.start();
		w2.start();
		w3.start();

	}
}
