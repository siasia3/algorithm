import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static List<Integer> result;
    static List<int[]> list;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N];
        list = new ArrayList<>();
        result = new ArrayList<>();
        int house = 0;

        for(int i=0;i<N;i++){
            int[] numArr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            list.add(numArr);
        }


        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int count = DFS(i, j);
                if(count>0){
                    house++;
                    result.add(count);
                }
            }
        }
        Collections.sort(result);

        bw.write(String.valueOf(house));
        for(int k=0;k<result.size();k++){
            bw.newLine();
            bw.write(String.valueOf(result.get(k)));
        }


        bw.flush();
        bw.close();
    }

    public static int DFS(int x,int y){

        int[] arr = list.get(x);
        int xy = arr[y];

        if(visited[x][y] || xy == 0){
            return 0;
        }

        int count = 0;
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0&&nx<=N-1&&ny>=0&&ny<=N-1){
                count += DFS(nx,ny);
            }
        }
        count++;
        return count;
    }
}
