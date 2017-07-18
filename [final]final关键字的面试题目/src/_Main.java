
// final 就是类似于 顶层 const 的存在
// int * const p = NULL;  类似于这个

public class _Main
{
	void func(final int f)
	{
		// final 操作符操作的是给一个变量或者对象的顶层地址赋予 const 只读属性
//		f++;
	}
	
	void func1(final Test o)// final 就是一个顶层 const 的存在, 
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
