
import java.util.Scanner;

public class Solution {
    static int N, L; // 재료 수, 제한 칼로리
    static int[] scores;
    static int[] calories;
    static int maxScore;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            L = sc.nextInt();
            scores = new int[N];
            calories = new int[N];

            for (int i = 0; i < N; i++) {
                scores[i] = sc.nextInt();
                calories[i] = sc.nextInt();
            }

            maxScore = 0;
            // index 0부터 시작, 현재 점수 0, 현재 칼로리 0
            generateSubset(0, 0, 0);

            System.out.println("#" + t + " " + maxScore);
        }
    }

    static void generateSubset(int cnt, int sumScore, int sumCal) {
        // 1. 가지치기: 현재 칼로리 합이 제한을 넘으면 바로 종료
        if (sumCal > L) return;

        // 2. 기저 조건: 모든 재료를 다 고려했을 때
        if (cnt == N) {
            maxScore = Math.max(maxScore, sumScore);
            return;
        }

        // 3. 유도 부분
        // 현재 재료를 선택하는 경우
        generateSubset(cnt + 1, sumScore + scores[cnt], sumCal + calories[cnt]);

        // 현재 재료를 선택하지 않는 경우
        generateSubset(cnt + 1, sumScore, sumCal);
    }
}