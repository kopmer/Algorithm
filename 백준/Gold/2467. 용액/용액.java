import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 * left, right 포인터 두고 포인터 값의 합이 0 이면 left, right출력
 * left, right 합 절대값이 기존보다 크면 
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
//		System.out.println(list);
		search(list);
	}

	private static void search(ArrayList<Integer> list) {
		//시작 끝 포인터 인덱스
		int start = 0;
		int end = list.size() - 1;
		int min = Integer.MAX_VALUE;
		int[] ans = new int[2];
		
		while(start < end) {
			int sum = Math.abs(list.get(start) + list.get(end));
			// 두 수의 합이 현재 min보다 작으면 갱신
			if(sum < min) {
				min = sum;
				ans[0] = list.get(start);
				ans[1] = list.get(end);
			}
			// 두 수의 합이 0보다 크면 합이 더 작아져야함 -> end 왼쪽으로
			if(list.get(start) + list.get(end) > 0) {
				end--;
			}
			// 두 수의 합이 0보다 작으면 합이더 커져야함 -> start 오른쪽으로
			else if(list.get(start) + list.get(end) < 0) {
				start++;
			}
			else {
				ans[0] = list.get(start);
				ans[1] = list.get(end);
				break;
			}
		}
		System.out.println(ans[0] + " " + ans[1]);
	}
	

}
