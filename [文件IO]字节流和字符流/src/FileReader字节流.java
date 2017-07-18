import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader�ֽ���
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO �Զ����ɵ� catch ��
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}
