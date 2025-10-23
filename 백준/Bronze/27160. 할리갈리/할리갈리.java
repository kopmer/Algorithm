import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String,Integer> map = new HashMap<>();
		boolean isbell = false;
		
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String furuit = st.nextToken();
			int cnt = Integer.parseInt(st.nextToken());
			map.put(furuit, map.getOrDefault(furuit, 0) + cnt);
		}
		
		for(String f : map.keySet()) {
			if(map.get(f) == 5) isbell = true;
		}
		
		System.out.println(isbell ? "YES":"NO");
	}

}
