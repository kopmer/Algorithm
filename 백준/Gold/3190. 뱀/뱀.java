import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
/*
 * 벽이나 자기 자신 몸과 부딪히면 종료
 * 사과 먹으면 몸길이 늘어남
 * 사과위치와 뱀 이동경로 주어졌을때 게임 종료 시간
 * 
 * 맵 만들고 사과들 좌표 1로 표시
 * 머리 꼬리 디큐로 관리
 */
	static int N, K;
	static int[][] map;
	static HashMap<Integer,Character> command;
	static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] = 1;
		}
		
		int L = Integer.parseInt(br.readLine());
		command = new HashMap<>();
		// 전환 시간, 전환 방향
		for(int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			command.put(X,C);
		}
		int tick = gameStart();
		System.out.println(tick);
	}
		
	public static int gameStart() {
		Deque<int[]> snake = new LinkedList<>();
		snake.add(new int[] {0,0});
		map[0][0] = 2;
		
		int dir = 1;
		int tick = 0;
		
		while(true) {
			tick++;
			int[] head = snake.peekLast();
			int nx = head[0] + dx[dir];
			int ny = head[1] + dy[dir];
			// 벽이랑 몸통 부딪히면 종료
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 2) return tick;
			// 사과 없으면 꼬리 제거
			if(map[nx][ny] != 1) {
				int[] tail = snake.pollFirst();
				map[tail[0]][tail[1]] = 0;
			}
			// 머리 이동
			snake.addLast(new int[] {nx,ny});
			map[nx][ny] = 2;
			// 방향 전환
			if(command.containsKey(tick)) {
				char com = command.get(tick);
				if(com == 'L') dir = (dir + 3) % 4;
				else dir = (dir + 1) % 4;
			}
		}
	}

}
