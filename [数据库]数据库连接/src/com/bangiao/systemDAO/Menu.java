package com.bangiao.systemDAO;

import java.util.Scanner;

public class Menu
{
	private Scanner m_Scan;
	private SqlCtrl m_SqlCtrl;
	
	public Menu()
	{
		m_Scan = new Scanner(System.in);
		m_SqlCtrl = new SqlCtrl();
	}
	
	private void display()
	{
		System.out.println("0. 退出");
		System.out.println("1. 增加");
		System.out.println("2. 删除");
		System.out.println("3. 改变");
		System.out.println("4. 查找");
	}
	
	public void ShowMainMenu()
	{
		boolean b = false;
		while (!b)
		{
			display();
			System.out.println("请输入 ID: ");
			int nKey = m_Scan.nextInt();
			switch (nKey)
			{
				case 0:
					System.out.println("退出系统...");
					b = true;
					break;
				case 1:
					// 增加
					ShowAdd();
					break;
				case 2:
					// 删除
					ShowDel();
					break;
				case 3:
					// 改变
					ShowChange();
					break;
				case 4:
					// 查找
					ShowFind();
					break;
				default:
					break;
			}
		}
	}
	
	public void ShowAdd()
	{
		System.out.println("增加数据项: ");
		String pValName = null;
		String pValPwd = null;
		
		System.out.println("请输入 AdminName: ");
		pValName = m_Scan.next();
		System.out.println("请输入 AdminPwd: ");
		pValPwd = m_Scan.next();
		m_SqlCtrl.add(pValName, pValPwd);
	}
	
	public void ShowDel()
	{
		int AdminId = 0;
		System.out.println("请输入需要删除的 AdminId: ");
		m_SqlCtrl.del(AdminId);
	}
	
	public void ShowChange()
	{
		String pValName = null;
		String pValPwd = null;
		
		System.out.println("请输入要修改的 AdminName: ");
		pValName = m_Scan.next();
		System.out.println("请输入要修改的 AdminPwd: ");
		pValPwd = m_Scan.next();
		m_SqlCtrl.change(pValName, pValPwd);
	}
	
	public void ShowFind()
	{
		int AdminId = 0;
		System.out.println("请输入要查找的 AdminId: ");
		AdminId = m_Scan.nextInt();
		m_SqlCtrl.find(AdminId);
	}
	
}
