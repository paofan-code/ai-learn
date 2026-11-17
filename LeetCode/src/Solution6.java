/**
 * @author 酸汤泡饭
 * data:2026-11-16
 */
public class Solution6 {
    public int maxSubArray(int[] nums) {
        //[-2,1]
        int max = nums[0];
        int total = nums[0];
        int len = nums.length;
        for(int i=1;i<len;i++){
            if(total<=0){
                total = 0;
            }
            total += nums[i];
            if(total>max) max = total;
        }
        return max;
    }

    //暴力破解版本+剪枝
    public int maxSubArray1(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        for(int i=0;i<len;i++){
            int total = 0;
            for (int j=i;j<len;j++){
                total+=nums[j];
                if(total>max) max = total;
                if(total<=0){
                    /**
                     * 说明i到j加起来是无效的，直接进入下一个循环，下一个循环
                     * 下一个循环从i+1到依然是无效的可以直接令i=j+1
                     */
                    i = j;
                    break;
                }
            }
        }
        return max;
    }


    //如果输入全为正数，会进行重复计算，相应地添加终止条件
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int j = 0;
        for(int i=0;i<len;i++){
            int total = 0;
            for (j=i;j<len;j++){
                total+=nums[j];
                if(total>max) max = total;
                if(total<=0){ //说明i'到j加起来是小于0的，但是i到j的最大值已经被找到
                    i = j;
                    break;
                }
            }
            if(j==len) break;;
        }
        return max;
    }


    public int maxSubArray4(int[] nums) {
        //[-2,1]
        int max = nums[0],total = nums[0];
        int len = nums.length;
        for(int i=1;i<len;i++){
//            if(total<=0){//说明前面已经累计为0
//                total = 0;
//            }
            total = Math.max(nums[i],nums[i]+total);
            max = Math.max(total,max);
        }
        return max;
    }

    //简化版本
    public int maxSubArray5(int[] nums) {
        //[-2,1]
        int max = nums[0],total = 0;
        for(int num:nums){
            if(total<=0) total = num;
            else total += num;
            max = Math.max(total,max);
        }
        return max;
    }
}
