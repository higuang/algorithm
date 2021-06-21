package org.yray.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 就是两个链表表示的。数相加，这样就可以实现两个很大的数相加了，无需考虑数值 int ，float 的限制了。
 *input: (2->4->3) + (5->6->4)
 * output: 7->0->8
 * exp: 342+456=807
 *  @author  lyg
 */
public class Q3_LongestSubstring {

    public static void main(String[] args) {
        String str="abdnca1232234543321sdfeqs1209876543210iuytrewq2";
        System.out.println(JSONObject.toJSONString(exec(str)));
        System.out.println(JSONObject.toJSONString(lengthOfLongestSubstring(str)));
    }

    private static int exec(String str)
    {
        int result=0;
        int[] temp=new int[500];
        Arrays.fill(temp,-1);
        int begin=0;
        for(int i=0;i<str.length();i++)
        {
            char tc=str.charAt(i);
            if(temp[tc]>-1)
            {
                begin=Math.max(temp[tc],begin);
            }
            result= Math.max(i-begin+1,result);
            temp[tc]=i+1;
        }
        return result;

    }

    public static  int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;//（下标 + 1） 代表 i 要移动的下个位置
        }
        return ans;
    }
    public static  int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);//下标 + 1 代表 i 要移动的下个位置
        }
        return ans;
    }
    public static  int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;//保存当前得到满足条件的子串的最大值
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++) //之所以 j<= n，是因为我们子串是 [i,j),左闭右开
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i); //更新 ans
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();//初始化 hash set
        for (int i = start; i < end; i++) {//遍历每个字符
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false; //判断字符在不在 set 中
            set.add(ch);//不在的话将该字符添加到 set 里边
        }
        return true;
    }
}
