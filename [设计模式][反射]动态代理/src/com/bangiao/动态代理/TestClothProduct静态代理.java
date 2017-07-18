package com.bangiao.动态代理;

import org.junit.Test;

interface ClothProduct
{
	void productCloth();
}

class NikeClothFactory implements ClothProduct
{

	@Override
	public void productCloth()
	{
		// TODO 自动生成的方法存根
		System.out.println("Nike工厂生产一批衣服");
	}
	
}

class ProxyFactory implements ClothProduct
{
	ClothProduct cf;
	
	public ProxyFactory(ClothProduct cf)
	{
		super();
		this.cf = cf;
	}

	@Override
	public void productCloth()
	{
		// TODO 自动生成的方法存根
		System.out.println("代理类开始执行, 收代理费$1000");
		cf.productCloth();
	}
	
}

public class TestClothProduct静态代理
{
	@Test
	public void test1()
	{
		NikeClothFactory ncf = new NikeClothFactory();
		ProxyFactory pf = new ProxyFactory(ncf);
		pf.productCloth();
	}
}
