import java.io.*;
import java.util.*;

//백준 3273번 두수의 합
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(br.readLine());
        int answer = 0;

        Arrays.sort(numbers);


        int start = 0;
        int end = n - 1;
        while (start < end) {

            int sum = numbers[start] + numbers[end];
            if(sum == x){
                answer += 1;
                start++;
                end--;
            } else if(sum > x){
                end--;
            } else {
                start++;
            }
        }


        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}