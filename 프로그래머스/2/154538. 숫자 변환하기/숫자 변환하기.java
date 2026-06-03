import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;

        List<Integer> cans = new ArrayList<>();
        // 어차피 수는 y를 못넘으니까 y까지 설정후 
        // 계산값에대한 visited를 tf로 판단
        // visited list로 하니까 시간초과
        boolean[] visited = new boolean[y + 1];

        cans.add(x);
        visited[x] = true;

     while (!cans.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < cans.size(); i++) {
                int cur = cans.get(i);
                // 현재 값이 y면 리턴
                if (cur == y) return answer;
                
                // 1.  경우의 수 계산
                int a = cur * 2;
                int b = cur * 3;
                int c = cur + n;
                
                // 2.  계산된값이 y보다 적고, 이미 나온 숫자가 아니면 temp에 add + visited에 add
                if (a <= y && !visited[a]) {
                    visited[a] = true;
                    temp.add(a);
                }

                if (b <= y && !visited[b]) {
                    visited[b] = true;
                    temp.add(b);
                }

                if (c <= y && !visited[c]) {
                    visited[c] = true;
                    temp.add(c);
                }
            }
            // 3. temp 로 cans 변경 (visited에 이미 다녀온 숫자 다 있음)
            cans = temp;
         
            answer++;
        }
        // cans에 없으면 다 y넘는 수라 끝남
        return -1;
    }
}