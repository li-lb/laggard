package com.lilb.loser.leetcode;

public class Knapsack {

    static int[] value = {0, 1500, 3000, 2000};//分别对应物品a,b,c，为了方便人机交互，定义第0个物品为0
    static int[] weight = {0, 1, 4, 3};//分别对应物品a,b,c，为了方便人机交互，定义第0个物品为0
    static int bag = 4;//背包容量

    public static void main(String[] args) {
        System.out.println(re_OPT(3, 4));
    }

    /**
     * 动态规划：递归来求最优解
     *
     * @param n   第n个物品
     * @param bag 背包容量
     * @return 最优解
     */
    public static int re_OPT(int n, int bag) {
        if (n == 0) {
            return 0;
        }
        if (bag >= weight[n]) {
            return Math.max(value[n] + re_OPT(n - 1, bag - weight[n]), re_OPT(n - 1, bag));
        } else {
            return re_OPT(n - 1, bag);
        }
    }

}
