package leecode;

import java.util.HashMap;
import java.util.Map;

public class Leecode1901 {
    public static int[] findPeakGrid(int[][] mat) {
        boolean[][] flag = new boolean[mat.length][mat[0].length];
        dfs(0,0,mat,flag);
        return new int[]{item_i,item_j};
    }
    static int item_i=-1,item_j=-1;

    public static void dfs(int i, int j, int[][] mat, boolean[][] flag) {
        flag[i][j] = true;
        int n1,n2,n3,n4;
        if (i == 0) {
            n1 = -1;
            n3 = mat[i + 1][j];
        }else if(i==mat.length-1){
            n3=-1;
            n1 = mat[i - 1][j];
        }else {
            n3 = mat[i + 1][j];
            n1 = mat[i - 1][j];
        }
        if (j == 0) {
            n2 = -1;
            n4 = mat[i][j + 1];
        }else if(j==mat[0].length-1){
            n4=-1;
            n2 = mat[i][j - 1];
        }else {
            n4 = mat[i][j + 1];
            n2 = mat[i][j - 1];
        }
        Map<Integer, int[]> map=new HashMap();
        map.put(n1,new int[]{i-1,j});
        map.put(n2,new int[]{i, j - 1});
        map.put(n3,new int[]{i+1,j});
        map.put(n4,new int[]{i, j + 1});
        int max = Math.max(Math.max(n1, n2), Math.max(n3, n4));
        if(max<mat[i][j]){
            item_i=i;
            item_j=j;
        }else {
            int i1 = map.get(Math.max(Math.max(n1, n2), Math.max(n3, n4)))[0];
            int j1 = map.get(Math.max(Math.max(n1, n2), Math.max(n3, n4)))[1];
            dfs(i1,j1,mat,flag);
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{10,20,15},{21,30,14},{7,16,32}};
        int[] peakGrid = findPeakGrid(mat);
        System.out.println(peakGrid[0]+"=="+peakGrid[1]);
    }
}
