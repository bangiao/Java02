import java.util.Random;
// �౻��ʼ����������ͬ
// �����������, x ��һ������ʱ�����ڵ������������ʱ��ش���
// ��ĳ�ʼ��������������(6��)
class FinalTest2
{
	// ����ʱȷ���ĳ���, jvm ���Ӻ����, �����������ʱһ��ȷ��
	// ����͵����� static ���������ʱ����������, ���Ǳ���ʱ
	public static final int x = new Random().nextInt(100);
	// ��� static ��������ļ���˳���ֵĵڶ���������
	// ��׼���׶γ�ʼ���ľ�̬�����
	static 
	{
		System.out.println("FinalTest2 static block");
	}
}

public class ����ʱ����
{
	public static void main(String[] args)
	{
		// ���÷Ǳ���ʱ�ೣ��, ���������������������ʼ����������
		System.out.println(FinalTest2.x);
	}
}
