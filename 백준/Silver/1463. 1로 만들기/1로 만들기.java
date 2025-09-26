import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N+1];
        DP[1] = 0;

        for(int i=2;i<N+1;i++){

            DP[i] = DP[i - 1] + 1;
            if (i % 2 == 0) {
                DP[i] = Math.min(DP[i], DP[i / 2] + 1);
            }if (i % 3 == 0) {
                DP[i] = Math.min(DP[i], DP[i / 3] + 1);
            }
        }
        bw.write(String.valueOf(DP[N]));
        bw.flush();
        bw.close();
    }
    
}