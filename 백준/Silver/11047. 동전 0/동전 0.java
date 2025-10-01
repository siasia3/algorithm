import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        int[] coins = new int[N];
        int count = 0;

        for(int i=0;i<N;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        while(K!=0){
            if((K - coins[N-1]) >= 0){
                count +=  K / coins[N-1];
                K = K % coins[N-1];
            }
            N--;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}