package com.zzc;

public class Face2 {

    public static void main(String[] args) {
        // 1. 1,2,3,1
        //  3
        int[] result = getHigherNum(new int[]{1,2,3,1});
        for (int i : result) {
            System.out.println(result[i]);
        }
    }

    private static int[] getHigherNum(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        if (nums.length == 1) {
            result[0] = 0;
            // DDD
            return result;
        }
        int resultIndex = 0;
        int index = 0;

        while (index < length) {
            int leftIndex = index - 1;
            int rightIndex = index + 1;

            int nowNum = nums[index];
            int leftNum = leftIndex < 0 ? -1 : nums[leftIndex];
            int rightNum = rightIndex >= length ? -1 : nums[rightIndex];

            if (nowNum > leftNum && nowNum >rightNum ) {
                result[resultIndex] = index;
                break;
            }

            index ++;
        }

        return result;
    }

}
