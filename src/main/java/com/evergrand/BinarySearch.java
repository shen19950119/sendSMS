package com.evergrand;

import java.util.Arrays;
import java.util.List;

/**
 * @author 申燕栋
 * @create 2020-11-19 23:04
 */
public class BinarySearch {
    //告诉你一个长度为n的数组
    public static void main(String[] args) {
        int [] arr = {2,1,3,5,6,7,8,9,10};
        int[] ints = binarySearch(arr);
        System.out.println(ints.toString());
	//随便加一行注释回忆一下
//再来一行
    }

    private static int [] binarySearch(int [] arr){
        Arrays.sort(arr);
        int start = arr[0];
        int high = arr.length - 1;
        int end = arr[high];
        int n = (start + end ) / 2;

        List<int[]> ints = Arrays.asList(arr);
        int i = ints.indexOf(n);
        int[] arr1 = new int[2];
        while(start < end) {
            if (i < high / 2) {
                end = n - 1;
            } else {
                start = n + 1;
            }
           arr1 = new int []{start,end};
        }
        return arr1;
    }
}
