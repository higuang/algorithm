package org.yray.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组和一个目标和，从数组中找两个数字相加等于目标和，输出这两个数字的下标。每个元素只能使用一次
 *  @author  lyg
 */
public class Q1_TwoSum {

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(twoSum(new int[]{2,7,13,15},9)));
    }

    private static int[] twoSum(int[] ints,int targe)
    {
        int[] result=new int[2];
        Map<Integer,Integer> temp=new HashMap<>();
        for (int i=0;i<ints.length;i++)
        {
            if(temp.get(ints[i])!=null)
            {
                result[0]=i;
                result[1]=temp.get(ints[i]);
                break;
            }
            temp.put(targe-ints[i],i);
        }
        return result;
    }

}
