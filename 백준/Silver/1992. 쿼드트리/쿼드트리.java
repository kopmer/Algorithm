import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String st = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = st.charAt(j) - '0';
			}
		}
		make(0,0,N);
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
	}
	static void make(int R,int C,int size) {
		int rEnd = R+size;
		int cEnd = C+size;
		int sum = 0;
		for(int i = R; i < rEnd; i++) {
			for(int j = C; j < cEnd; j++) {
				if(map[i][j] == 1) sum += 1;
			}
		}
		
		//모두 1일 때
		if(sum == size*size) {
			System.out.print("1");
		}
		//모두 0일때
		else if(sum == 0) {
			System.out.print("0");
		}
		else {
			System.out.print("(");
			int newSize = size / 2;
			//1사분면
			make(R,C,newSize);
			//2사분면(행은 그대로)
			make(R,C+newSize,newSize);
			//3사분면(열은 그대로)
			make(R+newSize,C,newSize);
			make(R+newSize,C+newSize,newSize);
			System.out.print(")");
		}
		
	}
	

}
