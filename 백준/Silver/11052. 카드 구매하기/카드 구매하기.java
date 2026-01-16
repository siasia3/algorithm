import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] card = new int[n+1];
        int[] DP = new int[n+1];
        for(int i=0;i<n;i++){
            card[i+1] = Integer.parseInt(st.nextToken());
            DP[i+1] = card[i+1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                DP[i] = Math.max(DP[i], DP[i - j] + card[j]);
            }
        }


        /*if(n>1){
            for(int i=2;i<n+1;i++){
                DP[i] = Math.max(DP[i - 1] + card[1], DP[i]);
                if(i%2==0){
                    DP[i] = Math.max((i/2) * DP[2],DP[i]);
                }
                if(i%3==0){
                    DP[i] = Math.max((i/3) * DP[3],DP[i]);
                }
            }
        }*/



        //1  DP[1]
       //1+1, 2 DP[1]+DP[1] or DP[2]
       //1+1+1,2+1,3 DP[3] OR DP[2]+DP[1] OR DP[1]+DP[1]+DP[1]
       //1+1+1+1,2+1+1,2+2,3+1,4 DP[1]+DP[1]+DP[1]+DP[1],DP[2]+DP[1]+DP[1], DP[2]+DP[2], DP[3]+DP[1],DP[4]
       //1+1+1+1+1,2+1+1+1,2+2+1,1+1+3,4+1,5


        bw.write(String.valueOf(DP[n]));
        bw.flush();
        bw.close();
    }
}
