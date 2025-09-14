import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * knapsack
 * 최대 K만큼 넣을수 있는가방에 넣을수 있는 물건들의 가치의 최댓값 구하기
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//각 물건의 무게, 각 물건의 가치 1-based
		int[] Weights = new int[N+1];
		int[] Values = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			Weights[i] = Integer.parseInt(st.nextToken());
			Values[i] = Integer.parseInt(st.nextToken());
		}
		
		//1-base, [0][K]&[N][0] 패딩 (고려하는 물건x, 무게 0)
		int[][] dp = new int[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			int curWeight = Weights[i];
			int curValue = Values[i];
			
			for(int j = 1; j <= K; j++) {
				if(j<curWeight) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-curWeight]+curValue);
				}
				
			}
		}
		System.out.println(dp[N][K]);
	}

}
