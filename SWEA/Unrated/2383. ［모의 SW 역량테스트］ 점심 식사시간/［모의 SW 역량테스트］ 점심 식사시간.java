import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
/*
 * 계단 입구까지 이동시간 |PR - SR| + |PC - SC|
 * 계단 도착후 1분후 아래칸으로 내려갈 수 있다
 * 계단 위에 동시 3명까지 올라가 있을 수 있다.
 * 이미 3명이 내려가는 중이면 그중 한명이 완전히 내려갈때 까지 대기해야 한다
 * 계단 길이 K -> 완전히 내려가는데 K분
 * 모든 사람들이 내려가 이동 완료되는 최소 경우
 */
	static int N;
	static int[][] map;
	static List<int[]> pList, sList;
	static boolean[] visited;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			
			//사람 리스트
			pList = new LinkedList<>();
			//계단 리스트
			sList = new LinkedList<>();
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						pList.add(new int[] {i,j});
					}
					else if(map[i][j] > 1) {
						sList.add(new int[] {i,j});
					}
				}
			}
			
			visited = new boolean[pList.size()];
			result = Integer.MAX_VALUE;
			subset(0);
			System.out.println("#" + tc + " " + result);
		}

	}
	//사람들 계단 이동후 시간 반환
	public static void simulate(PriorityQueue<Integer> q1, PriorityQueue<Integer> q2) {
		List<Integer> stair1 = inStair(q1, map[sList.get(0)[0]][sList.get(0)[1]]);
		List<Integer> stair2 = inStair(q2, map[sList.get(1)[0]][sList.get(1)[1]]);
		
		int time = 0;
		if(!stair1.isEmpty()) time = Math.max(time, Collections.max(stair1));
		if(!stair2.isEmpty()) time = Math.max(time, Collections.max(stair2));
		
		result = Math.min(result, time);
	}

	public static List<Integer> inStair(PriorityQueue<Integer> arrivals, int len) {
		List<Integer> finishTimes = new ArrayList<>();
		if(arrivals.isEmpty()) return finishTimes;
		
		//도착 시간 +1
		List<Integer> arrivalTimes = new ArrayList<>();
		while(!arrivals.isEmpty()) {
			arrivalTimes.add(arrivals.poll()+1);
		}
		Collections.sort(arrivalTimes);
		
		//계단 내려가는 사람들 종료시간 관리
		PriorityQueue<Integer> inProgress = new PriorityQueue<>();
		
		for(int arrival : arrivalTimes) {
			//도착 시간까지 이미 내려간사람 큐에서 제거
			while(!inProgress.isEmpty() && inProgress.peek() <= arrival) {
				inProgress.poll();
			}
			//계단 내려가는 인원 3명 미만이면
			if(inProgress.size() < 3) {
				int finish = arrival + len; //종료 시간 = 거리 + 1 + 계단길이
				inProgress.add(finish);
				finishTimes.add(finish);
			}else {
				//대기 해야하면
				int earliest = inProgress.poll();
				while(!inProgress.isEmpty() && inProgress.peek() <= earliest) {
					inProgress.poll();
				}
				int finish = earliest + len;
				inProgress.add(finish);
				finishTimes.add(finish);
			}
		}
		return finishTimes;
		
		
	}
	//계단 1 이용할 사람, 2 이용할 사람 나누기
	public static void subset(int idx) {
		if(idx == pList.size()) {
			PriorityQueue<Integer> q1 = new PriorityQueue<>();
			PriorityQueue<Integer> q2 = new PriorityQueue<>();
			for(int i = 0; i < pList.size(); i++) { 
				if(visited[i]) {//계단 1이용자
					int dist = Math.abs(pList.get(i)[0] - sList.get(0)[0]) + Math.abs(pList.get(i)[1] - sList.get(0)[1]);
//					System.out.print(dist + " ");
					q1.add(dist);
				}
				else {//계단 2이용자
					int dist = Math.abs(pList.get(i)[0] - sList.get(1)[0]) + Math.abs(pList.get(i)[1] - sList.get(1)[1]);
//					System.out.print(dist + " ");
					q2.add(dist);
				}
				
			}
			
			simulate(q1,q2);
//			System.out.println();
			return;
		}
		visited[idx] = true;
		subset(idx+1);
		visited[idx] = false;
		subset(idx+1);
	}

}
