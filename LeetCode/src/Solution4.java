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
        return true;
    }
}
