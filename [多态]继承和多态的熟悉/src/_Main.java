
abstract class Food
{
	protected String name = "无名食物";
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
		System.out.println(this.name + "吃" + f.getName());
	}
}

public class _Main
{
	public static void main(String[] args)
	{
		Food f = new Bone("骨头");
		Animal a = new Dog("小黄");
		a.eat(f);
	}
}
