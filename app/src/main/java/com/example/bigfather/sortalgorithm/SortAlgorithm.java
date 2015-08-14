package com.example.bigfather.sortalgorithm;

import android.util.Log;

/**
 * Created by huangpeiqiang on 15/8/14.
 */
public class SortAlgorithm {
    /**
     * 直接插入排序
     * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
     * 要点：设立哨兵，作为临时存储和判断数组边界之用。
     * @param datas 需要排序的数组
     * @return      排序完成的数组
     */
    public static void straightInsertionSort(int[] datas){
        int length = datas.length;
        for(int i = 1; i<=length - 1; i++ ){
            if(datas[i] < datas[i - 1]){
                int temp = datas[i];
                datas[i] = datas[i - 1];
                int j = i - 1;
                while(j > 0 && temp < datas[j-1]){
                    datas[j] = datas[j-1];
                    j --;
                }
                datas[j] = temp;
            }
            logcat(datas);
        }
    }

    /**
     * 希尔排序
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。

     * 操作方法：

     * 选择一个增量序列t1，t2，…，tk，其中t[i]>t[i+1]，tk=1，即增量递减；
     * 按增量序列个数k，对序列进行k 趟排序；
     * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * @param datas
     */
    public static void shellSort(int[] datas){
        int length = datas.length;
        int dk = length / 2;  //定义增量值
        while(dk >= 1){

            for(int i = dk; i<=length - 1; ++i ){
                if(datas[i] < datas[i - dk]){
                    int temp = datas[i];
                    datas[i] = datas[i - dk];
                    int j = i - dk;
                    while(j > dk && temp < datas[j-dk]){
                        datas[j] = datas[j-dk];
                        j -= dk;
                    }
                    datas[j] = temp;
                }
                logcat(datas);
            }

            dk = dk / 2;
        }
    }

    public static void logcat(int[] datas){
        String str = "";
        for(int k = 0; k<=datas.length - 1; k++) {
            str = str + " " + datas[k];
        }
        Log.v("Debug", "data:" + str);
    }

}
