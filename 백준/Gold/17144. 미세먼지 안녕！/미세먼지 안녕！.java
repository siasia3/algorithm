import java.io.*;
import java.util.*;

public class Main {

    static int R, C, T;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int top = -1, bottom = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == -1) {
                    if (top == -1) top = i;
                    else bottom = i;
                }
            }
        }

        for (int t = 0; t < T; t++) {
            spread();      // 확산
            operate();     // 공기청정기
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) answer += map[i][j];
            }
        }

        System.out.println(answer);
    }

    // 미세먼지 확산
    static void spread() {
        int[][] temp = new int[R][C];

        // 공기청정기 유지
        temp[top][0] = -1;
        temp[bottom][0] = -1;

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (map[x][y] > 0) {
                    int spread = map[x][y] / 5;
                    int count = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (0 <= nx && nx < R && 0 <= ny && ny < C
                                && map[nx][ny] != -1) {
                            temp[nx][ny] += spread;
                            count++;
                        }
                    }

                    temp[x][y] += map[x][y] - (spread * count);
                }
            }
        }

        map = temp;
    }

    // 2. 공기청정기 작동
    static void operate() {

        // 위쪽 (반시계)
        
        for (int i = top - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        
        for (int j = 0; j < C - 1; j++) {
            map[0][j] = map[0][j + 1];
        }
        
        for (int i = 0; i < top; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }
        
        for (int j = C - 1; j > 1; j--) {
            map[top][j] = map[top][j - 1];
        }
        map[top][1] = 0;

        // 아래쪽 (시계)
        
        for (int i = bottom + 1; i < R - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        
        for (int j = 0; j < C - 1; j++) {
            map[R - 1][j] = map[R - 1][j + 1];
        }
       
        for (int i = R - 1; i > bottom; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        
        for (int j = C - 1; j > 1; j--) {
            map[bottom][j] = map[bottom][j - 1];
        }
        map[bottom][1] = 0;
    }
}