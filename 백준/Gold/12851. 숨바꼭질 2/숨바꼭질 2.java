import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//큐에 이동지점 넣기
static int[][] map = new int[100001][2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(N==K) {
			System.out.println(0);
			System.out.println(1);
		}
		else {
			bfs(N, K);
			System.out.println(map[K][0]);
			System.out.println(map[K][1]);
			
		}
	}
	
	static void bfs(int N, int K) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {N,0});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int front = now[0]+1;
			int back = now[0]-1;
			int teleport = now[0]*2;
			int nxtime = now[1]+1;
			if(front <=100000 && front > 0) {
				if(map[front][0] > nxtime | map[front][0] == 0) {
					map[front][0] = nxtime;
					map[front][1] = 1;
					queue.offer(new int[] {front,nxtime});
				}
				else if(map[front][0] == nxtime) {
					map[front][1]++;
					queue.offer(new int[] {front,nxtime});
				}
			}
			if(back >=0 && back < 100000) {
				if(map[back][0] > nxtime | map[back][0] == 0) {
					map[back][0] = nxtime;
					map[back][1] = 1;
					queue.offer(new int[] {back,nxtime});
				}
				else if(map[back][0] == nxtime) {
					map[back][1]++;
					queue.offer(new int[] {back,nxtime});
				}
			}
			if(teleport > 0 && teleport <=100000) {
				if(map[teleport][0] > nxtime | map[teleport][0] == 0) {
					map[teleport][0] = nxtime;
					map[teleport][1] = 1;
					queue.offer(new int[] {teleport,nxtime});
				}
				else if(map[teleport][0] == nxtime) {
					map[teleport][1]++;
					queue.offer(new int[] {teleport,nxtime});
				}
			}
			
		}
	}

}
