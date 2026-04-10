import java.io.*;
import java.util.*;

public class Main {


	static int[] matrix = new int[82]; // 1 ~81 사용

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		matrix[0] = 0;

		// 입력
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j < 10; j++) {
				int where = i * 9 + j;
				matrix[where] = Integer.parseInt(st.nextToken());
			}
		}

		// 백트래킹 (1번부터 검사)
		dfs(1);

		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 82; i++) {
			sb.append(matrix[i]).append(" ");
			if (i % 9 == 0) sb.append("\n");
		}
		System.out.print(sb);
	}

	// =========================================
	// DFS
	// =========================================
	static boolean dfs(int idx) {

		// 1~81까지 다 검사했으면 끝
		if (idx == 82) {
			return true;
		}

		// 이미 값 있으면 넘어감
		if (matrix[idx] != 0) {
			return dfs(idx + 1);
		}

		// 0이면  가로세로 네모를 검사해서 되는숫자 찾기
		// 1~9 다 넣고 → 안되는거 제거
		ArrayList<Integer> noList = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			noList.add(i);
		}
		// 가로 열( 9로 나눈 몫 )
		// 세로 축( 9로 나눈 나머지)
		// -1 하는 이유 : 인덱스 0 부터 시작이므로
		int r = (idx - 1) / 9;
		int c = (idx - 1) % 9;

		// ------------------------
		// 1. 가로 검사
		// ------------------------
		for (int col = 0; col < 9; col++) {
			int checkIdx = r * 9 + col + 1;
			int val = matrix[checkIdx];
			if (val != 0) {
				noList.remove(Integer.valueOf(val));
			}
		}

		// ------------------------
		// 2. 세로 검사
		// ------------------------
		for (int row = 0; row < 9; row++) {
			int checkIdx = row * 9 + c + 1;
			int val = matrix[checkIdx];
			if (val != 0) {
				noList.remove(Integer.valueOf(val));
			}
		}

		// ------------------------
		// 3. 네모(3x3) 검사
		// ------------------------
		int startR = (r / 3) * 3;
		int startC = (c / 3) * 3;

		for (int dr = 0; dr < 3; dr++) {
			for (int dc = 0; dc < 3; dc++) {
				int checkIdx = (startR + dr) * 9 + (startC + dc) + 1;
				int val = matrix[checkIdx];
				if (val != 0) {
					noList.remove(Integer.valueOf(val));
				}
			}
		}

		// 되는 숫자 아무거나 하나 넣고 쭉 진행
		for (int num : noList) {

			matrix[idx] = num;

			// 계속 진행
			if (dfs(idx + 1)) {
				return true;
			}

			// =========================================
			// 막히면 돌아가서 다른 숫자 넣기
			// =========================================
			matrix[idx] = 0;
		}

		return false;
	}
}


