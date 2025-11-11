import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int ans = 0;

        if (k == 2) {
            ans = Math.max(0, r - Math.max(l, 3) + 1);
        } else if (k == 3) {
            ans = Math.max(0, r / 3 - (Math.max(l, 6) - 1) / 3);
        } else if (k == 4) {
            ans = Math.max(0, r / 2 - (Math.max(l, 14) - 1) / 2);
            if (l <= 10 && 10 <= r) ans += 1;
        } else {
            ans = Math.max(0, r / 5 - (Math.max(l, 15) - 1) / 5);
        }
        System.out.println(ans);
    }
}
