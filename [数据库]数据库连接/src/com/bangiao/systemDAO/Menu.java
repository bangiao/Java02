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
		System.out.println("0. �˳�");
		System.out.println("1. ����");
		System.out.println("2. ɾ��");
		System.out.println("3. �ı�");
		System.out.println("4. ����");
	}
	
	public void ShowMainMenu()
	{
		boolean b = false;
		while (!b)
		{
			display();
			System.out.println("������ ID: ");
			int nKey = m_Scan.nextInt();
			switch (nKey)
			{
				case 0:
					System.out.println("�˳�ϵͳ...");
					b = true;
					break;
				case 1:
					// ����
					ShowAdd();
					break;
				case 2:
					// ɾ��
					ShowDel();
					break;
				case 3:
					// �ı�
					ShowChange();
					break;
				case 4:
					// ����
					ShowFind();
					break;
				default:
					break;
			}
		}
	}
	
	public void ShowAdd()
	{
		System.out.println("����������: ");
		String pValName = null;
		String pValPwd = null;
		
		System.out.println("������ AdminName: ");
		pValName = m_Scan.next();
		System.out.println("������ AdminPwd: ");
		pValPwd = m_Scan.next();
		m_SqlCtrl.add(pValName, pValPwd);
	}
	
	public void ShowDel()
	{
		int AdminId = 0;
		System.out.println("��������Ҫɾ���� AdminId: ");
		m_SqlCtrl.del(AdminId);
	}
	
	public void ShowChange()
	{
		String pValName = null;
		String pValPwd = null;
		
		System.out.println("������Ҫ�޸ĵ� AdminName: ");
		pValName = m_Scan.next();
		System.out.println("������Ҫ�޸ĵ� AdminPwd: ");
		pValPwd = m_Scan.next();
		m_SqlCtrl.change(pValName, pValPwd);
	}
	
	public void ShowFind()
	{
		int AdminId = 0;
		System.out.println("������Ҫ���ҵ� AdminId: ");
		AdminId = m_Scan.nextInt();
		m_SqlCtrl.find(AdminId);
	}
	
}
