import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int totalTime = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int Ti = Integer.parseInt(st.nextToken());
			totalTime += Ti;
		}
		totalTime += (N-1) * 8;
		System.out.println(totalTime / 24 + " " + totalTime % 24);
	}

}
