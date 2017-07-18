package 简单工厂模式;

interface Worker
{
	void doWork();
}

class Student implements Worker
{
	@Override
	public void doWork()
	{
		System.out.println("学生写作业");
	}
}

class Teacher implements Worker
{
	@Override
	public void doWork()
	{
		System.out.println("老师在上课");
	}
}

class Factory
{
	Worker setWorker(String name)
	{
		if ("Student".equals(name))
		{
			return new Student();
		}
		else if ("Teacher".equals(name))
		{
			return new Teacher();
		}
		return null;
	}
}

public class _Main
{
	public static void main(String[] args)
	{
		Factory fac = new Factory();
		Worker stu = fac.setWorker("Student");
		stu.doWork();
	}
}
