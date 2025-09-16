import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
/*
 * 현재 자신(터렛)위치에서 적(류)까지의 거리 계산
 * 터렛 좌표 주어지고 적까지의 거리 주어졌을때 있을수 있는 좌표의 수 출력
 * 터렛을 중점으로 반지름 r 만큼의 원이 적이 존재하는 곳
 * r1 + r2가 두 터렛사이의 거리보다 크면 원끼리 교차하면서 2개
 * r1 + r2와 같으면 원끼리 접점이 생기므로 1개
 * r1 + r2가 더 작으면 원끼리 교차하지 않으므로 0개
 * 터렛의 위치가 동일하고 r1 과 r2가 동일하면 원이 겹치므로 무한개
 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0 ; tc < T; tc ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
			
			int result;

			if(x1 == x2 && y1 == y2) {
				if(r1 == r2) {
					result = -1;
				}
				else {
					result = 0;
				}
			}
			else {
				int x = Math.abs(x1 - x2);
				int y = Math.abs(y1 - y2);
				int d =(x*x+y*y);
				int rSum  = r1 + r2;
				int rDiff = Math.abs(r1 - r2);
				//원끼리 떨어져있거나 한원 안에 다른원 -> 0
				if(rSum * rSum < d || rDiff* rDiff > d) {
					result = 0;
				}
				//외접, 내접
				else if(rSum * rSum == d || rDiff * rDiff == d ){
					result = 1;
				}
				else {
					result = 2;
				}
			}
			System.out.println(result);
		}
	}

}
