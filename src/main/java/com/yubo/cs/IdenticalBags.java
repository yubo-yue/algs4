package com.yubo.cs;

import java.util.Arrays;

public class IdenticalBags {
    public static long makeBags(long[] candy, long bagSize) {
        Arrays.sort(candy);
        if (candy.length >= bagSize) {
            long pickedSum = 0L;
            long min = Long.MAX_VALUE;
            boolean flag = true;
            for (int i = 1; i <= bagSize; i++) {
                min = Math.min(min, candy[Long.valueOf(candy.length - i).intValue()]);
                pickedSum += candy[Long.valueOf(candy.length - i).intValue()];
                flag &= (candy[Long.valueOf(candy.length - i).intValue()] % bagSize == 0);

            }
            if (flag) {
                return pickedSum / 3;
            }
            return min;
        }

        long max = candy[candy.length - 1];

        return max / bagSize;
        //100, 200, 300 (6) ->

    }

    public static void main(String[] args) {
        long[] case1 = {10, 11, 12};
        long[] case2 = {10, 11, 12, 1, 2, 3};
        long[] case3 = {100};
        long[] case4 = {100, 200, 300};
        long res1 = IdenticalBags.makeBags(case1, 3);
        long res2 = IdenticalBags.makeBags(case2, 3);
        long res3 = IdenticalBags.makeBags(case3, 7);
        long res4 = IdenticalBags.makeBags(case4, 6);

        System.out.printf("case 1 = %d, case 2 = %d, case 3 = %d\n", res1, res2, res3);
        System.out.printf("case 4 = %d\n", res4);
    }
}
