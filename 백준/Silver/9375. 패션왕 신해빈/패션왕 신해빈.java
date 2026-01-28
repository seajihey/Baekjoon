
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * 첫줄 n - 테케 수
 * 
 * 다음n옷 수
 * n번의 의상 생성
 * 
 * 반복
 * 
 * 1. n번만큼 반복한다
 * 		의상 수를 받고
 * 		bufferReader로 옷 받고 엔터를 기준으로 끝문자열이 같은 게 있는지 확인
 * 		같은게 있다면 
 * 			result = 그 개수만큼 빼고+1해서 조합 + 옷 개수
 * 		같은게없다면
 * 			result = 옷 개수 포함해서 조합
 * 			
 * 	==> 조합을 이용하는거니 집합Set으로 빼고 팩토리얼을 하자 
 * 	==> 어떤 알고리즘 쓰는 건진 모르겠음...
 *  ==> 근데 어차피 중요한건 앞에 이름이 아니라 뒤에 종류니까 뒤에 종류만 입력 받아도 되지 않을
 * 
 * 트러블슈팅
 * 		==>  BufferReader.readLine()쓸때 try-catch예외처리 안 하면 컴파일 에러났다.
 * 			==>  throws IOException를 메인메서드 옆에 붙여주면 안 난다.
 * 
 */


public class Main {

	public static void main(String[] args) throws IOException {
		//버퍼리더 호출
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//n == 테케 수
		int n = Integer.parseInt(br.readLine());
		for(int k = 0 ; k< n ; k++) {
			//m == 옷 가지 수
			int m = Integer.parseInt(br.readLine());
			//arr == 옷 종류 담을 배열 
			String[] arr = new String[m];
			
			if (m == 0) {
			    System.out.println(0);
			    continue; // 다음 테스트케이스로
			}
			//배열에 옷 담기
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				arr[i] = st.nextToken();
	
			}
			
			//예시 배열 = [ headgear , eyewear , headgear ]
			
			//1. 우선 하나씩 입는 경우를 더해주고
			//2. set으로 중복제거 한 후
			//3. 조합으로 풀어준다
			
			long result = 0;
			
			//1
			result = arr.length;
			
			//2 set 몰라서 지삐띠니 했음
			Set<String> setArr = new HashSet<>(Arrays.asList(arr));
			String[] types = setArr.toArray(new String[0]);
	
			long temp = 1;
			//3 "조합" (각 종류별 (개수+1) 곱하기) - 전부 for 
			for (int i = 0; i < types.length; i++) {
			    int cnt = 0;
	
			    for (int j = 0; j < arr.length; j++) {
			        if (types[i].equals(arr[j])) cnt++;
			    }
	
			    temp = temp * (cnt + 1);  
			}
			// 알몸상태제거
			result = temp - 1;       
			
			System.out.println(result);
		}
	}

}
