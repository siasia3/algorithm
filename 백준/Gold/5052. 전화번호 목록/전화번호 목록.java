import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            String[] telNums = new String[n];
            for(int j=0; j<n;j++){
                telNums[j] = br.readLine();
            }
            Arrays.sort(telNums);
            boolean flag = true;
            for(int a=0;a<telNums.length;a++){

                if(a+1<telNums.length && telNums[a+1].startsWith(telNums[a])){
                    flag = false;
                }
            }
            if(flag){
                bw.write("YES");
                bw.newLine();
            }else{
                bw.write("NO");
                bw.newLine();
            }
        }


        bw.flush();
        bw.close();
    }
}