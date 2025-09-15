import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] books;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		books = new int[N+1];
		//1번부터 N번 책 일렬로 꽂혀있음
		for(int i = 1; i <= N; i++) {
			books[i] = i;
		}
		for(int cnt = 0; cnt < M; cnt++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			//i ~ j까지 순서 뒤집기
			reverse(i,j);
			
		}
		for(int i = 1; i <= N; i++) {
			System.out.print(books[i] + " ");
		}
		
	}
	
	static void reverse(int i, int j) {
		//책장에서 뺴놓기
		int bookCnt = j-i+1;
		int[] hands = new int[bookCnt];
		for(int hi = i; hi <= j; hi++) {
			hands[hi-i] = books[hi];
		}
		//교체
		for(int bi = 0; bi < bookCnt; bi++) {
			books[i+bi] = hands[bookCnt-1-bi];
		}
	}

}
