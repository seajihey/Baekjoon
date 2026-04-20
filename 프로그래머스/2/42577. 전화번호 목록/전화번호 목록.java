import java.util.*;


/*
효율성테스트에서 삑나는 코드 
이유 ?  시간복잡도가 O(n²) 이기 때문입니다.

왜 느린지 분석
for (int i = 0; i < pb.size(); i++) {
    for (int j = 0; j < pb.size(); j++) {
n개면 → n × n = n² 비교
전화번호 최대가 보통 10만 개 수준이라서
→ 100,000² = 100억 번 비교

→ 시간 초과 나는 게 정상입니다.

라네요....


import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        ArrayList<String> pb = new ArrayList<>(Arrays.asList(phone_book));
        
        for (int i = 0; i < pb.size(); i++) {
            for (int j = 0; j < pb.size(); j++) {
                if (i == j) continue;
                
                if (pb.get(j).startsWith(pb.get(i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}


*/


class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }
        
        return true;
    }
}