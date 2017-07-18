
package com.xxxxx.Child;

import com.xxxxx.Interface.AbsStaff;
import com.xxxxx.Interface.Sign;

/**
 * @author 章希平 
 *
 */
public class Manager extends AbsStaff implements Sign
{
	/**
	 * @param m_id
	 * @param m_name
	 * @param m_age
	 * @param m_salary
	 * @param m_time
	 * @param testScore
	 * @param administratorX
	 * @param money
	 */
	public Manager(String m_id, String m_name, int m_age, double m_salary, 
			String m_time, double testScore,double administratorX, double money)
	{
		super(m_id, m_name, m_age, m_salary, m_time);
		this.setTestScore(testScore);
		this.setAdministratorX(administratorX);
		this.setMoney(money);
	}

	/**
	 * @param m_id
	 * @param m_name
	 * @param m_age
	 * @param m_salary
	 * @param m_time
	 */

	public Manager(String m_id, String m_name, int m_age, double m_salary, String m_time)
	{
		super(m_id, m_name, m_age, m_salary, m_time);
		// TODO 自动生成的构造函数存根
	}

	private double TestScore;

	private double AdministratorX;

	private double money;

	/***
	 * 
	 * 当月管理绩效考核分数 @TestScore
	 * 
	 * @return
	 */
	public double getTestScore()
	{
		return TestScore;
	}

	public void setTestScore(double testScore)
	{
		if(0<=testScore&&testScore<=100){
		TestScore = testScore;
		}
	}

	/**
	 * 
	 * 管理分红基数 @AdministratorX
	 * 0<=AdministratorX<=100
	 * @return
	 */
	public double getAdministratorX()
	{
		return AdministratorX;
	}

	public void setAdministratorX(double administratorX)
	{
		
		
		AdministratorX = administratorX;
		
	}
		
		

	/**
	 * 管理岗位津贴 
	 * @money
	 * @return
	 */
	public double getMoney()
	{
		return money;
	}

	public void setMoney(double money)
	{
		this.money = money;
	}

	

	

	/* （非 Javadoc）
	 * @see com.xxxxx.Interface.AbsStaff#sign()
	 * 
	 * 技术人员和管理人员实现打卡接口，并重写打卡的方法，
	 * 分别打印出“技术人员，编号：***，姓名：***，上班签到成功！”；
	 * 
	 */
	@Override
	public  void  sign() 
	{
		// TODO 自动生成的方法存根
		String str="管理人员，编号："+this.getM_id()+",姓名："+this.getM_name()+",上班签到成功！";
		System.out.println(str);
	}
	/**
	 * 
	 * 管理人员工资算法=基本工资+管理分红基数*（当月管理绩效考核分数/100）+管理岗位津贴
	 */
	/* （非 Javadoc）
	 * @see com.xxxxx.Interface.AbsStaff#CalcSalary()
	 */
	@Override
	public double CalcSalary()
	{
		double salary = 0;
		
		
		salary= this.getM_salary()+ this.getAdministratorX()*(this.getTestScore()/100)+this.getMoney();
		
		// TODO 自动生成的方法存根
		return salary;
	}
}
