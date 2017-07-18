import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/*
---------------------��ӿͻ�---------------------
����������
�Ա���
���䣺30
�绰��010-56253825
���䣺zhang@abc.com
---------------------������---------------------
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
		if (false == "��".equals(m_sex) && false == "Ů".equals(m_sex)
				&& false == "1".equals(m_sex) && false == "0".equals(m_sex))
		{
			return;
		}
		if ("1".equals(m_sex))
		{
			m_sex = "��";
		}
		else if ("0".equals(m_sex))
		{
			m_sex = "Ů";
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
		System.out.println("---------------------��ӿͻ�---------------------");
		System.out.println("I D: " + c.getM_id());
		System.out.println("����: " + c.getM_name());
		System.out.println("�Ա�: " + c.getM_sex());
		System.out.println("����: " + c.getM_years());
		System.out.println("�绰: " + c.getM_phone());
		System.out.println("����: " + c.getM_email());
		System.out.println("---------------------������---------------------");
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
		System.out.println("0 �� ʾ ȫ ��");
		System.out.println("1 �� �� �� ��");
		System.out.println("2 �� �� �� ��");
		System.out.println("3 ɾ �� �� ��");
		System.out.println("4 �� ѯ �� ��");
		System.out.println("5 ��           ��");
		System.out.println("");
		System.out.print("��ѡ��(1-5): ");
	}
	// input
	public void input(Client c)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("������ͻ��� ID: ");
		c.setM_id(scan.nextInt());
		System.out.print("����������: ");
		c.setM_name(scan.next());
		System.out.print("�������Ա�: ");
		c.setM_sex(scan.next());
		System.out.print("����������: ");
		c.setM_years(scan.nextInt());
		System.out.print("������绰: ");
		c.setM_phone(scan.next());
		System.out.print("����������: ");
		c.setM_email(scan.next());
	}
}
