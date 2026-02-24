package q14510;
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1;tc<=testCase;tc++) {
            sb.append("#").append(tc).append(" ");

            int ret = 0;
            int cnt = 0;

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

//            Collections.sort(list,Collections.reverseOrder());
            list.sort(Comparator.reverseOrder());
            int target = list.get(0);
            for (Integer i : list) {
                if(target==i) cnt++;
            }

            while (cnt<n) {
                ret++; // 일단 하루 카운트
                for (int i = 0; i < n; i++) { // 물을 줘야할 나무부터
                    if(list.get(i)==target) continue;

                    Integer now = list.get(i);

                    int diff = target - now;

                    if (ret % 2 != 0) {
                        if (diff == 1 || diff >= 3) {
                            list.set(i, now + 1);
                            if (list.get(i) == target)
                                cnt++;
                            break;
                        }
                    } else {
                        if (diff >= 2) {
                            list.set(i, now + 2);
                            if (list.get(i) == target)
                                cnt++;
                            break;
                        }
                    }
                }
            }
            sb.append(ret);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
