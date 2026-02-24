import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, B, minDiff;
    static int[] heights;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            heights = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            minDiff = Integer.MAX_VALUE;
            dfs(0, 0);

            sb.append("#").append(t).append(" ").append(minDiff).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int idx, int sum) {
        if (sum >= B) {
            minDiff = Math.min(minDiff, sum - B);
            return;
        }

        if (idx == N) return;

        dfs(idx + 1, sum + heights[idx]);
        dfs(idx + 1, sum);
    }
}