package com.collection;

import java.util.*;

public class Bai3 {
}

//class Solution {
//    public List<String> topKFrequent(String[] words, int k) {
//        Map<String, Integer> wordMap = new HashMap<>();
//        for (String word: words){
//            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
//        }
//
//        List<String> result = new ArrayList<>(wordMap.keySet());
//
//        result.sort((a,b)-> {
//            int freqCompare = wordMap.get(b) - wordMap.get(a);
//            if (freqCompare == 0){
//                return a.compareTo(b);
//            }
//
//            return  freqCompare;
//        });
//        return result.subList(0,k);
//    }
//}