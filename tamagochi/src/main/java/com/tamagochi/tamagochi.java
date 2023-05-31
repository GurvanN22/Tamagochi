package com.tamagochi;

public class Tamagotchi implements Runnable {
        static int happiness = 15;
        static int timeUnitPassed = 0;
        
        @Override
        public void run() {
                Thread timer = new Thread(new Tamagochi());
        }
    }