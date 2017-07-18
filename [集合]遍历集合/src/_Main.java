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
		
		// 方式一: 
		Iterator<Object> it = coll.iterator();
		System.out.println("方式一: ");
		while (it.hasNext())
		{
			System.out.print(it.next() + " ");
		}
		System.out.println("");
		
		// 方式二:
		System.out.println("方式二: ");
		for (Object obj : coll)
		{
			System.out.print(obj + " ");
		}
		System.out.println("");
		
		// 使用了 创建的 it 变量, 迭代器后, 无法再次遍历新修改后的集合
		// 新加入
		coll.add("laji");
		// 错误
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
