import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 진실 or 과장
 * 진실을 아는사람 존재 -> 진실
 * 사람수 N, 진실을 아는사람, 파티에 오는 사람들 번호 -> 과장된 이야기 할수 있는 파티 개수 최댓값
 * 진실을 아는 파티에기면 해당사람 제외됨 -> 파티 참여한 사람들 묶어줘야함
 * 
 */

public class Main {
	public static int[] link;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int M = Integer.parseInt(st.nextToken()); // 파티 수
		
		link = new int[N+1];
		for(int i = 1; i <= N; i++) {
			link[i] = i;
		}
		// 진실 아는 사람 수
		st = new StringTokenizer(br.readLine());
		int knowsCnt = Integer.parseInt(st.nextToken());

		List<Integer> truth = new LinkedList<>();
	
	    for (int i = 0; i < knowsCnt; i++) {
	    	truth.add(Integer.parseInt(st.nextToken()));
	    }

		List<List<Integer>> partys = new LinkedList<>();
		
		for(int i = 0; i < M; i++) {
			partys.add(new LinkedList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int entryCnt = Integer.parseInt(st.nextToken());
//			partys[i].add(new int[entry]);
			for(int j = 0; j < entryCnt; j++) {
				int entry = Integer.parseInt(st.nextToken());
				partys.get(i).add(entry);
			}
//			System.out.println(Arrays.toString(partys.get(i).toArray()));
		}
		for(int i = 0; i < partys.size(); i++) {
			List<Integer> cur = partys.get(i);
			if(cur.size() <= 1) continue;
			for(int j = 1; j < cur.size(); j++) {
				union(cur.get(0), cur.get(j));
			}
		}
		
		int truthRoot = -1;
        if(!truth.isEmpty()) {
            truthRoot = find(truth.get(0));
            for(int i = 1; i < truth.size(); i++) {
                union(truthRoot, truth.get(i));
            }
            truthRoot = find(truthRoot);
        }
		
		int ans = 0;
		
		partyLoop:
		for(int i = 0; i < M; i++) {
			
            for(int person : partys.get(i)) {
                if(truthRoot != -1 && find(person) == truthRoot) {
                    continue partyLoop;
                } 
            }
            ans++;
        }
		System.out.println(ans);
	}
	public static void union(int n1, int n2) {
		int a = find(n1);
		int b = find(n2);
		if(a != b) {
			link[b] = a;
		}
	}
	public static int find(int x) {
		if(link[x] != x) {
			link[x] = find(link[x]);
		}
		return link[x];
	}
}
