import java.io.*;
import java.util.*;

public class Solution {
    static int[][] input;
    static boolean[][] input1;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer m = sc.nextInt();
        input = new int[n][m];
        input1 = new boolean[n][m];
        for (int row = 0; row < n; row++){
            for (int col = 0; col < m; col++){
                input[row][col] = sc.nextInt();
                input1[row][col] = false;
            }
        }
        int ans = 0;
        for (int row = 0; row < n; row++){
            for (int col = 0; col < m; col++){
                if (input1[row][col] == false){
                    ans++;
                    floodfill(row, col, n, m);
                }
            }
        }
        System.out.println(ans);
    }
    
    public static void floodfill(int r, int c, int nn, int mm){
        int current = input[r][c];
        if ((r+1) < nn && input[r+1][c] == current && input1[r+1][c] == false){
            input1[r+1][c] = true;
            floodfill(r + 1, c, nn, mm);
        }
        if (r > 0 && input[r-1][c] == current && input1[r-1][c] == false){
            input1[r-1][c] = true;
            floodfill(r - 1, c, nn, mm);
        }
        if ((c+1) < mm && input[r][c + 1] == current && input1[r][c + 1] == false){
            input1[r][c + 1] = true;
            floodfill(r, c + 1, nn, mm);
        }
        if (c > 0 && input[r][c - 1] == current && input1[r][c - 1] == false){
            input1[r][c - 1] = true;
            floodfill(r, c - 1, nn, mm);
        }
    }
    
}
