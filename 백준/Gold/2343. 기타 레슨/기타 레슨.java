import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = 0;
        int end = 0;

        for(int i=0;i<N;i++){
            if(start < numArr[i]){
                start = numArr[i];
            }
            end += numArr[i];
        }




        while(start<=end){
            int mid = (end+start)/2;
            int sum = 0;
            int cnt = 0;

            for(int i=0;i<N;i++){
                if(sum + numArr[i] > mid){
                    cnt++;
                    sum = 0;
                }
                sum += numArr[i];
            }

            if(sum != 0){
                cnt++;
            }
            if(cnt > M){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }

        bw.write(String.valueOf(start));
        bw.flush();
        bw.close();
    }
}