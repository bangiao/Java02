
public class _02_1��100���������� {
	public static void main(String[] args) {
		// ֻ�ܱ� 1 �� ������ �������� �� ����
		
		int j = 0;
		for (int i = 2; i < 101; i++)
		{
			for (j = 2; j < i; j++)
			{
				// ���Ա�����������������, ����еĻ�, ��ǰ����
				if (0 == (i % j))
				{
					break;
				}
			}
			// ��� j == i �ͱ�ʾ �����ѭ��û��ִ�� ���ʱ�� j == i
			if (j == i)
			{
				System.out.print(i + " ");
			}
		}
	}
}
