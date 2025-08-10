import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<String[]> list = new ArrayList<>(N);
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String prob = st.nextToken();
			String diff = st.nextToken();
			list.add(new String[]{prob,diff});
			
		}
		Collections.sort(list, (a,b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));//난이도 순으로 정렬
		System.out.println(list.get(0)[0]);
	}

}
