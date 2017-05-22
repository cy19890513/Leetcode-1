package com.stevesun.solutions;

import java.util.Arrays;

/**Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 For example, given array S = {-1 2 1 -4}, and target = 1.
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/

public class _16 {

    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int len = nums.length;
        if(len < 3){
            int sum = 0;
            for(int i : nums){
                sum += i;
            }
            return sum;
        }
        int sum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length-2; i++){
            int left = i+1, right = nums.length-1;
            while(left < right){
                int thisSum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - thisSum) < Math.abs(target - sum)) {
                    sum = thisSum;
                    if(sum == target) return sum;
                }
                else if(target > thisSum){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return sum;
    }

}
