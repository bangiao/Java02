
class FinalTest
{
	// 编译时常量  6 / 3 这个在编译的时候已经被确认
	// 这个时候 static 块也在编译被加载类时启动
	public static final int x = 6 / 3;
	static 
	{
		System.out.println("FinalTest static block");
	}
}

public class 编译时常量
{
	public static void main(String[] args)
	{
		// 调用编译时常量, 不会触发类的初始化加载条件
		System.out.println(FinalTest.x);
	}
}
