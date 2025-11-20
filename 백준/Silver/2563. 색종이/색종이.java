import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[101][101];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			for(int row = r; row < r + 10; row++) {
				for(int col = c; col < c + 10; col++) {
					map[row][col] = true;
				}
			}

		}
		int cnt = 0;
		for(int i = 1; i < 101; i++) {
			for(int j = 1; j < 101; j++) {
				if(!map[i][j]) continue;
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}
