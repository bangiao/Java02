package ���󹤳�ģʽ;

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
		// TODO �Զ����ɵķ������
		System.out.println("ѧ�����Ͽ�");
	}
}

class Teacher implements AbsWork
{

	@Override
	public void doWork()
	{
		// TODO �Զ����ɵķ������
		System.out.println("��ʦ�ڽ���");
	}
}

class StudentFactory implements AbsFactory
{
	@Override
	public AbsWork getWork()
	{
		// TODO �Զ����ɵķ������
		return new Student();
	}
}

class TeacherFactory implements AbsFactory
{
	@Override
	public AbsWork getWork()
	{
		// TODO �Զ����ɵķ������
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
