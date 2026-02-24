import java.io.*;
import java.util.*;
public class 최대부분수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1;tc<=testCase;tc++){
            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] psum = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++){
                psum[i] = psum[i-1]+Integer.parseInt(st.nextToken());
            }

            int ret =Integer.MIN_VALUE;
            int first =0;
            int second = 0;
            for(int i=1;i<=n-k;i++){

                for(int j=i;j<=j+k;j++){
                    first += psum[j+k]-psum[j];
                }

                for(int j = i+k+1;j<= n - (j+k);j++){
                    second+=psum[j+k]-psum[j];

                    ret = Math.max(first+second,ret);
                }

            }
            sb.append(ret).append('\n');

        }
        System.out.println(sb.toString());

    }
}
