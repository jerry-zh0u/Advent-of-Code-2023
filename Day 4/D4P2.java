import java.util.*;
import java.io.*;

public class D4P2 {
    private static final int MAX_SIZE = 251;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("test.in"));
        PrintWriter pw = new PrintWriter(System.out);
        
        String s = r.readLine();
        long ans = 0;
        long[] used = new long[MAX_SIZE];
        while(s != null){
            StringTokenizer st = new StringTokenizer(s);
            st.nextToken(); //dummy variable for "Card"
            String num_String = (st.nextToken());
            HashSet<Integer> win = new HashSet<>();
            int card_Num = Integer.parseInt(num_String.substring(0, num_String.length() - 1));
            boolean yours = false;
            int count = 0;
            used[card_Num] ++;
            
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
            for (int i = card_Num + 1; i <= card_Num + count; i++) {
                used[i] += used[card_Num];
            }   
            s = r.readLine();
        }
        for(long e : used){
            ans += e;
        }
        pw.println(ans);
        pw.close();
        r.close();
    }
}
