package com.dfilipes;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    Scanner in = new Scanner(new File("input"));
        int nTestCases = in.nextInt();

        while (nTestCases > 0) {
            in.nextLine();
            String testString = in.nextLine();

            TreeSet<String> substringList = new TreeSet<>();
            HashSet<String> helper = new HashSet<>();
            for (int i = 0; i < testString.length(); i++) {

                for (int j = i; j < testString.length(); j++) {
                    helper.add(testString.substring(i, j + 1));
                    /*if (!substringList.contains(substring)) {
                        substringList.add(substring);
                    }*/
                }

            }
            substringList.addAll(helper);

            int k = in.nextInt();

            int positionCounter = 0;
            for (String substring : substringList) {
                if (positionCounter + substring.length() >= k) {
                    System.out.println(substring.charAt((k - positionCounter) - 1));
                    break;
                }

                positionCounter += substring.length();
            }

            System.out.println(substringList);

            nTestCases--;
        }
    }
}
