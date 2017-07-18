package com.xxxxx.Child;

import com.xxxxx.Interface.AbsStaff;

/**
 * @author Ñ¦Áá
 *
 */
public class Business extends AbsStaff{
	
	public Business(String m_id, String m_name, int m_age, double m_salary, String m_time) {
		super(m_id, m_name, m_age, m_salary, m_time);
		// TODO Auto-generated constructor stub
	}
	private double sale;
	private double vPercent;
	public Business(String m_id, String m_name, int m_age, double m_salary, String m_time, double sale, double vPercent,
			double vTaskPercent) {
		super(m_id, m_name, m_age, m_salary, m_time);
		this.setSale(sale);
		this.setvPercent(vPercent);
		this.setvTaskPercent(vTaskPercent);
	}
	private double vTaskPercent;
	/**
	 * @return the sale
	 */
	public double getSale() {
		return sale;
	}
	/**
	 * @param sale the sale to set
	 */
	public void setSale(double sale) {
		this.sale = sale;
	}
	/**
	 * @return the vPercent
	 */
	public double getvPercent() {
		return vPercent;
	}
	/**
	 * @param vPercent the vPercent to set
	 */
	public void setvPercent(double vPercent) {
		if(vPercent>=0&&vPercent<=1){
			this.vPercent = vPercent;
		}
		
	}
	/**
	 * @return the vTaskPercent
	 */
	public double getvTaskPercent() {
		return vTaskPercent;
	}
	/**
	 * @param vTaskPercent the vTaskPercent to set
	 */
	public void setvTaskPercent(double vTaskPercent) {
		if(vTaskPercent>=0&&vTaskPercent<=1){
			this.vTaskPercent = vTaskPercent;
		}
		
		
	}


	@Override
	public double CalcSalary() {
		// TODO Auto-generated method stub
		double salary=0;
		salary=this.getM_salary()+this.getSale()*this.vPercent*this.getvTaskPercent();
		return salary;
	}

	
	
}
