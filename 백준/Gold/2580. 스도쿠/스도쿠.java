import java.io.*;
import java.util.*;


public class Main {

    static int[][] arr = new int[9][9];
    static List<int[]> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0;i<9;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {
                if(arr[i][j]==0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        DFS(0);

        System.out.println(sb.toString());
        //bw.flush();
        //bw.close();
    }

    public static boolean DFS(int index){
        int[] xy = list.get(index);
        int x = xy[0];
        int y = xy[1];


        //가로 체크
        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for(int k=0;k<9;k++){
            if(arr[k][y] != 0){
                set.remove(arr[k][y]);
            }
        }
        //세로 체크
        for(int k=0;k<9;k++){
            if(arr[x][k] != 0){
                set.remove(arr[x][k]);
            }
        }

        //3x3 정사각형 체크

        int startX = x-x%3;
        int startY = y-y%3;
        for(int q=0;q<3;q++){
            for(int w=0;w<3;w++){
                if(arr[startX+q][startY+w] != 0){
                    set.remove(arr[startX+q][startY+w]);
                }
            }
        }

        /*if(set.size() == 0){
            return true;}else*/
            if(set.size()==1) {
                arr[x][y] = set.iterator().next();
                if(index+1 == list.size()){
                for(int i=0;i<9;i++){
                    for(int j=0;j<9;j++){
                        sb.append(arr[i][j]+ " ");
                    }
                    sb.append("\n");
                }
                return false;
            }
            DFS(index+1);
            arr[x][y] = 0;
        }else if(set.size()>1){
            for (int num : set) {
                arr[x][y] = num;
                DFS(index + 1);
                arr[x][y] = 0;
            }
        }
        return true;
    }

}