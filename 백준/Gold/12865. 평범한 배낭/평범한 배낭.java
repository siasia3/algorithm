import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        Thing[] things = new Thing[N];
        int[] DP = new int[V+1];
        DP[0] = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            things[i] = new Thing(weight,value);
        }


        // 그냥 예를 들어서 무게가 3인 경우 무게를 3으로 만드는 경우 중의 가치(상품의 갯수가 한개~ 여러개) , 무게 2 이하에서 가치가 가장 높은 경우
        //무게를 2로 만드는 경우, 무게가 2인거 하나 무게가 1인거 두개
        // 이런 느낌이라면 현재 물건의 무게가 1인 경우에 DP[100000] = DP[99999]+현재 물건의 가치 or DP[99999] = DP[100000] - 현재 물건의 가치
        // 2부터 시작 한다고 하면 DP[2] = DP[1]+ 현재 물건의 가치 OR DP[1] = DP[2] - 현재 물건의 가치

        for(int j=0;j<N;j++){
            int w = things[j].weight;
            int v = things[j].value;
            if(w > V) continue;

                /*for(int k=1;k<=V;k++) {
                    if(k-w >= 0) {
                        DP[k] = Math.max(DP[k-w] + v, DP[k]);
                    }
                    이 방식은 같은 아이템을 여러개 써버리면서 답이 이상해지는 경우가 존재함
                    DP[5] = DP[0]+5 , DP[5]
                    DP[10] = DP[5]+5 , DP[10]

                }*/

            //
            for(int k=V;k>=w;k--) {
                DP[k] = Math.max(DP[k-w] + v, DP[k]);
            }
            //DP[10] = DP[5]+5,DP[10]
            //DP[5] = DP[0]+5,DP[5] -> 이 경우에서 핵심은 같은 아이템을 다시 사용하지 않음 즉 아직 DP[5]라는 값이 바뀌지 않은 상태라는 것
        }


        bw.write(String.valueOf(DP[V]));
        bw.flush();
        bw.close();
    }

    

}

class Thing{
    int weight;
    int value;

    public Thing(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
