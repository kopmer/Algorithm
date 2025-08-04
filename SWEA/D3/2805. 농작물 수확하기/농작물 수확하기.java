import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int testCase = 1;testCase <= TC;testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] farmMap = new int[N][N];
            int sum = 0;

            for (int i = 0;i < N;i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    farmMap[i][j] = line.charAt(j) - '0';
                }
            }

            for (int i = 0;i < N;i++) {
                int start = Math.abs(N / 2 - i); // 1줄 내려갈수록 센터에서 -1
                int end = N - start; // 1줄 내려갈수록 센터에서 +1
                for (int j = start; j < end; j++) {
                    sum += farmMap[i][j];
                }
            }

            System.out.println("#" + testCase + " " + sum);
        }
    }
}