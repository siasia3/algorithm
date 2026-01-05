import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        int[] switches = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int studentNum = Integer.parseInt(br.readLine());
        Student[] students = new Student[studentNum];
        for(int i=0;i<studentNum;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int genderNum = Integer.parseInt(st.nextToken());
            String gender = (genderNum == 1) ? "male" : "female";
            int switchNum = Integer.parseInt(st.nextToken());
            students[i] = new Student(gender,switchNum);

            if(gender.equals("male")){
                for(int j=switchNum;j<=N;j+=switchNum){
                   switches[j-1] = (switches[j-1] == 0) ? 1 : 0;
                }
            }

            if(gender.equals("female")){
                int count = 1;
                switches[switchNum-1] = (switches[switchNum-1] == 1) ? 0 : 1;
                while(true){
                    if(switchNum + count <= N  && switchNum - count >= 1){
                        if(switches[switchNum + count - 1] == switches[switchNum - count - 1]){
                            int status = (switches[switchNum - count - 1] == 0) ? 1 : 0;
                            switches[switchNum + count - 1] = status;
                            switches[switchNum - count - 1] = status;
                            count++;
                            continue;
                        }
                    }
                    break;
                }
            }
        }
        
        for(int i = 0; i < N; i++) {
            bw.write(switches[i] + " ");
            if ((i + 1) % 20 == 0) bw.newLine();
        }

        bw.flush();
        bw.close();
    }

}

class Student{
    String gender;
    int switchNum;

    public Student(String gender, int switchNum) {
        this.gender = gender;
        this.switchNum = switchNum;
    }
}
