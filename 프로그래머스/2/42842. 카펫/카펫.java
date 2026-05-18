import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        // 전체 칸 수
        int total = brown + yellow;

        ArrayList<int[]> cans = new ArrayList<>();

        int tempY = 1;

        while (tempY <= total) {
            // 약수쌍 찾기
            if (total % tempY == 0) {

                int tempX = total / tempY;

                cans.add(new int[]{tempX, tempY});
            }

            tempY++;
        }

        // 조건= 2x+2y -4 == brown
        for (int i = 0; i < cans.size(); i++) {

            int x = cans.get(i)[0];
            int y = cans.get(i)[1];

            // 갈색 테두리 개수
            if ((x * 2 + y * 2 - 4) == brown) {

                answer = new int[]{x, y};
                break;
            }
        }

        return answer;
    }
}