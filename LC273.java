// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class LC273 {
    String[] unitArr1 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String[] unitArr2 = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    String[] unitArr3 = { "", "Thousand", "Million", "Billion" };

    private String helper(int num){
        String sb = "";
        int part1 = num % 100;
        if(part1<=19){
            sb = unitArr1[part1] + " " + sb;
        } else if((part1 % 10) == 0) {
            sb = unitArr2[part1/10] + " " + sb;
        } else {
            sb = unitArr1[part1%10] + " " + sb;
            sb = unitArr2[(part1/10)%10] + " " + sb;
        }
        int part2 = num/100;
        if(part2!=0) sb = unitArr1[part2]+" Hundred " + sb;;
        return sb;
    }
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        int unitArr3Ptr = 0;
        int tempNum = num;
        String ans = "";
        while(tempNum>0){
            String x = helper(tempNum%1000);
            if(x.trim().length()>0){
                ans =  x.trim() + " " + unitArr3[unitArr3Ptr] + " " + ans;
            }
            unitArr3Ptr++;
            tempNum /= 1000;
        }
        return ans.trim();
    }
}
