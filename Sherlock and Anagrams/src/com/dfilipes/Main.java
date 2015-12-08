package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        int nTestCases = in.nextInt();
        in.nextLine();

        while (nTestCases > 0) {
            String sequence = in.nextLine();
            HashMap<String, Integer> substrings = new HashMap<>();
            int counter = 0;

            for (int i = 0; i < sequence.length(); i++) {
                for (int j = i + 1; j <= sequence.length(); j++) {
                    StringBuilder sequenceSubstring = new StringBuilder(sequence.substring(i, j));
                    String normal = sequenceSubstring.toString();
                    char[] normalArray = normal.toCharArray();
                    Arrays.sort(normalArray);
                    normal = new String(normalArray);

                    if (substrings.containsKey(normal)) {
                        substrings.put(normal, substrings.get(normal) + 1);
                    } else {
                        substrings.put(normal, 1);
                    }
                }
            }

            for (Map.Entry<String, Integer> entry : substrings.entrySet()) {
                if (entry.getValue() > 1) {
                    int n = entry.getValue();
                    counter += (n * (n - 1)) / 2;
                }
            }

            System.out.println(counter);

            nTestCases--;
        }
    }
}
