package 不使用aop思想的实现方式;

public class _Main
{
	public static void main(String[] args) throws Exception
	{
		/*获得代理*/
		Calculator arithmeticCalculatorProxy = 
				(Calculator)new ArithmeticCalculatorInvocationHandler
				(new ArithmeticCalculator()).getProxy();
		/*调用add方法*/
//		arithmeticCalculatorProxy.add(10, 10);
		
		Calculator argValidatorProxy = (Calculator)new ArithmeticCalculatorArgsInvocationHandler(
				arithmeticCalculatorProxy
				).getProxy();
		
		argValidatorProxy.add(10, 10);
	}
}
