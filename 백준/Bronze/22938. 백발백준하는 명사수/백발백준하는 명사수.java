import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double x1 = Double.parseDouble(st.nextToken());
		double y1 = Double.parseDouble(st.nextToken());
		double r1 = Double.parseDouble(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		double x2 = Double.parseDouble(st.nextToken());
		double y2 = Double.parseDouble(st.nextToken());
		double r2 = Double.parseDouble(st.nextToken());
		
		double x = x2 - x1;
		double y = y2 - y1;
		
		double R1ToR2 = Math.sqrt(x * x + y * y);
//		System.out.println(R1ToR2);
//		System.out.println(r1 + r2);
		if(R1ToR2 < r1 + r2) {
			System.out.println("YES");
			
		}
		else {
			System.out.println("NO");
		}
	}

}
