import java.io.*;
import java.util.*;

//7576? 토마토 문제
public class Main {

    static Queue<Tomato> queue = new LinkedList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int M;
    static int[][] tomatoes;
    //static boolean[][] visited;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoes = new int[N][M];



        for(int i=0;i<N;i++){
            tomatoes[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        result = 1;
        checkTomato1();

        if(result>0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tomatoes[i][j] == 1) {
                        queue.offer(new Tomato(i,j));
                    }
                }
            }
            BFS();


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    result = Math.max(result, tomatoes[i][j] - 1);
                }
            }

            checkTomato2();
        }



        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static void BFS(){

        while(!queue.isEmpty()){
            Tomato tomato = queue.poll();
            for(int i=0;i<4;i++){
                int nextX = tomato.x + dx[i];
                int nextY = tomato.y + dy[i];
                if(nextX >= 0 && nextX <= (N-1) && nextY >=0 && nextY <= (M-1)){
                    //벽
                    if(tomatoes[nextX][nextY] == -1){
                        continue;
                    }
                    //익지않은 토마토
                    if(tomatoes[nextX][nextY] == 0 || tomatoes[nextX][nextY] > tomatoes[tomato.x][tomato.y]+1) {
                        tomatoes[nextX][nextY] = tomatoes[tomato.x][tomato.y]+1;
                        queue.offer(new Tomato(nextX,nextY));
                    }
                }
            }
        }
    }

    //토마토 모두 익어있는지 상태 체크
    public static void checkTomato1(){

        int count = 0;

        for(int i=0;i<N;i++){
            for(int j=0; j<M;j++) {
                if(tomatoes[i][j] != 0){
                    count++;
                }
            }
        }

        if(count == N*M){
            result = 0;
        }
    }

    //토마토가 모두 익지 못하는 경우
    public static void checkTomato2(){

        for(int i=0;i<N;i++){
            for(int j=0; j<M;j++) {
                if(tomatoes[i][j] == 0){
                    result = -1;
                    return;
                }
            }
        }

    }


}

class Tomato {
    int x;
    int y;

    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
