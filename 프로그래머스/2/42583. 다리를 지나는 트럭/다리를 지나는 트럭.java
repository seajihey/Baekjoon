import java.util.*;

/*
하나가 다 가는데에는 3초가 걸림
0초 끝 -> 항상그대로 
1초 끝 -> 7이 올라감 + 계산끝에 4는 못 올라와
2초 끝 -> 7이 끝지점 + 계산끝에 4는 못올라와
3초 끝 -> 7 날라가 + 계산끝에 4가 올라왔어 
4초 끝 -> 4가 끝지점 + 5가 계산끝에 올라왔어
5초 끝 -> 4 날라가 + 5가 끝지점  + 계산끝에 6이 못올라와
6초 끝 -> 5가 날라가 + 6이 올라와
7초 끝 -> 6이 끝지점
8초 끝 -> 6이 날라가

배열을 
대기트럭[] => 남은게 없을때까지
건너는 트럭[] => 남은게 없을때까지
초수[] => 건너는트럭의 초수가 2초가 넘으면 안댐.
한단계를 1초로보고

다리건너는트럭 + 현재대기트럭[i] < 10 
=> 다음턴에 추가 가능
>10
다음턴에 또 계산
 
 다음턴 들어 올 수 있냐 없냐 -> true false 변수로 둠

추가 가능 조건 
1. 다리진행중트럭[].length <= 1
2. 드갈수있냐없냐변수가 true여야함

*/

class Solution {
    public int solution(int bridge_length, int maxW, int[] waitingT_Old) {
        int ans = 0;

        ArrayList<Integer> waitingT = new ArrayList<>();
        for (int i : waitingT_Old) {
            waitingT.add(i);
        }

        ArrayList<Integer> inProgress = new ArrayList<>();
        ArrayList<Integer> countSec = new ArrayList<>();

        int curWeight = 0;

        while (true) {
            // 종료 조건
            if (waitingT.size() == 0 && inProgress.size() == 0) {
                break;
            }

            ans++; // 1초 증가

            // 나가는 트럭 처리 (맨 앞만 보면 됨) => 왜냐?어차피 하나씩 들어와서
            if (countSec.size() > 0 && countSec.get(0) >= bridge_length) {
                curWeight -= inProgress.get(0);
                inProgress.remove(0);
                countSec.remove(0);
            }

            // 트럭 추가 시도
            /*
            추가 가능 조건 
                1. 다리진행중트럭[].length <= 1
                2. 드갈수있냐없냐변수가 true여야함
            */
            if (waitingT.size() > 0) {
                int next = waitingT.get(0);

                if (inProgress.size() < bridge_length && curWeight + next <= maxW) {
                    inProgress.add(next);
                    countSec.add(0);
                    curWeight += next;
                    waitingT.remove(0);
                }
            }

            //  시간 증가
            for (int i = 0; i < countSec.size(); i++) {
                countSec.set(i, countSec.get(i) + 1);
            }
        }

        return ans;
    }
}