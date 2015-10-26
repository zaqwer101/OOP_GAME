package main;
public abstract class Item {
	public boolean usable;
	public String name;
	public abstract void use(Creature point);
}
