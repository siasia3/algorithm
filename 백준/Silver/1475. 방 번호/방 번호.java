import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;
        String roomNumber = br.readLine();
        int[] numbers = new int[10];
        for(char numberChar: roomNumber.toCharArray()){
            int num = numberChar - '0';
            if(num == 6 || num == 9){
                numbers[6] += 1;
            }else{
                numbers[num] += 1;
            }
        }

        numbers[6] = (numbers[6] + 1) / 2;

        for(int number : numbers){
            if(number>result){
                result = number;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}