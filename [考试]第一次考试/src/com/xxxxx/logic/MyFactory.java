package com.xxxxx.logic;

import com.xxxxx.Child.Business;
import com.xxxxx.Child.Manager;
import com.xxxxx.Child.Technician;
import com.xxxxx.Interface.AbsStaff;
import com.xxxxx.Util.HRMQ;

public class MyFactory
{
	public AbsStaff setWorker(int i_type)
	{
		switch (i_type)
		{
			case 1:
				Technician a = new Technician("11", "小李", 12, 1800.0, "2017-07-05", 0.5,
							0.3, 3);
				HRMQ.printSign(a);
				return a;
			case 2:
				return new Business("22", "小娃", 12, 12.0, "2017-07-06", 888.0, 0.5,
						0.5);
			case 3:
				Manager m = new Manager("33", "校花", 12, 2000, "2017-07-07", 50, 5, 1800);
				HRMQ.printSign(m);
				return m;
			default:
				System.out.println("输入错误");
				return null;
		}
	}

}
