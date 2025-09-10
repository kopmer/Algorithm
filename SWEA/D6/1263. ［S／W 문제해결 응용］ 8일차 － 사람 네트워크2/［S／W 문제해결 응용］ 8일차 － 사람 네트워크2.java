import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
/*
 * CC(i) = dist(i,j)
 */
	static int[][] graph,dist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			graph = new int[N+1][N+1];
			dist = new int[N+1][N+1];
			
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					if(graph[i][j] == 0) {
						dist[i][j] = Integer.MAX_VALUE;
					}
					else {
						dist[i][j] = 1;
					}
				}
			}
//			for(int i = 0; i <= N; i++) {
//				System.out.println(Arrays.toString(graph[i]));
//			}
			for(int k = 1; k <= N; k++) {
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= N; j++) {
						if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
							dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]); 							
						}
					}
				}
			}
			int minCnt = Integer.MAX_VALUE;
			for(int i = 1; i <= N; i++) {
				int cnt = 0;
				for(int j = 1; j <= N; j++) {
					if(i == j) continue;
					cnt += dist[i][j];
					if(j == N) {
						minCnt = Math.min(cnt, minCnt);
					}
				}
			}
			
//			for(int i = 0; i <= N; i++) {
//				System.out.println(Arrays.toString(dist[i]));
//			}
			System.out.println("#"+tc+" "+minCnt);
		}

	}

}
