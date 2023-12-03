import java.util.*;
import java.io.*;

public class D2P2 {
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
            s = s.substring(colon + 1, n);
            String[] options = s.split("; ");
            long r_Red = 0; long r_Green = 0; long r_Blue = 0;
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
                r_Red = Math.max(r_Red, red);
                r_Green = Math.max(r_Green, green);
                r_Blue = Math.max(r_Blue, blue);
            }
            ans += r_Red * r_Green * r_Blue;
            s = r.readLine();
        }
        pw.println(ans);
        pw.close();
    }
}
