import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] triangle = new int[n][n];
        int[][] DP = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;

        DP[0][0] = triangle[0][0];


        // DP[1] =           triangle[1][0]                            triangle[1][1];
        // DP[2] = triangle[2][0]     triangle[2][1]       triangle[2][1]         triangle[2][2]
        // DP[3] = triangle[3][0],[3][1] [3][1]-[3][2]         [3][1]-[3][2]        [3][2]-[3][3]
        //triangle[i+1][j] triangle[i+1][j+1]
        for(int i=0;i<n-1;i++){
            for(int j=0;j<=i;j++){
                /*triangle[i+1][j] = triangle[i][j] + triangle[i+1][j];
                triangle[i+1][j+1] = triangle[i][j] + triangle[i+1][j+1];
                DP[i+1] = Math.max(DP[i+1],Math.max(triangle[i][j] + triangle[i+1][j],triangle[i][j] + triangle[i+1][j+1]));*/
                DP[i+1][j] = Math.max(DP[i][j] + triangle[i+1][j],DP[i+1][j]);
                DP[i+1][j+1] = Math.max(DP[i][j] + triangle[i+1][j+1],DP[i+1][j+1]);
            }
        }

        for(int k=0;k<n;k++){
            result = Math.max(result,DP[n-1][k]);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }



}
