package ��ʹ��aop˼���ʵ�ַ�ʽ;

public class _Main
{
	public static void main(String[] args) throws Exception
	{
		/*��ô���*/
		Calculator arithmeticCalculatorProxy = 
				(Calculator)new ArithmeticCalculatorInvocationHandler
				(new ArithmeticCalculator()).getProxy();
		/*����add����*/
//		arithmeticCalculatorProxy.add(10, 10);
		
		Calculator argValidatorProxy = (Calculator)new ArithmeticCalculatorArgsInvocationHandler(
				arithmeticCalculatorProxy
				).getProxy();
		
		argValidatorProxy.add(10, 10);
	}
}
