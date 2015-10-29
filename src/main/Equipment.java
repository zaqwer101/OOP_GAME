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
public abstract class Equipment extends Item{
    public String type; //Тип экипировки
    public int value; //Сколько статов даёт
    @Override
    public void use(Creature point) {
        this.equip(point);
    }
    public abstract void equip(Creature dude);
    public abstract void unequip(Creature dude);
}
