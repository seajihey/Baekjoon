class Solution {
    public int solution(String word) {
        int answer = 0;

        int[] weights = {781, 156, 31, 6, 1};

        String dict = "AEIOU";

        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            int index = dict.indexOf(c);

            answer += index * weights[i] + 1;
        }

        return answer;
    }
}