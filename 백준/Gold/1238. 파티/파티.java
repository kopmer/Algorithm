import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
/*
 * X에서 다익 시작한 후 가장 cost가 큰 마을 리턴 하면 될듯
 */
	static int[] cost;
	static List<Edge>[] graph, reverseGraph;
	static int N;
	public static class Edge implements Comparable<Edge>{
		int to; int c;
		public Edge(int to, int c) {
			this.to = to;
			this.c = c;
		}
		@Override
		public int compareTo(Edge o) {
			return this.c - o.c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()); // 파티 장소
		
		graph = new ArrayList[N+1];
		reverseGraph = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
			reverseGraph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Edge(to ,c));
			reverseGraph[to].add(new Edge(from, c));
		}
		int[] distTo = dij(graph, X);       
        int[] distFrom = dij(reverseGraph, X); 
        
        int result = 0;
        for(int i = 1; i <= N; i++) {
        	if(i == X) continue;
        	result = Math.max(result, distTo[i] + distFrom[i]);
        }
		System.out.println(result);
	}
	public static int[] dij(List<Edge>[] list, int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		cost = new int[N+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		pq.add(new Edge(start, 0));
		cost[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(now.c > cost[now.to]) continue;
			
			for(Edge next : list[now.to]) {
				int newCost = now.c + next.c;
				if(newCost >= cost[next.to]) continue;
				cost[next.to] = newCost;
				pq.add(new Edge(next.to, newCost));
			}
		}
		return cost;
	}

}
