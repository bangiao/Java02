package service;

import java.util.List;

import bean.Admin;
import dao.AdminDAO;

public class AdminService
{

	AdminDAO dao = new AdminDAO();

	public int login(Admin pAdmin)
	{
		if (pAdmin == null)
			return 0;
		return dao.login(pAdmin);
	}

	public List<Admin> listAll()
	{
		return dao.listAll();
	}

	public List<Admin> showAll()
	{
		return dao.listAll();
	}

	public List<Admin> search(String pName)
	{
		return dao.search(pName);
	}
	
	public int del(int id)
	{
		if (id < 0)
		{
			return -1;
		}
		return dao.del(id);
	}
	
	public int update(int id, int x, String content)
	{
		if (id < 0 && x <= 0 && null == content)
		{
			return -1;
		}
		return dao.Modify(id, x, content);
	}
}
