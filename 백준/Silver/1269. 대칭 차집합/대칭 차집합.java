import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		        StringTokenizer st = new StringTokenizer(bf.readLine());

		        int n = Integer.parseInt(st.nextToken());
		        int m = Integer.parseInt(st.nextToken());

		        HashSet<Integer> setN = new HashSet<>();
		        HashSet<Integer> setM = new HashSet<>();

		        st = new StringTokenizer(bf.readLine());
		        for (int i = 0; i < n; i++) setN.add(Integer.parseInt(st.nextToken()));

		        st = new StringTokenizer(bf.readLine());
		        for (int i = 0; i < m; i++) setM.add(Integer.parseInt(st.nextToken()));

		        int result = 0;

		        for (int x : setN) {
		            if (!setM.contains(x)) result++;
		        }
		        for (int x : setM) {
		            if (!setN.contains(x)) result++;
		        }

		        System.out.println(result);
		    }
		
		
		
		
		
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(bf.readLine());
//		
//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
//		
//		ArrayList<Integer> listN = new ArrayList<>();
//		ArrayList<Integer> listM = new ArrayList<>();
//		
//		st = new StringTokenizer(bf.readLine());
//		for(int i = 0 ; i < n ; i++) {
//			listN.add(Integer.parseInt(st.nextToken()));
//		}
//		st = new StringTokenizer(bf.readLine());
//		for(int i = 0 ; i < m ; i++) {
//			listM.add(Integer.parseInt(st.nextToken()));
//		}
//		
//		int result = 0;
//		
//		for(int j = 0 ; j < listN.size();j++) {
//			if (!listM.contains(listN.get(j))) {
//				result = result + 1;
//			}
//		}
//		for(int k = 0 ; k < listM.size();k++) {
//			if (!listN.contains(listM.get(k))) {
//
//				result = result + 1;
//			}
//		}
//		System.out.println(result);


}
