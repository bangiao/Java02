
abstract class Food
{
	protected String name = "����ʳ��";
	public abstract String getName();
}

class Bone extends Food
{
	public Bone(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}
}

interface Animal
{
	public void eat(Food f);
}

class Dog implements Animal
{
	private String name;
	
	public Dog(String name)
	{
		super();
		this.name = name;
	}

	public void eat(Food f)
	{
		// TODO Auto-generated method stub
		System.out.println(this.name + "��" + f.getName());
	}
}

public class _Main
{
	public static void main(String[] args)
	{
		Food f = new Bone("��ͷ");
		Animal a = new Dog("С��");
		a.eat(f);
	}
}
