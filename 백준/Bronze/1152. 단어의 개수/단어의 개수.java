import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> array = new ArrayList<>();

        while(st.hasMoreTokens()){
            array.add(st.nextToken());
        }

        bw.write(Integer.toString(array.size()));

        bw.flush();
        bw.close();
    }
}