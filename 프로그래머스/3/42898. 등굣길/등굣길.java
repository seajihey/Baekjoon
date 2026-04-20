/*

주어진건 1.1 시작부터임
이것도 dp인듯?

dp[i][j] = matrix[i][j] + max(dp[i-1][j]) 

< 갈 수 있는 곳 >
matrix[i+1][j], matrix[i][j+1]

dp로 가다가 물웅덩이만나면 버리기 

*/

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        int[][] dp = new int[n+1][m+1];

        // 물웅덩이 체크용
        boolean[][] water = new boolean[n+1][m+1];
        for (int[] p : puddles) {
            water[p[1]][p[0]] = true;
        }

        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;
                if (water[i][j]) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
                }
            }
        }

        return dp[n][m];
    }
}