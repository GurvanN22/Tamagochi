package com.tamagochi;

import java.io.Serializable;
import java.util.Random;

public class Tamagochi implements Serializable , Save{
    public String name;
    public boolean IsNew = true;
    public int age = 0;
    public int hungerDay = 0;  
    public int happiness = 15;
    public boolean Isclean = true;
    public boolean IsSick = false;
    public boolean IsEgg = true;
    public String state = "egg";
    public boolean IsDead = false;
    public int playingTime = 0; 
    public boolean foodTime = true;   
    
    public Tamagochi() {
    }
    
    public void grow () {
        System.out.print("\033[H\033[2J");       
        if(foodTime == false && hungerDay == 0 && state != "egg") {       
            happiness -= 5;
            hungerDay = 5;
        } else if(foodTime == false && state != "egg") {
            hungerDay *= 2;
            happiness -= hungerDay;
        } else {
            hungerDay = 0;
        }
        
        
        playingTime = 0;
        foodTime = false;
        
        if(Isclean == false) {
            this.happiness -= 3;
        }
        if(hungerDay == 0) {
            Isclean = false;
        }
        
        if(IsSick == true) {
            state = "dead";
            IsDead = true;
        }
        if(happiness <= 0) {
            state = "dead";
            IsDead = true;
        }
        if (IsDead != true) {
            if(age >= 1 && state != "baby" && state != "adult" && state != "old") {
                IsEgg = false;
                state = "baby";
            } else if(age >= 5 && happiness >= 40 && state != "adult" && state != "old") {
                state = "adult";
            } else if(age >= 20 && state == "adult" && state != "old") {
                state = "old";
                Random rand = new Random(); 
                if(rand.nextInt(3) == 3) {
                    IsSick = true;
                } 
            } else if(age >= 25 && state == "old") {
                state = "dead";
                IsDead = true;
            }
        }
        age++;
    }
    
    public void feed () {
        foodTime = true;
        hungerDay = 0;
    }
    
    public void  play() {
        if(playingTime < 3) {
            if (this.happiness + 2 > 50) {
                this.happiness = 50;
            } else {
                this.happiness += 2;
            }
            playingTime++;
        }
        
    }
    
    public void wash() {
        Isclean = true;
    }
    
    public void heal() {
        IsSick = false;
    }
    
}

