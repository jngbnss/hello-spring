import java.io.*;
import java.util.*;

public class 미로2 {
    static int arr[][], visited[][];
    static int dy[]={-1,0,1,0};
    static int dx [] = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < 100; tc++) {
            int t = Integer.parseInt(br.readLine());
            sb.append("#").append(t).append(" ");

            int ret = 0;
            int sy = 0;
            int sx = 0;
            int ey =0;
            int ex =0;
            arr = new int[100][100];
            visited = new int[100][100];
            for (int i = 0; i < 100; i++) {
                String line = br.readLine();
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = line.charAt(j) - '0';
                    if (arr[i][j] == 2) {
                        sy = i;
                        sx = j;
                    }else if(arr[i][j]==3){
                        ey = i;
                        ex = j;
                    }

                }
            }
            dfs(sy,sx);
            if(visited[ey][ex]==1){
                ret = 1;
            }

            sb.append(ret).append("\n");
        }
        System.out.println(sb.toString());

    }
    static void dfs(int y,int x){
        visited[y][x]  = 1;
        for(int i=0;i<4;i++){
            int ny = y+dy[i];
            int nx = x+dx[i];

            if(ny<0||nx<0||ny>=100||nx>=100) continue;
            if(arr[ny][nx]!=1&&visited[ny][nx]==0){
                dfs(ny,nx);
            }
        }
    }
}
