import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//Dij = min(Dij,(Dik + Dkj))
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dist = new int[N+1][N+1]; // 1-based
		
		// 초기 거리 자기 자신은 0, 이외 다른 도시까지 도달 불가로 초기화
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j) {
					dist[i][j] = 0;
				}
				else {
					dist[i][j] = Integer.MAX_VALUE;
				}					
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			dist[a][b] = Math.min(dist[a][b], cost);
//			dist[b][a] = Math.min(dist[b][a], cost);
		}
		
//		for(int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
						dist[i][j] = Math.min(dist[i][k]+dist[k][j], dist[i][j]);
						
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(dist[i][j] == Integer.MAX_VALUE) {
					sb.append("0 ");
				}
				else {
					sb.append(dist[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
