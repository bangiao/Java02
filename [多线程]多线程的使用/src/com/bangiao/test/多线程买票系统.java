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
					System.out.println(Thread.currentThread().getName() + "��Ʊ, Ʊ��Ϊ:" + NTICK);
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

public class ���߳���Ʊϵͳ
{
	public static void main(String[] args)
	{
		Window w1 = new Window();
		Window w2 = new Window();
		Window w3 = new Window();

		w1.setName("����1");
		w2.setName("����2");
		w3.setName("����3");

		w1.start();
		w2.start();
		w3.start();

	}
}
