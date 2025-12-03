import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int primeFirst = 0;
		int primeSum = 0;
		
		// N과 M사이 수
		first:
		for(int i = N; i <= M; i++) {
			if (i == 1) continue;
			// i가 소수인지 쳌
			for(int j = 2; j < i; j++) {
				if(i % j == 0)continue first;
			}
			if(primeFirst == 0) primeFirst = i;
			primeSum += i;
			
		}
		if(primeSum == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(primeSum);
			System.out.println(primeFirst);
			
		}
	}

}
