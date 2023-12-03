import java.util.*;
import java.io.*;

public class D1P1{
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("test.in"));
        long ans = 0;
        String s = r.readLine();
        while(s != null){
            int left = 0; int right = 0;
            for (int i = 0; i < s.length(); i++) {
                if(0 <= s.charAt(i) - '0' && s.charAt(i) - '0' <= 9){
                    left = i;
                    break;
                }
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                if(0 <= s.charAt(i) - '0' && s.charAt(i) - '0' <= 9){
                    right = i;
                    break;
                }
            }
            ans += (s.charAt(left) - '0') * 10 + (s.charAt(right) - '0');
            s = r.readLine();
        }
        System.out.println(ans);
    }
}