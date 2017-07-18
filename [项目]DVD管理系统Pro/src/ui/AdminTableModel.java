package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import bean.Admin;

public class AdminTableModel  extends AbstractTableModel
{
	private List<Admin> data = new ArrayList<Admin>();

	public AdminTableModel(List<Admin> list)
	{
		try
		{
			setData(list);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void setData(List<Admin> data) throws Exception
	{
		if (data == null)
			throw new IllegalArgumentException("参数data不能为null");
		this.data = data;
		fireTableDataChanged();
	}

	@Override
	public int getRowCount()
	{
		return data.size();
	}

	@Override
	public int getColumnCount()
	{
		return 3;
	}

	@Override
	public String getColumnName(int column)
	{
		// 根据实际情况返回列名
		if (column == 0)
			return "管理员ID";
		else if (column == 1)
			return "管理员账号";
		else if (column == 2)
			return "管理员密码";
		return null;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		// TODO Auto-generated method stub
		Admin book = data.get(rowIndex);
		if (columnIndex == 0)
			return book.getAdminId();

		else if (columnIndex == 1)
			return book.getAdminName();

		else if (columnIndex == 2)
			return book.getAdminPwd();

		return null;
	}

}
