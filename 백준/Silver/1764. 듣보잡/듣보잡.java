import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> listen = new HashSet<>();
		HashSet<String> see = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			listen.add(br.readLine());
		}
		for(int i = 0; i < M; i++) {
			see.add(br.readLine());
		}
		List<String> list = new ArrayList<>(listen);
		Collections.sort(list);
		int cnt = 0;
		for(String s : list) {
			if(see.contains(s)) {
				sb.append(s).append("\n");
				cnt++;
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
	}

}
