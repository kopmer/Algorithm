/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] start; 
	static int possible;
	static boolean[][] visited;
	static int[][] map = new int[100][100];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		for(int t = 1;t<=10;t++) {
			//초기화
			possible = 0;
			start = new int[2];
			visited = new boolean[100][100];
			
			//테스트 케이스
			int testcase = Integer.parseInt(br.readLine());
			for(int i = 0;i<100;i++) {
				String st = br.readLine(); //미로 한줄
				for(int j = 0;j < 100;j++) {
					map[i][j] = st.charAt(j)-'0';
					if(map[i][j] == 2) {
						start[0] = i;
						start[1] = j;
					}
				}
			}
			dfs(start[0],start[1]); 
			System.out.println("#"+testcase+" "+possible);
			
		}

		

	}
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		if(map[x][y] == 3) {
			possible = 1;
			return;
		}
		for(int i = 0;i < 4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && ny >= 0 && nx < 100 && ny < 100) {
				if(map[nx][ny] != 1 && visited[nx][ny] == false) {
					
					dfs(nx,ny);
					if (possible ==1) return;
				}
			}
		}
	}

}