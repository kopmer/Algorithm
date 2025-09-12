import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static List<int[]> worm;
	static int[] result;
	static long min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			worm = new LinkedList<>();
			int sumx = 0;
			int sumy = 0;
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				sumx += x;
				sumy += y;
				worm.add(new int[] {x,y});
				
			}
			result = new int[N/2];
			min = Long.MAX_VALUE;
			comb(0,0,N,sumx,sumy);
			System.out.println("#"+tc+" "+min);
		}
	}
	static void comb(int idx, int start, int N, int sumx, int sumy) {
		if(idx == N/2) {// 음수벡터 N/2개 골랐으면
			long px = 0; long py = 0;
			for(int i : result) {
				px += worm.get(i)[0];
				py += worm.get(i)[1];
				
			}
			long vx = sumx - px * 2  ;
			long vy = sumy -py * 2 ;
			long dist = vx * vx + vy * vy;
			min = Math.min(min, dist);
			return;
		}
		for(int i = start; i < N; i++) {
			result[idx] = i;
			comb(idx+1,i+1,N,sumx,sumy);
			
		}
	}
	

}
