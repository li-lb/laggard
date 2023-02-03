package com.lilb.loser.practice;

import java.util.stream.Stream;

public class JdkTest {
    public static void main(String[] args) {
        long size1 = Stream.ofNullable(null).count();
        System.out.println(size1);
        long size2 = Stream.ofNullable("").count();
        System.out.println(size2);


        int i = 7;
        System.out.println(i | 1);

    }


}
