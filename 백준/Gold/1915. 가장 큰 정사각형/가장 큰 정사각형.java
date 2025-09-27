import java.io.*;
import java.util.stream.Stream;

public class Main {
    static int N;
    static int M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        arr = new int[N][M];
        int max = 0;

        for(int i=0;i<N;i++){
            String[] strArr = br.readLine().split("");
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j] == 1 && i > 0 && j > 0){
                    arr[i][j] = Stream.of(arr[i - 1][j], arr[i][j - 1], arr[i - 1][j - 1]).min(Integer::compare).get() + 1;
                }

                if(arr[i][j]>max){
                    max = arr[i][j];
                }
            }
        }

        bw.write(String.valueOf(max*max));
        bw.flush();
        bw.close();
    }
}