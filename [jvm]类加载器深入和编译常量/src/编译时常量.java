
class FinalTest
{
	// ����ʱ����  6 / 3 ����ڱ����ʱ���Ѿ���ȷ��
	// ���ʱ�� static ��Ҳ�ڱ��뱻������ʱ����
	public static final int x = 6 / 3;
	static 
	{
		System.out.println("FinalTest static block");
	}
}

public class ����ʱ����
{
	public static void main(String[] args)
	{
		// ���ñ���ʱ����, ���ᴥ����ĳ�ʼ����������
		System.out.println(FinalTest.x);
	}
}
