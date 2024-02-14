package leetcode;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:实现堆排序
 * @Date:15:49 2023/11/8
 */
public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] ints = {2, 3, 8, 1, 4, 9, 10, 7, 16, 14};
//        heapSort.HeapSort(ints);
        System.out.println(Arrays.toString(ints));

    }
//    public void heapfy(int[] arr,int n,int i){//n指堆中的节点个数，i指的是某一个子堆中的根节点,
//        //维护大根堆。(建堆)
//        int largest=i;
//        int left=2*i+1;
//        int right=2*i+2;
//        if(left<n&&arr[largest]<arr[left]){
//            largest=left;
//        }
//        if(right<n&&arr[largest]<arr[right]){
//            largest=right;
//        }
//        if(largest!=i){
//            int temp=arr[i];
//            arr[i]=arr[largest];
//            arr[largest]=temp;
//            heapfy(arr,n,largest);
//        }
//    }
//    public void HeapSort(int[] arr){
//        int n=arr.length;
//        for(int i=n/2-1;i>=0;i--){//建堆
//            heapfy(arr,n,i);
//        }
//        for(int i=n-1;i>0;i--){//排序
//            int temp=arr[i];
//            arr[i]=arr[0];
//            arr[0]=temp;
//            heapfy(arr,i,0);
//        }
//    }
    public void Heapfy(int[] arr,int n,int i){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n&&arr[largest]<arr[left]){
            largest=left;
        }
        if(right<largest&&arr[largest]<arr[right]){
            largest=right;
        }
        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            Heapfy(arr,n,largest);
        }
    }
    public void HeapSort(int[] arr){
        int n=arr.length;
        //建堆
        for(int i= n/2-1;i>=0;i--){
            Heapfy(arr,n,i);
        }
        //排序
        for(int i=n-1;i>=0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            Heapfy(arr,i,0);
        }
    }
}
