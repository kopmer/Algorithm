import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
static int map[][];
static int dx[] = {-1,1,0,0};
static int dy[] = {0,0,-1,1};
static int moveCnt;
static int MaxMove;
static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int testCase = 1;testCase <= TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			// 방 입력 받기
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N;j ++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxStartX = 0;
			int maxStartY = 0;
			MaxMove = -1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N;j ++) {
					moveCnt = 1;
					dfs(i,j);
					if (moveCnt > MaxMove) { //최대 방 이동수 갱신
						MaxMove = moveCnt;
						maxStartX = i;
						maxStartY = j;
					}
					else if(moveCnt == MaxMove && map[i][j]<map[maxStartX][maxStartY]) { // 최대 방 이동수 같고 수가 더 작다면
						maxStartX = i;
						maxStartY = j;
					}
				}
			}
			System.out.println("#"+testCase+" "+map[maxStartX][maxStartY]+" "+MaxMove);
			
			
			
		}
	}
	public static void dfs(int x, int y) {
		
		for(int i = 0;i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(map[x][y] == map[nx][ny]-1) {
					moveCnt++;
					dfs(nx,ny);
				}
			}
		}
		
	}

}
