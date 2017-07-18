/*
 * ��ļ��ع���
 * 
 * 1. �����, ֱ�Ӽ�����Ķ���������
 * 2. ����:
 * 		--��֤: ȷ�����������ȷ��
 * 		--׼��: Ϊ��ľ�̬���������ڴ�, �������ʼ��Ĭ��ֵ(��������ݳ�ʼ��)
 * 		--����: ����ķ�������(������.run())���ֱ������(������ + run()ָ���ַ)
 * 3. ��ʼ��(�û����ݳ�ʼ��)
 * 		Ϊ��� static ������ʼ��ֵ
 * */

/*
 * ��̬�����޷�ֱ�ӷ��ʷǾ�̬�Ĵ���, ֻ��ͨ�� new һ������Ӷ���ӷ���
 * �Ǿ�̬�������Է��ʾ�̬�ķ���
 * */

class Single
{
	private static Single m_single = new Single();
	static public int counter1;
	static public int counter2 = 0;

	private Single()
	{
		counter1++;
		counter2++;
	}

	static Single getInstance()
	{
		return Single.m_single;
	}
}

public class _Main
{
	public static void main(String[] args)
	{
		Single s = Single.getInstance();

		System.out.println(Single.counter1);
		System.out.println(Single.counter2);


		//		Single s2 = Single.getInstance();
		//		
		//		if (s.equals(s2))
		//		{
		//			System.out.println("���");
		//		}
		//		else
		//		{
		//			System.out.println("�����");
		//		}
	}
}
