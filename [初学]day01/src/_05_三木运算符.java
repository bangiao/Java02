
public class _05_��ľ�����
{
	// 5 ��ȡ�������еĽϴ���, ʹ����Ŀ����
	public static void main(String[] args)
	{
		int a = 10;
		int b = 20;
		int c  = 35;
		
		int max = c > (a > b ? a : b) ? c : (a > b ? a : b); 
		
		System.out.println("max: " + max);
	}
}
