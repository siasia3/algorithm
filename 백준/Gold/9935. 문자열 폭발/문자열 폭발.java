import java.io.*;

public class Main {
    //9935번
    // 처음에 String.replace를 이용했지만 메모리 초과 String으로는 불가능하다는걸 깨달음
    // StringBuilder를 써야한다고 생각했지만 indexOf를 이용해버리면 매우 시간이 오래걸림 시간복잡도에서 걸려버림;
    //

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder strSB = new StringBuilder();
        String str = br.readLine();
        String boomStr = br.readLine();

        for(int i=0;i<str.length();i++){
            strSB.append(str.charAt(i));

            if(strSB.length() >= boomStr.length()){
                boolean flag = true;
                for(int j=0;j<boomStr.length();j++){
                    if(strSB.charAt(strSB.length()-boomStr.length()+j) != boomStr.charAt(j)){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    strSB.delete(strSB.length()-boomStr.length(),strSB.length());
                }
            }
        }

        if(strSB.length()==0){
            strSB.append("FRULA");
        }

        bw.write(strSB.toString());
        bw.flush();
        bw.close();
    }

}
