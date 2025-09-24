import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		
		String inputNum = br.readLine();
		int num = Integer.parseInt(inputNum);
		Set<String> inputStr = new HashSet<>();
		for(int i=0; i<num; i++) {
			inputStr.add(br.readLine());
		}
		
		String[] strArray = new String[inputStr.size()];
		strArray = inputStr.stream().toArray(String[]::new);
		Arrays.sort(strArray,Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
	
		
		for(int i=0; i<strArray.length; i++) {
			bw.write(strArray[i]+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
