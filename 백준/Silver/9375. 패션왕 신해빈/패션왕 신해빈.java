import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testNum = Integer.parseInt(br.readLine());

        for(int i=0;i<testNum;i++) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> clothesMap = new HashMap<>();
            for(int j=0;j<N;j++){
                String[] clothes = br.readLine().split(" ");
                clothesMap.put(clothes[1], clothesMap.getOrDefault(clothes[1],0)+1);
            }
            int result = 1;
            for(int count :  clothesMap.values()){
                result *= (count + 1);
            }
            result = result - 1;
            bw.write(String.valueOf(result));
            bw.newLine();
        }


        bw.flush();
        bw.close();
    }
}