import java.io.*;
import java.util.*;

//백준 10815번 숫자카드
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] answers = new int[M];

        Arrays.sort(cards);

        int cnt = 0;
        for(int number : numbers) {
            int start = 0;
            int end = N - 1;
            while (start <= end) {
                int mid = (end - start) / 2 + start;
                if(number == cards[mid]){
                    answers[cnt] = 1;
                    break;
                }
                if(number > cards[mid]){
                    start = mid + 1;
                }
                if(number < cards[mid]){
                    end = mid - 1;
                }
            }
            cnt++;
        }

        for(int answer: answers){
            bw.write(answer+" ");
        }
        bw.flush();
        bw.close();
    }
}