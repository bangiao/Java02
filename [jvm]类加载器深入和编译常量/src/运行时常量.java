import java.util.Random;
// 类被初始化的条件不同
// 在这个常量中, x 是一个运行时常量在调用这个常量的时候回触发
// 类的初始化主动调用条件(6种)
class FinalTest2
{
	// 运行时确定的常量, jvm 会延后加载, 将其放在运行时一起确认
	// 这个就导致了 static 语句在运行时被启动起来, 而非编译时
	public static final int x = new Random().nextInt(100);
	// 这个 static 块是在类的加载顺序种的第二种连接中
	// 的准备阶段初始化的静态块代码
	static 
	{
		System.out.println("FinalTest2 static block");
	}
}

public class 运行时常量
{
	public static void main(String[] args)
	{
		// 调用非编译时类常量, 触发类的主动调用条件初始化加载条件
		System.out.println(FinalTest2.x);
	}
}
