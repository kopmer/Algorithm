
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		dp[1] = 0;
		if(N >= 2) {
			dp[2] = 1; 
		}
		if(N >= 3) {
			dp[3] = 1;	
		}
		if(N >= 4) {
			for(int i = 4; i <= N; i++) {
				dp[i] = dp[i-1] + 1;
				if(i % 2 == 0) {
					dp[i] = Math.min(dp[i],dp[i/2] + 1);
				}
				if(i % 3 == 0) { 
					dp[i] = Math.min(dp[i/3] + 1, dp[i]);;
				}

			}
		}
			
		System.out.println(dp[N]);
	}

}
