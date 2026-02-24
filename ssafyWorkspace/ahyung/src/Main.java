import java.io.*;
import java.util.*;

public class 암기왕 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int mn = Integer.MAX_VALUE;
            int mx = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int input = Integer.parseInt(st.nextToken());
                arr[i] = input;
                mn = Math.min(mn, input);
                mx = Math.max(mx, input);

            }

            int m = Integer.parseInt(br.readLine());
            int[] arr1 = new int[m];

            Arrays.sort(arr);
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                int input = Integer.parseInt(st.nextToken());
                if (input < 0 || input > mx) {
                    sb.append(0).append("\n");
                } else {
                    int a = 0;
                    int b = n;

                    boolean flag = false;
                    while (a < b) {
                        int mid = (a + b) / 2;
                        if (arr[mid] == input) {
                            sb.append(1).append("\n");
                            flag = true;
                            break;
                        } else if (arr[mid] < input) {
                            a = mid + 1;
                        } else {
                            b = mid - 1;
                        }
                    }
                    if (!flag) {
                        sb.append(0).append("\n");
                    }
                }

            }


        }
        System.out.println(sb.toString());

    }
}
