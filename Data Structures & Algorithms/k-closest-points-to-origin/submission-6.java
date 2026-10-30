class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int l = 0;
        int r = points.length - 1;
        int p = points.length;
        while(k != p) {
            p = partition(points, l, r);
            if(p < k) {
                l = p + 1;
            } else {
                r = p - 1;
            }
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        return res;
    }

    private int partition(int[][] points, int l, int r) {
        int p = r;
        int dist = eucl(points[p]);
        int i = l;
        for(int j = l; j < r; j++) {
            if(eucl(points[j]) <= dist) {
                int[] temp = points[j];
                points[j] = points[i];
                points[i] = temp;
                i++;
            }
        }
        int[] temp = points[r];
        points[r] = points[i];
        points[i] = temp;
        return i;
    }

    private int eucl(int[] points) {
        return points[0] * points[0] + points[1] * points[1]; // Try math pow
    }
}
