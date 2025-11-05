
import java.io.*;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> psChar = new Stack<>();

        int T = Integer.parseInt(br.readLine());
        boolean flag = true;

        for(int i=0;i<T;i++){
            String ps = br.readLine();
            for(int j=0;j<ps.length();j++){
                char c = ps.charAt(j);
                if(c == '('){
                    psChar.push(c);
                }else if(c == ')'){
                    if(!psChar.isEmpty()){
                        psChar.pop();
                    }else{
                        flag = false;
                    }

                }
            }
            if(psChar.isEmpty() && flag){
                bw.write("YES");
                bw.newLine();
            }else{
                psChar = new Stack<>();
                bw.write("NO");
                bw.newLine();
            }
            flag = true;
        }


        bw.flush();
        bw.close();
    }

}
