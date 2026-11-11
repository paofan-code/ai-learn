/**
 * 总结，最开始先进行数据的处理：特殊边界考虑、初始化
 */
class Solution2 {
    public boolean isValid(String s) {
        int len = s.length();
        char[] stack = new char[len];
        char[] chars = s.toCharArray();
        if (len % 2 == 1) return false;
        int pos = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack[pos++] = chars[i];
                continue;
            }
            if(pos==0) return false; // 代表栈非空
            if (chars[i] == ')' && stack[pos - 1] == '(' ||
                    chars[i] == '}' && stack[pos - 1] == '{' ||
                    chars[i] == ']' && stack[pos - 1] == '[') {
                pos--;
            } else {
                return false;
            }
        }
        return pos == 0;
    }
}
