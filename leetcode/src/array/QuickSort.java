package array;

import leetcode.PathSum;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:快速排序的手动实现
 * @Date:20:42 2024/1/17
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] quick = quickSort.quick(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        QuickSortⅡ quickSortⅡ = new QuickSortⅡ();
        int[] quick1 = quickSortⅡ.quick(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        QuickSortⅢ quickSortⅢ = new QuickSortⅢ();
        int[] quick2 = quickSortⅢ.quick(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        QuickSortⅣ quickSortⅣ = new QuickSortⅣ();
        int[] quick3 = quickSortⅣ.quick(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        System.out.println(Arrays.toString(quick3));
        System.out.println(Arrays.toString(quick2));
        System.out.println(Arrays.toString(quick1));
        System.out.println(Arrays.toString(quick));
        QuickSortⅤ quickSortⅤ = new QuickSortⅤ();
        int[] ints = quickSortⅤ.quickSort(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        System.out.println(Arrays.toString(ints));
        QuickSortⅥ quickSortⅥ = new QuickSortⅥ();
        int[] quick4 = quickSortⅥ.quick(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        System.out.println(Arrays.toString(quick4));
    }
    public int[] quick(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    public void quickSort(int[] arr,int L,int R){
        if(L>=R)
            return;
        int left=L,right=R;
        int pivot=arr[left];
        while (left<right){
            while (left<right&&arr[right]>=pivot){
                right--;
            }
            if(left<right){
                arr[left]=arr[right];
            }
            while (left<right&&arr[left]<=pivot){
                left++;
            }
            if(left<right){
                arr[right]=arr[left];
            }
            if(left>=right)
                arr[right]=pivot;
        }
        quickSort(arr,L,right-1);
        quickSort(arr,right+1,R);
    }
}
class QuickSortⅡ{
    public int[] quick(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    public void quickSort(int[] arr,int L,int R){
        if(L>=R)
            return;//递归出口要注意，因为不写的话，后续的逻辑无法结束递归，会一直入栈，直到栈满报错退出。L>=R说明当前要处理的子数组只有一个元素，因此可以退出。
        int left=L,right=R;
        int pivot=arr[left];
        while (left<right){
            while (left<right&&arr[right]>=pivot)
                right--;
            if(left<right)
                arr[left]=arr[right];
            while (left<right&&arr[left]<=pivot)
                left++;
            if(left<right)
                arr[right]=arr[left];
            if(left>=right)
                arr[right]=pivot;
        }
        quickSort(arr,L,right-1);
        quickSort(arr,right+1,R);
    }
}
class QuickSortⅢ{
    public void quickSort(int[] arr,int L,int R){
        if (L>=R)
            return;
        int left=L,right=R;
        int pivot=arr[left];
        while(left<right){
            while (left<right&&arr[right]>=pivot)
                right--;
            if(left<right)
                arr[left]=arr[right];
            while (left<right&&arr[left]<=pivot)
                left++;
            if(left<right)
                arr[right]=arr[left];
            if(left>=right)
                arr[right]=pivot;
        }
        quickSort(arr,L,right-1);
        quickSort(arr,right+1,R);
    }
    public int[] quick(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
}
class QuickSortⅣ{
    public int[] quick(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    public void quickSort(int[] arr,int L,int R){
        if(L>=R)
            return;
        int left=L,right=R;
        int pivot=arr[left];
        while (left<right){
            while (left<right&&arr[right]>=pivot)
                right--;
            if(left<right)
                arr[left]=arr[right];
            while (left<right&&arr[left]<=pivot)
                left++;
            if(left<right)
                arr[right]=arr[left];
            if(left==right)
                arr[right]=pivot;
        }
        quickSort(arr,L,right-1);
        quickSort(arr,right+1,R);
    }
}
class QuickSortⅤ{
    public int[] quickSort(int[] arr){
        quick(arr,0,arr.length-1);
        return arr;
    }
    public void quick(int[] arr,int L,int R){
        if(L>=R)
            return;
        int left=L;
        int right=R;
        int pivot=arr[left];
        while (left<right){
            while (left<right&&arr[right]>=pivot)
                right--;
            if(left<right)
                arr[left]=arr[right];
            while (left<right&&arr[left]<=pivot)
                left++;
            if(left<right)
                arr[right]=arr[left];
            if(left==right)
                arr[right]=pivot;
        }
        quick(arr,L,right-1);
        quick(arr,right+1,R);
    }
}
class QuickSortⅥ{
    public int[] quick(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    public void quickSort(int[] arr,int L,int R){
        if(L>=R)
            return;
        int left=L;
        int right=R;
        int pivot=arr[left];
        while (left<right){
            while (left<right&&arr[right]>=pivot)
                right--;
            if(left<right)
                arr[left]=arr[right];
            while (left<right&&arr[left]<=pivot)
                left++;
            if(left<right)
                arr[right]=arr[left];
            if(left==right)
                arr[right]=pivot;
        }
        quickSort(arr,L,right-1);
        quickSort(arr,right+1,R);
    }
}
