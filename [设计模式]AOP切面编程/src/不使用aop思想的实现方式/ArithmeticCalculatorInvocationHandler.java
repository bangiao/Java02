package ��ʹ��aop˼���ʵ�ַ�ʽ;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorInvocationHandler implements InvocationHandler
{
	// �������, ����ŵ��� ArithmeticCalculator 
	// Calculator �ӿڵ�ʵ����
	private Object target = null;
	
	public ArithmeticCalculatorInvocationHandler(Object target)
	{
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		/*ԭ���󷽷�����ǰ������־��Ϣ*/
        System.out.println("the method ["+method.getName()+"]"+"begin with args ("+Arrays.toString(args)+")");
        
        Object result = method.invoke(this.target, args);
        
        /*ԭ���󷽷����ú�����־��Ϣ*/
        System.out.println("the method ["+method.getName()+"]"+"end with result ("+result+")");
        
        return result;
	}
	
	public Object getProxy()
	{
		return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), 
				this.target.getClass().getInterfaces(), this);
	}
	
}
