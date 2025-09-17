import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numArr);
        int count = 0;
        for(int i=0;i<num;i++){
            int start_idx = 0;
            int end_idx = num-1;
            int k = numArr[i];

            while(start_idx < end_idx) {

                int numSum = numArr[start_idx] + numArr[end_idx];

                if (numSum == k) {
                    if (start_idx != i && end_idx != i) {
                        count++;
                        break;
                    } else if (end_idx == i) {
                        end_idx--;
                    } else if (start_idx == i) {
                        start_idx++;
                    }
                } else {
                    if (numSum > k) {
                        end_idx--;
                    } else if (numSum < k) {
                        start_idx++;
                    }
                }

            }
        }
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}