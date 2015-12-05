package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("input"));
        TreeMap<Integer, Integer> listA = new TreeMap<>();
        TreeMap<Integer, Integer> listB = new TreeMap<>();

        int n = kb.nextInt();
        for (int i = 0; i < n; i++) {
            int val = kb.nextInt();
            if (!listA.containsKey(val)) {
                listA.put(val, 1);
            } else {
                listA.put(val, listA.get(val) + 1);
            }
        }

        int m = kb.nextInt();
        for (int i = 0; i < m; i++) {
            int val = kb.nextInt();
            if (!listB.containsKey(val)) {
                listB.put(val, 1);
            } else {
                listB.put(val, listB.get(val) + 1);
            }
        }

        StringBuilder missingNumbers = new StringBuilder();
        for (Integer key : listB.keySet()) {
            if (listA.containsKey(key)) {
                if (listA.get(key).intValue() != listB.get(key).intValue()) {
                    missingNumbers.append(key + " ");
                }
            } else {
                missingNumbers.append(key + " ");
            }
        }

        System.out.println(missingNumbers.toString().trim());
    }
}
