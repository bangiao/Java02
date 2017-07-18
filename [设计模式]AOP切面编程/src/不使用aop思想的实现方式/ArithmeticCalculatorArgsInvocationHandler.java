package 不使用aop思想的实现方式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorArgsInvocationHandler implements InvocationHandler 
{
	private Object target = null;
	public ArithmeticCalculatorArgsInvocationHandler(Object o)
	{
		target = o;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		System.out.println("begin valid method ["+method.getName()+"] with args "+Arrays.toString(args));
		for (Object o : args)
		{
			this.argValidtor((Double)o);
		}
		Object res = method.invoke(this.target, args);
		return res;
	}
	
	public Object getProxy()
	{
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), this);
	}
	
	private void argValidtor(double arg) throws Exception
	{
		if(arg < 0)
            throw new Exception("参数不能为负数");
	}
}
