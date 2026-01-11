import java.io.*;
import java.util.*;

// 백준 1715번
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> queue = new PriorityQueue<>();

        int N = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int cardNum = Integer.parseInt(st.nextToken());
            queue.add(cardNum);
        }

        long result = 0;
        while(!queue.isEmpty()){
            Integer cardNum = queue.poll();
            if(!queue.isEmpty()){
                Integer cardNum2 = queue.poll();
                int sum = cardNum + cardNum2;
                result += sum;
                if(!queue.isEmpty()){
                    queue.add(sum);
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}