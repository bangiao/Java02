package 抽象工厂模式;

interface AbsWork
{
	public void doWork();
}

interface AbsFactory
{
	public AbsWork getWork();
}

class Student implements AbsWork
{
	@Override
	public void doWork()
	{
		// TODO 自动生成的方法存根
		System.out.println("学生在上课");
	}
}

class Teacher implements AbsWork
{

	@Override
	public void doWork()
	{
		// TODO 自动生成的方法存根
		System.out.println("老师在讲课");
	}
}

class StudentFactory implements AbsFactory
{
	@Override
	public AbsWork getWork()
	{
		// TODO 自动生成的方法存根
		return new Student();
	}
}

class TeacherFactory implements AbsFactory
{
	@Override
	public AbsWork getWork()
	{
		// TODO 自动生成的方法存根
		return new Teacher();
	}
	
}

public class _Main
{
	public static void main(String[] args)
	{
		AbsFactory fac_base = new StudentFactory();
		AbsWork stu = fac_base.getWork();
		stu.doWork();
	}
}
