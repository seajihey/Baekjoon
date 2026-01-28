
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제를 보자마자 드는 생각
 * 재귀?이중포문?dfs?아무튼 무식하게 하나하나 점검해나가는건 알겠다....
 * 시작점 하나를 잡고 검사하기
 * 근데 그 시작점은, 왼쪽위가될것이니, 가로길이-8만큼의 횟수만 하면됨
 * 세로길이의-8만큼의 횟수만 하면됨
 * 일단 이중 포문ㅇ로 하자
 * 
 * 매트릭스받을때 굳이?이중배열로안받고 한줄로처리하겠다.
 * 여러줄받은걸 한줄로만들땐 StringTokenizer쓴다
 * 
 * 
 * 
 * 일단진짜무식하게 돌려보자
 */


public class Main {
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < x; i++) {
		    sb.append(br.readLine());
		}
		
		String result = sb.toString();
		
		int ans = Integer.MAX_VALUE;

		for (int j = 0; j <= x - 8; j++) {
		    for (int k = 0; k <= y - 8; k++) {

		        int cntW = 0;
		        int cntB = 0;

		        for (int r = 0; r < 8; r++) {
		            for (int c = 0; c < 8; c++) {

		                char ch = result.charAt((j + r) * y + (k + c));

		                char expW = ((r + c) % 2 == 0) ? 'W' : 'B';
		                char expB = ((r + c) % 2 == 0) ? 'B' : 'W';

		                if (ch != expW) cntW++;
		                if (ch != expB) cntB++;
		            }
		        }

		        ans = Math.min(ans, Math.min(cntW, cntB));
		    }
		}



		System.out.println(ans);

		
		
		
	}
}
