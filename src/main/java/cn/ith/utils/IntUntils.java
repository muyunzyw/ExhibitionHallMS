package cn.ith.utils;

/**
 * @author muyun
 * @date 2020/3/28 - 14:58
 */
public class IntUntils {
    public static Integer[] intToInteger(int[] arr){
        int n = arr.length;
        Integer[] iarr = new Integer[n];
        for(int i=0;i<n;i++){
            iarr[i] = new Integer(arr[i]);
        }
        return iarr;
    }
}
