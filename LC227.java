import java.util.Stack;

// Approach 1: No extra space
// Time Complexity : O(n)
// Space Complexity : O(1)
// where n -> length of the string
public class LC227 {
    public int calculate(String s) {
        if(s==null || s.length()==0) return 0;
        int n = s.length();
        int num = 0;
        int cal = 0;
        int tail = 0;
        char lastSign = '+';
        for(int i=0;i<=n;i++){
            char ch = ' ';
            if(i<n){
                ch = s.charAt(i);
                if(ch==' ') continue;
            }
            if(Character.isDigit(ch)){
                num = (num*10) + (ch-'0');
            } else {
                if(lastSign=='+' || lastSign == '-'){
                    if(lastSign=='-') num *= -1;
                    cal += num;
                    tail = num;
                } else {
                    cal -= tail;
                    if(lastSign=='*') tail *= num;
                    else if(lastSign=='/') tail /= num;
                    cal += tail;
                }
                lastSign = ch;
                num = 0;
            }
        }
        return cal;
    }
}


// Approach 2: Using Stack
// Time Complexity : O(n)
// Space Complexity : O(n)
// where n -> length of the string
class LC227_1 {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        int num = 0;
        char lastSign = '+';
        for (int i = 0; i <= n; i++) {
            char ch = ' ';
            if (i < n) {
                ch = s.charAt(i);
                if (ch == ' ')
                    continue;
            }
            if (Character.isDigit(ch)) {
                num = (num * 10) + (ch - '0');
            } else {
                if (lastSign == '+' || lastSign == '-') {
                    if (lastSign == '-')
                        num *= -1;
                    stack.push(num);
                } else {
                    int top = stack.pop();
                    if (lastSign == '*')
                        top *= num;
                    else if (lastSign == '/')
                        top /= num;
                    stack.push(top);
                }
                lastSign = ch;
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}