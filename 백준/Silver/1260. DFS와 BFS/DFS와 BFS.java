import java.io.*;
import java.util.*;

public class Main {

    static boolean[] DFSVisited;
    static boolean[] BFSVisited;

    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {

        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int node = inputArr[0];
        int edge = inputArr[1];
        int startNode = inputArr[2];

        DFSVisited = new boolean[node+1];
        BFSVisited = new boolean[node+1];

        graph = new ArrayList[node+1];
        for(int i=1;i<node+1;i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=0;i<node;i++){
            Collections.sort(graph[i+1]);
        }

        DFS(startNode);
        System.out.println("");
        BFS(startNode);

    }

    public static void DFS(int num){
        if(DFSVisited[num]){
            return;
        }

        DFSVisited[num] = true;
        System.out.print(num + " ");

        for(int i=0;i<graph[num].size();i++){
            int node = graph[num].get(i);
            DFS(node);
        }


    }


    public static void BFS(int num){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        BFSVisited[num] = true;


        while (!queue.isEmpty()){

            int node = queue.poll();
            System.out.print(node + " ");

            /*for(int i=0;i<graph[node].size();i++){
                int n = graph[node].get(i);

                if(!BFSVisited[n]){
                    BFSVisited[n] = true;
                    queue.add(n);
                }
            }*/

            for(int i :graph[node]){
                if(!BFSVisited[i]){
                    BFSVisited[i] = true;
                    queue.add(i);
                }
            }

        }



    }


}