import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 만큼 반복
		for(int i = 0; i < T; i++) {
			// 일관성 기록 해시셋 초기화
			HashMap<String,Integer> set = new HashMap<>();
			// 전화번호 개수
			int N = Integer.parseInt(br.readLine());
			String[] telArray = new String[N];
			boolean consistency = true;
			
			// N개 전화번호 일관성 등록
			for(int j = 0; j < N; j++) {
				String tel = br.readLine();
				telArray[j] = tel;
				// 해당 번호 일관성 기록
				for(int endIdx = 1; endIdx <= tel.length(); endIdx++) {
					//
					String num = tel.substring(0,endIdx);
//					System.out.println("일관성 등록: "+ num );
					set.put(num ,set.getOrDefault(num, 0) + 1);
				}
			}
			for(String telNum : telArray) {
//				System.out.println(telNum);
				if(set.get(telNum) > 1) {
//					System.out.println(telNum);
					consistency = false;
					break;
				}
			}
			if(consistency) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}

}
