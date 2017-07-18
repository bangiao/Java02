package ������;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class MyTestDataStream
{
	@Test
	public void test2DateStreamInput()
	{
		DataInputStream dis = null;
		try
		{
			dis = new DataInputStream(new FileInputStream(new File("data.txt")));
			byte[] b = new byte[20];
			int len = 0;
			
//			while (-1 != (len = dis.read(b)))
//			{
//				System.out.println(new String(b, 0, len));
//			}
			
			String str = dis.readUTF();
			System.out.println(str);
		}
		catch (IOException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally
		{
			if (null != dis)
			{
				try
				{
					dis.close();
					dis = null;
				}
				catch (IOException e)
				{
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
	}
	
	
	@Test
	public void test1DataStream()
	{
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try
		{
			fos = new FileOutputStream("data.txt");
			dos = new DataOutputStream(fos);
			dos.writeUTF("�Ұ���, ����ȴ��֪��!");
			dos.writeBoolean(true);
			dos.writeLong(12345456);
		}
		catch (FileNotFoundException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (null != dos)
				{
					dos.close();
					dos = null;
				}
				if (null != fos)
				{
					fos.close();
					fos = null;
				}
			}
			catch (IOException e)
			{
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}
