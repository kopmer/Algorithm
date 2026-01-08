import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
/*
 * M : 보석 색상 가지 수
 * N : 학생 수
 * N <= M
 * 하나도 못 받아도 됨, 학생은 같은 색상만 가질수 있음
 * 질투심: 가장 많은 보석을 가진 학생의 보석 수 -> 한사람이 가질 수 있는 최대 보석 개수
 * 질투심의 최솟값 찾기 -> 이분탐색
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 보석 색상 가지
		
		int[] arr = new int[M];
		int max = 0;
		int ans = max;
		// M색상의 보석 수
		for(int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(arr[i], max);
		}
		int left = 1;
		int right = max;
		while(left <= right) {
			int mid = (left + right) / 2;
			int need = 0; // 모든 색상에 필요한 사람들
			
			for(int a : arr) {
				need += (a + mid - 1) / mid;
			}
			
			if(need <= N) {
				ans = mid;
				right = mid - 1;
			}
			// 보석 할당 불가 -> 질투심 늘려줘야함(할당 가능 최대 보석 늘려줘야함)
			else {
				left = mid + 1;
			}
		}
		System.out.println(ans);
	}

}
