import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer,Integer> map = new HashMap<>();


        int N = Integer.parseInt(br.readLine());
        int[] nArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int[] mArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=0; i<nArr.length;i++){
            if(map.containsKey(nArr[i])) {
                Integer value = map.get(nArr[i]);
                map.put(nArr[i], value+1);
            }else{
                map.put(nArr[i], 1);
            }
        }

        for(int j=0;j<mArr.length;j++){
            if(map.containsKey(mArr[j])){
                bw.write(map.get(mArr[j])+" ");
            }else{
                bw.write("0 ");
            }
        }

        bw.flush();
        bw.close();
    }
}