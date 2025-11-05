import java.io.*;
import java.util.Stack;


//9012번 백준
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> intStack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];
        for(int i=0;i<n;i++){
            nArr[i] = Integer.parseInt(br.readLine());
        }
        int index = 0;
        int num = 1;
        while(true){


            if(nArr[index] >= num){
                intStack.push(num);
                num++;
                sb.append("+\n");
            }

            if(nArr[index] < intStack.peek()){

                sb.setLength(0);
                sb.append("NO");
                break;
            }

            if(nArr[index] == intStack.peek()){
                intStack.pop();
                index++;
                sb.append("-\n");
                if(index == n){
                    break;
                }
            }


        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}