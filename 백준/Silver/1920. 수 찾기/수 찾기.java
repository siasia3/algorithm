import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] NArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int[] MArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(NArr);

        for(int X : MArr) {

            boolean check = true;
            int startNode = 0;
            int lastNode = N-1;


            while (startNode <= lastNode) {
                int mid =  + startNode + (lastNode-startNode)/2;
                if (NArr[mid] == X) {
                    //bw.write("1\n");
                    check = false;
                    break;
                }else if (NArr[mid] < X) {
                    startNode = mid+1;
                } else if (NArr[mid] > X) {
                    lastNode = mid-1;
                }
            }
            if(check){
                bw.write("0\n");
            }else{
                bw.write("1\n");
            }
        }

        bw.flush();
        bw.close();
    }
}