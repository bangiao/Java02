package ui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import com.exjor.common.SysFun;

import bean.Admin;
import service.AdminService;

public class AdminShowFrm extends JFrame
{
	
	private JPanel contentPane;

	private JPanel panel;
	private JScrollPane pnlAdminList;
	private JTable tableAdminList;
	private JTextField text_SerachName;
	private JButton button;
	private JButton button_1;
	private JPopupMenu popupMenu;

	/**
	 * Create the frame.
	 */
	public AdminShowFrm()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("DVD管理系统-管理员列表");// 设置窗体的标题
		this.setSize(706, 442);// 设置窗体的长度
		// 计算窗体居中显示时，窗体左上角在整个屏幕的x和y的坐标的值
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int x = (int) (toolkit.getScreenSize().getWidth() - this.getWidth()) / 2;
		int y = (int) (toolkit.getScreenSize().getHeight() - this.getHeight()) / 2;

		// 设置窗体的位置
		this.setLocation(x, y);
		// this.setLocationRelativeTo(null);//让窗体居中显示，主要设置组件居中生效

		panel = new JPanel();// 创建一个面板
		getContentPane().add(panel);// 将这个面板放到当前窗体，整个窗体都是这个面板
		panel.setLayout(null);// 把面板的布局设置为null，代表绝对布局
		tableAdminList = new JTable();
		tableAdminList.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				if (java.awt.event.MouseEvent.BUTTON3 == e.getButton())
				{
					// 获取鼠标的横坐标
					int focuseRowIndex = tableAdminList.rowAtPoint(e.getPoint());
					if (-1 == focuseRowIndex)
					{
						return;
					}
					tableAdminList.setRowSelectionInterval(focuseRowIndex, focuseRowIndex);
					if (null == popupMenu)
					{
						CreatePopMenu();
					}
					popupMenu.show(tableAdminList, e.getX(), e.getY());
				}
			}
		});
		// 将JTable添加到JScrollPane，JTable才能滚动
		pnlAdminList = new JScrollPane(tableAdminList);

		pnlAdminList.setBounds(10, 10, 500, 383);
		panel.add(pnlAdminList);

		text_SerachName = new JTextField();
		text_SerachName.setBounds(520, 20, 160, 33);
		panel.add(text_SerachName);

		button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				searchData(text_SerachName.getText());
			}
		});
		button.setText("\u641C\u7D22");
		button.setBounds(520, 63, 76, 33);
		panel.add(button);

		button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				text_SerachName.setText("");
				showAll();
			}
		});
		button_1.setText("\u6E05\u7A7A");
		button_1.setBounds(606, 63, 76, 33);
		panel.add(button_1);

		showAll();
	}

	private void CreatePopMenu()
	{
		this.popupMenu = new JPopupMenu();
		JMenuItem delMenuItem = new JMenuItem("删除");
		JMenuItem modMenuItem = new JMenuItem("修改");
		
		delMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int index = tableAdminList.getSelectedRow();
				if (-1 == index)
				{
					return ;
				}
				TableModel model = tableAdminList.getModel();
				int id = (int) model.getValueAt(index, 0);
				int res = JOptionPane.showConfirmDialog(null, "真的要删除么???", "系统提示", JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE);
				if (JOptionPane.YES_OPTION == res)
				{
					AdminService as = new AdminService();
					int num = as.del(id);
					if (num > 0)
					{
						SysFun.Log("删除成功");
						text_SerachName.setText("");
						showAll();
						return ;
					}
				}
				
			}
		});
		
		modMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO 自动生成的方法存根
				System.out.println("修改");
			}
		});
		
		this.popupMenu.add(delMenuItem);
		this.popupMenu.add(modMenuItem);
	}

	public void showAll()
	{

		AdminService service = new AdminService();

		List<Admin> list = service.showAll();
		AdminTableModel modelList = new AdminTableModel(list);
		tableAdminList.setModel(modelList);
	}

	public void searchData(String pName)
	{

		AdminService service = new AdminService();
		List<Admin> list = service.search(pName);

		AdminTableModel modelList = new AdminTableModel(list);
		tableAdminList.setModel(modelList);

	}
}
