import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //14503번

    static int directionX;
    static int directionY;
    static int robotDirection;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] xy = new int[n][m];
        //boolean[][] visited = new boolean[n][m];

        int[] robotSetting = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int robotX = robotSetting[0];
        int robotY = robotSetting[1];
        robotDirection = robotSetting[2];

        direction();


        /*switch (robotDirection){
            case 0:
                directionX = -1;
                break;
            case 1:
                directionY = 1;
                break;
            case 2:
                directionX = 1;
                break;
            case 3:
                directionY = -1;
        }*/



        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                xy[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;

        int currentX = robotX;
        int currentY = robotY;
        int nextX = 0;
        int nextY = 0;
        boolean operate = true;

        while(operate){
            if(xy[currentX][currentY]==0){
                xy[currentX][currentY] = 2;
                result++;
            }

            boolean checkFlag = false;

            for(int i=0;i<4;i++) {

                nextX = currentX + dx[i];
                nextY = currentY + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX <= (n-1) && nextY <= (m-1)) {
                    if(xy[nextX][nextY]==0){
                        checkFlag = true;
                    }
                }
            }
            if(checkFlag){
                for(int i=0;i<4;i++) {
                    robotDirection = robotDirection - 1;
                    direction();
                    nextX = currentX + directionX;
                    nextY = currentY + directionY;
                    if(xy[nextX][nextY] == 0){
                        currentX = nextX;
                        currentY = nextY;
                        break;
                    }
                }

            }else{

                nextX = currentX - directionX;
                nextY = currentY - directionY;

                if (nextX >= 0 && nextY >= 0 && nextX <= (n-1) && nextY <= (m-1)) {
                    if(xy[nextX][nextY]==1){
                        operate = false;
                    }else{
                        //xy[nextX][nextY]==2인 경우
                        currentX = nextX;
                        currentY = nextY;
                    }
                }else{
                    operate = false;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static void direction(){

        if(robotDirection == -1){
            robotDirection = 3;
        }

        switch (robotDirection){
            case 0:
                directionX = -1;
                directionY = 0;
                break;
            case 1:
                directionX = 0;
                directionY = 1;
                break;
            case 2:
                directionX = 1;
                directionY = 0;
                break;
            case 3:
                directionX = 0;
                directionY = -1;
        }
    }

}