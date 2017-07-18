package 不使用aop思想的实现方式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorInvocationHandler implements InvocationHandler
{
	// 这个对象, 最后存放的是 ArithmeticCalculator 
	// Calculator 接口的实现类
	private Object target = null;
	
	public ArithmeticCalculatorInvocationHandler(Object target)
	{
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		/*原对象方法调用前处理日志信息*/
        System.out.println("the method ["+method.getName()+"]"+"begin with args ("+Arrays.toString(args)+")");
        
        Object result = method.invoke(this.target, args);
        
        /*原对象方法调用后处理日志信息*/
        System.out.println("the method ["+method.getName()+"]"+"end with result ("+result+")");
        
        return result;
	}
	
	public Object getProxy()
	{
		return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), 
				this.target.getClass().getInterfaces(), this);
	}
	
}
