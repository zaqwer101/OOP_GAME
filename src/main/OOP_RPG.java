/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Runtime;
import static java.lang.Runtime.getRuntime;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author zaqwer
 */
public class OOP_RPG 
{
	public static String log = "";
        
	public static void handler(String _msg, Person dude)
	{
		String a[] = _msg.split(" ");
                for(int i=0;i<a.length;i++)
                {
                    a[i] = a[i].toLowerCase();
                }
		switch(a[0])
		{
		case "ешь":
		{
                    switch (a[1])
                    {
                    case "макароны":
			dude._food += 5;
                    	break;
                    }
                    break;
		}
		case "состояние":
                    System.out.println(dude.name + " " + dude._food + " едениц сытости\nЖив:"+dude.alive+"\nХочет есть:"+dude.wantToEat+"\nВозраст:"+dude.age+"\nХП:" + dude.hp);
                    break;
		case "атакуй":
                    if(dude.location.members.get(Integer.parseInt(a[1])).alive)
                	dude.attack(dude.location.members.get(Integer.parseInt(a[1])));
                    else
			System.out.println("Ему уже хватит");
                    break;
		case "лог":
                    System.out.println(log);
                    break;
                case "уровень":
                    if(a[1].equals("локации"))
                    {
                        System.out.println(dude.location.level);
                    }
                    break;
                case "список":
                    if(a[1].equals("врагов"))
                    {
                        for(int i=0;i<dude.location.members.size();i++)
                        {
                            System.out.print("("+i+")"+dude.location.members.get(i).name +"[" +dude.location.members.get(i).hp+"] ");
                        }
                    }
                    break;
                case "иди":
                {
                    System.out.println("Переходим в локацию...");
                    try 
                    {
                        dude.goTo(World.world[Integer.parseInt(a[1])][Integer.parseInt(a[2])]);
                        System.out.println("Локация ("+a[1] + ","+a[2]+"):");
                        for(int i=0;i<dude.location.members.size();i++)
                        {
                            System.out.print("("+i+")"+dude.location.members.get(i).name +"[" +dude.location.members.get(i).hp+"] ");
                        }
                        System.out.println();
                    }
                    catch (Exception ex) 
                    {
                        System.out.println("Невозможно перейти");
                    }
                    break;
                }
                    
		}

		
	}
    public static void main(String[] args) throws IOException
    {
        log = "";
        System.out.println("Загрузка...");
        Scanner in = new Scanner(System.in);
        //Создание мира
        World.init();
        Person Vasya =  new Person("Вася",10,100, World.world[0][0]);
        System.out.println("Внимаю твоим командам, великий!");
        while(Vasya.alive)
	{
            World.update(Vasya);
            String x = in.nextLine();
            handler(x,Vasya);  
            Vasya.Update();
            System.out.println(log);
        }
        System.out.println("Game over");
    }

}
