//same logic but check to see if something has 2 borders in a gear

import java.util.*;
import java.io.*;

public class D3P2 {
    private static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    private static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("test.in"));
        PrintWriter pw = new PrintWriter(System.out);

        String s = r.readLine();
        ArrayList<String> grid = new ArrayList<>();
        long ans = 0;
        while(s != null){
            grid.add(s);
            s = r.readLine();
        }
        boolean[][] used = new boolean[grid.size()][grid.get(0).length()];
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).length(); j++) {
                if(grid.get(i).charAt(j) != '*'){
                    continue;
                }
                ArrayList<Integer> possible = new ArrayList<>();
                for (int j2 = 0; j2 < 8; j2++) {
                    int fx = i + dx[j2];
                    int fy = j + dy[j2];
                    if(0 <= fx && fx < grid.size() && 0 <= fy && fy < grid.get(i).length()){
                        if(0 <= grid.get(fx).charAt(fy) - '0' && grid.get(fx).charAt(fy) - '0' <= 9 && !used[fx][fy]){
                            used[fx][fy] = true;
                            int num = 0;
                            int left = fy;
                            while(left - 1 >= 0 && (0 <= grid.get(fx).charAt(left - 1) - '0' && grid.get(fx).charAt(left - 1) - '0' <= 9)){
                                used[fx][left - 1] = true;
                                left--;
                            }
                            int right = fy;
                            while(right + 1 < grid.get(fx).length() && (0 <= grid.get(fx).charAt(right + 1) - '0' && grid.get(fx).charAt(right + 1) - '0' <= 9)){
                                used[fx][right + 1] = true;
                                right++;
                            }
                            for (int k = left; k <= right; k++) {
                                num = 10 * num + (grid.get(fx).charAt(k) - '0');
                            }
                            possible.add(num);
                        }
                    }
                }
                if(possible.size() == 2){
                    ans += (long)possible.get(0) * (long)possible.get(1);
                }
            }
        }
        pw.println(ans);
        pw.close();
        r.close();
    }
}
