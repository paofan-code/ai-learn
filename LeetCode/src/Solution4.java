/**
 * @author 酸汤泡饭
 * data:2026-11-12
 */
public class Solution4 {
    public boolean isPalindrome(int x) {
        String s  = String.valueOf(x);
        char [] chars = s.toCharArray();
        for(int i=0,j=chars.length-1;i!=j;i++,j--){
            if(chars[i]!= chars[j]) return false;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if(x<=0) return false;
        int[] nums = new int[32];
        int pos = 0;
        while(x!=0){
            nums[pos] = x%10;
            pos++;
            x = x/10;
        }
        for(int i=0,j=pos-1;j>i;i++,j--) {
            if(nums[i]!=nums[j]) return false;
        }
        return true;
    }

    public static boolean isPalindrome3(int x) {
        if(x<0) return false;
        int total = 0;
        int temp = x;
        while(x!=0){
            int remainder = x%10;
            x = x/10;
            total = total*10+remainder;
        }
        return total == temp;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome3(121));
    }
}
