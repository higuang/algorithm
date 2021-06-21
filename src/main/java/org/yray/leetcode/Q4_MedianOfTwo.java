package org.yray.leetcode;

import java.util.Arrays;

/**
 * 已知两个有序数组，找到两个数组合并后的中位数。要求O(log(m+n))
 */
public class Q4_MedianOfTwo {
    public static void main(String[] args) {

        double[] ints1=new double[]{1,9};
        double[] ints2=new double[]{2,6};
        //System.out.println(exec(ints1,ints2));
        //System.out.println(execByMergeSort(ints1,ints2));
        //System.out.println(findMedianSortedArrays(ints1,ints2));
        ints1=new double[]{10,14};
        ints2=new double[]{3,4,5,6,7,9,12,13};
        System.out.println(exec(ints1,ints2));
        System.out.println(execByMergeSort(ints1,ints2));
        System.out.println(findMedianSortedArrays(ints1,ints2));
    }

    private static double exec(double[] ints1,double[] ints2)
    {
        //首先确保，短的数组在前面
        if(ints1.length>ints2.length)
        {
            return exec(ints2,ints1);
        }
        //各是1个的情况，独立处理
        if(ints1.length==1&&ints2.length==1)
            return (ints1[0]+ints2[0])/2;
        //最前面只有一个的情况，独立处理,偶数的情况
        if(ints1.length==1&&ints2.length%2==0)
        {
            return Math.min(ints2[ints2.length/2],Math.max(ints2[ints2.length/2-1],ints1[0]));
        }
        //奇数情况
        if(ints1.length==1&&ints2.length%2==1)
        {
            return (ints2[ints2.length/2]+(ints2[ints2.length/2]>ints1[0]?Math.max(ints1[0],ints2[ints2.length/2-1]):Math.min(ints1[0],ints2[ints2.length/2+1])))/2;
        }
        if(ints1.length==2&&ints2.length==2)
        {
            return (Math.max(ints1[0],ints2[0])+Math.min(ints1[1],ints2[1]))/2;
        }

        int index1=ints1.length/2-1;
        int index2=ints2.length/2-1;
        for(int i=0;i<ints1.length/2;i++)
        {
            if(ints1[index1]>ints2[index2])
            {
                index2++;
            }
            else {
                index1++;
            }
        }
        double[] new1=Arrays.copyOfRange(ints1,index1==0?index1:index1-1,index1+1);
        if((ints1.length+ints2.length)%2==0&&new1.length==1)
        {
            double[] new2=Arrays.copyOfRange(ints2,index2>0?index2-1:index2,index1==0?index2+2:index2+1);
            return exec(new1,new2);
        }
        double[] new2=Arrays.copyOfRange(ints2,index2,index2+2);
        return exec(new1,new2);



    }

    //按二路归并思想实现
    private static double execByMergeSort(double[] ints1,double[] ints2)
    {
        int mid=(ints1.length+ints2.length)/2+1;
        int pass=0,j=0,i=0;
        double findMe=0;
        double lastMe=0;
        while (pass<mid)
        {
            if(i==ints1.length||ints1[i]>ints2[j])
            {
                lastMe=findMe;
                findMe=ints2[j++];
            }
            else
            {
                lastMe=findMe;
                findMe=ints1[i++];
            }
            pass++;

        }

        if((ints1.length+ints2.length)%2==1)
        {
            return findMe;
        }

        return ((findMe+lastMe)/2);
    }

    public static double findMedianSortedArrays(double[] A, double[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B,A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j-1] > A[i]){ // i 需要增大
                iMin = i + 1;
            }
            else if (i != 0 && j != n && A[i-1] > B[j]) { // i 需要减小
                iMax = i - 1;
            }
            else { // 达到要求，并且将边界条件列出来单独考虑
                double maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; } // 奇数的话不需要考虑右半部分

                double minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }
}
