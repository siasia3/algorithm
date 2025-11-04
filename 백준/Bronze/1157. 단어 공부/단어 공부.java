import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character, Integer> map = new HashMap<>();

        String str = br.readLine();

        str = str.toLowerCase();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                Integer value = map.get(c);
                map.put(c,value+1);
            }else{
                map.put(c,1);
            }
        }

        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (a,b) -> b.getValue().compareTo(a.getValue()));

        int firstValue = entries.get(0).getValue();
        if(entries.size() > 1) {
            int secondValue = entries.get(1).getValue();
            if(firstValue > secondValue){
                String result = entries.get(0).getKey().toString().toUpperCase();
                bw.write(result);
            }else{
                bw.write("?");
            }
        }else{
            String result = entries.get(0).getKey().toString().toUpperCase();
            bw.write(result);
        }


        bw.flush();
        bw.close();
    }

}