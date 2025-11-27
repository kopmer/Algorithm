import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 0;
		st = new StringTokenizer(br.readLine());
		int[] cards = new int[N];
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N-2; i++) {
			int a = cards[i];
			for(int j = i+1; j < N-1;j++) {
				int b = cards[j];
				for(int k = j+1; k < N; k++) {
					int c = cards[k];
					int blackJack = a + b + c;
					// M을 넘지 않으면서 M에 가까운
					if(blackJack <= M) ans = Math.max(blackJack, ans);
				}
			}
		}
		System.out.println(ans);
	}

}
