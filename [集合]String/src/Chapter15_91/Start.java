package Chapter15_91;

import java.util.Scanner;

class StrMgr
{
	public static int counter(String in_str, String in_word)
	{
		String str_src = in_str;
		String str_tmp = in_word;
		int nCount = 0;
		int nIndexOffset = 0;
		
		while (true)
		{
			int nIndex = (str_src).indexOf(str_tmp, nIndexOffset);
			if (-1 == nIndex)
			{
				break;
			}
			nIndexOffset = str_src.offsetByCodePoints(nIndex, str_tmp.length());
			nCount++;
		}
		return nCount;
	}
}

public class Start
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个字符串: ");
		String strTarget = scan.nextLine();
		System.out.println("请输入要查找的字符: ");
		String strWord = scan.next();
		
		int nCount = StrMgr.counter(strTarget, strWord);
		System.out.println(strTarget + "中包含" + nCount + "个" + strWord);
	}
}
