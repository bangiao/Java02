import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/*
---------------------添加客户---------------------
姓名：张三
性别：男
年龄：30
电话：010-56253825
邮箱：zhang@abc.com
---------------------添加完成---------------------
 */

class Client
{
	private int m_id;
	private String m_name;
	private String m_sex;
	private int m_years;
	private String m_phone;
	private String m_email;

	public int getM_id()
	{
		return m_id;
	}
	public void setM_id(int m_id)
	{
		if (m_id < 0)
		{
			return ;
		}
		this.m_id = m_id;
	}
	public String getM_name()
	{
		return m_name;
	}
	public void setM_name(String m_name)
	{
		if (null == m_name)
		{
			return ;
		}
		this.m_name = m_name;
	}
	public String getM_sex()
	{
		return m_sex;
	}
	public void setM_sex(String m_sex)
	{
		if (false == "男".equals(m_sex) && false == "女".equals(m_sex)
				&& false == "1".equals(m_sex) && false == "0".equals(m_sex))
		{
			return;
		}
		if ("1".equals(m_sex))
		{
			m_sex = "男";
		}
		else if ("0".equals(m_sex))
		{
			m_sex = "女";
		}
		this.m_sex = m_sex;
	}
	public int getM_years()
	{
		return m_years;
	}
	public void setM_years(int m_years)
	{
		if (m_years <= 0)
		{
			return ;
		}
		this.m_years = m_years;
	}
	public String getM_phone()
	{
		return m_phone;
	}
	public void setM_phone(String m_phone)
	{
		if (null == m_phone)
		{
			return ;
		}
		this.m_phone = m_phone;
	}
	public String getM_email()
	{
		return m_email;
	}
	public void setM_email(String m_email)
	{
		if (null == m_email)
		{
			return ;
		}
		this.m_email = m_email;
	}
}

public class Client_System
{
	private TreeMap<Integer, Client> map_Client;

	public Client_System()
	{
		map_Client = new TreeMap<Integer, Client>();
		map_Client.clear();
	}

	// add
	public Client add(Client c)
	{
		if (null == c)
		{
			return null;
		}
		map_Client.put(c.getM_id(), c);
		return c;
	}

	// del
	public Client del(int _id)
	{
		if (_id < 0)
		{
			return null;
		}
		if (0 == map_Client.size())
		{
			return null;
		}
		return map_Client.remove(_id);
	}

	// modify
	public Client modify(int _id, Client _new)
	{
		if (0 == map_Client.size())
		{
			return null;
		}
		if (_id < 0)
		{
			return null;
		}
		return map_Client.replace(_id, _new);
	}

	// find
	public Client find(int _id)
	{
		if (_id < 0)
		{
			return null; 
		}
		if (0 == map_Client.size())
		{
			return null;
		}
		return map_Client.get(_id);
	}

	// display client
	public void display_client(Client c)
	{
		if (null == c)
		{
			return ;
		}
		System.out.println("---------------------添加客户---------------------");
		System.out.println("I D: " + c.getM_id());
		System.out.println("姓名: " + c.getM_name());
		System.out.println("性别: " + c.getM_sex());
		System.out.println("年龄: " + c.getM_years());
		System.out.println("电话: " + c.getM_phone());
		System.out.println("邮箱: " + c.getM_email());
		System.out.println("---------------------添加完成---------------------");
	}

	public void display_all()
	{
		if (0 == map_Client.size())
		{
			return ;
		}
		
		Set<Integer> tmp_set = map_Client.keySet();
		
		for (Integer it : tmp_set)
		{
			Client c = map_Client.get(it);
			this.display_client(c);
		}
	}

	// display
	public void display()
	{
		System.out.println("");
		System.out.println("0 显 示 全 部");
		System.out.println("1 添 加 客 户");
		System.out.println("2 修 改 客 户");
		System.out.println("3 删 除 客 户");
		System.out.println("4 查 询 客 户");
		System.out.println("5 退           出");
		System.out.println("");
		System.out.print("请选择(1-5): ");
	}
	// input
	public void input(Client c)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入客户的 ID: ");
		c.setM_id(scan.nextInt());
		System.out.print("请输入姓名: ");
		c.setM_name(scan.next());
		System.out.print("请输入性别: ");
		c.setM_sex(scan.next());
		System.out.print("请输入年龄: ");
		c.setM_years(scan.nextInt());
		System.out.print("请输入电话: ");
		c.setM_phone(scan.next());
		System.out.print("请输入邮箱: ");
		c.setM_email(scan.next());
	}
}
