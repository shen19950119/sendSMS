package com.evergrand;

/**
 * @author 申燕栋
 * @create 2020-11-15 16:24
 */
public class TestArrayAdd {
    public static void main(String[] args) {
        int [] arr = {1,3,5,6,7,9};
        int target = 10;
        int [] arr1 = twoSum(arr,target);
        System.out.println(arr1[0] +"==="+ arr1[1]);
    }
    public static int[] twoSum(int[] nums, int target) {
        int [] arr = new int[2];
        a:
        for(int i = 0;i < nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                     arr = new int []{i,j};
                     break a;
                }
            }
        }
        return arr;
    }
}
