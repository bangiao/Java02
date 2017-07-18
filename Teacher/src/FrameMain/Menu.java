package FrameMain;

import java.util.Scanner;

public class Menu
{
	private StuCtrlSys m_sys;
	Scanner m_scan = new Scanner(System.in);
	public Menu(StuCtrlSys sys)
	{
		m_sys = sys;
	}
	
	void displayMenu()
	{
		System.out.println("\t\tѧ����Ϣ����ϵͳ");
		System.out.println("************************************************");
		System.out.println("\t0. �˳�");
		System.out.println("\t1. ����ѧ����Ϣ");
		System.out.println("\t2. ɾ��ѧ����Ϣ");
		System.out.println("\t3. �ı�ѧ����Ϣ");
		System.out.println("\t4. ��ѯѧ����Ϣ");
		System.out.println("************************************************");
		System.out.println("��ѡ��Ҫִ�еĲ���: ");
	}

	void printMainMenu()
	{
		boolean b = false;

		while (!b)
		{
			displayMenu();
			switch (m_scan.nextInt())
			{
				case 0:
					b = true;
					System.out.println("ѧ������ϵͳ�˳�...");
					break;
				case 1:
					printAddMenu();
					break;
				case 2:
					printDelMenu();
					break;
				case 3:
					printChangeMenu();
					break;
				case 4:
					printFindMenu();
					break;
				default:
					b = true;
					System.out.println("ѧ������ϵͳ�˳�...");
			}
		}
	}

	void printAddMenu()
	{
		Student stu = new Student();
		Student tmp = m_sys.add(stu);
		tmp.print_stu();
	}

	void printDelMenu()
	{
		System.out.println("��������Ҫɾ����ѧ����ѧ��: ");
		String id = m_scan.next();
		Student tmp = m_sys.del(id);
		tmp.print_stu();
	}

	void printChangeMenu()
	{
		System.out.println("��������Ҫ�޸ĵ�ѧ��������Ϣ: ");
		System.out.println("\t0. �˳�");
		System.out.println("\t1. ����");
		System.out.println("\t2. �Ա�");
		System.out.println("\t3. ����");
		System.out.println("��������Ҫ�޸ĵ�ѧ�����͵� ID: ");
		int nKey = m_scan.nextInt();
		System.out.println("��������Ҫ�޸ĵ�ѧ����ѧ��: ");
		String id = m_scan.next();
		Student tmps = null;
		switch (nKey)
		{
			case 0:
				return ;
			case 1:
				System.out.println("��������Ҫ�ı������: ");
				String name = m_scan.next();
				tmps = m_sys.ChangeName(id, name);
				break;
			case 2:
				System.out.println("��������Ҫ�ı���Ա�: ");
				String sex = m_scan.next();
				tmps = m_sys.ChangeSex(id, sex);
				break;
			case 3:
				System.out.println("��������Ҫ�ı������: ");
				int age = m_scan.nextInt();
				tmps = m_sys.ChangeYears(id, age);
				break;
			default:
				return ;
		}
		tmps.print_stu();
	}

	void printFindMenu()
	{
		System.out.println("��������Ҫ��ѯ��ѧ��ѧ��: ");
		String id = m_scan.next();
		Student tmp = m_sys.find(id);
		tmp.print_stu();
	}
}
