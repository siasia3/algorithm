import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = 0;
        int end = 0;
        int result = 0;
        int sum = arr[0];
        while(start <= end && end < arr.length){

            if(sum>=S){
                if(result == 0){
                    result = end - start + 1;
                }else if(result > (end - start + 1)){
                    result = end - start + 1;
                }

                sum -= arr[start];
                start++;

            }else{
                end++;
                if (end == N) break;
                sum += arr[end];

            }

        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
