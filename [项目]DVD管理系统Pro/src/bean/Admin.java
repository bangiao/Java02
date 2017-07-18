package bean;

import util.DBEnc;

public class Admin
{

	private int adminId;
	private String adminName;
	private String adminPwd;
	private int isDisable;

	public Admin()
	{
		super();
	}

	public int getAdminId()
	{
		return adminId;
	}

	public void setAdminId(int adminId)
	{
		this.adminId = adminId;
	}

	public String getAdminName()
	{
		return adminName;
	}

	public void setAdminName(String adminName)
	{
		this.adminName = adminName;
	}

	public String getAdminPwd()
	{
		String ret = (DBEnc.convertMD5(this.adminPwd));
		return ret;
	}

	public void setAdminPwd(String adminPwd)
	{
		this.adminPwd = DBEnc.convertMD5(adminPwd);
//		this.adminPwd = adminPwd;
	}

	public int getIsDisable()
	{
		return isDisable;
	}

	public void setIsDisable(int isDisable)
	{
		this.isDisable = isDisable;
	}

}
