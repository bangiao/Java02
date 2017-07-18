package com.xxxxx.Child;

import com.xxxxx.Interface.AbsStaff;
import com.xxxxx.Interface.Sign;

public class Technician extends AbsStaff implements Sign{
	
	private double completionRate;
	private double dividendRatio;
	private int workYear;
	
	public Technician(String m_id, String m_name, int m_age, double m_salary, String m_time) {
		super(m_id, m_name, m_age, m_salary, m_time);
		
	}
	
	public Technician(String m_id, String m_name, int m_age, double m_salary, String m_time,double completionRate,double dividendRatio,int workYear) {
		super(m_id, m_name, m_age, m_salary, m_time);
		this.dividendRatio=dividendRatio;
		this.workYear=workYear;
		this.setCompletionRate(completionRate);
	}
	
	@Override
	public double CalcSalary(){
		
		double sala;
		sala=this.getM_salary()+this.dividendRatio*this.completionRate+this.workYear*300;
		return sala;
	}
	
	@Override
	public void sign() {
		// TODO Auto-generated method stub
		String str="技术人员，编号："+this.getM_id()+",姓名："+this.getM_name()+",上班签到成功！";
		System.out.println(str);
		
	}

	public double getCompletionRate() {
		return completionRate;
	}

	public void setCompletionRate(double completionRate) {
		
		if(completionRate<0||completionRate>1){
			completionRate=0.5;
		}
		this.completionRate = completionRate;
	}

	public double getDividendRatio() {
		return dividendRatio;
	}

	public void setDividendRatio(double dividendRatio) {
		this.dividendRatio = dividendRatio;
	}

	public int getWorkYear() {
		return workYear;
	}

	public void setWorkYear(int workYear) {
		this.workYear = workYear;
	}

	
	
}
