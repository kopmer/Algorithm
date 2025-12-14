import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 집합 S의 개수 N
		int N  = Integer.parseInt(st.nextToken());
		// 검사 해야하는 문자열 개수 M
		int M = Integer.parseInt(st.nextToken());
		
		// hashset(집합S)에 문자열 추가
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		// 집합 S에 포함된건지 확인
		int cnt = 0;
		for(int i = 0; i < M; i++) {
			if(set.contains(br.readLine())) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
