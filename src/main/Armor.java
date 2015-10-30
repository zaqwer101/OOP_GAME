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
public class Armor extends Equipment
{
    public Armor(int level, String name)
    {
        this.type = "armor";
        this.name = name;
        this.value = level * 30 + 50;
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
