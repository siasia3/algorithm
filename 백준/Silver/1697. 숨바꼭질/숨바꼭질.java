import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Position> queue = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        int result = 0;
        queue.add(new Position(N,0));

        while(!queue.isEmpty()){
            Position position = queue.poll();
            int dist = position.dist;
            int time = position.time;
            if(visited[dist]){
                continue;
            }
            visited[dist] = true;
            if(position.dist == K){
                result = position.time;
                break;
            }
            if(dist<100000){
                queue.add(new Position(dist+1,time+1));
            }
            if(dist>0){
                queue.add(new Position(dist-1,time+1));
            }
            if(0<2*dist && 2*dist<100001){
                queue.add(new Position(2*dist,time+1));
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}

class Position {
    int dist;
    int time;

    public Position(int dist, int time) {
        this.dist = dist;
        this.time = time;
    }
}