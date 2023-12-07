import java.util.*;
import java.io.*;

public class D2P1 {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("test.in"));
        PrintWriter pw = new PrintWriter(System.out);
        
        String s = r.readLine();
        long ans = 0;
        while(s != null){
            int n = s.length();
            int colon = 0;
            for (int i = 0; i < n; i++) {
                if(s.charAt(i) == ':'){
                    colon = i;
                    break;
                }
            }
            String before = s.substring(0, colon);
            StringTokenizer st = new StringTokenizer(before);
            st.nextToken();
            int idx = Integer.parseInt(st.nextToken());
            boolean good = true;
            s = s.substring(colon + 1, n);
            String[] options = s.split("; ");
            for(String e : options){
                int red, green, blue;
                red = green = blue = 0;
                String[] cubes = e.split(", ");
                for(String e1 : cubes){
                    st = new StringTokenizer(e1);
                    int amt = Integer.parseInt(st.nextToken());
                    String color = st.nextToken();
                    if(color.equals("blue")){
                        blue += amt;
                    }
                    else if(color.equals("red")){
                        red += amt;
                    }
                    else{
                        green += amt;
                    }
                }
                if(red > 12 || green > 13|| blue > 14){
                    good = false;
                }   
            }
            if(good){
                ans += idx;
            }
            s = r.readLine();
        }
        pw.println(ans);
        pw.close();
        r.close();
    }
}
