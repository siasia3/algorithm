import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());



        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] distance = new int[100001];
        Arrays.fill(distance,-1);

        Deque<Integer> deque = new ArrayDeque<>();

        deque.offer(N);
        distance[N] = 0;

        while(!deque.isEmpty()){
            Integer pos = deque.poll();
            if(pos==K){
                break;
            }

            if((pos * 2)<100001 && distance[pos*2] == -1) {
                
                distance[pos * 2] = distance[pos];
                deque.offerFirst(pos*2);
            }

            if(pos > 0 && distance[pos-1] == -1) {
                
                distance[pos-1] = distance[pos]+1;
                deque.offer(pos-1);
            }

            if(pos<100000 && distance[pos+1] == -1){
                
                distance[pos+1] = distance[pos]+1;
                deque.offer(pos+1);
            }
            
        }

        bw.write(String.valueOf(distance[K]));
        bw.flush();
        bw.close();
    }

}