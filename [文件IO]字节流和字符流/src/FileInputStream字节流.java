import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStream字节流
{
	public static void main(String[] args)
	{
		File file = new File("test.txt");
		File file2 = new File("test2.txt");
		FileOutputStream fos = null;
		FileInputStream fis = null;
		byte[] b = new byte[1024];
		int len = 0;
		try
		{
			fis = new FileInputStream(file);
			fos = new FileOutputStream(file2);
			while (-1 != (len = fis.read(b)))
			{
				System.out.println(new String(b));
				fos.write(b);
				fos.flush();
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally {
			try
			{
				if (null != fos)
				{
					fos.close();
					fos = null;
				}
				if (null != fis)
				{
					fis.close();
					fis = null;
				}
			}
			catch (IOException e)
			{
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
