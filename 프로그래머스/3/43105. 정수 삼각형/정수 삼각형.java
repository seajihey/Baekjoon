import java.util.*;

/*
[[7], 
[3, 8], 
[8, 1, 0], 
[2, 7, 4, 4], 
[4, 5, 2, 6, 5]]	

현재 숫자에서 갈 수 있는건 [i+1][j] [i+1][j+1]

그리고 dfs? bfs? 다익스트라 ?

브루트포스?

==> dp

*/
/*

      
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
        
            for(int j= 0 ; j < i ; j ++){
                
                        if (j == 0) {
            dp[i][j] = dp[i-1][j] + triangle[i][j];
            } else if (j == i) {
                dp[i][j] = dp[i-1][j-1] + triangle[i][j];
            } else {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
                
                
            }
        
        
        }
        
        */
    
    // 병렬처리하면 메모리 초과나려나...?
    // 나(i)에게 왔을때 가장 적은 수를 찾으면됨
    // 밑에서 부터 젤큰거 찾으면안되게찌....?
class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }

        return triangle[0][0];
    }
}