package ��ʹ��aop˼���ʵ�ַ�ʽ;

/*AOP�ｫ���ǳ�Ϊ���й�ע�㣨crosscutting concern����
 * ��������ϵͳ��Χ������ͨ����Ҫ��Խ���ģ�顣*/

/*AOPʵ����GoF���ģʽ�����������ģʽ���β���׷����ǵ����ߺͱ�������֮��Ľ��
 * AOP����˵Ҳ������Ŀ���һ��ʵ�֡�AOP����ʹ��"����ģʽ"��ʵ�֡�*/

/*
 * ����ĳ���һ����ֱ�۵��ص���ǣ��ö��ظ��Ĵ��룬
 * ���ҵ�����Խ��Խ��ķ�ҵ������������־��¼�Ͳ�����֤����
 * ԭ�еļ�����������������߳���������һ���ǳ�ʹ������飬
 * �޷�ʹ��ԭ�еı�̷�ʽ������ģ�黯���Ӻ���ҵ������ȡ����
 * 
 * ��Ϊҵ��Ҫ���ϵ����ӽ�������, ������Щ�����޷��Ӻ���ҵ������ȡ����
 * �������û�ܾò���Ҫ�޸ĵĿ����
 * */

public class ArithmeticCalculator implements Calculator
{
	private void argsValidatior(double arg)throws Exception
    {
        if(arg < 0)
            throw new Exception("��������Ϊ����");
    }
	@Override
	public double add(double num1, double num2) throws Exception
	{
		// TODO �Զ����ɵķ������
		// (3) �� n ������
		// (2) �ڶ������ӹ���
//		argsValidatior(num1);
//		argsValidatior(num2);
		// (1) ��һ�����ӹ���
//		System.out.println("the method [add()]"+"begin with args ("+num1+","+num2+")");
		double res = num1 + num2;
//		System.out.println("the method [add()]"+"end with result ("+res+")");
		return res;
	}

	@Override
	public double sub(double num1, double num2) throws Exception
	{
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
//		argsValidatior(num1);
//		argsValidatior(num2);
//		System.out.println("the method [mul()]"+"begin with args ("+num1+","+num2+")");
		double res = num1 * num2;
//		System.out.println("the method [mul()]"+"end with result ("+res+")");
		return res;
	}

}
