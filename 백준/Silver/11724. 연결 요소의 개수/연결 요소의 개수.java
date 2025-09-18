import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        int count = 0;

        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1;i<M+1;i++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int adjacentNode = Integer.parseInt(st.nextToken());

            graph[adjacentNode].add(node);         
            graph[node].add(adjacentNode);
        }

        for(int i=1;i<N+1;i++){
            if(!visited[i]) {
                DFS(i);
                count++;
            }
        }



        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }

    public static void DFS(int node){

            if(visited[node]){
                return;
            }
            visited[node] = true;
           /* for(int i=0;i< graph[node].size();i++){
                int adjacentNode = graph[node].get(i);
                if(!visited[adjacentNode]{
                    DFS(adjacentNode);
                }
            }*/
            for(int adjacentNode: graph[node]){
                if (!visited[adjacentNode]){
                    DFS(adjacentNode);
                }
            }
    }
}