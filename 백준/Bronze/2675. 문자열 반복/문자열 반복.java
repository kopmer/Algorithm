import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int repeat = Integer.parseInt(st.nextToken()); // 반복 횟수
			String word = st.nextToken(); 
			
			for(int i = 0; i < word.length(); i++) {
				for(int j = 0; j < repeat; j++) {
//					System.out.println(word.charAt(i));
					sb.append(word.charAt(i));
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
		
		
	}

}
