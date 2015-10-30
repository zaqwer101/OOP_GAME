package main;
public abstract class Item {
	public boolean usable;
	public String name;
        public int value;
	public abstract void use(Creature point);
}
