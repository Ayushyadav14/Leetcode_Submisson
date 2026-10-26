import java.util.*;
class Main {
    static int sum(int n){
        int total = 0;
        while (n > 0) {
            int rem = n % 10;
            total = total + rem;
            n = n / 10;
        }
        return total;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the No. :");
        int n = sc.nextInt();

        int result = sum(n);
        System.out.println("Enter the value of total : "+result);

    }
}


// Valid Parenthese Leetcode 

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != 
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

//344. Reverse String

class Solution {

    public void helper(char[] s, int left , int right){
        while(left>=right){
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        helper(s,left+1,right-1);
    }
    public void reverseString(char[] s) {
        helper(s,0,s.length-1);
    }
}