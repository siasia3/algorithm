import java.io.*;
import java.util.*;

//백준 1238번
public class Main {

    static int N, M, X;
    static ArrayList<Street>[] list;
    static ArrayList<Street>[] reverseList;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        reverseList = new ArrayList[N+1];


        for(int k=1;k<N+1;k++){
            list[k] = new ArrayList<>();
            reverseList[k] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int streetNum = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            list[streetNum].add(new Street(destination,distance));
            reverseList[destination].add(new Street(streetNum,distance));

        }

        int[] distFromX = distance(list,X);

        int[] distToX = distance(reverseList,X);

        int answer = 0;
        for (int i=1; i<=N; i++) {
            answer = Math.max(answer, distFromX[i] + distToX[i]);
        }



        //그 전 코드 일부.. 이 경우는 학생이 갈 수 있는 케이스를 돌아서 기존보다 짧은 거리인 경우만 도는 것
        /*queue.add(new Street(j,0));
        //distance1[j] = 0;
        while(!queue.isEmpty()){
            Street street = queue.poll();
            int currentEdge = street.destination;
            int currentDistance = street.distance;

            if(currentDistance > distance1[currentEdge]){
                continue;
            }

            for(int i=0;i<list[currentEdge].size();i++) {
                int nextDestination = list[currentEdge].get(i).destination;
                int nextDistance = list[currentEdge].get(i).distance;
                if (distance1[nextDestination] > currentDistance + nextDistance) {
                    distance1[nextDestination] = currentDistance + nextDistance;
                }
                queue.add(new Street(nextDestination,currentDistance+nextDistance));
            }
        }
*/

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }


    static int[] distance(List<Street>[] street,int start){
        PriorityQueue<Street> pq = new PriorityQueue<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.add(new Street(start, 0));

        while (!pq.isEmpty()) {
            Street current = pq.poll();

            if (current.distance > dist[current.destination]) continue;

            for (Street next : street[current.destination]) {
                if (dist[next.destination] > current.distance + next.distance) {
                    dist[next.destination] = current.distance + next.distance;
                    pq.add(new Street(next.destination, dist[next.destination]));
                }
            }
        }
        return dist;
    }

}

class Street implements Comparable<Street>{
    int destination;
    int distance;

    public Street(int destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }

    @Override
    public int compareTo(Street street) {
        //return this.distance - street.distance;
        return Integer.compare(this.distance, street.distance);
    }
}