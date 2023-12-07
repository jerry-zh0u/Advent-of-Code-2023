import java.util.*;
import java.io.*;

public class D1P2 {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("test.in"));
        PrintWriter pw = new PrintWriter(System.out);
        long ans = 0;
        String s = r.readLine();
        while(s != null){
            int n = s.length();
            int left = 0; int right = 0;
            for (int i = 0; i < n; i++) {
                if(0 <= s.charAt(i) - '0' && s.charAt(i) - '0' <= 9){
                    left = s.charAt(i) - '0'; break;
                }
                if(i <= n - 3){
                    String num = s.substring(i, i + 3);
                    if(num.equals("one")){
                        left = 1; break;
                    }
                    else if(num.equals("two")){
                        left = 2; break;
                    }
                    else if(num.equals("six")){
                        left = 6; break;
                    }
                }
                if(i <= n - 4){
                    String num = s.substring(i, i + 4);
                    if(num.equals("four")){
                        left = 4; break;
                    }
                    else if(num.equals("five")){
                        left = 5; break;
                    }
                    else if(num.equals("nine")){
                        left = 9; break;
                    }
                }
                if(i <= n - 5){
                    String num = s.substring(i, i + 5);
                    if(num.equals("three")){
                        left = 3; break;
                    }
                    else if(num.equals("seven")){
                        left = 7; break;
                    }
                    else if(num.equals("eight")){
                        left = 8; break;
                    }
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if(0 <= s.charAt(i) - '0' && s.charAt(i) - '0' <= 9){
                    right = s.charAt(i) - '0'; break;
                }
                if(i <= n - 3){
                    String num = s.substring(i, i + 3);
                    if(num.equals("one")){
                        right = 1; break;
                    }
                    else if(num.equals("two")){
                        right = 2; break;
                    }
                    else if(num.equals("six")){
                        right = 6; break;
                    }
                }
                if(i <= n - 4){
                    String num = s.substring(i, i + 4);
                    if(num.equals("four")){
                        right = 4; break;
                    }
                    else if(num.equals("five")){
                        right = 5; break;
                    }
                    else if(num.equals("nine")){
                        right = 9; break;
                    }
                }
                if(i <= n - 5){
                    String num = s.substring(i, i + 5);
                    if(num.equals("three")){
                        right = 3; break;
                    }
                    else if(num.equals("seven")){
                        right = 7; break;
                    }
                    else if(num.equals("eight")){
                        right = 8; break;
                    }
                }
            }
            ans += left * 10 + right;
            s = r.readLine();
        }
        pw.println(ans);
        pw.close();
        r.close();
    }
}
