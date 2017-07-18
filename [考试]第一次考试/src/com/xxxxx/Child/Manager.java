
package com.xxxxx.Child;

import com.xxxxx.Interface.AbsStaff;
import com.xxxxx.Interface.Sign;

/**
 * @author ��ϣƽ 
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
		// TODO �Զ����ɵĹ��캯�����
	}

	private double TestScore;

	private double AdministratorX;

	private double money;

	/***
	 * 
	 * ���¹���Ч���˷��� @TestScore
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
	 * ����ֺ���� @AdministratorX
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
	 * �����λ���� 
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

	

	

	/* ���� Javadoc��
	 * @see com.xxxxx.Interface.AbsStaff#sign()
	 * 
	 * ������Ա�͹�����Աʵ�ִ򿨽ӿڣ�����д�򿨵ķ�����
	 * �ֱ��ӡ����������Ա����ţ�***��������***���ϰ�ǩ���ɹ�������
	 * 
	 */
	@Override
	public  void  sign() 
	{
		// TODO �Զ����ɵķ������
		String str="������Ա����ţ�"+this.getM_id()+",������"+this.getM_name()+",�ϰ�ǩ���ɹ���";
		System.out.println(str);
	}
	/**
	 * 
	 * ������Ա�����㷨=��������+����ֺ����*�����¹���Ч���˷���/100��+�����λ����
	 */
	/* ���� Javadoc��
	 * @see com.xxxxx.Interface.AbsStaff#CalcSalary()
	 */
	@Override
	public double CalcSalary()
	{
		double salary = 0;
		
		
		salary= this.getM_salary()+ this.getAdministratorX()*(this.getTestScore()/100)+this.getMoney();
		
		// TODO �Զ����ɵķ������
		return salary;
	}
}
