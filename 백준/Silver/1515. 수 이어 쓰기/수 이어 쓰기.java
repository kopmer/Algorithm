
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	/*
	 * 백준 1515: 수 이어쓰기
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		char[] numList = num.toCharArray();
		int idx = 0; // 찾을수(numList의 target)
		
		for(int i = 1;; i++) { //이어쓸 수의 후보(1 ~ N)
			String possible = "" + i; //int -> string
			
			//이어쓸 후보 숫자 문자 배열로 변환
 			char[] posChar = possible.toCharArray();
			
			for(char p : posChar) {
				//현재 찾는수 아니면 패스
				if(numList[idx] != p) continue;
				idx++; //다음 수 찾기(target++)
				//다 찾았으면 종료
				if(idx >= numList.length) {
					System.out.println(i);
					return;
				}
			}
					
			
			
		}
	}

}
