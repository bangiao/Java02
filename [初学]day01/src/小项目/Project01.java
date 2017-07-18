package 小项目;

import java.util.Scanner;

// 家庭收支对象
class Family_Money
{
	private int m_balence = 10000; // 账户余额
	private int m_shouru = 0;// 收入
	private int m_zhichu = 0;// 支出
	
	public Family_Money(int balence)
	{
		super();
		this.m_balence = balence;
	}

	public void displayMenu()
	{
		System.out.println("-----------------家庭收支记账软件-----------------");
		System.out.println("");
		System.out.println("1 收支明细");
		System.out.println("2 登记收入");
		System.out.println("3 登记支出");
		System.out.println("4 退    出");
		System.out.println("");
		System.out.print("请选择(1-4)：");
	}
	
	// 收支明细
	public void Details()
	{
		System.out.println("-----------------当前收支明细记录-----------------");
		System.out.println("收支\t\t账户金额\t\t收支金额\t\t说    明");
		System.out.println("收入\t\t" + m_balence + "\t\t" + m_shouru + "\t\t劳务费");
		System.out.println("支出\t\t" + m_balence + "\t\t" + m_zhichu + "\t\t物业费");
	}
	
	// 登记收入
	public void join()
	{
		int money = 0;
		
		System.out.print("收入了: ");
		Scanner scan = new Scanner(System.in);
		
		money = scan.nextInt();
		
		m_balence += money;
		m_shouru = money;
		System.out.println("-----------------当前收入明细记录-----------------");
		System.out.println("本次收入金额：" + m_shouru);
		System.out.println("本次收入说明：劳务费_");
		System.out.println("账户余额: " + m_balence);
	}
	
	// 登记支出
	public void pay()
	{
		int money = 0;
		
		System.out.print("支出了: ");
		Scanner scan = new Scanner(System.in);
		
		money  = scan.nextInt();
		
		if (m_balence < money)
		{
			System.out.println("支出错误...");
			return ;
		}
		m_balence -= money;
		m_zhichu = money;
		System.out.println("-----------------当前支出明细记录-----------------");
		System.out.println("本次支出金额：" + m_zhichu);
		System.out.println("本次支出说明：物业费_");
		System.out.println("账户余额: " + m_balence);
		
	}
}

public class Project01
{
	public static void main(String[] args)
	{
		boolean loopFlag = true;
		Family_Money f = new Family_Money(10000);
		
		while (loopFlag)
		{
			f.displayMenu();

			Scanner scan = new Scanner(System.in);

			int userInput = scan.nextInt();

			switch (userInput)
			{
				case 1:
					// 收支明细
					f.Details();
					break;
				case 2:
					// 登记收入
					f.join();
					break;
				case 3:
					// 登记支出
					f.pay();
					break;
				case 4:
					loopFlag = false;
					System.out.println("退出程序...");
					break;
				default:
					break;
			}
		}
	}
}
