import java.util.*;
import java.io.*;

public class D4P1 {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("test.in"));
        PrintWriter pw = new PrintWriter(System.out);
        
        String s = r.readLine();
        long ans = 0;
        while(s != null){
            StringTokenizer st = new StringTokenizer(s);
            st.nextToken(); st.nextToken(); //Both dummy variables
            HashSet<Integer> win = new HashSet<>();
            boolean yours = false;
            int count = 0;

            while(st.hasMoreTokens()) {
                String temp = st.nextToken();
                if(temp.equals("|")){
                    yours = true;
                    continue;
                }
                if(yours){
                    if(win.contains(Integer.parseInt(temp))){
                        count++;
                    }
                }  
                else{
                    win.add(Integer.parseInt(temp));
                }
            }
            if(count >= 1){
                ans += 1 << (count - 1);
            }
            s = r.readLine();
        }
        pw.println(ans);
        pw.close();
        r.close();
    }
}
