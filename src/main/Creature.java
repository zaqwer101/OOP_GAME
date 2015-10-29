package main;
import java.util.ArrayList;

public abstract class Creature 
{
public Equipment weapon, body_armor;
public Location location; //Ссылка на текущую локацию
public String name;
int age,damage,hp;
boolean alive;
public ArrayList<Item> inventory;
boolean wantToEat;
public int _food;
public Creature(String name, Location location)
{
    this.hp = 1;
    this.damage = 0;
    this._food = 3;
    this.name = name;
    this.age = 0;
    this.alive = true;
    this.wantToEat = false;
    this.inventory = new ArrayList<Item>();
    this.moveTo(location);
    //OOP_RPG.log += this.name + " родилсо и гатов убивать\n";
}

public void Eat(Food food)
{
	this._food += food.food;
	this.hp += food.heal;
	OOP_RPG.log += this.name + " покушал\n";
}

public void Update()
{
	this.age ++;
	this._food -= 1;
	if(this._food < 0)
	{
		this.wantToEat = true;
		if(this._food < -5 || this.hp < 0)
		{
                    this.hp = 0;
                    this.alive = false;
		}
	}
	else
		this.wantToEat = false;
	if(this.hp <= 0)
	{
		this.alive = false;
                for(int i = 0;i<this.inventory.size();i++)
                {
                    this.location.items.add(this.inventory.get(i));
                }
                this.location.members.remove(this);
                OOP_RPG.log += this.name + " умир\n";
	}
}
public void takeDamage(int damage)
{
	this.hp -= damage;
}

public void attack(Creature enemy)
{
	if(this.alive)
	{
		enemy.takeDamage(this.damage);
		OOP_RPG.log += this.name + " атаковал " + enemy.name + "[" + enemy.hp + "]\n";
	}

}
public void moveTo(Location location)
    {
            this.location = location;
    }

public void goTo(Location location) throws Exception
    {
    if((Math.abs(this.location.getLocation().x - location.getLocation().x))<= 1 & (Math.abs(this.location.getLocation().y - location.getLocation().y) <=1))
    {
        this.moveTo(location);
    }
    else
        throw new Exception("Невозможно совершить переход");
    }

public void equip(Equipment eq)
{
    if(this.inventory.contains(eq))
    {
        switch(eq.type)
        {
            case "weapon":
                this.weapon = eq;
                this.damage += eq.value;
                break;
            case "armor":
                this.body_armor = eq;
                this.hp += eq.value;
        }
    }
}

public abstract void doSmth(Creature creature);

}