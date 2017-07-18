package util;

import java.sql.*;

import com.exjor.common.SysFun;

public class DBUtil {

	/**
	 * jdbc驱动的类名
	 */
	public static String driverName = "com.mysql.jdbc.Driver";

	/**
	 * 数据库连接url
	 */
	public static String connUrl = "jdbc:mysql://127.0.0.1:3306/dvdmgr?"
                + "&useUnicode=true&characterEncoding=UTF8&useSSL=false";

	/**
	 * 数据库用户
	 */
	public static String userName = "root";

	/**
	 * 数据库密码
	 */
	public static String userPwd = "root";

	
	

	
	/**
	 * 处理数据库的增删改
	 * 
	 * @param pSQL
	 *            Insert/Delete/Update语句
	 * @return 受影响的行数，为0，则表示没记录被SQL操作
	 */
	public static int edit(String pSQL) {
		int num = 0;

		// JDBC 的对象.
		Connection conn = null; // 连接对象 conn : 相当于java程序和数据库之间的桥梁
		Statement stmt = null; // 语句对象 stmt : 相当于司令员,下达命令（SQL语句）——执行SQL语句

		try {
			// 加载jdbc驱动类到内存
			Class.forName(DBUtil.driverName);
			// 根据 url,user,pwd创建一个Java程序到数据库的桥——连接对象
			conn = DriverManager.getConnection(DBUtil.connUrl, DBUtil.userName, DBUtil.userPwd);

			// 使用连接对象，创建一个司令员——语句对象
			stmt = conn.createStatement();

			// 由语句对象执行增删改语句的话，会返回受晾影的记录行
			num = stmt.executeUpdate(pSQL);

			StringBuffer sb = new StringBuffer();
			sb.append(pSQL + "\t\t受影响的行数：" + num);
			SysFun.Log(sb);
			System.out.println(sb);

		} catch (Exception e) {
			//e.printStackTrace(); // 打印堆栈跟踪
			SysFun.Log(e.getMessage()); // 将异常信息写到日志文件
			SysFun.Log(pSQL); // 将异常信息写到日志文件
			//System.out.println(e.getMessage());
		} finally {

			// 如果stmt不为空，则尝试关闭stmt，以便释放资源
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}
			// 如果conn不为空，则尝试关闭conn，以便释放资源
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}

		return num;
	}
	

	public static ResultSet query(StringBuilder sbSQL) {
		// TODO Auto-generated method stub
		ResultSet rs=query(sbSQL.toString());
		return rs;
	}
	/**
	 * 查询记录
	 * 
	 * @param pSQL
	 *            Select语句
	 * @return 结果集
	 */
	public static ResultSet query(String pSQL) {

		// JDBC 的对象.
		Connection conn = null; // 连接对象 conn : 相当于java程序和数据库之间的桥梁
		Statement stmt = null; // 语句对象 stmt : 相当于司令员,下达命令（SQL语句）——执行SQL语句
		ResultSet rs = null; // 结果集合 rs : 保存Select语句取得的数据
		
		try {
			// 加载jdbc驱动类到内存
			Class.forName(DBUtil.driverName);
			
			// 根据 url,user,pwd创建一个Java程序到数据库的桥——连接对象
			conn = DriverManager.getConnection(DBUtil.connUrl, DBUtil.userName, DBUtil.userPwd);

			// 使用连接对象，创建一个司令员——语句对象
			stmt = conn.createStatement();
			
			// 由语句对象执行SQL，Select语句的话，会返回结果集，保存到rs里
			rs = stmt.executeQuery(pSQL);

		} catch (Exception e) {
			//e.printStackTrace(); // 打印堆栈跟踪
			SysFun.Log(e.getMessage()); // 将异常信息写到日志文件
			SysFun.Log(pSQL); // 将异常信息写到日志文件
			//System.out.println(e.getMessage());
		} finally {

		}

		return rs;
	}

	
	
	/**
	 * 关闭ResultSet对象对应的Statement对象和Connection对象
	 * @param pResultSet
	 */
	public static void CloseRS(ResultSet rs) {

		// JDBC 的对象.
		Connection conn = null; // 连接对象 conn : 相当于java程序和数据库之间的桥梁
		Statement stmt = null; // 语句对象 stmt : 相当于司令员,下达命令（SQL语句）——执行SQL语句

		try {
			stmt = rs.getStatement();
			conn = rs.getStatement().getConnection();

		} catch (Exception e) {
			//e.printStackTrace(); // 打印堆栈跟踪
			SysFun.Log(e.getMessage()); // 将异常信息写到日志文件
			//System.out.println(e.getMessage());
		} finally {
			//如果rs不为空，则尝试关闭rs，以便释放资源
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {

				}
			}
			// 如果stmt不为空，则尝试关闭stmt，以便释放资源
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}
			// 如果conn不为空，则尝试关闭conn，以便释放资源
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}
	}
}
