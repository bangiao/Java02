import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;

public class TestCollection
{
	@Test
	public void testCollection1()
	{
		Collection<Object> coll = new ArrayList<Object>();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");
		boolean b1 = coll.contains(123);
		System.out.println(b1);
		Person p = new Person("zhazha", 23);
		coll.add(p);
		System.out.println(coll);
//		boolean b2 = coll.contains(p);
//		System.out.println(b2);
		
		boolean b2 = coll.contains(new Person("zhazha", 23));
		System.out.println(b2);
		
//		ArrayList<Object> coll = new ArrayList<Object>();
//		System.out.println(coll.size());
//		coll.add(123);
//		coll.add("AA");
//		coll.add(new Date());
//		coll.add("BB");
//		Collection<Integer> coll1 = Arrays.asList(1, 2, 3);
//		coll.addAll(coll1);
//		System.out.println(coll.size());
//		System.out.println(coll.isEmpty());
//		coll.clear();
//		System.out.println(coll.isEmpty());
	}
}
