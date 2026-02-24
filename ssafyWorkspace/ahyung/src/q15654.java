import java.io.*;
import java.util.*;
public class n과m5 {
    static int n,m;
    static ArrayList<Integer>list,result;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int input = Integer.parseInt(st.nextToken());
            list.add(input);


        }
        Collections.sort(list);

        go(0);
        System.out.println(sb.toString());
    }
    static void go(int cnt){
        if(cnt==m){
            for(int i:result){
                sb.append(i).append(" ");
            }sb.append("\n");
            return;
        }

        for(int i=0;i<n;i++){
            result.add(i);
            go(cnt+1);
            result.remove(list.size()-1);
        }
    }

}
