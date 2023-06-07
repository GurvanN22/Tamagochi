package com.tamagochi;

import java.util.Timer;
import java.util.TimerTask;

public class MinuteTimer implements Runnable {
    @Override
    public void run() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int minutes = 0;

            @Override
            public void run() {
                System.out.println("Minute: " + minutes);
                minutes++;
            }
        };

        // Schedule the task to run every minute (60,000 milliseconds)
        timer.scheduleAtFixedRate(task, 0, 6000);
    }

    public static void main(String[] args) {
        MinuteTimer minuteTimer = new MinuteTimer();
        Thread thread = new Thread(minuteTimer);
        thread.start();
    }
}
