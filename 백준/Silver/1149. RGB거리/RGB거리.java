import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] RGB = new int[N+1][3]; //[i][0] = R, [i][1] = G, [i][2] = B
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			RGB[i][0] = Integer.parseInt(st.nextToken());
			RGB[i][1] = Integer.parseInt(st.nextToken());
			RGB[i][2] = Integer.parseInt(st.nextToken());
			
		}
		
		int[][] dp = new int[N+1][3];
		for(int i = 1; i <= N; i++) {
			//i번째집 R일때 최소 비용
			//현재 R + 이전 집 G, B중 최소
			dp[i][0] = RGB[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			//i번째집 G일때 최소 비용
			//현재 G + 이전 집 R, B중 최소
			dp[i][1] = RGB[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			//i번째집 B일때 최소 비용
			//현재 B + 이전 집 R, G중 최소
			dp[i][2] = RGB[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]),dp[N][2]));
		
	}

}
