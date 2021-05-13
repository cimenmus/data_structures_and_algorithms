package com.company.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class FacebookExercises {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        //System.out.println("Total: " + getTotalTime(arr));
        //System.out.println("Encripted: " + rotationalCipher("Zebra-493?", 3));
        //System.out.println("Min length: " + substring("dcbefebce", "df"));
        //System.out.println("Min length: " + substring("bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf", "cbccfafebccdccebdd"));

        ArrayList<Sides> arr_1 = new ArrayList<>();
        arr_1.add(new Sides(7, 6, 5));
        arr_1.add(new Sides(5, 7, 6));
        arr_1.add(new Sides(8, 2, 9));
        arr_1.add(new Sides(2, 3, 4));
        arr_1.add(new Sides(2, 4, 3));
        //System.out.println("is balanced: " + countDistinctTriangles(arr_1));ü

        int[] revenues = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] milestones = {100, 200, 500};
        //System.out.println("is balanced: " + Arrays.toString(getMilestoneDays(revenues, milestones)));

        //System.out.println("Middle: " + findEncryptedWord("abcd"));

        int[] denos = {5, 10, 25, 100, 200};
        int[] denos2 = {4, 17, 29};
        System.out.println("Middle: " + canGetExactChange(75, denos2));
    }

    private static int getTotalTime(int[] arr) {
        int total = 0;
        int pointer = arr.length - 1;
        Arrays.sort(arr);
        while(pointer > 0){
            int i1 = arr[pointer];
            int i2 = arr[pointer - 1];
            int sum = i1 + i2;
            total += sum;
            arr[pointer - 1] = sum;
            pointer--;
        }
        return total;
    }

    private static String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        char[] chars = input.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(Character.isLetter(chars[i])){
                int alphabetStart = (int) 'a';
                int alphabetEnd = (int) 'z';
                if (Character.isUpperCase(chars[i])){
                    alphabetStart = (int) 'A';
                    alphabetEnd = (int) 'Z';
                }
                int c = (int) chars[i];
                c = c + rotationFactor;
                c = c % alphabetEnd;
                if (c < alphabetStart){
                    c += alphabetStart - 1;
                }
                chars[i] = (char) c;
            } else if(Character.isDigit(chars[i])){
                int newValue = (Character.getNumericValue(chars[i]) + rotationFactor) % 10;
                // int a=Integer.parseInt(String.valueOf(c));
                chars[i] = String.valueOf(newValue).charAt(0);
            }
        }
        return new String(chars);
    }

    private static int substring(String s, String t) {
        for (int i = 0; i < s.length(); i++){
            for (int j = i + 1; j <= s.length(); j++){
                String subs = s.substring(i, j);
                ArrayList<Character> subsCharsList = new ArrayList<>();
                for (char c: subs.toCharArray()){
                    subsCharsList.add(c);
                }
                ArrayList<Character> tsCharsList = new ArrayList<>();
                for (char c: t.toCharArray()){
                    tsCharsList.add(c);
                }
                if (subsCharsList.containsAll(tsCharsList)){
                    return subs.length();
                }
            }
        }
        return -1;
    }

    private static boolean balancedSplit(int[] arr) {
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--){
            int sumRight = 0;
            for(int j = i; j < arr.length; j++){
                sumRight += arr[j];
            }
            int sumLeft = 0;
            for(int j = 0; j < i; j++){
                if (arr[j] != arr[i]){
                    sumLeft += arr[j];
                }
            }
            if (sumLeft == sumRight){
                return true;
            }
        }
        return false;
    }

    static class Sides{
        int a;
        int b;
        int c;
        Sides(int a,int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static int countDistinctTriangles(ArrayList<Sides> arr) {
        Set<List<Integer>> sideSet = new HashSet<>();
        for (Sides triangle: arr){
            Integer[] sds = new Integer[3];
            sds[0] = triangle.a;
            sds[1] = triangle.b;
            sds[2] = triangle.c;
            Arrays.sort(sds);
            sideSet.add(Arrays.asList(sds));
        }
        return sideSet.size();
    }

    static int[] getMilestoneDays(int[] revenues, int[] milestones) {
        int[] days = new int[milestones.length];
        for (int i = 0; i < milestones.length; i++){
            int sum = 0;
            for (int j = 0; j < revenues.length; j++){
                sum += revenues[j];
                if (sum >= milestones[i]){
                    days[i] = j + 1;
                    break;
                }
            }
        }
        return days;
    }

    static String findEncryptedWord(String s) {
        // Write your code here
        if (s.length() <= 2){
            return s;
        }
        int middleIndex = s.length() / 2;
        if (s.length() % 2 == 0){
            middleIndex--;
        }
        char middle = s.charAt(middleIndex);
        String left = findEncryptedWord(s.substring(0, middleIndex));
        //String right = s.substring(middleIndex + 1);
        String right = findEncryptedWord(s.substring(middleIndex + 1));
        return middle + left + right;
    }

    static boolean canGetExactChange(int targetMoney, int[] denominations) {
        // Write your code here
        if (denominations.length == 0){
            return true;
        }
        int[] denos = new int[denominations.length - 1];
        System.arraycopy(denominations, 0, denos, 0, denominations.length - 1);
        return canGetExactChange(targetMoney % denominations[denominations.length - 1], denos);
    }

    static boolean canGetExactChange2(int targetMoney, int[] denominations) {
        // Write your code here
        Arrays.sort(denominations);
        int remaining = targetMoney;
        for(int i = denominations.length - 1; i >= 0; i--){
            remaining %= denominations[i];
            if (remaining == 0){
                return true;
            }
        }
        return false;
    }

}
