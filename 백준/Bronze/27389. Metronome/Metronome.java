import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double n = Double.parseDouble(br.readLine());
		n /= 4;
		n *= 100;
		n = (int)n;
		n = (double)n / 100;
		System.out.println(n);

	}

}
