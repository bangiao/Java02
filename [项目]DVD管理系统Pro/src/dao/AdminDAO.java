package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exjor.common.SysFun;

import bean.Admin;
import util.DBEnc;
import util.DBUtil;

public class AdminDAO
{
	private final String ADMIN_ID = "admin_id";
	private final String ADMIN_NAME = "admin_name";
	private final String ADMIN_PWD = "admin_pwd";
	private final String ADMIN = "my_admin";
	
	public int Modify(int id, int x, String content)
	{
		int ret = 0;
		String sql = null;
		
		switch (x)
		{
			case 1:
				sql = "update " + ADMIN + " set  " + ADMIN_NAME + "='" + content + "' where admin_id="
						+ Integer.toString(id) + ";";
				break;
			case 2:
				sql = "update " + ADMIN + " set  " + ADMIN_PWD + "='" + content + "' where admin_id="
						+ Integer.toString(id) + ";";
				break;
			default:
				SysFun.Log("AdminDAO Modify ªÒ»°∫· x ¥ÌŒÛ");
				return -1;
		}
		// update my_admin set admin_pwd='123' where admin_id=2;
		ret = DBUtil.edit(sql);
		return ret;
	}
	
	public int del(int id)
	{
		int ret = 0;
		String sql = "delete from " + ADMIN + " where " + ADMIN_ID + "=" + Integer.toString(id) + ";";
		SysFun.Log(sql);
		ret = DBUtil.edit(sql);
		return ret;
	}
	
	public int login(Admin pAdmin)
	{
		int result = 0;
		String sql = "select count(1) from " + ADMIN + " " +
		"where " +ADMIN_NAME + "='" + pAdmin.getAdminName() + "' "
				+ "and " + ADMIN_PWD + " ='" + pAdmin.getAdminPwd() + "'";
		ResultSet rs = DBUtil.query(sql);
		try
		{
			if (rs != null)
			{
				if (rs.next())
				{
					result = rs.getInt(1);
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.CloseRS(rs);
		}
		return result;
	}

	public List<Admin> listAll()
	{
		ArrayList<Admin> list = new ArrayList<Admin>();
		ResultSet rs = DBUtil.query("Select " + ADMIN_ID + " , " + ADMIN_NAME +
				" , " + ADMIN_PWD + "  From " + ADMIN + " ");

		if (rs != null)
		{
			try
			{
				Admin bean = null;
				while (rs.next())
				{
					bean = new Admin();

					bean.setAdminId(rs.getInt(ADMIN_ID));
					bean.setAdminName(rs.getString(ADMIN_NAME));
					bean.setAdminPwd(DBEnc.convertMD5(rs.getString(ADMIN_PWD)));
					System.out.println(DBEnc.convertMD5(DBEnc.convertMD5(rs.getString(ADMIN_PWD))));
					list.add(bean);
				}
			}
			catch (SQLException e)
			{
				SysFun.Log(e.getMessage());
			}
			return list;
		}
		DBUtil.CloseRS(rs);
		return list;
	}

	public List<Admin> search(String pName)
	{
		ArrayList<Admin> list = new ArrayList<Admin>();
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append("select " + ADMIN_ID + " , " + ADMIN_NAME + " ," + ADMIN_PWD + " from " + ADMIN + " ");
		sbSQL.append("where " + ADMIN_NAME + " like '%" + pName + "%'");
		ResultSet rs = DBUtil.query(sbSQL);

		if (rs != null)
		{
			try
			{
				Admin bean = null;
				while (rs.next())
				{
					bean = new Admin();
					bean.setAdminId(rs.getInt(ADMIN_ID));
					bean.setAdminName(rs.getString(ADMIN_NAME));
					bean.setAdminPwd(rs.getString(ADMIN_PWD));
					bean.setAdminPwd(DBEnc.convertMD5(rs.getString(ADMIN_PWD)));
					list.add(bean);
				}
			}
			catch (SQLException e)
			{
				SysFun.Log(e.getMessage());
			}
			return list;
		}
		DBUtil.CloseRS(rs);
		return list;

	}
}
