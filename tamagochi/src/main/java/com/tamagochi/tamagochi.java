package com.tamagochi;

public class Tamagochi {

    public static void main(String[] args) {
        Thread timer = new Thread(new MinuteTimer());
        timer.start();
    }
}