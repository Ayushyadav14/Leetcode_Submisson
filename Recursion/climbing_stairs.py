#Climbing Stairs with the recursion approach

# Time Limit will Exceed
#Time Complexity O(2^n)
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
#Climbing stairs with the tabular logic dp
#Time Complexity O(n)

class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        
        int dp[] = new int[n+1];
        dp[1] =1;
        dp[2] =2;

        for(int i =3;i<=n;i++){
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}