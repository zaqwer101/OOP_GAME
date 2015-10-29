/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.ArrayList;

/**
 *
 * @author zaqwer
 */
public class Location 
{
    public int level;
    public ArrayList<Item> items;//Предметы, лежащие в локации
    public ArrayList<Creature>  members;
    private int x,y; //Координаты
    
    public Location(int x, int y)
    {
        this.x = x; this.y = y;
        this.items = new ArrayList<Item>();
        this.level = Math.abs((this.x + this.y)/2); // Определение уровня локации
        this.members = new ArrayList<Creature>();
    }
    public Point getLocation()
    {
        return new Point(this.x, this.y);
    }
    public void addCreature(Creature creature)
    {
        this.members.add(creature);
    }
}

