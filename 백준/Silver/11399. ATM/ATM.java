import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        int[] minArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(minArr);
        int sum = 0;
        int total = 0;

        for(int i=0;i<N;i++){
            sum += minArr[i];
            total += sum;
        }

        bw.write(String.valueOf(total));
        bw.flush();
        bw.close();
    }
}