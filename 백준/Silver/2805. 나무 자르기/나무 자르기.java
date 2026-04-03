import java.io.*;
import java.util.*;

//백준 2805번 나무자르기
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] treeLengths = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long start = 0;
        long end = Arrays.stream(treeLengths).max().getAsLong();
        long answer = 0;

        while(start<=end){
            long mid = (end - start) / 2 + start;
            long result = 0;
            for(long treeLength: treeLengths){
                if(treeLength > mid){
                    result += treeLength - mid;
                }
            }

            if (result >= M){
                answer = mid;
                start = mid + 1;
            }
            if(result < M){
                end = mid - 1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
