import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		int answer = 4; // 양쪽 포인터 차이는 최대 4
		
		for(int i = 0; i < N; i++) {
			int end = i;
			while(end < N && arr[end] - arr[i] <= 4) { //end 포인터 한칸씩 뒤로
				end++;
			}
			int len = end - i;
			answer = Math.min(answer, 5 - len);
		}
		
		System.out.println(answer);
	}

}
