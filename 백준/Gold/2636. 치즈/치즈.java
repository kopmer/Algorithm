import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[][] map;
	static int H, W, cheese;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited,melt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0; cheese = 0;
		//치즈 다 녹을때까지
		while(true) {
			if(cheeseSum() == 0) { break;} //치즈 없으면 중지
			cnt++;
			bfs(0,0);//녹을 치즈 체크
			melting();//치즈 녹이기
			
		}
		System.out.println(cnt+"\n"+cheese);
	}
	//남은 치즈 개수 세기
	static int cheeseSum() {
		int cnt = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j] == 0) continue;
				cnt++;
			}
		}
		if(cnt != 0) { //치즈 있으면 기록해두기
			cheese = cnt;
		}
		return cnt;
	}
	static void melting() {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(!melt[i][j]) continue;
				map[i][j] = 0;
			}
		}
	}
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[H][W];
		melt = new boolean[H][W];
		visited[x][y] = true;
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				//방문했거나 맵 밖이면 패스
				if(nx < 0 || ny < 0 || nx >= H || ny >= W || visited[nx][ny]) continue;
				//치즈면 녹는맵에 체크 해두기
				if(map[nx][ny] == 1) {
					melt[nx][ny] = true;
				}
				//0이면 방문처리 하고 큐에 넣기
				else {
					visited[nx][ny] = true;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}
}
