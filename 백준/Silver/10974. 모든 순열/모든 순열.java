import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
static boolean visited[];
static int arr[];
static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		arr = new int[N];
		perm(0,N);
		System.out.print(sb.toString());
	}
	static void perm(int depth, int N) {
		if(depth == N) { //최고 깊이마다(N개 다 고를때마다)
			for(int i = 0; i< N; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 1;i <= N;i++) {
			if(!visited[i]) { //이전에 방문 안했으면
				visited[i] = true;//1. 지금 숫자 선택
				arr[depth] = i; // 2. 지금 깊이에 숫자 추가 
				perm(depth+1,N); //3. 다음깊이 선택하러
				visited[i] = false; // 이전깊이로 백트레킹
			}
		}
	}

}
