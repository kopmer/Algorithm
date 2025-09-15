import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
/*
 * 카드 골고루 셔플(덱에서 절반 나누고 하나씩 교차)
 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] deck = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				deck[i] = st.nextToken();
			}
			//절반씩 나누기 홀수라면(뒤에 덱이 한장더 갖고감)
			int deck2Idx = N/2;
			if(N % 2 == 1) deck2Idx++;
			
			System.out.print("#"+tc+" ");
			for(int i = 0; i < deck2Idx; i++) {
				System.out.print(deck[i] + " ");
				if(deck2Idx+i == N)continue;
				System.out.print(deck[deck2Idx+i]+ " ");
			}
			System.out.println();

		}
	}

}
