import java.io.*;
import java.util.*;

//백준 14502번
public class Main {

    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,1,-1,0};
    static int[][] area;
    static List<int[]> emptyArea;
    static List<int[]> virusArea;
    static boolean[][] visited;

    static int N;
    static int M;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new int[N][M];
        virusArea = new ArrayList<>();
        emptyArea = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                if(area[i][j] == 2){
                    int[] virus = {i, j};
                    virusArea.add(virus);
                }else if(area[i][j] == 0){
                    int[] empty = {i,j};
                    emptyArea.add(empty);
                }
            }
        }
        DFS(0,0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
    public static void DFS(int i,int count){
       
        if(count == 3){
            int virusCount = BFS();
            int safeArea = emptyArea.size() - 3 - virusCount;
            result = Math.max(result,safeArea);
            return;
        }

        for(int k=i;k<emptyArea.size();k++){
            int[] empty = emptyArea.get(k);
            int x = empty[0];
            int y = empty[1];
            area[x][y] = 1;
            DFS(k+1,count+1);
            area[x][y] = 0;
        }


    }

    public static int BFS(){
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> changed = new ArrayList<>();
        visited = new boolean[N][M];
        for (int[] virus : virusArea) {
            queue.add(new int[]{virus[0], virus[1]});
            visited[virus[0]][virus[1]] = true;
        }

        int virusCount = 0;
        while (!queue.isEmpty()) {
            int[] virus = queue.poll();
            int x = virus[0];
            int y = virus[1];
            for(int j=0;j<4;j++){
                int nextX = x + dx[j];
                int nextY = y + dy[j];
                if(nextX<N && nextY<M && nextX>=0 && nextY>=0){
                    if(!visited[nextX][nextY] && area[nextX][nextY]==0){
                        visited[nextX][nextY] = true;
                        area[nextX][nextY] = 2;
                        virusCount++;
                        queue.add(new int[]{nextX,nextY});
                        changed.add(new int[]{nextX,nextY});
                    }
                }
            }
        }
        for(int[] change: changed){
            area[change[0]][change[1]] = 0;
        }
        return virusCount;
    }
}
