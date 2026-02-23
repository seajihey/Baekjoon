/*
 * 
 * 1. op 명령어는 굳이 저장하지않고 if 문으로 처리
 * 			op==1
 * 			
 * 			op==0
 * 				
 * 
 * 
 * 
 * TS 
 * 1. Key Val HASHMAP으로 해결하려했으나 ArrayList추가가 애매해져서 기각
 * 배열로 해결
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void union(int x, int y, int[] parent) {
		// 현재 parent배열과 찾기위한 X,Y의 값 넣어서 자신의 루트찾기 
		int rootA = find(x,parent);
		int rootB = find(y,parent);
		//만약 두개의 루트가 다르면 x = 1, y = 3일때
        // 3을 1의 자식으로 만들라는 뜻이므로
        // parent[3] = 루트값. 즉 1을 가르켜라 라고지정
        // 그래서 parent[3]=1이되고
        // 그의루트는 parent[1]=1즉 1이된다
		if(rootA!=rootB) parent[rootB]=rootA;
	}
	public static int find(int x,int[] parent ) {
        // X값의 루트찾아주는거
        // 만약 전부 지가 대표라면
        // parent[3]의값은 3이되므로
        //바로 루트리턴
        
		if (parent[x] == x) return x;
        
        //아니라면 parent[3]이 가리키는 값을 find의 int로 넣어서
        // parent[ 0 , 1, 1 ]이라하면 3의 엄마는 parent[1]의값이다를 나타내고
        // parnet[3] = 1. find(1)하면
        // 1이므로 루트는 1이된다
		return parent[x]=find(parent[x],parent);
	}
	
	public static void main(String[] args) throws IOException {

		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		//초기엔 지가 다 대표
		int [] parent = new int[n+1];
		for (int i=0; i<=n; i++) parent[i] = i;
		for(int i =0;i<m;i++) {
		    st = new StringTokenizer(bf.readLine());
			int op = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
            
            //값 입력받자마자 바로바로 해결
			//union
			if(op==0) {
				union(x,y,parent);
			}
			// find -> rs값추가
			if(op==1) {
				if (find(x,parent)==find(y,parent)){
					sb.append("YES\n");
				}else {
					sb.append("NO\n");
				}
			}
			

		}
		
		System.out.print(sb.toString());		
		
	}

}
