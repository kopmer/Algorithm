
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			pq.offer(num);
		}
		
		int ans = 0;

        // 카드 묶음이 1개만 있으면 비교 비용 0
        if (pq.size() == 1) {
            System.out.println(0);
            return;
        }

        // PQ에 1개 남을 때까지 반복
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int sum = a + b;
            ans += sum;
            pq.add(sum);
        }
		System.out.println(ans);
	}

}
