import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//백준 1753번
public class Main {

    public static int V,E,K;
    public static boolean visited[];
    public static int distance[];
    public static ArrayList<Edge> list[];
    public static PriorityQueue<Edge> q = new PriorityQueue<Edge>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        distance = new int[V+1];
        visited = new boolean[V+1];
        list = new ArrayList[V+1];

        for(int i=1;i<V+1;i++){
            distance[i] = Integer.MAX_VALUE;
            list[i] = new ArrayList<Edge>();
        }

        for(int i=0;i<E;i++){
            int[] numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list[numArr[0]].add(new Edge(numArr[1],numArr[2]));
        }

        q.add(new Edge(K,0));
        distance[K] = 0;
        while(!q.isEmpty()){
            Edge edge = q.poll();
            int ci = edge.index;
            if(visited[ci]){
               continue;
            }
            visited[ci] = true;

            for(int i=0;i<list[ci].size();i++){
                int next = list[ci].get(i).index;
                int value = list[ci].get(i).distance;
                if(distance[next] > distance[ci] + value){
                    distance[next] = distance[ci] + value;
                    q.add(new Edge(next, distance[next]));
                }
            }
        }

        for(int i=1;i<V+1;i++){
            if(visited[i]){
                bw.write(String.valueOf(distance[i]));
                bw.newLine();
            }else if(!visited[i]){
                bw.write("INF");
                bw.newLine();
            }

        }

        bw.flush();
        bw.close();
    }

}


class Edge implements Comparable<Edge>{
    int index;
    int distance;

    public Edge(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge other) {
        //return this.distance - other.distance;
        return  Integer.compare(this.distance, other.distance);
    }
}
