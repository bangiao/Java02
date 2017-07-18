package com.xxxxx.Interface;

import java.time.LocalDate;

public abstract class  AbsStaff
{
	private String m_id;
	private String m_name;
	private int m_age;
	private double m_salary;
	private String m_time;
	
	// 业务员
	public static final int BUSINESS = 1;
	// 技术人员Technical
	public static final int TECHNICAL = 2;
	// 管理人员manager
	public static final int MANAGER = 3;

	public AbsStaff(String m_id, String m_name, int m_age, double m_salary, String m_time)
	{
		super();
		this.setM_id(m_id);
		this.setM_name(m_name);
		this.setM_age(m_age);
		this.setM_salary(m_salary);
		this.setM_time(m_time);
	}
	
	public String getM_id()
	{
		return m_id;
	}
	public void setM_id(String m_id)
	{
		this.m_id = m_id;
	}
	public String getM_name()
	{
		return m_name;
	}
	public void setM_name(String m_name)
	{
		this.m_name = m_name;
	}
	public int getM_age()
	{
		return m_age;
	}
	
	/*
	 * 员工的年龄需要做合法性验证，必须在21-55岁之间，
	 * 如果不符合设置为21岁；*/
	public void setM_age(int m_age)
	{
		if (m_age >= 55 && m_age <= 21)
		{
			m_age = 21;
		}
		this.m_age = m_age;
	}
	public double getM_salary()
	{
		return m_salary;
	}
//	基本工资需要合法性验证，必须大或等于1800元，
//	 * 如果不符合设置为1800；
	 
	public void setM_salary(double m_salary)
	{
		if (m_salary < 1800)
		{
			m_salary = 1800;
		}
		this.m_salary = m_salary;
	}
	public String getM_time()
	{
		return m_time;
	}
//	* 入职时间需要合法性验证，不能超过当前系统时间，
//	 * 如果不符合设置为当前系统时间。
	
	private static int toTime(String time)
	{
		String[] my_time = time.split("-");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < my_time.length; i++)
		{
			sb.append(my_time[i]);
		}
		int iTime = Integer.parseInt(sb.toString());
		return iTime;
	}
	
	public void setM_time(String m_time)
	{
		LocalDate l = LocalDate.now();
		String tmp_time = l.toString();
		int cur_time = toTime(tmp_time);
//		System.out.println(cur_time);
		int time2 = toTime(m_time);
		if (time2 > cur_time)
		{
			m_time = tmp_time;
		}
		this.m_time = m_time;
	}
	
	// 获取工资
	public abstract double CalcSalary();
//	public abstract void sign();
}
