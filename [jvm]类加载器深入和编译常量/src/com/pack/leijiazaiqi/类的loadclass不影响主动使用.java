package com.pack.leijiazaiqi;

class CL
{
	static 
	{
		System.out.println("class CL");
	}
}

public class ���loadclass��Ӱ������ʹ��
{
	public static void main(String[] args) throws Exception
	{
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		// ��� loadClass ��Ӱ���������ʹ��
		// ������δ���ֻ�Ǽ���, ��δ�������Ӻͳ�ʼ���Ĺ���
		Class<?> clazz = loader.loadClass("com.pack.leijiazaiqi.CL");
		System.out.println("---------------------------");
		clazz = Class.forName("com.pack.leijiazaiqi.CL");
		
	}
}
