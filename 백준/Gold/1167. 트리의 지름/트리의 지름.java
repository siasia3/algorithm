import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Node>[] nodeList;
    static boolean[] visited;
    static int result = 0;
    static int resultNode;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int V = Integer.parseInt(br.readLine());
        nodeList = new ArrayList[V+1];
        visited = new boolean[V+1];

        for (int i = 1; i <= V; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for(int i=1;i<V+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());

            while(true){
                int to = Integer.parseInt(st.nextToken());
                if(to == -1){
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());

                nodeList[node].add(new Node(to,distance));
            }
        }


        DFS(1,0);
        visited = new boolean[V+1];
        DFS(resultNode,0);


        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static void DFS(int node,int distance){
        if(visited[node]){
           return;
        }
        if(result < distance){
            result = distance;
            resultNode = node;
        }
        visited[node] = true;
        for(int i=0;i<nodeList[node].size();i++){
            Node nextNode = nodeList[node].get(i);
            DFS(nextNode.to, nextNode.distance+distance);
        }
    }
}

class Node{

    int to;
    int distance;

    public Node(int to, int distance) {
        this.distance = distance;
        this.to = to;
    }
}
