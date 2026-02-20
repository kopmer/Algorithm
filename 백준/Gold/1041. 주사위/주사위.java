import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
/*
 * 주사위 
 * N x N x N
 * 
 * 주사위 구조 신경써야 할듯(N = 3 이상)
 * 정육면체 주사위 바깥 라인 끝쪽은 3면 연결
 * 끝쪽 제외 바깥라인은 2면 연결
 * 
 * 가운데는 1면(최소값)
 * 
 * 주사위 3면 최소값, 2면 최소값 구하기
 * 3면 최소값 A F 비교 더 작은거 + BD | DE | EC | CB
 * 2면 최소값 BC,CE,ED,DB 최소 조합 구하고 A랑 F 비교해보기
 */
	static int[] nums = new int[6]; // A(0), B(1), C(2), D(3), E(4), F(5)
	static long bigestInThree, bigestInTwo, oneFace, oneFaceMin, oneFaceMax;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		oneFaceMin = Integer.MAX_VALUE;
		oneFaceMax = Integer.MIN_VALUE;
		for(int i = 0; i < 6; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(nums[i] < oneFaceMin) {
				oneFaceMin = nums[i];
			}
			if(nums[i] > oneFaceMax) {
				oneFaceMax = nums[i];
			}
			oneFace += nums[i];
		}
		
		long threeFace = calThree();
		long twoFace = calTwo();
		long result = 0;
		if(N == 1) {
			oneFace -= oneFaceMax;
			result = oneFace;
		}
		else if(N == 2) {
			// 3면 8개 계산
			result = threeFace * 8;
			result -= bigestInThree * 4;
		}
		else {
			// 3면 8개 계산
			result = threeFace * 8;
			result -= bigestInThree * 4;
//			System.out.println("3면 계산: "+result);
			// 2면 계산
			long twoFaceNum = (N - 2) * 12;
			// 2면 개수 * 2면 최소값
			result += twoFace * twoFaceNum;
			result -= bigestInTwo * 4 * (N-2);
//			System.out.println("2면 계산: "+ result);
			// 일반 면 계산
			long oneFaceNum = (N-2L) * (N-2L) * 5L;
//			System.out.println("oFN: "+ oneFaceNum);
			result += oneFaceMin * oneFaceNum;
			
		}
		
		System.out.println(result);
	}
	// A(0), B(1), C(2), D(3), E(4), F(5)
	// 2면 최소값 BC,CE,ED,DB 최소 조합 구하고 A랑 F 비교해보기
	private static long calTwo() {
		// BC
		int min1 = nums[1];
		int min2 = nums[2];
		long minSum = min1 + min2;
		// CE
		if(nums[2] + nums[4] < minSum) {
			min1 = nums[2];
			min2 = nums[4];
			minSum = min1 + min2;
		}
		// ED
		if(nums[3] + nums[4] < minSum) {
			min1 = nums[3];
			min2 = nums[4];
			minSum = min1 + min2;
		}
		// DB
		if(nums[1] + nums[3] < minSum) {
			min1 = nums[1];
			min2 = nums[3];
			minSum = min1 + min2;
		}
		// min(A,F)
		int AorF = nums[0] > nums[5] ? nums[5] : nums[0];
		// 기존 min1 min2 보다 AorF가 더 작으면 교체 후 minSum갱신
		// min2가 더 크게 고정
		if(min1 > min2) {
//			System.out.println("min1, min2 고정전: "+ min1+", "+min2);
			int temp = min2;
			min2 = min1;
			min1 = temp;
//			System.out.println("min1, min2 고정후: "+ min1+", "+min2);
		}
		// 다른 최소값 조합이 있으면 값 갱신
		if(AorF < min2) {
			min2 = AorF;
			minSum = min1 + min2;
		}
		bigestInTwo = min1 < min2 ? min2 : min1;
		return minSum;
	}
	//3면 최소값 계산
	private static long calThree() {
		// BC
		int min1 = nums[1];
		int min2 = nums[2];
		long minSum = min1 + min2;
		// CE
		if(nums[2] + nums[4] < minSum) {
			min1 = nums[2];
			min2 = nums[4];
			minSum = min1 + min2;
		}
		// ED
		if(nums[3] + nums[4] < minSum) {
			min1 = nums[3];
			min2 = nums[4];
			minSum = min1 + min2;
		}
		// DB
		if(nums[1] + nums[3] < minSum) {
			min1 = nums[1];
			min2 = nums[3];
			minSum = min1 + min2;
		}
		bigestInThree = min1 < min2 ? min2 : min1;
		// min(A,F)
		int AorF = nums[0] > nums[5] ? nums[5] : nums[0];
		bigestInThree = bigestInThree < AorF ? AorF : bigestInThree;
//		System.out.println(AorF+ " "+ minSum);
		return AorF + minSum;
	}

}
