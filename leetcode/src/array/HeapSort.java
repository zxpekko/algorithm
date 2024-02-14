package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author:zxp
 * @Description:堆排序手动实现
 * @Date:21:40 2024/1/17
 */
public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        HeapSortⅡ heapSortⅡ = new HeapSortⅡ();
        int[] ints1 = heapSortⅡ.HeapSort(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        System.out.println(Arrays.toString(ints1));
        int[] ints = heapSort.HeapSort(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        System.out.println(Arrays.toString(ints));
        HeapSortⅢ heapSortⅢ = new HeapSortⅢ();
        int[] ints2 = heapSortⅢ.heapSort(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        System.out.println(Arrays.toString(ints2));
        HeapSortⅣ heapSortⅣ = new HeapSortⅣ();
        int[] ints3 = heapSortⅣ.heapSort(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        System.out.println(Arrays.toString(ints3));
        BubbleSort bubbleSort = new BubbleSort();
        int[] ints4 = bubbleSort.bubbleSort(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        System.out.println(Arrays.toString(ints4));
    }
    /**
     * @param arr 传入数组
     * @param n   待维护的长度
     * @param i   待维护的数组下标
     *            节点标号为i的节点的父节点为(i-1)/2,
     *            它的左孩子节点的下标为2*i+1,右孩子节点的下标为2*i+2.
     */
    public void Heapfy(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            Heapfy(arr, n, largest);
        }
    }

    /**
     * @param arr 传入数组，准备进行排序
     */
    public int[] HeapSort(int[] arr) {
        //建堆(构建一个大顶堆，目的是进行递增排序)
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            Heapfy(arr, n, i);
        }
        //交换下标为0的元素和下标为i的元素，交换之后待处理的元素长度逐次递减。
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            Heapfy(arr, i, 0);
        }
        return arr;
    }
}
class HeapSortⅡ{
    /**
     *
     * @param arr 维护数组
     * @param n 数组中多少个元素维护
     * @param i 维护的下标
     */
    public void Heapfy(int[] arr,int n,int i){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n&&arr[largest]<arr[left])
            largest=left;
        if(right<n&&arr[largest]<arr[right])
            largest=right;
        if(largest!=i){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            Heapfy(arr,n,largest);
        }
    }

    /**
     *
     * @param arr 待排序的数组
     * @return
     */
    public int[] HeapSort(int[] arr){
        //建堆
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--){
            Heapfy(arr,n,i);
        }
        //交换首尾进行排序，每次交换都需要维护数组
        for(int i=n-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            Heapfy(arr,i,0);
        }
        return arr;
    }
}
class HeapSortⅢ{
    public void heapfy(int[] arr,int n,int i){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n&&arr[left]>arr[largest])
            largest=left;
        if(right<n&&arr[right]>arr[largest])
            largest=right;
        if(largest!=i){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            heapfy(arr,n,largest);
        }
    }
    public int[] heapSort(int[] arr){
        int n=arr.length;
        //建堆,i节点的父节点为(i-1)/2
        for(int i=n/2-1;i>=0;i--){
            heapfy(arr,n,i);
        }
        //排序加维护
        for(int i=n-1;i>0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            heapfy(arr,i,0);
        }
        return arr;
    }
}
class HeapSortⅣ{
    public void heapfy(int[] arr,int n,int i){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n&&arr[largest]<arr[left])
            largest=left;
        if(right<n&&arr[largest]<arr[right])
            largest=right;
        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            heapfy(arr,n,largest);
        }
    }
    public int[] heapSort(int[] arr){
        int n=arr.length;
        //建堆
        for(int i=n/2-1;i>=0;i--){
            heapfy(arr,n,i);
        }
        //排序加继续维护大根堆
        for(int i=n-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapfy(arr,i,0);
        }
        return arr;
    }
}
class BubbleSort{
    public int[] bubbleSort(int[] arr){
        int n=arr.length;
        for(int i=1;i<n;i++){
            int flag=0;
            for(int j=0;j<n-i;j++){
                if(arr[j]>arr[j+1]){
                    flag=1;
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if(flag==0)
                break;
        }
        return arr;
    }
}
