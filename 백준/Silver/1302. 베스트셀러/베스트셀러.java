import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String,Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String st = br.readLine();
			
			map.put(st, map.getOrDefault(st, 0) + 1);
		}
		String ans = "";
		int max = 0;
		
		for(Map.Entry<String,Integer> entry : map.entrySet()) {
			String st = entry.getKey();
			int cnt = entry.getValue();
			if(cnt > max) {
				ans = st;
				max = cnt;
			}else if(cnt == max) { // 사전순 비교
				if (st.compareTo(ans) < 0){
					ans = st;
				}
			}
		}
		System.out.println(ans);
		
		
	}

}
