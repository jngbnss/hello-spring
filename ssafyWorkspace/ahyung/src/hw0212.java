import java.util.Scanner;

public class hw0212 {
    static int N;
    static int[][] map;
    static int[][] memo;
    static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new int[N][N];
            memo = new int[N][N]; // 각 위치에서 출발했을 때의 최대 이동 거리를 저장

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int maxDistance = 0;
            int minStartNum = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // DFS 탐색 시작
                    int dist = dfs(i, j);

                    // 최대 거리 갱신
                    if (dist > maxDistance) {
                        maxDistance = dist;
                        minStartNum = map[i][j];
                    }
                    // 거리가 같다면 더 작은 방 번호 선택
                    else if (dist == maxDistance) {
                        minStartNum = Math.min(minStartNum, map[i][j]);
                    }
                }
            }

            System.out.println("#" + tc + " " + minStartNum + " " + maxDistance);
        }
        sc.close();
    }

    static int dfs(int r, int c) {
        // 이미 계산된 적이 있다면 그 값을 즉시 반환 (Memoization)
        if (memo[r][c] != 0) return memo[r][c];

        // 기본적으로 자기 자신(방 1개)은 방문 가능
        memo[r][c] = 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 경계 체크 및 조건(현재 숫자 + 1 == 다음 숫자) 확인
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (map[nr][nc] == map[r][c] + 1) {
                    // 다음 방에서 갈 수 있는 최대 거리 + 1
                    memo[r][c] = dfs(nr, nc) + 1;
                    break; // 숫자는 유일하므로 조건에 맞는 방은 최대 1개뿐임
                }
            }
        }
        return memo[r][c];
    }
}