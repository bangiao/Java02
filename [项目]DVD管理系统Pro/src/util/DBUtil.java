package util;

import java.sql.*;

import com.exjor.common.SysFun;

public class DBUtil {

	/**
	 * jdbc����������
	 */
	public static String driverName = "com.mysql.jdbc.Driver";

	/**
	 * ���ݿ�����url
	 */
	public static String connUrl = "jdbc:mysql://127.0.0.1:3306/dvdmgr?"
                + "&useUnicode=true&characterEncoding=UTF8&useSSL=false";

	/**
	 * ���ݿ��û�
	 */
	public static String userName = "root";

	/**
	 * ���ݿ�����
	 */
	public static String userPwd = "root";

	
	

	
	/**
	 * �������ݿ����ɾ��
	 * 
	 * @param pSQL
	 *            Insert/Delete/Update���
	 * @return ��Ӱ���������Ϊ0�����ʾû��¼��SQL����
	 */
	public static int edit(String pSQL) {
		int num = 0;

		// JDBC �Ķ���.
		Connection conn = null; // ���Ӷ��� conn : �൱��java��������ݿ�֮�������
		Statement stmt = null; // ������ stmt : �൱��˾��Ա,�´����SQL��䣩����ִ��SQL���

		try {
			// ����jdbc�����ൽ�ڴ�
			Class.forName(DBUtil.driverName);
			// ���� url,user,pwd����һ��Java�������ݿ���š������Ӷ���
			conn = DriverManager.getConnection(DBUtil.connUrl, DBUtil.userName, DBUtil.userPwd);

			// ʹ�����Ӷ��󣬴���һ��˾��Ա����������
			stmt = conn.createStatement();

			// ��������ִ����ɾ�����Ļ����᷵������Ӱ�ļ�¼��
			num = stmt.executeUpdate(pSQL);

			StringBuffer sb = new StringBuffer();
			sb.append(pSQL + "\t\t��Ӱ���������" + num);
			SysFun.Log(sb);
			System.out.println(sb);

		} catch (Exception e) {
			//e.printStackTrace(); // ��ӡ��ջ����
			SysFun.Log(e.getMessage()); // ���쳣��Ϣд����־�ļ�
			SysFun.Log(pSQL); // ���쳣��Ϣд����־�ļ�
			//System.out.println(e.getMessage());
		} finally {

			// ���stmt��Ϊ�գ����Թر�stmt���Ա��ͷ���Դ
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}
			// ���conn��Ϊ�գ����Թر�conn���Ա��ͷ���Դ
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
	 * ��ѯ��¼
	 * 
	 * @param pSQL
	 *            Select���
	 * @return �����
	 */
	public static ResultSet query(String pSQL) {

		// JDBC �Ķ���.
		Connection conn = null; // ���Ӷ��� conn : �൱��java��������ݿ�֮�������
		Statement stmt = null; // ������ stmt : �൱��˾��Ա,�´����SQL��䣩����ִ��SQL���
		ResultSet rs = null; // ������� rs : ����Select���ȡ�õ�����
		
		try {
			// ����jdbc�����ൽ�ڴ�
			Class.forName(DBUtil.driverName);
			
			// ���� url,user,pwd����һ��Java�������ݿ���š������Ӷ���
			conn = DriverManager.getConnection(DBUtil.connUrl, DBUtil.userName, DBUtil.userPwd);

			// ʹ�����Ӷ��󣬴���һ��˾��Ա����������
			stmt = conn.createStatement();
			
			// ��������ִ��SQL��Select���Ļ����᷵�ؽ���������浽rs��
			rs = stmt.executeQuery(pSQL);

		} catch (Exception e) {
			//e.printStackTrace(); // ��ӡ��ջ����
			SysFun.Log(e.getMessage()); // ���쳣��Ϣд����־�ļ�
			SysFun.Log(pSQL); // ���쳣��Ϣд����־�ļ�
			//System.out.println(e.getMessage());
		} finally {

		}

		return rs;
	}

	
	
	/**
	 * �ر�ResultSet�����Ӧ��Statement�����Connection����
	 * @param pResultSet
	 */
	public static void CloseRS(ResultSet rs) {

		// JDBC �Ķ���.
		Connection conn = null; // ���Ӷ��� conn : �൱��java��������ݿ�֮�������
		Statement stmt = null; // ������ stmt : �൱��˾��Ա,�´����SQL��䣩����ִ��SQL���

		try {
			stmt = rs.getStatement();
			conn = rs.getStatement().getConnection();

		} catch (Exception e) {
			//e.printStackTrace(); // ��ӡ��ջ����
			SysFun.Log(e.getMessage()); // ���쳣��Ϣд����־�ļ�
			//System.out.println(e.getMessage());
		} finally {
			//���rs��Ϊ�գ����Թر�rs���Ա��ͷ���Դ
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {

				}
			}
			// ���stmt��Ϊ�գ����Թر�stmt���Ա��ͷ���Դ
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}
			// ���conn��Ϊ�գ����Թر�conn���Ա��ͷ���Դ
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}
	}
}
