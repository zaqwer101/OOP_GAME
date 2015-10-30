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
public class EOgre extends Enemy {

    public EOgre(String name, Location location) 
    {
        super(name, location);
        if(World.rnd.nextInt(100)>=70)
        {
            if(World.rnd.nextInt(100)>=50)
                this.inventory.add(new Weapon(location.level,"Бальшая дубина"));
            else
                this.inventory.add(new Armor(location.level, "Бальшая броня"));
        }
        this.hp = 20 + 30 * location.level;
        this.damage = 1 + 5 * location.level;
        
    }
    
}
