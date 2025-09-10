import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
/*
 * 자신보다 큰 학생 수, 자신보다 작은 학생 수를 알수 있으면 됨
 * outgraph, ingraph 두개 만들어서 해당 노드에서 각각 bfs해주고 모든 노드 방문했으면 몇번째인지 아는것임
 */
	static List<LinkedList<Integer>> ingraph, outgraph;
	static int N, M, result;
	static boolean[] know;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			result = 0;
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			ingraph = new LinkedList<>();
			outgraph = new LinkedList<>();
			
			for(int i = 0; i <= N; i++) { // 1-based
				ingraph.add(new LinkedList<>());
				outgraph.add(new LinkedList<>());
			}
			
			for(int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				//out 자신보다 큰키
				outgraph.get(a).add(b);
				//in 자신보다 작은키
				ingraph.get(b).add(a);
				
				
				
			}
			for(int i = 1; i <= N; i++) {
				
				know = new boolean[N+1];
				bfs(i,outgraph);
				bfs(i,ingraph);
				
				int cnt = 0; //알고있는 키 개수

				for(int k = 1; k <= N; k++) {
					if(know[k])cnt++;
				}
				if(cnt == N) {
					result++;
				}
				
			}
			System.out.println("#"+tc+" "+result);
		}
		
	}
	static void bfs(int start, List<LinkedList<Integer>> list) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		know[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : list.get(now)) {
				if(visited[next]) continue;
				q.add(next);
				visited[next] = true;
				know[next] = true;
			}
		}
	}

}
