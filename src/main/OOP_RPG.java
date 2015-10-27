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
		String msg = a[0];
		String arg1;
                msg = msg.toLowerCase();
		try{
			arg1 = a[1];
		}catch(Throwable t)
		{
			arg1 = "lol";
		}
		String sayed = "";
		for(int i=1;i<a.length;i++)
		{
			sayed += a[i] + " ";
		}
		switch(msg)
		{
		case "ешь":
		{
			switch (arg1)
			{
			case "макароны":
				dude._food += 5;
				break;
			}
			break;
		}
		case "скажи":
		{
			System.out.println(dude.Say(sayed));
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
		}

		
	}
    public static void main(String[] args) throws IOException
    {
        System.out.println("Загрузка...");
        Scanner in = new Scanner(System.in);
        //Создание мира
        World.init();
        Person Vasya =  new Person("Вася",10,100, World.world[0][0]);
        System.out.println("Внимаю твоим командам, великий!");
        while(Vasya.alive)
	{
            
            String x = in.nextLine();
            handler(x,Vasya);  
            System.out.println("Загрузка...");
            Vasya.Update();
            World.update(Vasya);
            System.out.println("Готово!");
        }
        System.out.println("Game over");
    }

}
