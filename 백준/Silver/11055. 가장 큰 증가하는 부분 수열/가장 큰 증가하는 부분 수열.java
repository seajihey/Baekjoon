/*
 * 
 * dp
 * arr[i]를 찾기위해선 
 * arr[j] < arr[i]를 만족하는 J중
 * dp[j] + arr[i]
 * 
 * 연결 가능한 이전 수열의 최대 합
 * [1,100,2,50,60]
 * dp[0] = arr[1] // 1
 * dp[1] = dp[0] + 100 = 101
 * dp[2] = 1 <2 ok 
 *         100 < 2 no
 *         dp[0] + 2  = 3
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for(int i = 0 ; i < n ; i ++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		//dp0 = arr[0]
		dp[0] = arr[0];
		
		//
		for(int i = 1; i <n;i++  ) {
			dp[i] = arr[i];
			for(int j =0; j < i ; j++) {
				if(arr[j]<arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
		}
		
		int max = dp[0];
		for (int i = 1; i < dp.length; i++) {
		    if (dp[i] > max) {
		        max = dp[i];
		    }
		}
		System.out.println(max);
		
		
	}

}
