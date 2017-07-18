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
				case 0:// 0 显 示 全 部
					sys.display_all();
					break;
				case 1:// 1 添 加 客 户
					c = new Client();
					sys.input(c);
					if (null == sys.add(c))
					{
						System.out.println("客户信息添加失败...");
						break;
					}
					sys.display_client(c);
					break;
				case 2:// 2 修 改 客 户
					c = new Client();
					System.out.print("请输入要修改的客户 ID: ");
					_id = scan.nextInt();
					sys.input(c);
					if (null == sys.modify(_id, c))
					{
						System.out.println("修改客户信息失败...");
						break;
					}
					sys.display_client(c);
					break;
				case 3:// 3 删 除 客 户
					System.out.print("请输入要删除的客户 ID: ");
					_id = scan.nextInt();
					if (null == sys.del(_id))
					{
						System.out.println("客户删除失败...");
						break;
					}
					sys.display_client(c);
					break;
				case 4:// 4 查 询 客 户
					System.out.print("请输入要查询的客户 ID: ");
					_id = scan.nextInt();
					c = sys.find(_id);
					if (null == c)
					{
						System.out.println("客户资料查询失败...");
						break;
					}
					sys.display_client(c);
					break;
				case 5:// 5 退           出
					isRun = false;
					System.out.println("系统退出...");
					break;
				default:
					break;
			}
		}
	}
}
