import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(bf.readLine());

        int k = Integer.parseInt(st1.nextToken());
        long n = Long.parseLong(st1.nextToken()); // n도 long으로

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(bf.readLine().trim());
        }

        long start = 1L;
        long ans = 0L;

        long end = arr[0];
        for (int num : arr) {
            if (num > end) end = num;
        }

        while (start <= end) {
            long mid = start + (end - start) / 2;

            long maxRs = 0L; // 반복마다 초기화 (여기서 하는 게 안전)
            for (int cur : arr) {
                maxRs += (cur / mid);
            }

            if (maxRs >= n) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
