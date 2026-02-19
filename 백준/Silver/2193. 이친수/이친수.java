
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * dp -> 하나의 큰 문제를 작은 문제로 나누어 해결하는 기법
 * 
 */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(bf.readLine());
		
		if(input==0){
			System.out.println("0");
			return ;
		}
		if(input==1){
			System.out.println("1");
			return;
		}
		long[] dp= new long[input+1];
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i = 3 ; i <= input ; i ++) {
			
			dp[i] = dp[i-1]+dp[i-2];
		}
		System.out.println(dp[input]);

	}
}
