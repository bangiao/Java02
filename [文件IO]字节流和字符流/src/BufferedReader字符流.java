import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReader字符流
{
	public static void main(String[] args)
	{
		File file1 = new File("BufferedFile.txt");
		File file2 = new File("BufferedFile1.txt");
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try
		{
			fr = new FileReader(file1);
			fw = new FileWriter(file2);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			int len = 0;
			char[] cbuf = new char[1024];
			while (-1 != (len = br.read(cbuf)))
			{
				System.out.println(cbuf);
				bw.write(cbuf);
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
		finally
		{
			try
			{
				if (null != bw)
				{
					bw.close();
					bw = null;
				}
				if (null != br)
				{
					br.close();
					br = null;
				}
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
