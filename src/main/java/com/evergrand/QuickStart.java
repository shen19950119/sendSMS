package com.evergrand;

import java.util.Arrays;

/**
 * @author 申燕栋
 * @create 2020-11-14 15:52
 */
public class QuickStart {
    public static void main(String[] args) {
        int [] arr = {22,10,30,9,35,5};
        qsort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void qsort(int [] arr,int start,int end){
        int mid = 0;
        if(start >= end) {
            return;
        }else {
            //获取分界点
            mid = getIndex(arr,start ,end);
            //分界点左边排序
            qsort(arr,start,mid-1);//递归，左右两边继续执行下面的代码
            //分界点右边排序
            qsort(arr,mid + 1,end);//递归
        }
    }
    public static int getIndex(int [] arr,int start,int end){
        //从右到左遍历
        int midValue = arr[start];//初始中间值设为第一个元素arr[0]
        while(start < end){
            while(arr[end] > midValue && start < end){//最后一个元素比中间值大，就往前移一位,初始中间值为第一位就从后往前，反之则反之
                end --;
            }
            //一旦后面出现比中间值小的值，将该值放入0的位置
            arr[start] = arr[end];
//            arr[end] = midValue;//这行可有可无
            //从左往右遍历
            while(arr[start] <= midValue && start <  end){
                start ++;
            }
            //如果前面出现值比中间值大的，将该值放入中间值的原来位置，换方向比较
            arr[end] = arr[start];
//            arr[start] = midValue;//这行可有可无
        }
        arr[start] = midValue;//需要把中间值落地，如果省去可有可无那行
        return start;
}
}
