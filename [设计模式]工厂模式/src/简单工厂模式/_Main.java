package �򵥹���ģʽ;

interface Worker
{
	void doWork();
}

class Student implements Worker
{
	@Override
	public void doWork()
	{
		System.out.println("ѧ��д��ҵ");
	}
}

class Teacher implements Worker
{
	@Override
	public void doWork()
	{
		System.out.println("��ʦ���Ͽ�");
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
