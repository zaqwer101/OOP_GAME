/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author zaqwer
 */
public class Weapon extends Equipment
{
    public Weapon(int level, String name)
    {
        this.type = "weapon";
        this.name = name;
        this.value = level * 10 + 5;
        this.name = this.name + "["+this.value+"]";
    }
    
    @Override
    public void equip(Creature dude)
    {
        dude.equip(this);
    }

    @Override
    public void unequip(Creature dude)
    {
        dude.unequip(this);
    }
    
}
