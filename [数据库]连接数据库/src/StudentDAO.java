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
		
		// 与特定数据库的连接（会话）。在连接上下文中执行 SQL 语句并返回结果。
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String vSQL = null;
		
		vSQL = "select StudentNo, StudentName from Student";
		
		try
		{
			// 返回与带有给定字符串名的类或接口相关联的 Class 对象。
			// 调用 forName("X") 将导致命名为 X 的类被初始化。 
			Class.forName(driverName);
			// 试图建立到给定数据库 URL 的连接。
			conn = DriverManager.getConnection(connUrl, userName, userPwd);
			// 创建一个 Statement 对象来将 SQL 语句发送到数据库。
			stmt = conn.createStatement();
			// 执行给定的 SQL 语句，该语句返回单个 ResultSet 对象。
			// 数据库结果集的数据表，通常通过执行查询数据库的语句生成。
			// 数据库资料读取结果
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

























