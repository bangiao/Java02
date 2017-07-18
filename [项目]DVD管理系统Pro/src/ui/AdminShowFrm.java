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
		this.setTitle("DVD����ϵͳ-����Ա�б�");// ���ô���ı���
		this.setSize(706, 442);// ���ô���ĳ���
		// ���㴰�������ʾʱ���������Ͻ���������Ļ��x��y�������ֵ
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int x = (int) (toolkit.getScreenSize().getWidth() - this.getWidth()) / 2;
		int y = (int) (toolkit.getScreenSize().getHeight() - this.getHeight()) / 2;

		// ���ô����λ��
		this.setLocation(x, y);
		// this.setLocationRelativeTo(null);//�ô��������ʾ����Ҫ�������������Ч

		panel = new JPanel();// ����һ�����
		getContentPane().add(panel);// ��������ŵ���ǰ���壬�������嶼��������
		panel.setLayout(null);// �����Ĳ�������Ϊnull��������Բ���
		tableAdminList = new JTable();
		tableAdminList.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				if (java.awt.event.MouseEvent.BUTTON3 == e.getButton())
				{
					// ��ȡ���ĺ�����
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
		// ��JTable��ӵ�JScrollPane��JTable���ܹ���
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
		JMenuItem delMenuItem = new JMenuItem("ɾ��");
		JMenuItem modMenuItem = new JMenuItem("�޸�");
		
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
				int res = JOptionPane.showConfirmDialog(null, "���Ҫɾ��ô???", "ϵͳ��ʾ", JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE);
				if (JOptionPane.YES_OPTION == res)
				{
					AdminService as = new AdminService();
					int num = as.del(id);
					if (num > 0)
					{
						SysFun.Log("ɾ���ɹ�");
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
				// TODO �Զ����ɵķ������
				System.out.println("�޸�");
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
