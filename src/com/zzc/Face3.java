package com.zzc;

import java.util.Arrays;

public class Face3 {

    public static String transform(String input) {
        int length = input.length();
        if (length <= 1) {
            return input;
        }

        char[] temptChar = new char[length];

        char beforeChar = input.charAt(0);
        int resultIndex = 0;
        temptChar[resultIndex++] = beforeChar;
        int resultLength = 1;
        for (char c : input.toCharArray()) {
            if (c != beforeChar) {
                temptChar[resultIndex++] = c;
                resultLength++;
            }
            beforeChar = c;
        }

        char[] resultCharArray = new char[resultLength];
        if (resultLength >= 0) {
            System.arraycopy(temptChar, 0, resultCharArray, 0, resultLength);
        }

        return String.valueOf(resultCharArray);
    }

    public static void main(String[] args) {
        System.out.println(Face3.transform("aa"));


        System.out.println(Face3.getResult(3));

    }

    private static int getResult(int n ) {
        if (n == 6) {
            return 3;
        }
        return 3*getResult(n + 1);
    }

}
