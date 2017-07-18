package com.bangiao.systemDAO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlCtrl
{
	private ResultSet m_res;
	public SqlCtrl()
	{
		super();
		setM_res(SqlUtil.Modify("select * from [Admin]"));
	}
	
	public int add(String pValName, String pValPwd)
	{
		String vSql = "insert into [Admin](AdminName, AdminPwd) "
				+ "values('" + pValName + "', '" + pValPwd + "')";
		System.out.println(vSql);
		SqlUtil.noModify(vSql);
		return 0;
	}
	public int del(int AdminId)
	{
		String vSql = "DELETE FROM [Admin] WHERE AdminId = '" + AdminId + "'";
		System.out.println(vSql);
		SqlUtil.noModify(vSql);
		return 0;
	}
	public int change(String pValName, String pValPwd)
	{
		String vSql = "UPDATE [Admin] SET "
				+ "AdminPwd = '" + pValPwd + "' WHERE "
				+ "AdminName = '" + pValName + "'";
		System.out.println(vSql);
		SqlUtil.noModify(vSql);
		return 0;
	}
	public String find(int AdminId)
	{
		String str_ret = null;
		String vSql = "select * from [Admin] where AdminId = '" + AdminId + "'";
		System.out.println(vSql);
		setM_res(SqlUtil.Modify(vSql));
		try
		{
			while (getM_res().next())
			{
				System.out.println(getM_res().getInt(1) + " " + getM_res().getString(2) 
				+ " " + getM_res().getString(3) + "\n");
				str_ret = getM_res().getString(3);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return str_ret;
	}

	private ResultSet getM_res()
	{
		return m_res;
	}

	private void setM_res(ResultSet m_res)
	{
		if (null != m_res)
		{
			try
			{
				m_res.close();
				m_res = null;
			}
			catch (SQLException e)
			{
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		this.m_res = m_res;
	}
	
}
