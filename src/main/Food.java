package main;
public class Food extends Item
{
    public int food /*Колво насыщения*/,heal;
    public Food(int heal)
    {
            this.food = 5;
            this.heal = heal;
    }
    @Override
    public void use(Creature point) 
    {
            point.Eat(this);
            point.inventory.remove(this);
    }
}
