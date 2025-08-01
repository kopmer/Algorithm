import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static int dx[] = {-1,1,0,0,-1,-1,1,1};
	static int dy[] = {0,0,-1,1,-1,1,-1,1};
	static int[][] map;
	static boolean[][] visited; 
	static int h;
	static int w;
	static int cnt;
	public static void main(String[] args) throws IOException {
		// BufferedReader 객체
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			cnt = 0;
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i = 0;i < h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j < w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i = 0;i < h;i++) {
				for(int j = 0;j < w;j++) {
					if(visited[i][j] == false && map[i][j] == 1) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
		

	}
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i = 0;i<8;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];

			if(nx >= 0 && ny >= 0 && nx < h && ny < w) {
				if(visited[nx][ny] == false && map[nx][ny] == 1) {
					dfs(nx,ny);
				}
				
			}
		}
	}

}