import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class _Main
{
	public static void main(String[] args)
	{
		Collection<Object> coll = new ArrayList<Object>();
		
		coll.add("zhazha");
		coll.add("xixi");
		coll.add("goudan");
		coll.add("tiedan");
		coll.add("shabi");
		coll.add("haha");
		coll.add("hehe");
		
		// ��ʽһ: 
		Iterator<Object> it = coll.iterator();
		System.out.println("��ʽһ: ");
		while (it.hasNext())
		{
			System.out.print(it.next() + " ");
		}
		System.out.println("");
		
		// ��ʽ��:
		System.out.println("��ʽ��: ");
		for (Object obj : coll)
		{
			System.out.print(obj + " ");
		}
		System.out.println("");
		
		// ʹ���� ������ it ����, ��������, �޷��ٴα������޸ĺ�ļ���
		// �¼���
		coll.add("laji");
		// ����
//		while (it.hasNext())
//		{
//			System.out.print(it.next() + " ");
//		}
//		System.out.println("");
		
		for (Object obj : coll)
		{
			System.out.print(obj + " ");
		}
		System.out.println("");
	}
}
