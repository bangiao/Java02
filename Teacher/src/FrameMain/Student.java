package FrameMain;

import java.util.Scanner;

public class Student
{
	private String m_id;
	private String m_name;
	private String m_sex;
	private int m_years;
	Scanner m_scan = new Scanner(System.in);


	public Student(String m_id, String m_name, String m_sex, int m_years)
	{
		super();
		this.setM_id(m_id);
		this.setM_name(m_name);
		this.setM_sex(m_sex);
		this.setM_years(m_years);
	}
	public Student()
	{
		super();
		System.out.print("请输入学号: ");
		this.setM_id(m_scan.next());

		System.out.print("请输入姓名: ");
		this.setM_name(m_scan.next());

		System.out.print("请输入性别: ");
		this.setM_sex(m_scan.next());

		System.out.print("请输入年龄: ");
		this.setM_years(m_scan.nextInt());
	}
	public String getM_id()
	{
		return m_id;
	}
	public void setM_id(String m_id)
	{
		if (null == m_id)
		{
			this.m_id = "0";
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
		if ("男".equals(m_sex) || "女".equals(m_sex))
		{
			this.m_sex = m_sex;
		}
		else
		{
			this.m_sex = "男";
		}
	}
	public int getM_years()
	{
		return m_years;
	}
	public void setM_years(int m_years)
	{
		if (m_years < 0)
		{
			return ;
		}
		this.m_years = m_years;
	}

	public void print_stu()
	{
		System.out.print("学生的名字: ");
		System.out.println(this.getM_name());

		System.out.print("学生的性别: ");
		System.out.println(this.getM_sex());

		System.out.print("学生的年龄: ");
		System.out.println(this.getM_years());

		System.out.print("学生的学号: ");
		System.out.println(this.getM_id());
	}

}
