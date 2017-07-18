package com.pack.leijiazaiqi;

class CL
{
	static 
	{
		System.out.println("class CL");
	}
}

public class 类的loadclass不影响主动使用
{
	public static void main(String[] args) throws Exception
	{
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		// 这个 loadClass 不影响类的主动使用
		// 下面这段代码只是加载, 并未到达连接和初始化的过程
		Class<?> clazz = loader.loadClass("com.pack.leijiazaiqi.CL");
		System.out.println("---------------------------");
		clazz = Class.forName("com.pack.leijiazaiqi.CL");
		
	}
}
