import java.io.*;
import java.util.*;

//백준 11000번
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> queue = new PriorityQueue<>((a, b) -> a.end - b.end);
        Lecture[] lectures = new Lecture[N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Lecture lecture = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            lectures[i] = lecture;
        }
        Arrays.sort(lectures);

        for(Lecture lecture : lectures){
            if(!queue.isEmpty() && queue.peek().end <= lecture.start){
                queue.poll();
            }
            queue.add(lecture);
        }

        bw.write(String.valueOf(queue.size()));
        bw.flush();
        bw.close();
    }

}

class Lecture implements Comparable<Lecture>{
    int start;
    int end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lecture lecture) {
        int result = this.start - lecture.start;
        if(result == 0){
            return this.end - lecture.end;
        }
        return result;
    }
}
