
import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Node> stack = new ArrayDeque<>();
        int[] result = new int[N];
        Arrays.fill(result,-1);

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek().size < arr[i]){
                result[stack.pop().index] = arr[i];
            }
            stack.push(new Node(i,arr[i]));
        }

        for(int j=0;j<N;j++){
            bw.write(result[j]+" ");
        }

        bw.flush();
        bw.close();
    }

}

class Node {
    int index;
    int size;

    public Node(int index, int size) {
        this.index = index;
        this.size = size;
    }
}
