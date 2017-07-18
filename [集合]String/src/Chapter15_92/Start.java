package Chapter15_92;

import java.util.LinkedList;
import java.util.function.Consumer;

import com.sun.javafx.geom.transform.GeneralTransform3D;

class Goods
{
	private String m_name;
	private int m_num;
	public Goods(String m_name, int m_num)
	{
		super();
		this.setM_name(m_name);
		this.setM_num(m_num);
	}
	public Goods()
	{
		super();
		// TODO 自动生成的构造函数存根
	}
	public String getM_name()
	{
		return m_name;
	}
	public void setM_name(String m_name)
	{
		this.m_name = m_name;
	}
	public int getM_num()
	{
		return m_num;
	}
	public void setM_num(int m_num)
	{
		this.m_num = m_num;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (null == this)
		{
			return false;
		}
		if (null == obj)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Goods myObj = (Goods) obj;
		if (!this.m_name.equals(myObj.m_name))
		{
			return false;
		}
		return true;
	}
}

class Shop
{
	private LinkedList<Goods> list_arr;

	public Shop(LinkedList<Goods> list_arr)
	{
		super();
		this.list_arr = list_arr;
	}

	public Shop()
	{
		super();
		list_arr = new LinkedList<Goods>();
	}
	
	int initGoods()
	{
		if (null == list_arr)
		{
			list_arr = new LinkedList<Goods>();
			if (null == list_arr)
			{
				return -1;
			}
		}
		return 0;
	}
	
	int show()
	{
		for (int i = 0; i < list_arr.size(); i++)
		{
			list_arr.get(i);
		}
		return 0;
	}
	
	int buy(String in_name, int in_num)
	{
		for (int i = 0; i < list_arr.size(); i++)
		{
			Goods tmp = this.list_arr.get(i);
			if (new Goods(in_name, in_num).equals(tmp))
			{
				if (tmp.getM_num() <= in_num)
				{
					this.list_arr.remove(i);
					System.out.println("不够卖, " + tmp.getM_name() + "还差: " + (in_num - tmp.getM_num()) + "个");
				}
				else
				{
					this.list_arr.get(i).setM_num(tmp.getM_num() - in_num);
					System.out.println(tmp.getM_name() + "买了" + in_num + "个" 
					+ " 还剩:" + this.list_arr.get(i).getM_num() + "个");
				}
			}
		}
		return 0;
	}
	
	boolean add(Goods g)
	{
		return list_arr.add(g);
	}
}

public class Start
{
	public static void main(String[] args)
	{
		Shop s = new Shop();
		s.initGoods();
		s.add(new Goods("苹果", 1000));
		s.buy("苹果", 530);
	}
}
