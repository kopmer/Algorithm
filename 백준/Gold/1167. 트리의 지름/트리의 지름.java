import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
/*
 * 트리의 지름 ->  임의의 두 점사이 거리중 가장 긴것
 */
	public static class Node {
		int to;
		int cost;
		
		public Node(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
	}
	public static int V;
	public static boolean[] visited;
	public static LinkedList<Node>[] graph;
	static int maxDist;
	static int farNode;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정점 개수
		V = Integer.parseInt(br.readLine());
		
		graph = new LinkedList[V+1];
		for(int i = 0; i <= V; i++) {
			graph[i] = new LinkedList<>();
		}
		
		// V개 줄에 걸쳐 간선 정보
		for(int i = 0; i < V; i++) {
			// 정점 번호(처음) / 다른 정점 번호, 정점 까지 거리 / 마지막 -1
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			// 
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if(to == -1) break;
				else {
					int cost = Integer.parseInt(st.nextToken());
					graph[from].add(new Node(to,cost));
				}
			}
			
			
		}
		bfs(1);
		maxDist = 0;
		bfs(farNode);
		System.out.println(maxDist);
//		for(int i = 0; i <= V; i++) {
//			for(Node n : graph[i]) {
//				System.out.print("to: " + n.to + " | cost: "+ n.cost + " | ");
//			}
//			System.out.println();
//		}
	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[V+1];
		int[] dist = new int[V+1];
		
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(Node next : graph[cur]) {
				if(!visited[next.to]) {
					visited[next.to] = true;
					dist[next.to] = dist[cur] + next.cost;
					q.add(next.to);
					
					if(dist[next.to] > maxDist) {
						maxDist = dist[next.to];
						farNode = next.to;
					}
				}
			}
		}
	}

}
