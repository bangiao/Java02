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
		System.out.println("������Ҫ����Ա�������ͣ�1������Ա��2ҵ����Ա��3������Ա����");
		int num=input.nextInt();
		MyFactory m = new MyFactory();
		AbsStaff base = m.setWorker(num);
		HRMQ.printSalay(base);
	}
}
