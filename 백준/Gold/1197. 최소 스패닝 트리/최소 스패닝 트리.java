import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<edge>[] edgeList;
	static boolean[] visited;
	static class edge implements Comparable<edge>{
		int from; int to;
		long cost;
		public edge(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int vCnt = Integer.parseInt(st.nextToken());
		int eCnt = Integer.parseInt(st.nextToken());
		
		edgeList = new ArrayList[vCnt + 1];
		for(int i = 1;i <= vCnt; i++) {
			edgeList[i] = new ArrayList<>();
		}

		
		for(int i = 0; i < eCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long cost = Long.parseLong(st.nextToken());
			edgeList[from].add(new edge(to,cost));
			edgeList[to].add(new edge(from,cost));
		}
		visited = new boolean[vCnt+1];
		long sum = prim(1,vCnt);
		System.out.println(sum);
	}
	static long prim(int start, int vCnt) {
		PriorityQueue<edge> pq = new PriorityQueue<>();
		long sum = 0;
		int cnt = 0;
		
		pq.add(new edge(start,0));
		
		while(!pq.isEmpty()) {
			edge now = pq.poll();
						
			if(visited[now.to]) continue;
			visited[now.to] = true;
			sum += now.cost;
			cnt++;
			
			if(cnt == vCnt) break;
			
			for(edge next : edgeList[now.to]) {
				if(visited[next.to])continue;
				pq.offer(next);
			}
		}
		return sum;
		
	}
}
