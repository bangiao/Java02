import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import java.sql.*;

public class StudentDAO
{
	public void list()
	{
		String driverName = null;
		String connUrl = null;
		String userName = null;
		String userPwd = null;
		
		driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		connUrl = "jdbc:sqlserver://127.0.0.1:1433;"
				+ "instanceName=DBServer;databaseName=Teach;";
		userName = "sa";
		userPwd = "123";
		
		// ���ض����ݿ�����ӣ��Ự������������������ִ�� SQL ��䲢���ؽ����
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String vSQL = null;
		
		vSQL = "select StudentNo, StudentName from Student";
		
		try
		{
			// ��������и����ַ����������ӿ�������� Class ����
			// ���� forName("X") ����������Ϊ X ���౻��ʼ���� 
			Class.forName(driverName);
			// ��ͼ�������������ݿ� URL �����ӡ�
			conn = DriverManager.getConnection(connUrl, userName, userPwd);
			// ����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣
			stmt = conn.createStatement();
			// ִ�и����� SQL ��䣬����䷵�ص��� ResultSet ����
			// ���ݿ����������ݱ�ͨ��ͨ��ִ�в�ѯ���ݿ��������ɡ�
			// ���ݿ����϶�ȡ���
			rs = stmt.executeQuery(vSQL);
			StringBuffer sb = new StringBuffer();
			while (rs.next())
			{
				sb.append(rs.getString(1) + " " + rs.getString(2) + "\n");
			}
			System.out.println(sb);
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

























