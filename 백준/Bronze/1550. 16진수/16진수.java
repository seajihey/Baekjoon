import java.io.*;
import java.util.*;
//버퍼리더 드디어 안 보고 쓸 수 있게 됨

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String inputs = bf.readLine().trim();

        Map<Character, Integer> hexMap = new HashMap<>();
        hexMap.put('A', 10);
        hexMap.put('B', 11);
        hexMap.put('C', 12);
        hexMap.put('D', 13);
        hexMap.put('E', 14);
        hexMap.put('F', 15);
        // 최종 10진수 결과를 저장할 변수
        int result = 0;

        // 입력 문자열을 한 글자씩 순회
        for (char c : inputs.toCharArray()) {

            int value; // 현재 자리의 10진수 값

            // 문자가 A~F인 경우
            if (hexMap.containsKey(c)) {
                value = hexMap.get(c);
            }
            // 문자가 0~9인 경우
            else {
                value = c - '0'; // 문자 → 숫자 변환
            }

            // 이전 값에 16을 곱하고 현재 자리 값을 더함
            result = result * 16 + value;
        }

        // 최종 결과 출력
        System.out.println(result);
    }
}