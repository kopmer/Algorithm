import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] broken = new boolean[10];
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        // +, - 로만 이동하는 경우
        answer = Math.abs(N - 100);

        // 중복순열로 채널 번호 만들기
        for (int len = 1; len <= 6; len++) {
            makeNumber("", len);
        }

        System.out.println(answer);
    }

    static void makeNumber(String cur, int len) {
        if (cur.length() == len) {
            int channel = Integer.parseInt(cur);
            int press = cur.length() + Math.abs(channel - N);
            answer = Math.min(answer, press);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!broken[i]) {
                makeNumber(cur + i, len);
            }
        }
    }
}