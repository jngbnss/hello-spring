package dijk;

import java.io.*;
import java.util.*;

public class q14938 {
    static int n, m;
    static ArrayList<Edge>[] list;
    static int[] dist;
    static int[] path; // 경로 역추적을 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        dist = new int[n + 1];
        path = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Edge(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 출발지
        int B = Integer.parseInt(st.nextToken()); // 도착지

        dijkstra(A);

        // 1. 최소 비용 출력
        System.out.println(dist[B]);

        // 2. 경로 역추적 (B부터 A까지 거꾸로 찾기)
        Stack<Integer> stack = new Stack<>();
        int curr = B;
        while (curr != 0) { // 시작점 A의 이전 노드를 0으로 설정했으므로
            stack.push(curr);
            curr = path[curr];
        }

        // 3. 경로에 포함된 도시의 개수 출력
        System.out.println(stack.size());

        // 4. 경로 출력 (Stack을 사용하면 순서대로 출력됨)
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        path[start] = 0; // 시작점의 이전 노드는 없음(0)
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            int currentTo = now.to;
            int currentCost = now.cost;

            // 이미 처리된 더 짧은 경로가 있다면 무시
            if (currentCost > dist[currentTo]) continue;

            for (Edge next : list[currentTo]) {
                if (dist[next.to] > dist[currentTo] + next.cost) {
                    dist[next.to] = dist[currentTo] + next.cost;
                    // 최단 거리가 갱신될 때, 어디서 왔는지 기록
                    path[next.to] = currentTo;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}