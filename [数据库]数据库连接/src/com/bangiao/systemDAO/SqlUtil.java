package com.bangiao.systemDAO;

import java.sql.*;

class ResUtil
{
	private String driverName = null;
	private String connUrl = null;
	private String userName = null;
	private String userPwd = null;
	public ResUtil()
	{
		setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		setConnUrl("jdbc:sqlserver://127.0.0.1:1433;"
				+ "instanceName=DBServer;databaseName=School;");
		setUserName("sa");
		setUserPwd("123");
	}
	public String getDriverName()
	{
		return driverName;
	}
	public void setDriverName(String driverName)
	{
		this.driverName = driverName;
	}
	public String getConnUrl()
	{
		return connUrl;
	}
	public void setConnUrl(String connUrl)
	{
		this.connUrl = connUrl;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getUserPwd()
	{
		return userPwd;
	}
	public void setUserPwd(String userPwd)
	{
		this.userPwd = userPwd;
	}
}

public class SqlUtil
{
	private static ResUtil resu = new ResUtil();
	public static ResultSet Modify(String vSql)
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try
		{
			Class.forName(resu.getDriverName());
			conn = DriverManager.getConnection(resu.getConnUrl(),
					resu.getUserName(), resu.getUserPwd());
			stmt = conn.createStatement();
			rs = stmt.executeQuery(vSql);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally
		{
			if (null != stmt)
			{
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if (null != conn)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return rs;
	}
	
	
	public static void noModify(String vSql)
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try
		{
			Class.forName(resu.getDriverName());
			conn = DriverManager.getConnection(resu.getConnUrl(),
					resu.getUserName(), resu.getUserPwd());
			stmt = conn.createStatement();
			rs = stmt.executeQuery(vSql);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally
		{
			if (null != rs)
			{
				try
				{
					rs.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if (null != stmt)
			{
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if (null != conn)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
