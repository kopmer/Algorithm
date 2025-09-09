import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr,dp;
	static int LIS;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		LIS = 0;
		
		for(int i = 0; i < N; i++) {
			int idx = binarySearch(arr[i], 0, LIS, LIS+1);
			if(idx == -1) {
				dp[LIS] = arr[i];
				LIS++;
			}
			else {
				dp[idx] = arr[i];
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(LIS);

	}
	
	static int binarySearch(int num, int start, int end, int size) {
		int res = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(dp[mid] >= num) {
				res = mid;
				end = mid-1;
			}
			else {
				start = mid + 1;
			}
		}
		if(start == size) {
			return -1;
		}
		else {
			return res;
		}
	}

}
