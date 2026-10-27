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

