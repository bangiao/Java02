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
			throw new IllegalArgumentException("����data����Ϊnull");
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
		// ����ʵ�������������
		if (column == 0)
			return "����ԱID";
		else if (column == 1)
			return "����Ա�˺�";
		else if (column == 2)
			return "����Ա����";
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
