package com.bangiao.��̬����;

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
		// TODO �Զ����ɵķ������
		System.out.println("Nike��������һ���·�");
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
		// TODO �Զ����ɵķ������
		System.out.println("�����࿪ʼִ��, �մ����$1000");
		cf.productCloth();
	}
	
}

public class TestClothProduct��̬����
{
	@Test
	public void test1()
	{
		NikeClothFactory ncf = new NikeClothFactory();
		ProxyFactory pf = new ProxyFactory(ncf);
		pf.productCloth();
	}
}
