import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, Pnum;
    static long[] peoples;

    public static void main(String[] args) {
        try {
            N = Integer.parseInt(input.readLine());

            for (int i = 0; i < N; i++) {
                tokens = new StringTokenizer(input.readLine());
                Pnum = Integer.parseInt(tokens.nextToken());
                peoples = new long[Pnum];

                for (int j = 0; j < Pnum; j++) {
                    peoples[j] = Long.parseLong(tokens.nextToken());
                }

                long findNum = 0;
                int cnt = 0;
                for (int j = 0; j < Pnum; j++) {
                    if (cnt == 0) {
                        findNum = peoples[j];
                        cnt = 1;
                    } else if (peoples[j] == findNum) {
                        cnt++;
                    } else {
                        cnt--;
                    }
                }

                // 과반수인지 확인
                int realCnt = 0;
                for (int j = 0; j < Pnum; j++) {
                    if (peoples[j] == findNum) {
                        realCnt++;
                    }
                }

                if (realCnt > Pnum / 2) {
                    System.out.println(findNum);
                } else {
                    System.out.println("SYJKGW");
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("입력 오류 발생: " + e.getMessage());
        }
    }
}
