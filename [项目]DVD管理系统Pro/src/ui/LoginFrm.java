package ui;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bean.Admin;
import service.AdminService;

public class LoginFrm extends JFrame
{

	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_pwd;

	/**
	 * Create the frame.
	 */
	public LoginFrm()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Panel panel = new Panel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D:");
		lblNewLabel.setBounds(66, 35, 57, 25);
		panel.add(lblNewLabel);
		
		textField_name = new JTextField();
		textField_name.setBounds(116, 36, 152, 23);
		panel.add(textField_name);
		textField_name.setColumns(10);
		
		JLabel label = new JLabel("\u5BC6\u7801:");
		label.setBounds(66, 70, 57, 25);
		panel.add(label);
		
		textField_pwd = new JPasswordField();
		textField_pwd.setColumns(10);
		textField_pwd.setBounds(116, 71, 152, 23);
		panel.add(textField_pwd);
		
		JButton button_Login = new JButton("\u767B\u5165");
		button_Login.addActionListener(e -> 
		{
				String loginName = textField_name.getText();
				String loginPwd = textField_pwd.getText();
				AdminService as = new AdminService();
				Admin admin = new Admin();
				admin.setAdminName(loginName);
				admin.setAdminPwd(loginPwd);
				int iRet = as.login(admin);
				
				if (iRet > 0)
				{
					this.setTitle("³É¹¦");
					try
					{
						this.setVisible(false);
						AdminShowFrm frame = new AdminShowFrm();
						frame.setVisible(true);
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}
				else
				{
					this.setTitle("Ê§°Ü");
				}
			}
		);
		button_Login.setBounds(49, 120, 93, 23);
		panel.add(button_Login);
		
		JButton button_exit = new JButton("\u9000\u51FA");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_exit.setBounds(182, 120, 93, 23);
		panel.add(button_exit);
	}
}
