import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader字节流
{
	public static void main(String[] args)
	{
		File file1 = new File("FilRead.txt");
		File file2 = new File("FilRead1.txt");
		FileReader fr = null;
		FileWriter fw = null;
		try
		{
			fr = new FileReader(file1);
			fw = new FileWriter(file2);
			char[] cbuf = new char[1024];
			int len = 0;
			if (-1 != (len = fr.read(cbuf)))
			{
				System.out.println(cbuf);
				fw.write(cbuf);
				fw.flush();
			}
		}
		catch (FileNotFoundException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			try
			{
				if (null != fw)
				{
					fw.close();
					fw = null;
				}
				if (null != fr)
				{
					fr.close();
					fr = null;
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
