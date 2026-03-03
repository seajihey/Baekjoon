/*
 * 
 * dp[i][1] = i에 왔는데 연속1칸째(i-2) ----> i == 3 ----> 5
 * dp[i][2] = i에 왔는데 연속 2칸째(i-1)--->i == 3----->4
 * 
 * 
 * 시작 ->1
 * dp[1][1] = stairs[1]
 * 
 * 2번째계단
 * 시작->2번       =     dp[2][1] = stairs[2]
 * 1번밟고 2번     =     dp[2][2] = stairs[1] + stairs[2]
 * 
 * 3번째계단
 * 1 ->3         = dp[3][1] = max(dp[1][1], dp[1][2]) + stairs[3]
 * 2번밟고->3      = dp[3][2] = dp[2][1] + stair[3]
 * 
 * 4번째계단
 *        dp[4][1] => max(dp[2][1],dp[2][2])+stairs[4]
 *        dp[4][2] => dp[3][1] + stairs[4]
 *        
 *        
 *        결국 dp[i][1] dp[i][2]중에 더 큰 걸 고르는데
 *        안쪽ㄱ계산값은 
 *        dp[i][1] = max(dp[i-2][1],dp[i-2][2])+stair[i]
 *        dp[i][2] = dp[i-1][1]) + stairs[4]
 * 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(bf.readLine());
		
		int[] stairs =new int[input+1];
		int[][] dp = new int[input+1][3];
		
		for(int i =1;i<=input;i++) {
			stairs[i] = Integer.parseInt(bf.readLine());
			
		}
		dp[1][1] = stairs[1];
		
		if(input>=2) {
			dp[2][1] =stairs[2];
			dp[2][2] = stairs[1] +stairs[2];
			
		}
		
		for(int i = 3; i<=input; i++) {
			dp[i][1] = Math.max(dp[i-2][1],dp[i-2][2]) + stairs[i];
			
			dp[i][2] =   dp[i-1][1] + stairs[i];
			
		}
		System.out.println(Math.max( dp[input][1],dp[input][2]  ));
		
	}

}
