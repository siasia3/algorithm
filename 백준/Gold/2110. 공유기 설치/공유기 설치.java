import java.io.*;
import java.util.*;

//백준 2110번 공유기 설치
public class Main {

    static int[] routers;
    static int C;
    static int N;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        routers = new int[N];
        for(int i=0;i<N;i++){
            routers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(routers);

        int start = 1;
        int end = routers[N-1]-routers[0];


        while (start <= end) {
            int mid = (end - start) / 2 + start;

            if(canInstall(mid)){
                start = mid + 1;
            }else{
                end = mid - 1;
            }

        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static boolean canInstall(int mid){
        int count = 1;
        int end = routers[0];

        for(int i = 1; i<N;i++){
            if(routers[i] - end >= mid){
                count++;
                end = routers[i];
            }
        }
        if(count >= C){
            result = mid;
            return true;
        }
        return false;
    }
}
