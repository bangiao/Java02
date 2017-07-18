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
		System.out.println("\t\t学生信息管理系统");
		System.out.println("************************************************");
		System.out.println("\t0. 退出");
		System.out.println("\t1. 增加学生信息");
		System.out.println("\t2. 删除学生信息");
		System.out.println("\t3. 改变学生信息");
		System.out.println("\t4. 查询学生信息");
		System.out.println("************************************************");
		System.out.println("请选择要执行的操作: ");
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
					System.out.println("学生管理系统退出...");
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
					System.out.println("学生管理系统退出...");
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
		System.out.println("请输入想要删除的学生的学号: ");
		String id = m_scan.next();
		Student tmp = m_sys.del(id);
		tmp.print_stu();
	}

	void printChangeMenu()
	{
		System.out.println("请输入想要修改的学生类型信息: ");
		System.out.println("\t0. 退出");
		System.out.println("\t1. 姓名");
		System.out.println("\t2. 性别");
		System.out.println("\t3. 年龄");
		System.out.println("请输入想要修改的学生类型的 ID: ");
		int nKey = m_scan.nextInt();
		System.out.println("请输入想要修改的学生的学号: ");
		String id = m_scan.next();
		Student tmps = null;
		switch (nKey)
		{
			case 0:
				return ;
			case 1:
				System.out.println("请输入需要改变的名字: ");
				String name = m_scan.next();
				tmps = m_sys.ChangeName(id, name);
				break;
			case 2:
				System.out.println("请输入需要改变的性别: ");
				String sex = m_scan.next();
				tmps = m_sys.ChangeSex(id, sex);
				break;
			case 3:
				System.out.println("请输入需要改变的年龄: ");
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
		System.out.println("请输入需要查询的学生学号: ");
		String id = m_scan.next();
		Student tmp = m_sys.find(id);
		tmp.print_stu();
	}
}
