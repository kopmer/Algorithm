import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == -1) break;
			
			Queue<Integer> q = new LinkedList<>();
			int sum = 0;
			for(int i = 1; i <= N / 2; i++) {
				if(N % i != 0) continue;
				sum += i;
				q.add(i);
			}
			if(sum != N) {
				sb.append(N + " is NOT perfect. \n");
				continue;
			};
			sb.append(N + " = ");
			while(!q.isEmpty()) {
				if(q.size() == 1) sb.append(q.poll() + "\n");
				else {
					sb.append(q.poll() + " + ");
				}
			}
		}
		System.out.println(sb);
		
	}

}
