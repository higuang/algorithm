package org.yray.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;

/**
 * 就是两个链表表示的。数相加，这样就可以实现两个很大的数相加了，无需考虑数值 int ，float 的限制了。
 *input: (2->4->3) + (5->6->4)
 * output: 7->0->8
 * exp: 342+456=807
 *  @author  lyg
 */
public class Q2_AddTwoNum {

    public static void main(String[] args) {
        LinkedList<Integer> tempLinked1=new LinkedList<>();
        tempLinked1.push(2);
        tempLinked1.push(4);
        tempLinked1.push(3);
        LinkedList<Integer> tempLinked2=new LinkedList<>();
        tempLinked2.push(5);
        tempLinked2.push(6);
        tempLinked2.push(4);
        System.out.println(JSONObject.toJSONString(exec(tempLinked1,tempLinked2)));
    }

    private static LinkedList<Integer> exec(LinkedList<Integer> one,LinkedList<Integer> two)
    {
        LinkedList<Integer> result=new LinkedList<>();

        int size=one.size();
        Integer carry=0;
        for (int  i=0;i<size;i++)
        {

            Integer o1=one.poll();
            Integer o2=two.poll();

            if(i==0) {
                result.push((o1 + o2) % 10);
            }
            else {
                result.push((o1 + o2) % 10+carry);
            }
            carry=(o1+o2)/10;
        }
        if(carry>0)
        {
            result.push(carry);
        }


        return result;
    }

}
