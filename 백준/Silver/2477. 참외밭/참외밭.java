import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 1 동쪽, 2 서쪽, 3 남쪽, 4 북쪽
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[6][2];
		int h1 = 0; int w1 = 0; int h2Idx = 0; int w2Idx = 0;
		for(int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			if(arr[i][0] == 1 || arr[i][0] == 2) { //가로
				if(w1 < arr[i][1]) {
					w1 = arr[i][1];
					h2Idx = (i+3) % 6;
				}
				
			}
			else {//세로
				if(h1 < arr[i][1]) {
					h1 = arr[i][1];
					w2Idx = (i+3) % 6;
				}
			}
			
			
		}
//		System.out.println(w1 +" "+ h1+" " + w2Idx +" "+ h2Idx);
		System.out.println(((w1 * h1)-(arr[w2Idx][1] * arr[h2Idx][1])) * N);
	}

}
