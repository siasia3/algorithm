import java.io.*;
import java.util.*;


public class Main {

    static int[][] area;
    static List<int[]> homeArea;
    static List<int[]> chickenArea;
    static List<int[]> selectedChicken;

    static int N;
    static int M;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new int[N][N];
        selectedChicken = new ArrayList<>();
        homeArea = new ArrayList<>();
        chickenArea = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                area[i][j] = Integer.parseInt(st.nextToken());

                if(area[i][j]==1){
                    homeArea.add(new int[]{i,j});
                }else if(area[i][j]==2){
                    chickenArea.add(new int[]{i,j});
                }
            }
        }

        DFS(0,0);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static void DFS(int i,int count){
        if(count == M){
            int cityDistance = distance();
            result = Math.min(result, cityDistance);
            return;
        }

        for(int k=i;k<chickenArea.size();k++){
            int[] chicken = chickenArea.get(k);
            int x = chicken[0];
            int y = chicken[1];
            selectedChicken.add(chicken);
            //area[x][y] = 0;
            DFS(k+1,count+1);
            //area[x][y] = 2;
            selectedChicken.remove(selectedChicken.size() - 1);
        }
    }

    public static int distance(){

        int sum = 0;

        for(int[] home : homeArea){
            int minimum = 100;
            for(int i=0;i< selectedChicken.size();i++){
                int[] chickenXY = selectedChicken.get(i);
                int num = Math.abs(chickenXY[0] - home[0]) + Math.abs(chickenXY[1] - home[1]);
                minimum = Math.min(minimum, num);
            }
            sum += minimum;
        }

        return sum;
    }
}
