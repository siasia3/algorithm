import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lanLengths = new int[K];

        long start = 1;
        long end = 0;

        for(int i=0;i<K;i++){

            int lanLength = Integer.parseInt(br.readLine());
            lanLengths[i] = lanLength;

            if(end < lanLength){
                end = lanLength;
            }
        }

        long maxLength = binarySearch(start, end, lanLengths, N);
        bw.write(String.valueOf(maxLength));

        bw.flush();
        bw.close();
    }

    public static long binarySearch(long start,long end, int[] lanLengths,int target){

        long result = 0;

        while(start<=end){

            long cnt = 0;
            long mid = (start + end) / 2;
            for(int i=0;i<lanLengths.length;i++){
                cnt += lanLengths[i] / mid;
            }

            if(cnt >= target){
                result = mid;
                start = mid + 1; // 혹시 모르니 최대길이를 구하기 위해 더 긴 길이로 해봄
            }else if(cnt < target){
                end = mid - 1;
            }

        }

        return result;
    }


}
