import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i=0;i<N;i++){
            String groupStr = br.readLine();
            Set<Character> set = new HashSet<>();
            boolean flag = true;
            Character prevChar = ' ';
            int size = 0;
            for(int j=0;j<groupStr.length();j++){
                char currentChar = groupStr.charAt(j);
                set.add(currentChar);

                if(j>0){
                    if(prevChar != currentChar && set.size()==size){
                         flag = false;
                    }
                }
                size = set.size();
                prevChar = currentChar;
            }
            if(flag){
                result++;
            }
        }
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }

}
