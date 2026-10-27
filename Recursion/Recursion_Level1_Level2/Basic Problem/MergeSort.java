// 704. Binary Search

class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);   
    }

    public int binarySearch(int[] nums , int target, int left , int right){
        while(left>right){
            return -1;
        }
        int mid = left +(right-left)/2;

        if(nums[mid] == target){
            return mid;
        }
        if( nums[mid]<target){
            return binarySearch(nums, target, mid + 1, right);
        }else{
            return binarySearch(nums, target, left, mid-1);
        }

    }
}

// MErge sort with recursion

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        mergeRecursive(nums1, m - 1, nums2, n - 1, m + n - 1);
    }

    public void mergeRecursive(int[] nums1, int p1, int[] nums2, int p2, int i) {
        if (p2 < 0) {
            return;
        }

        if (p1 >= 0 && nums1[p1] > nums2[p2]) {
            nums1[i] = nums1[p1];
            mergeRecursive(nums1, p1 - 1, nums2, p2, i - 1);
        } else {
            nums1[i] = nums2[p2];
            mergeRecursive(nums1, p1, nums2, p2 - 1, i - 1);
        }
    }
}

// Merge sort method

import java.util.Arrays;

public class MergeSort {

    // JOB 1 — SPLIT: sorts a[lo..hi]
    static void mergeSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;                 // 1 element (or none): already sorted

        int mid = lo + (hi - lo) / 2;         // middle index

        mergeSort(a, lo, mid);                // sort the left half   (trust it)
        mergeSort(a, mid + 1, hi);            // sort the right half  (trust it)

        merge(a, lo, mid, hi);                // join the two sorted halves
    }

    // JOB 2 — MERGE: a[lo..mid] and a[mid+1..hi] are sorted; make a[lo..hi] sorted
    static void merge(int[] a, int lo, int mid, int hi) {
        int[] tmp = new int[hi - lo + 1];     // space for both halves
        int i = lo;                           // front of the left half
        int j = mid + 1;                      // front of the right half
        int t = 0;                            // next free slot in tmp

        // both halves have elements: take the smaller front
        while (i <= mid && j <= hi) {
            if (a[i] <= a[j]) {
                tmp[t++] = a[i++];
            } else {
                tmp[t++] = a[j++];
            }
        }

        // one half is finished: copy what's left of the other
        while (i <= mid) tmp[t++] = a[i++];
        while (j <= hi)  tmp[t++] = a[j++];

        // put the sorted result back into a[lo..hi]
        for (int k = 0; k < tmp.length; k++) {
            a[lo + k] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 4, 1};
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));   // [1, 2, 4, 5]
    }
}

//912. Sort an Array

class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        for (int p = 0; p < temp.length; p++) nums[left + p] = temp[p];
    }
}

//215. Kth Largest Element in an Array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        mergesort(nums,0,nums.length-1);
        return nums[nums.length-k];
        
    }
    public void mergesort(int[] nums, int left , int right){
        if(left>=right){
            return;
        }
        int mid= left+(right-left)/2;
        mergesort(nums,left,mid);
        mergesort(nums,mid+1,right);
        merge(nums,left,mid,right);

    }
    public void merge(int[] nums,int left,int mid, int right){

        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            nums[left + x] = temp[x];
        }
    }
}