import java.util.Scanner;

public class _Main
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		boolean isRun = true;
		Client_System sys = new Client_System();
		Client c = null;
		int _id = 0;
		while (isRun)
		{
			sys.display();
			int number = scan.nextInt();
			switch (number)
			{
				case 0:// 0 �� ʾ ȫ ��
					sys.display_all();
					break;
				case 1:// 1 �� �� �� ��
					c = new Client();
					sys.input(c);
					if (null == sys.add(c))
					{
						System.out.println("�ͻ���Ϣ���ʧ��...");
						break;
					}
					sys.display_client(c);
					break;
				case 2:// 2 �� �� �� ��
					c = new Client();
					System.out.print("������Ҫ�޸ĵĿͻ� ID: ");
					_id = scan.nextInt();
					sys.input(c);
					if (null == sys.modify(_id, c))
					{
						System.out.println("�޸Ŀͻ���Ϣʧ��...");
						break;
					}
					sys.display_client(c);
					break;
				case 3:// 3 ɾ �� �� ��
					System.out.print("������Ҫɾ���Ŀͻ� ID: ");
					_id = scan.nextInt();
					if (null == sys.del(_id))
					{
						System.out.println("�ͻ�ɾ��ʧ��...");
						break;
					}
					sys.display_client(c);
					break;
				case 4:// 4 �� ѯ �� ��
					System.out.print("������Ҫ��ѯ�Ŀͻ� ID: ");
					_id = scan.nextInt();
					c = sys.find(_id);
					if (null == c)
					{
						System.out.println("�ͻ����ϲ�ѯʧ��...");
						break;
					}
					sys.display_client(c);
					break;
				case 5:// 5 ��           ��
					isRun = false;
					System.out.println("ϵͳ�˳�...");
					break;
				default:
					break;
			}
		}
	}
}
