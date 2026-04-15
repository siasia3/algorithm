package org.example.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//백준 10799번 쇠막대기
public class Stack8 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        char before = ' ';
        int result = 0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c == '('){
                stack.push(c);

            }
            if(c == ')'){
                if(!stack.isEmpty() && before == '('){ //레이저
                    stack.pop();
                    result += stack.size();
                }else {
                    stack.pop();
                    result += 1;
                }
            }
            before = c;
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}
