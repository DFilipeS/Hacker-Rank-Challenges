package com.dfilipes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();

        String hoursString = time.substring(0, time.indexOf(':'));
        int hours = Integer.decode(hoursString);

        if (time.endsWith("AM")) {
            time = time.replace("AM", "");

            if (hours == 12) {
                System.out.println("00" + time.substring(time.indexOf(':')));
            } else {
                System.out.println(time);
            }
        } else if (time.endsWith("PM")) {
            time = time.replace("PM", "");

            if (hours == 12) {
                System.out.println(time);
            } else {
                hours += 12;
                System.out.print(hours + time.substring(time.indexOf(':')));
            }
        } else {
            System.out.println("Error: Wrong time format.");
        }
    }
}
