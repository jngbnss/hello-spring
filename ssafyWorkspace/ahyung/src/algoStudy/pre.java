package algoStudy;
import java.io.*;
import java.util.*;
public class 선수과목 {
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        list = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            arr[b]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i=1;i<=n;i++){
            if(arr[i] ==0){
                q.offer(i);
            }
        }
        int [] ret = new int[n+1];
        int idx = 1;
        while(!q.isEmpty()){
            Integer poll = q.poll();
            ret[poll] = idx;

            for(int i:list[poll]){
                arr[i]--;
                if(arr[i]==0){
                    idx++;
                    q.offer(i);

                }
            }



        }

        for(int i=1;i<=n;i++){
            System.out.print(ret[i]+ " ");
        }

    }
}
