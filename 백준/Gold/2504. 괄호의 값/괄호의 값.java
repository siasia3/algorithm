import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder strSB = new StringBuilder();
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int temp = 1;


        for(int i=0;i<str.length();i++){
            char currentChar = str.charAt(i);
            if(currentChar == '('){
                temp *= 2;
                stack.push(currentChar);

            }else if(currentChar == '['){
                temp *= 3;
                stack.push(currentChar);

            }else if(currentChar == ')'){
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }
                if (str.charAt(i - 1) == '(') result += temp; // 바로 앞이 '('면 값 더함
                stack.pop();
                temp /= 2;

            }else if(currentChar == ']'){
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                if (str.charAt(i - 1) == '[') result += temp; // 바로 앞이 '['면 값 더함
                stack.pop();
                temp /= 3; // 괄호 닫혔으니 다시 나눔
            }
        }

        if (!stack.isEmpty()) result = 0;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

}
