package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        HashMap<Integer, Integer> letterCounter = new HashMap<>();
        String sequence = in.nextLine();

        for (char letter : sequence.toCharArray()) {
            int index = letter - 'a';
            if (letterCounter.containsKey(index)) {
                letterCounter.put(index, letterCounter.get(index) + 1);
            } else {
                letterCounter.put(index, 1);
            }
        }

        int minFrequency = Integer.MAX_VALUE;
        int minFrequencyCounter = 0;
        for (Map.Entry<Integer, Integer> entry : letterCounter.entrySet()) {
            if (entry.getValue() < minFrequency) {
                minFrequency = entry.getValue();
                minFrequencyCounter = 1;
            } else if (entry.getValue() == minFrequency) {
                minFrequencyCounter++;
            }
        }

        int cuts = 0;
        HashSet<Integer> frequencySet = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : letterCounter.entrySet()) {
            cuts += Math.abs(entry.getValue() - minFrequency);
            frequencySet.add(entry.getValue());
        }

        if (cuts <= 1 || (minFrequencyCounter == 1 && frequencySet.size() == 2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
