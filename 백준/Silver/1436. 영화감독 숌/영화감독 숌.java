import java.io.*;




public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int num = 666;

        while(true) {
            String str = String.valueOf(num);
            if (str.contains("666")) {
                count++;
            }
            if (count == n) {
                bw.write(str);
                break;
            }
            num++;
        }
        bw.flush();
        bw.close();
    }
}