package com.xun.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1,3,5,2,4,6,-1,-3,-5,-2,-4,-6};
        BubbleSort sortUtils = new BubbleSort();
        sortUtils.bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        //外层循环控制循环多少次
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            //内层循环控制每一趟排序多少次
            //因为冒泡是把每轮循环中较大的数飘到后面，
            //数组下标又是从0开始的，i下标后面已经排序的个数就得多减1，总结就是i增多少，j的循环位置减多少
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果是逆序，就用<
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
              break;
            }
        }
    }
}
