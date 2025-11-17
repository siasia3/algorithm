import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character,Integer> priority = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        priority.put('+',1);
        priority.put('-',1);
        priority.put('*',2);
        priority.put('/',2);

        String str = br.readLine();


        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            //if문 조건을 '('를 먼저 체크해줘야 함 (,)는 map에 포함되있지 않기 때문
            if (c =='('){
                stack.push(c);
            }else if(c == ')'){
                Character prev = stack.pop();
                while(prev != '('){
                    bw.write(prev);
                    prev = stack.pop();
                }
            }else if(priority.containsKey(c)){
                while(!stack.isEmpty() && stack.peek() != '(' && priority.get(stack.peek()) >= priority.get(c)) {
                    bw.write(stack.pop());
                }
                stack.push(c);
            }else{
                bw.write(c);
            }
        }
        while(!stack.isEmpty()){
            Character c = stack.pop();
            bw.write(c);
        }
        

        bw.flush();
        bw.close();
    }

}
