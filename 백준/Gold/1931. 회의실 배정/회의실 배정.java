import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        List<Room> roomList = new ArrayList<>();


        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            roomList.add(new Room(x,y));
        }

        Collections.sort(roomList);
        int currentY = roomList.get(0).y;
        int count = 1;

        for (int j = 1; j < N; j++) {
            Room room = roomList.get(j);
            if (room.x >= currentY) { // 원래는 room.y >= currentY && 이것도 넣어줬었음
                currentY = room.y;
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}

class Room implements Comparable<Room>{
    int x;
    int y;

    public Room(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Room room) {
        if(this.y > room.y){
            return 1;
        }else if(this.y == room.y){
            if(this.x < room.x){
                return -1;
            }else{
                return 1;
            }
        }else{
            return -1;
        }
    }
}