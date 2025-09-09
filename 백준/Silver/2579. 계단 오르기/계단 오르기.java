import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 계단 한번에 한계단 or 두계단씩
 * 연속된 세계단 x
 *  
 */
public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] step = new int[N+1]; // 1-based
		int[] dp = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = step[1];
		if(N >= 2) {
			dp[2] = step[2]+step[1];
		}
		if(N >= 3) {
			for(int i = 3; i <= N; i++) {
				dp[i] = Math.max(dp[i-2]+step[i],dp[i-3]+step[i-1]+step[i]);
			}			
		}
		System.out.println(dp[N]);
//		System.out.println(Arrays.toString(dp));
	}

}
