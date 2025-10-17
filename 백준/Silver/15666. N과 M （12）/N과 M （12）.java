import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
/*
 * N개 중 M개를 고른 수열 -> 조합
 * 같은수 여러번 가능(중복 가능)
 * 고른 수열은 비 내림차순(오름 차순)
 * 
 */
	static int N, M;
	static int[] nums;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		sb = new StringBuilder();
		int[] out = new int[M];
		comb(0,0,out);
		System.out.println(sb);
	}
	
	public static void comb(int start, int idx, int[] out) {
		if(idx == M) {
			for(int n : out) {
				sb.append(n + " ");
			}
			sb.append("\n");
			return;
			
			
		}
		for(int i = start; i < N; i++) {
			out[idx] = nums[i];
			if(i-1 >= 0 && nums[i-1] == nums[i]) continue;
			comb(i, idx+1, out);
			
		}
	}
}
