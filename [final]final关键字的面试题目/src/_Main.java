
// final ���������� ���� const �Ĵ���
// int * const p = NULL;  ���������

public class _Main
{
	void func(final int f)
	{
		// final �������������Ǹ�һ���������߶���Ķ����ַ���� const ֻ������
//		f++;
	}
	
	void func1(final Test o)// final ����һ������ const �Ĵ���, 
	{
//		o = new Test();
		o.num++;
	}
	
	public static void main(String[] args)
	{
		
	}
}

class Test
{
	public int num = 0;
}
