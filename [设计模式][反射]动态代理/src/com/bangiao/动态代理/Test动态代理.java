package com.bangiao.��̬����;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

interface Subject
{
	void action();
}

class RealSubject implements Subject
{

	@Override
	public void action()
	{
		// TODO �Զ����ɵķ������
		System.out.println("���Ǳ�������, �ǵ�ִ����");
	}
	
}

class MyInvokecationHander implements InvocationHandler
{
	Object obj;
	// �����������ʵ����
	// ����һ��������Ķ���
	public Object bind(Object obj)
	{
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
			obj.getClass().getInterfaces(), this);
	}
	// ��ͨ��������Ķ�����Ա���д�ķ����ĵ���ʱ, ����ת��Ϊ�����µ�invoke�����ĵ���
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		Object retVal = method.invoke(obj, args);
		return retVal;
	}
}

public class Test��̬����
{
	public static void main(String[] args)
	{
		// 1. ��������Ķ���
		RealSubject real = new RealSubject();
		// 2. ����һ��ʵ���� InvacationHander�ӿڵ������
		MyInvokecationHander hander = new MyInvokecationHander();
		// 3. ���� bind ����, ��̬����һ��ͬ��ʵ���� real ������
		// ʵ�ֵĽӿ� Subject �Ĵ�����Ķ���
		Object obj = hander.bind(real);
		Subject sub = (Subject)obj;// ��ʱsub���Ǵ�����Ķ���
		// ת���� InvacationHander �ӿڵ�ʵ����� invoke() �����ĵ���
		sub.action();
		
		// �پ�һ��
		NikeClothFactory nike = new NikeClothFactory();
		ClothProduct proxyCloth = (ClothProduct)hander.bind(nike);
		proxyCloth.productCloth();
	}
}
