// Java code implementation:
import java.io.*;
import java.util.*;

class GFG {

    // To find the closest pair of points
    public static long closestPair(int[][] coordinates,
                                   int n)
    {

        // List of pairs to store points on plane
        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(new int[] { coordinates[i][0],
                    coordinates[i][1] });
        }

        // Sort them according to their x-coordinates
        Collections.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return a[0] - b[0];
            }
        });

        // Minimum distance b/w points seen so far //10 в 18 степени
        long d = (long)Math.pow(10, 18);

        // Keeping the points in increasing order
        Set<int[]> st = new HashSet<>();
        st.add(points.get(0));

        for (int i = 1; i < n; i++) {
            Set<int[]> l = new HashSet<>();
            for (int[] p : st) {
                if (p[0] >= points.get(i)[0] - d
                        && p[1] >= points.get(i)[1] - d) {
                    l.add(p);
                }
            }

            Set<int[]> r = new HashSet<>();
            for (int[] p : st) {
                if (p[0] <= points.get(i)[0] + d
                        && p[1] <= points.get(i)[1] + d) {
                    r.add(p);
                }
            }

            Set<int[]> intersection = new HashSet<>(l);
            intersection.retainAll(r);
            if (intersection.size() == 0) {
                continue;
            }

            for (int[] val : intersection) {
                long dis
                        = (long)Math.pow(
                        points.get(i)[0] - val[0], 2)
                        + (long)Math.pow(
                        points.get(i)[1] - val[1], 2);

                // Updating the minimum distance dis
                if (d > dis) {
                    d = dis;
                }
            }

            st.add(points.get(i));
        }

        return d;
    }

    public static void main(String[] args)
    {
        // Points on a plane P[i] = (x, y)
        int[][] P = {
                { 1, 2 }, { 2, 3 }, { 3, 4 }, { 5, 6 }, { 2, 1 }
        };
        int n = P.length;

        // Function call
        System.out.println("The smallest distance is "
                + closestPair(P, n));
    }
}

// This code is contributed by sankar.
