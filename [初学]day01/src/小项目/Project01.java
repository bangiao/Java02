package С��Ŀ;

import java.util.Scanner;

// ��ͥ��֧����
class Family_Money
{
	private int m_balence = 10000; // �˻����
	private int m_shouru = 0;// ����
	private int m_zhichu = 0;// ֧��
	
	public Family_Money(int balence)
	{
		super();
		this.m_balence = balence;
	}

	public void displayMenu()
	{
		System.out.println("-----------------��ͥ��֧�������-----------------");
		System.out.println("");
		System.out.println("1 ��֧��ϸ");
		System.out.println("2 �Ǽ�����");
		System.out.println("3 �Ǽ�֧��");
		System.out.println("4 ��    ��");
		System.out.println("");
		System.out.print("��ѡ��(1-4)��");
	}
	
	// ��֧��ϸ
	public void Details()
	{
		System.out.println("-----------------��ǰ��֧��ϸ��¼-----------------");
		System.out.println("��֧\t\t�˻����\t\t��֧���\t\t˵    ��");
		System.out.println("����\t\t" + m_balence + "\t\t" + m_shouru + "\t\t�����");
		System.out.println("֧��\t\t" + m_balence + "\t\t" + m_zhichu + "\t\t��ҵ��");
	}
	
	// �Ǽ�����
	public void join()
	{
		int money = 0;
		
		System.out.print("������: ");
		Scanner scan = new Scanner(System.in);
		
		money = scan.nextInt();
		
		m_balence += money;
		m_shouru = money;
		System.out.println("-----------------��ǰ������ϸ��¼-----------------");
		System.out.println("���������" + m_shouru);
		System.out.println("��������˵���������_");
		System.out.println("�˻����: " + m_balence);
	}
	
	// �Ǽ�֧��
	public void pay()
	{
		int money = 0;
		
		System.out.print("֧����: ");
		Scanner scan = new Scanner(System.in);
		
		money  = scan.nextInt();
		
		if (m_balence < money)
		{
			System.out.println("֧������...");
			return ;
		}
		m_balence -= money;
		m_zhichu = money;
		System.out.println("-----------------��ǰ֧����ϸ��¼-----------------");
		System.out.println("����֧����" + m_zhichu);
		System.out.println("����֧��˵������ҵ��_");
		System.out.println("�˻����: " + m_balence);
		
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
					// ��֧��ϸ
					f.Details();
					break;
				case 2:
					// �Ǽ�����
					f.join();
					break;
				case 3:
					// �Ǽ�֧��
					f.pay();
					break;
				case 4:
					loopFlag = false;
					System.out.println("�˳�����...");
					break;
				default:
					break;
			}
		}
	}
}
