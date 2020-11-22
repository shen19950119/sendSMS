package com.evergrand;

import java.util.Arrays;
import java.util.List;

/**
 * @author 申燕栋
 * @create 2020-11-20 0:05
 */
public class solution {


        int missingNumber(int [] num) {
            List<int[]> nums = Arrays.asList(num);
            int i=0;
            int j=nums.size()-1;
            while(i<=j)
            {
                int mid=(i+j)/2;
                if(num[mid]==mid)
                {
                    if(mid!=nums.size()-1)
                    {
                        i=mid+1;
                    }
                    else
                    {
                        return mid+1;
                    }
                }
                else if(mid==0)
                {
                    return 0;
                }
                else if(num[mid-1]==mid-1 && mid>0)
                {
                    return mid;
                    // break;
                }
                else
                {
                    j=mid-1;
                }
            }
            return num[i]-1;
        }
    }

