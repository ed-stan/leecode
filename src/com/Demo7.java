package com;

public class Demo7 {
    public static int maxPoints(int[][] points) {
        if (points.length==1)
            return 1;
        if (points.length==2)
            return 2;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < i; j++) {
                int x1 = points[i][0];
                int x2 = points[j][0];
                int y1 = points[i][1];
                int y2 = points[j][1];
                boolean flag=false;
                double k,b;
                if(x1-x2==0){
                    flag=true;
                    k=x1;
                    b=0;
                }else {
                    k = (double) (y1 - y2) / (x1 - x2);
                    b = (double) (x1 * y2 - x2 * y1) / (x1 - x2);
                }
                int max = 0;
                for (int[] point : points) {
                    if(flag){
                        if(point[0]==k)
                            max++;
                        continue;
                    }
                    if (point[0] * k + b == point[1]) {
                        max++;
                    }
                }
//                if ((float) max / points.length >= 0.5) {
//                    return max;
//                }
                if (max > res) {
                    res = max;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
//        {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}
//        {{1,1},{2,2},{3,3}}
//         {{-6,-1},{3,1},{12,3}}
//        {{0,0},{1,-1},{1,1}}


//        int[][] points = {{54,153},{1,3},{0,-72},{-3,3},{12,-22},{-60,-322},{0,-5},{-5,1},{5,5},{36,78},{3,-4},{5,0},{0,4},{-30,-197},{-5,0},{60,178},{0,0},{30,53},{24,28},{4,5},{2,-2},{-18,-147},{-24,-172},{-36,-222},{-42,-247},{2,3},{-12,-122},{-54,-297},{6,-47},{-5,3},{-48,-272},{-4,-2},{3,-2},{0,2},{48,128},{4,3},{2,4}};
//        int i = maxPoints(points);
//        System.out.println(i);

        System.out.println(-10/3);

    }


}
