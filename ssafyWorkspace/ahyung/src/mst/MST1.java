package mst;
import java.io.*;
import java.util.*;
public class 최소스패닝트리 {
    static int v,e;
    static int a,b,c;
    static int [] root;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        root = new int[v+1];
        for(int i=0;i<v+1;i++){
            root[i] = i;
        }

        list = new ArrayList<>();


        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            list.add(new Edge(a,b,c));

        }
        Collections.sort(list);

        int total = 0;
        int cnt = 0;
        for(Edge edge:list){
            if(find(edge.e1)!=find(edge.e2)){
                union(edge.e1,edge.e2);
                total+=edge.cost;
                cnt++;
                if(cnt==v-1) break;
            }
        }
        System.out.println(total);

    }
    static int find(int x){
        if(x==root[x]) return x;
        return root[x] = find(root[x]);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            root[b] = a;
        }
    }
    static ArrayList<Edge>list;
    static class Edge implements Comparable<Edge>{
        int e1;
        int e2;
        int cost;

        public Edge(int e1, int e2, int cost) {
            this.e1 = e1;
            this.e2 = e2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost-o.cost;
        }
    }
}
