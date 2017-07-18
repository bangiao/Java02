package com.bangiao.project;

class Clerk
{
	private int product = 0;
	private Object m_lock = new Object();
	private static Clerk m_clerk = null;

	private Clerk()
	{
		super();
		// TODO �Զ����ɵĹ��캯�����
	}

	public static Clerk getInstance()
	{
		if (null == Clerk.m_clerk)
		{
			Clerk.m_clerk = new Clerk();
		}
		return Clerk.m_clerk;
	}

	public void addProduct()
	{
		setProduct(getProduct() + 1);
	}

	public void summeProduct()
	{
		this.setProduct(this.getProduct() - 1);
	}

	public int getProduct()
	{
		return product;
	}

	public void setProduct(int product)
	{
		this.product = product;
	}

	public Object getM_lock()
	{
		return m_lock;
	}

	public void setM_lock(Object m_lock)
	{
		this.m_lock = m_lock;
	}
}

class Producter implements Runnable
{
	private Clerk m_clerk = null;

	public Producter()
	{
		super();
		this.m_clerk = Clerk.getInstance();
	}

	@Override
	public void run()
	{
		System.out.println("�����߿�ʼ������Ʒ");
		while (true)
		{
			synchronized (this.getM_clerk().getM_lock())
			{
				if (20 <= this.getM_clerk().getProduct())
				{
					try
					{
						this.getM_clerk().getM_lock().wait();
					}
					catch (InterruptedException e)
					{
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
				try
				{
					Thread.currentThread().sleep(1000);
				}
				catch (InterruptedException e)
				{
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				this.getM_clerk().getM_lock().notify();
				this.getM_clerk().addProduct();
				System.out.println(Thread.currentThread().getName() +
						" : �����˵�" + this.getM_clerk().getProduct() + 
						"����Ʒ");
			}
		}
	}

	public Clerk getM_clerk()
	{
		return m_clerk;
	}
}

class Consumer implements Runnable
{
	private Clerk m_clerk = null;

	public Consumer()
	{
		super();
		this.m_clerk = Clerk.getInstance();
	}
	@Override
	public void run()
	{
		while (true)
		{
			synchronized (this.getM_clerk().getM_lock())
			{
				if (this.getM_clerk().getProduct() <= 0)
				{
					try
					{
						this.getM_clerk().getM_lock().wait();
					}
					catch (InterruptedException e)
					{
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
				this.getM_clerk().getM_lock().notify();
				this.getM_clerk().summeProduct();
				System.out.println(Thread.currentThread().getName() + "�����˵� 1 ��" + "��ʣ��: " +
						this.getM_clerk().getProduct());
			}
		}
	}
	public Clerk getM_clerk()
	{
		return m_clerk;
	}
}

public class �����ߺ������߰���
{

	public static void main(String[] args)
	{
		Producter pro = new Producter();
		Consumer con = new Consumer();

		//		System.out.println(pro.getM_clerk().getM_lock() == con.getM_clerk().getM_lock());

		Thread thr1 = new Thread(pro);
		Thread thr2 = new Thread(con);

		thr1.setName("������");
		thr2.setName("������");

		thr1.start();
		thr2.start();

		try
		{
			thr1.join();
			thr2.join();
		}
		catch (InterruptedException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
