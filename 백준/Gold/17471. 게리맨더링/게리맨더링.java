import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
/*
 * 구역은 1번~N번 
 * 구역을2개의 선거구로 나눠야한다
 * 한 선거구에 포함되어 있는 구역은 모두 연결되어 있엉야 한다
 * 두 선거구의 인구 차이를 최소화
 * 백준시의 정보가 주어졌을떄, 인구차이의 최솟값을 구해보자
 */
	static int N, minGap;
	static boolean[] visited, connect;
	static List<LinkedList<Integer>> graph;
	static int[] popu;
	static List<Integer> Alist, Blist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		graph = new LinkedList<>();
		
		popu = new int[N+1];
		
		for(int i = 0; i <= N; i++) { //1-base
			graph.add(new LinkedList<>());
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			popu[i] = Integer.parseInt(st.nextToken());
		}
		
		//인접 구역 번호수
		for(int i = 1; i <= N; i++) { // N번 노드와 인접한 구역들
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); //인접 노드 개수
			for(int j = 0; j < num; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		minGap = Integer.MAX_VALUE;
		visited = new boolean[N+1];
		subset(1);
		System.out.println(minGap == Integer.MAX_VALUE ? -1 : minGap);
	}
	static boolean isConnected(List<Integer> list) {
		Queue<Integer> q = new LinkedList<>();
		connect = new boolean[N+1];
		q.add(list.get(0));
		connect[list.get(0)] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : graph.get(now)) {
				if(connect[next]) continue;
				//다른 구역이면 패스
				if(!list.contains(next))continue;
				connect[next] = true;
				q.add(next);
			}
			
		}
		for(int num : list) {
			if(!connect[num]) return false;
		}
		return true;
	}
	static void subset(int idx) {
		if(idx == N) {
			Alist = new LinkedList<>();
			Blist = new LinkedList<>();
			for(int i = 1; i <= N; i++) {
				if(visited[i] == true) Alist.add(i);
				else {Blist.add(i);}
			}
			if(Alist.isEmpty() || Blist.isEmpty()) return;
			if(!isConnected(Alist) || !isConnected(Blist)) return;
			int sumA = 0; int sumB = 0;
			for(int A : Alist) {
				sumA += popu[A];
			}
			for(int B : Blist) {
				sumB += popu[B];
			}
			minGap = Math.min(minGap, Math.abs(sumA - sumB));
//			System.out.println(Arrays.toString(Alist.toArray()));
			return;
		}
		visited[idx] = true;
		subset(idx+1);
		visited[idx] = false;
		subset(idx+1);

	}
}
