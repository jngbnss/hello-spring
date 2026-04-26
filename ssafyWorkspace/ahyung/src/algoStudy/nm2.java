package algoStudy;

import java.io.*;
import java.util.*;

/**
 * 전략
 * 방문처리를 기준으로
 * 추가 후 재귀 함수 진행
 */

public class nm1 {
    static int n, m;
    static StringBuilder sb;
    static ArrayList<Integer> list;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        list = new ArrayList<>();
        visited = new boolean[n + 1];

        go(0, list);
        System.out.println(sb.toString());

    }

    static void go(int idx, ArrayList<Integer> list) {

        if (idx == m) {
            for (int i = 0; i < m; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i);
                go(idx + 1, list);
                list.remove(list.size() - 1);
                visited[i] = false;

            }
        }

    }
}
