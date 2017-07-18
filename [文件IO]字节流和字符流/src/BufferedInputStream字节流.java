import java.io.*;

public class BufferedInputStream×Ö½ÚÁ÷
{
	public static void main(String[] args)
	{
		File file1 = new File("BufferFile.txt");
		File file2 = new File("BufferFile1.txt");
		FileInputStream fis  = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try
		{
			bis = new BufferedInputStream(fis = new FileInputStream(file1));
			bos = new BufferedOutputStream(fos = new FileOutputStream(file2));
			int len = 0;
			byte[] b = new byte[1024];
			while (-1 != (len = bis.read(b)))
			{
				System.out.println(new String(b));
				bos.write(b);
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
		finally
		{
			try
			{
				if (null != bos)
				{
					bos.close();
					bos = null;
				}
				if (null != bis)
				{
					bis.close();
					bis = null;
				}
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
				e.printStackTrace();
			}
		}
		
	}
}
