
class Single
{
	// (1)  ����һ�� static ����
	private static Single s;
	
	// (2) ���캯��˽�л�
	private Single() { }
	// (3) ������һ�������ⲿ�ľ�̬����
	public static Single getInstance()
	{
		// �߳���
		synchronized ("��")
		{
			if (s == null)
			{
				s = new Single();
			}
		}
		// ����
		return s;
	}
	
}

public class _02_��������ģʽ
{
	public static void main(String[] args)
	{
		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();
		
		if (s1 == s2)
		{
			System.out.println("the same s1 == s2");
		}
	}
}
