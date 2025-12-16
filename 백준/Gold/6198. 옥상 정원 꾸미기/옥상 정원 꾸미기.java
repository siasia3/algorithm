import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        //int[] building = new int[N];
        /*for(int i=0;i<N;i++){
            building[i] = Integer.parseInt(br.readLine());
        }*/
        //int[] resultArray = new int[N];
        Deque<Integer> deque = new ArrayDeque<>();
        long total = 0;

        /*for(int i=N-1;i>-1;i--) {
            int height = building[i];

            while (!deque.isEmpty() && deque.peekLast().height < height){
                //resultArray[i] = resultArray[i] + resultArray[deque.peekLast().index] + 1;
                //total++;
                deque.pollLast();
            }

            deque.addLast(new Building(i,height));
        }*/

        for(int i=0;i<N;i++){
            int h = Integer.parseInt(br.readLine());
            while(!deque.isEmpty() && deque.peek() <= h){
                deque.pop();
            }

            total += deque.size();

            deque.push(h);
        }

        /*for(int result : resultArray){
            total += result;
        }*/

        bw.write(String.valueOf(total));
        bw.flush();
        bw.close();
    }

}