package main;
public class Food extends Item{
public int food /*Колво насыщения*/,heal;
public Food(int food, int heal)
{
	this.food = food;
	this.heal = heal;
}
@Override
public void use(Creature point) {
	point.Eat(this);
	
}
}
