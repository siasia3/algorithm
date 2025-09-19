import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        backTracking(2,1);
        backTracking(3,1);
        backTracking(5,1);
        backTracking(7,1);

    }

    public static void backTracking(int num, int digit){

        boolean flag = primeNumber(num);
        if(N == digit){
            if(flag) {
                System.out.println(num);
            }
            return;
        }
        if(flag){
            for(int i=0;i<10;i++) {
                if (i % 2 != 0) {
                    backTracking((num*10)+i, digit + 1);
                }
            }
        }
    }

    //소수 체크
    public static boolean primeNumber(int num){
        for(double i=2;i<=Math.sqrt(num);i++){
            if(num == 2){
              return true;
            }
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }


}