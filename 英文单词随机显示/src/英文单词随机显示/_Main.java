package Ӣ�ĵ��������ʾ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class _Main
{
	public static void main(String[] args)
	{
		File file = new File("D:/devolop/java/02.JAVA��ѧ�й��"
				+ "/Ӣ�ĵ��������ʾ/src/Ӣ�ĵ��������ʾ/English.ini");
		String str_line = null;
		
		try
		{
			FileInputStream in_file = new FileInputStream(file);
			InputStreamReader inReader = new InputStreamReader(in_file);
			BufferedReader buf_file = new BufferedReader(inReader);
			while ((str_line = buf_file.readLine()) != null)
			{
				str_line = str_line.replace("\t", "");
				str_line = str_line.replace(" ", "");
				String [] str_buf = str_line.split("=");
				int length = str_buf.length;
				for (int i = 0; i < length; i ++)
				{
					System.out.println(str_buf[i]);
				}
			}
		}
		catch (FileNotFoundException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
}
