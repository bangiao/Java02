package com.xxxxx.Util;

import com.xxxxx.Interface.AbsStaff;
import com.xxxxx.Interface.Sign;

public class HRMQ
{
	public static void printSalay(AbsStaff m)
	{
		System.out.println(m.getM_name() + ": Ա������: " + m.CalcSalary());
	}

	public static void printSign(Sign m)
	{
		m.sign();
	}
}
