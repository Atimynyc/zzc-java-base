package com.zzc;

import java.util.ArrayList;

public class Face {

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        // x的负n次方就是 x分之一的 n - 1次方 乘以 x分之一
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double result = pow(x, n - 1);
        return result;
    }

    private static double pow(double x, int n) {
        if (n <= 0) {
            return x;
        }
        x = x * x;
        return pow(x, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(myPow(-5, 3));
    }


}
