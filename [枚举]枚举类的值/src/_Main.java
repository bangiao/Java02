
enum TYPE
{
	ONE,
	TWO,
	THREE
};

public class _Main
{
	public static void main(String[] args)
	{
		System.out.println(TYPE.ONE.equals("ONE"));
		System.out.println("ONE".equals(TYPE.ONE));
	}
}
