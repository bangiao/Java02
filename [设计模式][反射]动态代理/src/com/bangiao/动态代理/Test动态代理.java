package com.bangiao.动态代理;

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
		// TODO 自动生成的方法存根
		System.out.println("我是被代理类, 记得执行我");
	}
	
}

class MyInvokecationHander implements InvocationHandler
{
	Object obj;
	// 给被代理对象实例化
	// 返回一个代理类的对象
	public Object bind(Object obj)
	{
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
			obj.getClass().getInterfaces(), this);
	}
	// 当通过代理类的对象发起对被重写的方法的调用时, 都会转化为对如下的invoke方法的调用
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		Object retVal = method.invoke(obj, args);
		return retVal;
	}
}

public class Test动态代理
{
	public static void main(String[] args)
	{
		// 1. 被代理类的对象
		RealSubject real = new RealSubject();
		// 2. 创建一个实现了 InvacationHander接口的类对象
		MyInvokecationHander hander = new MyInvokecationHander();
		// 3. 调用 bind 方法, 动态返回一个同样实现了 real 所在类
		// 实现的接口 Subject 的代理类的对象
		Object obj = hander.bind(real);
		Subject sub = (Subject)obj;// 此时sub就是代理类的对象
		// 转到对 InvacationHander 接口的实现类的 invoke() 方法的调用
		sub.action();
		
		// 再举一例
		NikeClothFactory nike = new NikeClothFactory();
		ClothProduct proxyCloth = (ClothProduct)hander.bind(nike);
		proxyCloth.productCloth();
	}
}
