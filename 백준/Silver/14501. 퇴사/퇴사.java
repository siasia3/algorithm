import java.io.*;
import java.util.*;

//백준 14501번
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N+1];
        int[] price = new int[N+1];
        int[] DP = new int[N+2];
        for(int i=1;i<N+1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        //Day:   1  2  3  4  5  6  7
        //T:     3  5  1  1  2  4  2
        //P:    10 20 10 20 15 40 200

        for (int i = N; i >= 1; i--) {
            if (i + time[i] <= N + 1) {
                DP[i] = Math.max(
                        price[i] + DP[i + time[i]],
                        DP[i + 1]
                );
            } else {
                DP[i] = DP[i + 1]; // 상담 불가능
            }
        }

        bw.write(String.valueOf(DP[1]));
        bw.flush();
        bw.close();
    }

}
