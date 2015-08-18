package com.example.bigfather.sortalgorithm;

import android.util.Log;

/**
 * Created by huangpeiqiang on 15/8/14.
 * 参考网站：http://blog.csdn.net/hguisu/article/details/7776068
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

    /**
     * 冒泡排序
     * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
     * @param datas
     */
    public static void bubbleSort(int [] datas){
        int length = datas.length;
        for(int i = 0; i < length - 1; i++){
            for(int j=0; i<length - i - 1; j++){
                if(datas[j] > datas[j+1]){
                    int temp = datas[j];
                    datas[j] = datas[j + 1];
                    datas[j+1] = temp;
                }
                logcat(datas);
            }
        }
    }

    /**
     * 堆排序
     * 详解算法解析参考头部注释中的网站
     * @param datas
     */
    public static void heapSort(int[] datas){

    }

    /**
     * 简单选择排序
     * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。

     * 操作方法：
     * 第一趟，从n 个记录中找出关键码最小的记录与第一个记录交换；
     * 第二趟，从第二个记录开始的n-1 个记录中再选出关键码最小的记录与第二个记录交换；
     * 以此类推.....
     * 第i 趟，则从第i 个记录开始的n-i+1 个记录中选出关键码最小的记录与第i 个记录交换，
     * 直到整个序列按关键码有序。
     *
     * 简单选择排序的改进——二元选择排序
     * 简单选择排序，每趟循环只能确定一个元素排序后的定位。我们可以考虑改进为每趟循环确定两个元素（当前趟最大和最小记录）的位置,从而减少排序所需的循环次数。改进后对n个数据进行排序，最多只需进行[n/2]趟循环即可。
     * @param datas
     */
    public static void simpleSelectionSort(int[] datas){
        int length = datas.length;
        for(int i = 0; i<=length - 1; i++){
            int pos = i;
            for(int j = i + 1; j<=length - 1; j++){
                if(datas[pos] > datas[j]){
                    pos = j;
                }
            }
            Log.v("Debug", "最小数：" + datas[pos]);
            int temp = datas[pos];
            datas[pos] = datas[i];
            datas[i] = temp;
            logcat(datas);
        }
    }

    public static void logcat(int[] datas) {
        String str = "";
        for (int k = 0; k <= datas.length - 1; k++) {
            str = str + " " + datas[k];
        }
        Log.v("Debug", "data:" + str);
    }

}
