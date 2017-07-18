package 不使用aop思想的实现方式;

/*AOP里将他们称为横切关注点（crosscutting concern），
 * 它们属于系统范围的需求通常需要跨越多个模块。*/

/*AOP实际是GoF设计模式的延续，设计模式孜孜不倦追求的是调用者和被调用者之间的解耦，
 * AOP可以说也是这种目标的一种实现。AOP可以使用"代理模式"来实现。*/

/*
 * 下面的程序一个很直观的特点就是，好多重复的代码，
 * 并且当加入越来越多的非业务需求（例如日志记录和参数验证），
 * 原有的计算器方法变得膨胀冗长。这里有一件非常痛苦的事情，
 * 无法使用原有的编程方式将他们模块化，从核心业务中提取出来
 * 
 * 因为业务要不断的增加进入其中, 所以这些代码无法从核心业务中提取出来
 * 做成永久或很久不需要修改的框架中
 * */

public class ArithmeticCalculator implements Calculator
{
	private void argsValidatior(double arg)throws Exception
    {
        if(arg < 0)
            throw new Exception("参数不能为负数");
    }
	@Override
	public double add(double num1, double num2) throws Exception
	{
		// TODO 自动生成的方法存根
		// (3) 第 n 次增加
		// (2) 第二次增加功能
//		argsValidatior(num1);
//		argsValidatior(num2);
		// (1) 第一次增加功能
//		System.out.println("the method [add()]"+"begin with args ("+num1+","+num2+")");
		double res = num1 + num2;
//		System.out.println("the method [add()]"+"end with result ("+res+")");
		return res;
	}

	@Override
	public double sub(double num1, double num2) throws Exception
	{
		// TODO 自动生成的方法存根
//		argsValidatior(num1);
//		argsValidatior(num2);
//		System.out.println("the method [sub()]"+"begin with args ("+num1+","+num2+")");
		double res = num1 - num2;
//		System.out.println("the method [sub()]"+"end with result ("+res+")");
		return res;
	}

	@Override
	public double div(double num1, double num2) throws Exception
	{
		// TODO 自动生成的方法存根
//		argsValidatior(num1);
//		argsValidatior(num2);
//		System.out.println("the method [div()]"+"begin with args ("+num1+","+num2+")");
		double res = num1 / num2;
//		System.out.println("the method [div()]"+"end with result ("+res+")");
		return res;
	}

	@Override
	public double mul(double num1, double num2) throws Exception
	{
		// TODO 自动生成的方法存根
//		argsValidatior(num1);
//		argsValidatior(num2);
//		System.out.println("the method [mul()]"+"begin with args ("+num1+","+num2+")");
		double res = num1 * num2;
//		System.out.println("the method [mul()]"+"end with result ("+res+")");
		return res;
	}

}
