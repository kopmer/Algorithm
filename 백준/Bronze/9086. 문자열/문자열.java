import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0;i < T;i++) {
			String st = br.readLine();

			int stLen = st.length();
			System.out.println(st.charAt(0)+""+st.charAt(stLen-1));
		}

	}

}
