package FrameMain;

import java.util.TreeMap;

public class StuCtrlSys
{
	private TreeMap<String, Student> m_map;

	public StuCtrlSys()
	{
		super();
		setM_map(new TreeMap<String, Student>());
	}
	
	// 增
	public Student add(Student s)
	{
		if (null == s)
		{
			System.out.println("学生增加失败");
			return null;
		}
		TreeMap<String, Student> tmp = this.getM_map();
		tmp.put(s.getM_id(), s);
		return tmp.get(s.getM_id());
	}
	
	// 删
	public Student del(String id)
	{
		return getM_map().remove(id);
	}
	
	// 改
	public Student ChangeName(String id, String name)
	{
		if (null == id || null == name)
		{
			System.out.println("ChangeName err");
			return null;
		}
		Student s = getM_map().get(id);
		s.setM_name(name);
		return getM_map().replace(id, s);
	}
	
	public Student ChangeSex(String id, String sex)
	{
		if (null == id || null == sex)
		{
			System.out.println("ChangeSex err");
			return null;
		}
		Student s = getM_map().get(id);
		s.setM_sex(sex);
		return getM_map().replace(id, s);
	}
	
	public Student ChangeYears(String id, int years)
	{
		if (null == id || years <= 0)
		{
			System.out.println("ChangeYears err");
			return null;
		}
		Student s = getM_map().get(id);
		s.setM_years(years);
		return getM_map().replace(id, s);
	}
	
	// 查
	public Student find(String id)
	{
		return getM_map().get(id);
	}
	public TreeMap<String, Student> getM_map()
	{
		return m_map;
	}
	public void setM_map(TreeMap<String, Student> m_map)
	{
		this.m_map = m_map;
	}
}
