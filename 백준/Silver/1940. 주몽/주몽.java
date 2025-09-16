import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int sumNum = Integer.parseInt(br.readLine());
        int[] materials = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(materials);
        int start_idx = 0;
        int end_idx = num-1;
        int count = 0;

        while(start_idx < end_idx){

            int materialSum = materials[start_idx]+materials[end_idx];

            if(sumNum > materialSum) {
                start_idx++;
            }
            else if(sumNum < materialSum){
                end_idx--;
            }
            else if(sumNum == materialSum){
                count++;
                start_idx++;
                end_idx--;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}