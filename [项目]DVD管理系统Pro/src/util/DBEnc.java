package util;

import java.security.MessageDigest;

public class DBEnc
{
	// public static String md5(String plainText)
	// {
	// byte[] secretBytes = null;
	// try
	// {
	// secretBytes =
	// MessageDigest.getInstance("md5").digest(plainText.getBytes());
	// }
	// catch (NoSuchAlgorithmException e)
	// {
	// throw new RuntimeException("md5加密失败");
	// }
	// String md5code = new BigInteger(1, secretBytes).toString(16);
	// for (int i = 0; i < 32 - md5code.length(); i++)
	// {
	// md5code = "0" + md5code;
	// }
	// return md5code;
	// }

	public static String string2MD5(String inStr)
	{
		MessageDigest md5 = null;
		try
		{
			md5 = MessageDigest.getInstance("MD5");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++)
		{
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();

	}

	/**
	 * 加密解密算法 执行一次加密，两次解密
	 */
	public static String convertMD5(String inStr)
	{

		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++)
		{
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;

	}
	
	 // 测试主函数  
//    public static void main(String args[]) {  
//        String s = new String("admin123");  
//        System.out.println("原始：" + s);  
//        System.out.println("MD5后：" + string2MD5(s));  
//        System.out.println("加密的：" + convertMD5(s));  
//        System.out.println("解密的：" + convertMD5(convertMD5(s)));  
//  
//    }  
}
