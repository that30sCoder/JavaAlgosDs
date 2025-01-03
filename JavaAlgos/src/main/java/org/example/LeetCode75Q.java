
package org.example;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;
import java.util.stream.Collectors;

public class LeetCode75Q {
    public static void main(String[] args) {
        //find  difference between two arrays
        //findDifference(new int[]{1, 2, 3,3}, new int[]{1, 1, 2,2});
        //1732. Find the Highest Altitude
        //largestAltitude(new int[]{44,32,-9,52,23,-50,50,33,-84,47,-14,84,36,-62,37,81,-36,-85,-39,67,-63,64,-47,95,91,-40,65,67,92,-28,97,100,81});
        //443. String Compression
        //      char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        //    System.out.println("Count of charcters"+ compress(chars));

        //643.Maximum Average subarray1
        double average = findMaxAverage(new int[]{-1}, 1);
        System.out.println("Maximum possible average of subarray" + average);

    }


    public static double findMaxAverage(int[] nums, int k) {


        double sum = 0.0;
        for (int j = 0; j < k; j++) {
            sum = sum + nums[j];
        }
        double max = sum;


        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }


        return max / k;
    }


    public static int compress(char[] chars) {
        int leftPointer = 0;
        int modPointer = 0;
        while (leftPointer < chars.length) {
            int count = 0;
            char currentChar = chars[leftPointer];
            while (leftPointer < chars.length && chars[leftPointer] == currentChar) {
                count++;
                leftPointer++;
            }
            chars[modPointer++] = currentChar;


            if (count > 1) {
                for (char size : Integer.toString(count).toCharArray()) {
                    chars[modPointer] = size;
                    modPointer++;
                }
            }
        }
        return modPointer;


    }


    public static int largestAltitude(int[] gain) {
        int output = 0;
        int i = 0, sum = 0;
        while (i < gain.length) {
            sum = sum + gain[i];
            output = Math.max(sum, output);
            i++;
        }
        return output;

    }


    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> li1 = new ArrayList<>();
        List<Integer> li2 = new ArrayList<>();
        List<List<Integer>> li = new ArrayList<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }

        for (int num : set1) {
            if (!set1.contains(num)) {
                li1.add(num);
            }
        }

        for (int num : set2) {
            if (!set2.contains(num)) {
                li2.add(num);
            }
        }

        li.add(li2);
        li.add(li1);
        return li;
    }


}
