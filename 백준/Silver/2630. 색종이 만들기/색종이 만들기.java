import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int blue,white;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		blue = 0;
		white = 0;
		makePaper(0,0,N);
		System.out.println(white);
		System.out.println(blue);
		
	}
	static void makePaper(int R, int C, int size) {
		int rEnd = R+size;
		int cEnd = C+size;
		int sum = 0;
		for(int i = R; i < rEnd; i++) {
			for(int j = C; j < cEnd; j++) {
				if(map[i][j] == 1) sum += 1;
			}
		}
		
		if(sum == size*size) {
			blue++;
		}
		else if(sum == 0) {
			white++;
		}
		else {
			int newSize = size/2;
			//1사분면
			makePaper(R,C,newSize);
			//2사분면 (행 고정)
			makePaper(R,C+newSize,newSize);
			//3사분면(열 고정)
			makePaper(R+newSize,C,newSize);
			//4사분면
			makePaper(R+newSize,C+newSize,newSize);
			
		}
	}
}
