package com.collection;

import javax.swing.*;
import java.util.*;

public class Main {
    private static Random random = new Random();
    public static void main (String[] args){
        List<Integer> arrayA = generateArrayA();

//        for (int i: arrayA){
//            System.out.println(i);
//        }

        System.out.println("Size of A: "+ arrayA.size());

        Set<Integer> arrayB = generateArrayB(arrayA);
        System.out.println("Size of B: "+ arrayB.size());

        Map<Integer, Integer> frequency = countA(arrayA);
//        for(Map.Entry<Integer, Integer> i: frequency.entrySet()){
//            System.out.println("Number: " + i.getKey() + " count: " + i.getValue());
//        }

        findMostFrequency(frequency);

        List<Integer> arrayC = generateArrayC();
        findDuplicate(arrayB, arrayC);

    }

    public static List<Integer> generateArrayA(){
        List<Integer> A = new ArrayList<>();
        for (int i =0; i< 100000; i++){
            int number = random.nextInt(2001);
            A.add(number);
        }
        return A;
    }

    public static Set<Integer> generateArrayB(List<Integer> arrayA){
        Set<Integer> B = new HashSet<>();
        for (Integer i: arrayA){
            B.add(i);
        }
        return B;
    }

    public static Map<Integer, Integer> countA(List<Integer> arrayA){
        Map<Integer, Integer> frequency = new HashMap<>();
        for (Integer i: arrayA){
            frequency.put(i, frequency.getOrDefault(i, 0) +1);
        }
        return frequency;
    }

    public static void findMostFrequency(Map<Integer, Integer> count){
        int maxCount= 0;
        int mostFrequentNumber = -1;

        for (Map.Entry<Integer, Integer> i: count.entrySet()){
            if (i.getValue() > maxCount){
                maxCount = i.getValue();
                mostFrequentNumber = i.getKey();
            }
        }

        System.out.println("Most frequent number: " + mostFrequentNumber);
        System.out.println("Max count: " + maxCount);
    }

    public static List<Integer> generateArrayC(){
        List<Integer> C = new ArrayList<>();

        for (int i =0; i<10000; i++){
            int number = random.nextInt(1000, 3000);
            C.add(number);
        }

        return C;
    }

    public static void findDuplicate(Set<Integer> arrayB, List<Integer> arrayC){
        for (Integer c: arrayC){
            if (c >= 1000 || c <= 2000){
                System.out.println( c + " is duplicated");
            }
        }
    }
}