package main;
public class Person extends Creature {

	public String name;

	public Person(String name,int damage, int hp, Location location) {
		super(name, location);	
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}
	
	public String Say(String msg)
	{
		if(this.alive)
		{
			if(this.wantToEat)
				return this.name + " сказал:\"" + " я жрать хачу" + "\"";
			return this.name + " сказал:\"" +msg + "\"";
			
		}
		else
			return this.name + " умир((";
	}

    @Override
    public void doSmth(Creature creature) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}
