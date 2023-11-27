package com.lilb.leetcode;

public class Frog {
    public static int frog(int n) {
        int[] arr = new int[1000];
        if (n <= 2) {
            return n;
        } else {
            if (arr[n] == 0) {
                arr[n] = frog(n - 1) + frog(n - 2);
            }
            return arr[n];
        }
    }

    public static int frog2(int n) {
        if (n <= 2)
            return n;

        int f1 = 1;
        int f2 = 2;
        int sum = 0;

        for (int i = 3; i <= n; i++) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 30;
        int frog = frog2(n);
        System.out.println(frog);

    }
}
