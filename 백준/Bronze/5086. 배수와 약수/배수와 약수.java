import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
/*
 * 약수 -> factor
 * 배수 -> multiple
 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			boolean isFactor = false;
			boolean isMultiple = false;
			
			if(a == 0 && b == 0) break;
			
			if(b % a == 0) isFactor = true;
			if(a % b == 0) isMultiple = true;
			
			if(isFactor) {
				sb.append("factor" + "\n");
			}else if(isMultiple) {
				sb.append("multiple" + "\n");
			}else {
				sb.append("neither" + "\n");
			}
			
		}
		System.out.println(sb);
	}

}
