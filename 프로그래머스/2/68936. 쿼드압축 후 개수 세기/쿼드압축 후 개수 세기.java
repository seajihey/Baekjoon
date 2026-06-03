class Solution {

    int zero = 0;
    int one = 0;

    public int[] solution(int[][] arr) {
        solve(arr, 0, 0, arr.length);
        return new int[]{zero, one};
    }

    void solve(int[][] arr, int r, int c, int size) {

        int first = arr[r][c];
        boolean same = true;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != first) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        if (same) {
            if (first == 0) zero++;
            else one++;
            return;
        }

        int half = size / 2;

        solve(arr, r, c, half);
        solve(arr, r, c + half, half);
        solve(arr, r + half, c, half);
        solve(arr, r + half, c + half, half);
    }
}