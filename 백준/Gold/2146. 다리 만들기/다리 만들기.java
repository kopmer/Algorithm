import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
/*
 * 동서남북으로 연결 -> 같은섬
 * 섬을 잇는 다리를 가장 짧게 하나만
 * 다리를 놓을수 있는곳(사방이 1이 아닌곳)에서 bfs로 다른섬 탐색후 가장 짧은 길이 반환
 */
	static int[][] map;
	static boolean[][] numVisited, visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N;
	static List<Integer> edgeList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int num = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] != 1) continue;
				num++;
				numVisited = new boolean[N][N];
				numbering(i,j,num); //섬 넘버링
			}
		}
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		//섬 최외곽 체크
//		outline = new boolean[N][N];
		edgeList = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0) continue;
				if(checkCross(i,j)) {
					visited = new boolean[N][N];
					edgeList.add(makeB(i,j,map[i][j]));
				};
			}
		}
		Collections.sort(edgeList);
		System.out.println(edgeList.get(0));

	}
	static int makeB(int x, int y, int islandNum) {
		Queue<int[]> q = new LinkedList<int[]>();
		visited[x][y] = true;
		
		q.add(new int[] {x,y,0});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				int edgeCnt = now[2];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(map[nx][ny] == islandNum || visited[nx][ny]) continue; //같은 섬이거나 방문했으면 다리 안놓음
				else if(map[nx][ny] == 0) { //바다면 다리 놓기
					visited[nx][ny] = true;
					q.add(new int[] {nx,ny,edgeCnt+1});
				}
				else {
					return edgeCnt;
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	//사방중 다리 놓을 수 있으면 true
	static boolean checkCross(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if(map[nx][ny] == 0) return true;
		}
		return false;
	}
	static void numbering(int x, int y, int num) {
		Queue<int[]> q = new LinkedList<int[]>();
		numVisited[x][y] = true;
		map[x][y] = num;
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx < 0 || ny < 0|| nx >= N || ny >= N) continue;
				if(numVisited[nx][ny] || map[nx][ny] != 1) continue;
				map[nx][ny] = num;
				numVisited[nx][ny] = true;
				q.add(new int[] {nx,ny});
				
			}
		}
	}

}
