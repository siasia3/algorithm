import java.io.*;

public class Main {
    //2579번
    static int[] DP;
    static int[] stairs;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        N = Integer.parseInt(br.readLine());
        DP = new int[N+1];
        stairs = new int[N+1];
        for(int i=1;i<=N;i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }


        if (N >= 1) DP[1] = stairs[1];
        if (N >= 2) DP[2] = stairs[1] + stairs[2];

        for (int i = 3; i <= N; i++) {
            DP[i] = Math.max(DP[i - 2], DP[i - 3] + stairs[i - 1]) + stairs[i];
        }

        /*DP(0,1,0);
        if (N > 1) DP(1, 1, 0);*/


        bw.write(String.valueOf(DP[N]));
        bw.flush();
        bw.close();
    }
}