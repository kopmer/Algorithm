import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
/*
 * -나오면 묶어주면 됨(+ 나오기 전까지)
 * -> - 나오면 다음에 - 나오기 전 값 더해둔것들 빼주기 -(12 + 34 + 56) 
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nums = br.readLine();
		int ans = 0;
		// -로 스플릿
		String[] splitByMinus = nums.split("-");
		// 스플릿 한것들(괄호 안의 수들) 더해주기
		for(int i = 0; i < splitByMinus.length; i++) {
			int temp = 0;
			String[] splitByPlus = splitByMinus[i].split("\\+");
			// 그냥 +를 기준으로 split 하면 오류남
			for(int j = 0; j < splitByPlus.length; j++) {
				temp += Integer.parseInt(splitByPlus[j]);
			}
			if(i == 0) {
				ans += temp;
			}
			else {
				ans -= temp;
			}
			
		}
		System.out.println(ans);
	}

}
