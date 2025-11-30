import java.io.*;
import java.util.*;

public class Main {
	static class Seg implements Comparable<Seg> {
        int l, r;
        Seg(int l, int r) { this.l = l; this.r = r; }
        public int compareTo(Seg o) { return this.l - o.l; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<Seg> free = new TreeSet<>();
        free.add(new Seg(1, 100000));

        // 각 변수 이름 → (start, size)
        HashMap<String, int[]> alloc = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();

            if (line.startsWith("print")) {
                // print(xxxx);
                String var = line.substring(6, 10);
                sb.append(alloc.getOrDefault(var, new int[]{0,0})[0]).append("\n");
                continue;
            }

            if (line.contains("malloc")) {
                // xxxx=malloc(size);
                String var = line.substring(0, 4);
                int p1 = line.indexOf('(');
                int p2 = line.indexOf(')');
                int size = Integer.parseInt(line.substring(p1 + 1, p2));

                // first-fit search
                Seg chosen = null;
                for (Seg s : free) {
                    int len = s.r - s.l + 1;
                    if (len >= size) {
                        chosen = s;
                        break;
                    }
                }

                if (chosen == null) {
                    alloc.put(var, new int[]{0, 0});
                    continue;
                }

                int start = chosen.l;
                int end = start + size - 1;

                // free 구간 조정
                free.remove(chosen);
                if (end < chosen.r) {
                    free.add(new Seg(end + 1, chosen.r));
                }

                alloc.put(var, new int[]{start, size});
            }

            else if (line.contains("free")) {
                // free(xxxx);
                String var = line.substring(5, 9);
                int[] info = alloc.get(var);
                if (info == null || info[0] == 0) continue;

                int start = info[0];
                int size = info[1];
                int l = start;
                int r = start + size - 1;

                Seg newSeg = new Seg(l, r);

                // merge with left
                Seg lower = free.lower(newSeg);
                if (lower != null && lower.r + 1 == l) {
                    newSeg.l = lower.l;
                    free.remove(lower);
                }

                // merge with right
                Seg higher = free.higher(newSeg);
                if (higher != null && r + 1 == higher.l) {
                    newSeg.r = higher.r;
                    free.remove(higher);
                }

                free.add(newSeg);
                alloc.put(var, new int[]{0, 0});
            }
        }

        System.out.print(sb);
    }
}
