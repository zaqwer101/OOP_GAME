/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Random;

/**
 *
 * @author zaqwer
 */
public  class World 
{
    //private static boolean initialized = false, filled = false;
    public static Random rnd;
    public static Location[][] world;
    
    public static void init()
    {
        rnd = new Random();
        world = new Location[100][100];
        for(int i=0;i<100;i++)
        {
            for(int f=0;f<100;f++)
            {
                world[i][f] = new Location(i,f);
                for(int ii=0;ii<rnd.nextInt(6);ii++)
                {
                    EOgre tmp = new EOgre("Огр"+ii,world[i][f]);
                    world[i][f].addCreature(tmp);
                }
            }
        }
        
    }
    
    
    public static void update(Person dude)
    {
        for(int i=0;i<world[dude.location.getLocation().x][dude.location.getLocation().y].members.size();i++)
        {
            world[dude.location.getLocation().x][dude.location.getLocation().y].members.get(i).doSmth(dude); 
        }
    }
}
