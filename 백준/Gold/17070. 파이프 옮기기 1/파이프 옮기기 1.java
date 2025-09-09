import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//..[0] 가로, ..[1] 대각, ..[2]세로 로 파이프가 놓이는 경우의수
		int[][][] dp = new int[N+1][N+1][3];

		
		dp[1][2][0] = 1;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 3; j <= N; j++) {
				if(map[i][j] == 1)continue;
				//(i,j-1), (i-1,j-1), (i-1,j) pipeTable확인
				//가로
				if(map[i][j-1] == 0) {
					dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
				}
				//대각의 경우 왼쪽 위쪽도 빈칸이어야 함
				if(map[i-1][j-1] == 0 && map[i][j-1] == 0 && map[i-1][j] == 0) {
					dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2]; 
				}
				if(map[i-1][j] == 0) {
					dp[i][j][2] = dp[i-1][j][1] +dp[i-1][j][2];  
				}
				
				
			}
		}
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
//		for(int i = 0; i <= N; i ++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
	}
//	static boolean is 

}
