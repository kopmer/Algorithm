import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * [0][0] -> [N-1][N-1]이동
 * 도둑 루피칸을 지나면 소지금 잃는다(비용)
 * 잃는 금액을 최소로 하여 이동(상하좌우 이동)
 * 
 */
public class Main {
static int[][] map;
static int[][] cost;
static int[] dx = {-1,0,1,0};//시계방향
static int[] dy = {0,1,0,-1};
static int N, tc;
	public static class node implements Comparable<node>{
		int x; int y; int cost;
		node(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;

		}
		@Override
		public int compareTo(node o) {
			return this.cost - o.cost;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = 0;
		while(true) {
			tc++;
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			map = new int[N][N];
			cost = new int[N][N];
			for(int i = 0; i < N; i++) {
				Arrays.fill(cost[i], Integer.MAX_VALUE);
			}
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(cost[i]));
//		}
			System.out.println("Problem " + tc + ": "+cost[N-1][N-1]);
		}
	}
	public static void bfs() {
		node start = new node(0,0,map[0][0]);
		cost[start.x][start.y] = start.cost;
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(start);
		while(!pq.isEmpty()) {
			node now = pq.poll();
			
			if(now.cost > cost[now.x][now.y]) continue; //기존 루트비용보다 현재가중치가 더 크면 건너뜀(가지치기)
			
			for(int i = 0; i < 4; i++) {
				
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
				int newCost = cost[now.x][now.y] + map[nx][ny];
				if(newCost < cost[nx][ny]) {
					cost[nx][ny] = newCost;
					pq.add(new node(nx,ny,map[nx][ny]));
				}
			}
			
		}
	}

}
