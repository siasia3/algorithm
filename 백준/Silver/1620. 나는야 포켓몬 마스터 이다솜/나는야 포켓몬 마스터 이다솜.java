import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] poketmonNames = new String[N+1];
        Map<String, Integer> poketmonNumbers = new HashMap<>();

        for(int i=1;i<N+1;i++){
            String poketmonName = br.readLine();
            poketmonNames[i] = poketmonName;
            poketmonNumbers.put(poketmonName,i);
        }

        for(int i=1;i<M+1;i++){

            String input = br.readLine();
            if(Character.isDigit(input.charAt(0))){
                String poketmonName = poketmonNames[Integer.parseInt(input)];
                bw.write(poketmonName);
                bw.newLine();
            }else{
                Integer poketmonNumber = poketmonNumbers.get(input);
                bw.write(String.valueOf(poketmonNumber));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}

