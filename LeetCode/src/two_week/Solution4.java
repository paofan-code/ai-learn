package two_week;

import java.util.Arrays;

/**
 * @author 酸汤泡饭
 * data:2026-11-18
 * todo 这道题目可以用多种方法实现，有空可以了解一下
 */
public class Solution4 {

    static int res = 0;
    public int majorityElement(int[] nums) {
       int vote = nums[0];
       int count = 1;
       int len = nums.length;
       for(int i=1;i<len;i++){
           if(count==0){
               vote=nums[i];
//               count++; 可以直接被优化
           }
            if(nums[i]!=vote) count--;
            else  count++;
       }
       return vote;
    }

    public static void merge(int [] nums,int low,int high){
        if(high-low<=1) return ;
        int mid = (low+high)/2;
        merge(nums,low,mid);
        merge(nums,mid+1,high);
    }

    /**
     * 快排的解法
     * @param nums 待排序的数据
     * @param low  下标下界
     * @param high 下标上界
     */
    public static void quickSort(int [] nums,int low,int high){
        if(low>=high) return ;
        int mid = low + (high - low) / 2;
        swap(nums, low, mid);  // mid 就是中位数，放到 low
        int i=low,j=high;
        int key = nums[low];
        while (i<j){
            while (i<j &&nums[j]>=key) j--;
            if(i==j) break;
            nums[i] = nums[j];
            while (i<j &&nums[i]<=key) i++;
            nums[j] = nums[i];
        }
        nums[i] = key;
        quickSort(nums,low,i-1);
        quickSort(nums,i+1,high);
    }


    public static void main(String[] args) {
        int [] nums = {0,1,1,0,2,2,0,0,1,0,0};
        int res = new Solution4().majorityElement(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
