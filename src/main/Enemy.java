package main;
public class Enemy extends Creature {

	public Enemy(String name,Location location)
	{
		super(name,location);
	}
	
        @Override
	public void doSmth(Creature creature)
	{
		if(this.alive)
		{
			if(this.wantToEat)
			{
				Food f = new Food(0);
				this.Eat(f);
			}
			else
			{
				if(creature.alive)
                            {
				this.attack(creature);
                            }
			}
			this.Update();
		}
	}

}
