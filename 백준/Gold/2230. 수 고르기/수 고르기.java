import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        int start = 0;
        int end = 1;
        int result = nums[N-1]-nums[0];
        while (end < N){ //start가 end보다 커지는 경우는 존재하지 않음 start=end가 같으면 end가 커지기 때문
            int gap = nums[end] - nums[start];
            if(gap >= M){
                if(result > gap){
                    result = gap;
                    if(gap == M){
                        break;
                    }
                }
                start++;
            }else if(gap < M){
                end++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

}
