import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException{
		// ===========
		//    Input
		// ===========
		BufferedReader bf = new BufferedReader(new InputStreamReader((System.in)));

		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0 ; i < m ; i ++){
			st = new StringTokenizer(bf.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());

			graph.get(a).add(new int[]{b,c});
			graph.get(b).add(new int[]{a,c});

		}



		// ===========
		//    Logic
		// ===========
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.add(new int[]{1, 0}); // (노드, 현재 비용)

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int now = cur[0];
			int cost = cur[1];

			if (cost > dist[now]) continue;

			for (int[] next : graph.get(now)) {
				int nextNode = next[0];
				int nextCost = next[1];

				if (dist[nextNode] > cost + nextCost) {
					dist[nextNode] = cost + nextCost;
					pq.add(new int[]{nextNode, dist[nextNode]});
				}
			}
		}
		System.out.println(dist[n]);





	}


}
