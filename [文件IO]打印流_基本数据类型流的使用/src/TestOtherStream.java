import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class TestOtherStream
{
	@Test
	public void printStreamWriter()
	{
		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(new File("test.txt"));
		}
		catch (FileNotFoundException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		PrintStream ps = null;
		ps = new PrintStream(fos, true);
		if (null != ps)
		{
			System.setOut(ps);
		}
		for (int i = 0; i <= 255; i++)
		{
			System.out.print((char)i);
			if (i % 50 == 0)
			{
				System.out.println();
			}
		}
		if (null != ps)
		{
			ps.close();
			ps = null;
		}
	}
}
