import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int[] nums;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		nums = new int[N*N];

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				nums[i*N+j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(nums);
		
//		System.out.println(Arrays.toString(nums));
		System.out.println(nums[N*N-N]);
	}

}
