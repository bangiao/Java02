package 不使用aop思想的实现方式;

public interface Calculator
{
	public double add(double num1, double num2) throws Exception;
	public double sub(double num1, double num2) throws Exception;
	public double div(double num1, double num2) throws Exception;
	public double mul(double num1, double num2) throws Exception;
}
