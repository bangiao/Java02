package com.xxxxx.Main;

import java.util.Scanner;

import com.xxxxx.Interface.AbsStaff;
import com.xxxxx.Util.HRMQ;
import com.xxxxx.logic.MyFactory;

public class _Main
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要创建员工的类型（1技术人员，2业务人员，3管理人员）：");
		int num=input.nextInt();
		MyFactory m = new MyFactory();
		AbsStaff base = m.setWorker(num);
		HRMQ.printSalay(base);
	}
}
