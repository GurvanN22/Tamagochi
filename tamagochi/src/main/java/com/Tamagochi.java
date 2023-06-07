package com;

import java.io.Serializable;

public class Tamagochi implements Serializable{
    public String name;
    public int age;
    public int health;
    public int hunger;
    public int happiness;
    public int hygiene;
    public boolean IsSick;
    
    public Tamagochi(String name) {
        this.name = name;
        this.age = 0;
        this.health = 100;
        this.hunger = 50;
        this.happiness = 15;
        this.hygiene = 100;
        this.IsSick = false;
    }

}

